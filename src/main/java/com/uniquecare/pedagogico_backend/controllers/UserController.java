package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.payload.request.ProfileRequest;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import com.uniquecare.pedagogico_backend.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class UserController {
    private final IUserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @GetMapping("/user")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

    @PutMapping("/user/edit/{id}")
    public User updateUser (@RequestBody @Valid ProfileRequest profileRequest){
        User user = userRepository.findById(profileRequest.getId()).orElseThrow(RuntimeException::new);
        user.setName(profileRequest.getName());
        user.setSurname(profileRequest.getSurname());
        user.setEmail(profileRequest.getEmail());
        user.setUsername(profileRequest.getUsername());
        user.setCity(profileRequest.getCity());
        user.setPhone(profileRequest.getPhone());
        user.setPhoto(profileRequest.getPhoto());
    return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
