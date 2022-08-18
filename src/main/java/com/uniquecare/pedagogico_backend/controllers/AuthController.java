package com.uniquecare.pedagogico_backend.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.uniquecare.pedagogico_backend.models.ErrorDetails;
import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.payload.request.LoginRequest;
import com.uniquecare.pedagogico_backend.payload.request.SignupRequest;
import com.uniquecare.pedagogico_backend.payload.response.JwtResponse;
import com.uniquecare.pedagogico_backend.payload.response.MessageResponse;
import com.uniquecare.pedagogico_backend.security.jwt.JwtUtils;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.uniquecare.pedagogico_backend.models.ERole;
import com.uniquecare.pedagogico_backend.models.Role;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;


@CrossOrigin(origins = "**", maxAge = 3600)
@RestController

@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @ExceptionHandler

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws ErrorDetails {
        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());


        System.out.println("Usuario logueado");

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));

        }catch(Exception e) {
            throw new ErrorDetails(e.getMessage());
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(
                signUpRequest.getName(),
                signUpRequest.getSurname(),
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getCity(),
                signUpRequest.getPhone(),
                signUpRequest.getPhoto(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role newUserRole = roleRepository.findByName(ERole.ROLE_USER);
                    if(newUserRole==null){
                        new RuntimeException("Error: Role is not found.");
                    }else{
                        roles.add(newUserRole);
                    }
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
                        if(adminRole==null){
                            new RuntimeException("Error: Role is not found.");
                        }else{
                            roles.add(adminRole);
                        }



                        break;
                    case "facility":
                        Role facilityRole = roleRepository.findByName(ERole.ROLE_FACILITY);
                        if(facilityRole==null){
                            new RuntimeException("Error: Role is not found.");
                        }else{
                            roles.add(facilityRole);
                        }
                    break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER);
                        if(userRole==null){
                            new RuntimeException("Error: Role is not found.");
                        }else{
                            roles.add(userRole);
                        }

                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registrado  con exito came on In!!!!!!!"));
    }
}
