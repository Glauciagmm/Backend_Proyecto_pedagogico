package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.*;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import com.uniquecare.pedagogico_backend.services.IFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facility")
@CrossOrigin(origins="*")
public class FacilityController {
    @Autowired
    private final IFacilityService facilityService;


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

/*    @GetMapping
    public ResponseEntity<Page<Facilit>> FacilitiesList(Pageable pageable){
        return (ResponseEntity<List<Facilit>>) ResponseEntity.ok(facilitService.getAllFacilities(pageable));
    }*/

 @GetMapping("/list")
    public ResponseEntity<List<Facility>>getFacility(Authentication authentication, Pageable pageable) {
     if (authentication == null) {
         System.out.println("Es necesario que hagas el login");
     } else {
         String username = authentication.getPrincipal().toString();
         System.out.println(username);
     }
     return ResponseEntity.ok().body(facilityService.getAllFacilities(pageable));
 }

  /*  @PostMapping("/save")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Facility> addFacility(@AuthenticationPrincipal UserDetailsImpl user, @RequestBody Facility facility, HttpServletRequest request) {
        Optional<Category> OptionalCategory= categoryRepository.findById(facility.getCategory().getId());
        Optional<User>OptionalUser= userRepository.findByUsername(user.getUsername());
         if(!OptionalCategory.isPresent()||!OptionalUser.isPresent()){
             return ResponseEntity.unprocessableEntity().build();
         }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_FACILIT_GUAI"));

        facility.setUser(OptionalUser.get());
        facility.setCategory(OptionalCategory.get());

        System.out.println(facility);
         Facility facilitysaved = facilityService.addFacility(facility);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                 .buildAndExpand(facilitysaved.getId()).toUri();
         return ResponseEntity.created(uri).body(facilitysaved);

    }*/

  /*  @GetMapping("/{id}")
    public ResponseEntity<Facilit> findFacilitById(@PathVariable Long id){
        return ResponseEntity.ok().body(facilitService.findFacilityById(id));
    }*/
    @GetMapping("/category/{CategoryId}")
    public ResponseEntity<List<Facility>> findFacilityByCategoryId(@PathVariable("CategoryId") Long CategoryId){

       return ResponseEntity.ok().body(facilityService.getAllFacilitiesByCategoryId(CategoryId));
    }

@GetMapping("/{categoryName}")
    public ResponseEntity<List<Facility>> findFacilityByCategoryName(@PathVariable("categoryName") String categoryName) {
    return ResponseEntity.ok().body(facilityService.getAllFacilitiesByCategoryName(categoryName));
}

    @GetMapping("/facilit")
    public ResponseEntity<List<Facility>>getFacility(Authentication authentication, HttpSession session, Pageable pageable ){
        if (authentication == null){
            System.out.println("Es necesario que hagas el login");
        }else{
            String username = authentication.getPrincipal().toString();
            System.out.println(username);
        }return ResponseEntity.ok().body(facilityService.getAllFacilities(pageable));
    }

   @PostMapping("/save")
    public ResponseEntity<Facility> addFacility(Authentication authentication, @RequestBody Facility facility) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/save").toUriString());
        if (authentication == null) {
            System.out.println("Es necesario que hagas el login");
        } else {
            String username = authentication.getPrincipal().toString();
            System.out.println(username);
        }
        return ResponseEntity.created(uri).body(facilityService.addFacility(facility));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facility> findFacilityById(@PathVariable Long id){
        return ResponseEntity.ok().body(facilityService.findFacilityById(id));
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
