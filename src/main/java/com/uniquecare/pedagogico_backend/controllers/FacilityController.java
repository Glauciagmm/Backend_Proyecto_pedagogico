package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.*;
import com.uniquecare.pedagogico_backend.payload.request.ProfileRequest;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsServiceImpl;
import com.uniquecare.pedagogico_backend.services.IFacilityService;
import com.uniquecare.pedagogico_backend.services.IUserService;
import com.uniquecare.pedagogico_backend.services.UserServiceImplements;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facility")
@CrossOrigin(origins="*")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private UserDetailsServiceImpl  userDetailsService;

   @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService userService;



//Busqueda x categoria-id It Works
    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<Facility>> getAllFacilitiesByCategoriesId(@PathVariable(value = "categoryId") Long categoryId,
    Category category) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Not found Tag  with id = " + categoryId);
        }

        List<Facility> facilities = facilityService.getAllFacilitiesByCategoriesId(categoryId);
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }
    //detalle facility it Works
    @GetMapping("/detail/{id}")
    public ResponseEntity<Facility> findFacilityById(@PathVariable Long id){
        return ResponseEntity.ok().body(facilityService.findFacilityById(id));
    }
    //x category string it works
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Facility>> findFacilitiesByCategoryName(@PathVariable("categoryName") String categoryName) {
        return ResponseEntity.ok().body(facilityService.getAllFacilitiesByCategoriesName(categoryName));
    }

    @GetMapping("/list/{assistantId}")
    public ResponseEntity<List<Facility>>getFacility(Authentication authentication, UserServiceImplements user_logged,
                                                     Facility facility ,Long assistantId, Long userId){
        if (authentication == null){
            System.out.println("Es necesario que hagas el login");
        }else{
            Long Id = facility.setAssistant(user_logged).getId();
            Id= assistantId;
        }
        return ResponseEntity.ok().body(facilityService.getAllFacilitiesByAssistantId(assistantId));
    }

    @GetMapping("/otherlist")
    public ResponseEntity<List<Facility>>getFacilities(){
        return ResponseEntity.ok().body(facilityService.getAllFacilities());
    }
    @PostMapping("/create")
    public ResponseEntity<Facility> addFacility(Authentication authentication, UserServiceImplements user_logged, @RequestBody Facility facility) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/create").toUriString());
        if (authentication == null) {
            System.out.println("Es necesario que hagas el login");
        } else {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            System.out.println(userDetails.getUsername());
            User user = userRepository.getByUsername(userDetails.getUsername());
            user.getRoles();
            facility.setAssistant(user);
            //System.out.println(username);
        }
        return ResponseEntity.created(uri).body(facilityService.addNewFacility(facility));
    }
    @PutMapping("/edit")
    public ResponseEntity<Facility> editFacility(@RequestBody Facility facility){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/save").toUriString());
        return ResponseEntity.created(uri).body(facilityService.updateFacility(facility));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFacilityById(@PathVariable Long id){
        facilityService.deleteFacilityById(id);
        return ResponseEntity.noContent().build();
    }
}

//get facilities by UserId
/*    @GetMapping("/list/{userId}")
    public ResponseEntity<List<Facility>>getFacility(Authentication authentication, UserServiceImplements user_logged, Long userId ){
        if (authentication == null){
            System.out.println("Es necesario que hagas el login");
        }else{
        Long Id = user_logged.getId();
        Id=userId;
        }return ResponseEntity.ok().body(facilityService.getAllFacilitiesByUserId(userId));
    }*/

  /*  @GetMapping("/currentusername")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
*/
   /* @PostMapping("/save")
    @Transactional
    *//* @PreAuthorize("hasRole('USER')")*//*
    public ResponseEntity<Facility> addFacility(@AuthenticationPrincipal UserServiceImplements user_logged,
             UserDetailsImpl userDetails, User assistant, @RequestBody Facility facility,
             Long userRoles) {
           URI uri = null;
         if (AuthenticationPrincipal == null) {
            System.out.println("Es necesario que hagas el login");

        } else {
            userDetails = UserDetailsImpl.build(userRepository.findById(user_logged.getId()).orElseThrow(RuntimeException::new));
            UserServiceImplements userAssistant = (UserServiceImplements) userDetails.getAuthorities();
            userAssistant.setEmail(user_logged.getEmail());
            userAssistant.setUsername(user_logged.getUsername());
            userAssistant.setRoles((Set<Role>) roleRepository.findByName(ERole.ROLE_FACILITY));
            facility.setAssistant(userAssistant);
            uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/save").toUriString());
            System.out.println("Bienvenido Ya prestas servicios");
        }
        return ResponseEntity.created(uri).body(facilityService.addFacility(facility));
    }
*/





//            (@AuthenticationPrincipal UserServiceImplements user_logged, User assistant, @RequestBody Facility facility) {
//        UserServiceImplements userAssistant = user_logged;
//        Optional<Role> role = roleRepository.findByName(ERole.ROLE_FACILITY);
//        Set<Optional<Role>> roleSet = new HashSet<>();
//        roleSet.add(role);
//        Facility _facility = facilityService.addFacility(new Facility(facility.getTitle(), facility.getDescription(),
//        facility.getPricePerHour(),facility.getAssistant(),facility.getCategories(),facility.getAssistant()));
//        return new ResponseEntity<>(_facility, HttpStatus.CREATED);


/*        Optional<Category> OptionalCategory= categoryRepository.findById(facility.getCategories().add());
        Optional<User>OptionalUser= userRepository.findByUsername(user.getUsername());
         if(!OptionalCategory.isPresent()||!OptionalUser.isPresent()){
             return ResponseEntity.unprocessableEntity().build();
         }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        facility.setAssistant(OptionalUser.get());
        facility.setCategories((List<Category>) OptionalCategory.get());

        System.out.println(facility);
         Facility facilitysaved = facilityService.addFacility(facility);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                 .buildAndExpand(facilitysaved.getId()).toUri();
         return ResponseEntity.created(uri).body(facilitysaved);*/



 /*   @GetMapping("/category/{CategoryId}")
    public ResponseEntity<List<Facility>> findFacilityByCategoryId(@PathVariable("CategoryId") Long CategoryId){

       return ResponseEntity.ok().body(facilityService.getAllFacilitiesByCategoryId(CategoryId));
    }*/



/*    @PostMapping("/create")
    public ResponseEntity<Facility> addFacility(Authentication authentication, @RequestBody Facility facility) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/save").toUriString());
     *//*   if (authentication == null) {
            System.out.println("Es necesario que hagas el login");
        } else { }*//*
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User user = userRepository.findUserById(userDetails.getId());
            System.out.println(user);


        return ResponseEntity.created(uri).body(facilityService.addFacility(facility));
    }*/




/* @GetMapping("/list")
    public ResponseEntity<List<Facility>>getFacility(Authentication authentication, Facility facility) {
     if (authentication == null) {
         System.out.println("Es necesario que hagas el login");
     } else {
         String username = authentication.getPrincipal().toString();
         System.out.println(username);
     }
     return ResponseEntity.ok().body(facilityService.getAllFacilities(facility));
    }*/
