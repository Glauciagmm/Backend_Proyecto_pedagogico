package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.*;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import com.uniquecare.pedagogico_backend.services.IFacilitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facility")
@CrossOrigin(origins="*")
public class FacilitController {
    @Autowired
    private final IFacilitService facilitService;

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
    public ResponseEntity<List<Facilit>>getFacilit(Authentication authentication, Pageable pageable) {
     if (authentication == null) {
         System.out.println("Es necesario que hagas el login");
     } else {
         String username = authentication.getPrincipal().toString();
         System.out.println(username);
     }
     return ResponseEntity.ok().body(facilitService.getAllFacilities(pageable));
 }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Facilit> addFacilit(@AuthenticationPrincipal UserDetailsImpl user,@RequestBody Facilit facilit, HttpServletRequest request) {
        Optional<Category> OptionalCategory= categoryRepository.findById(facilit.getCategory().getId());
        Optional<User>OptionalUser= userRepository.findByUsername(user.getUsername());
         if(!OptionalCategory.isPresent()||!OptionalUser.isPresent()){
             return ResponseEntity.unprocessableEntity().build();
         }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_FACILIT_GUAI"));

        facilit.setUser(OptionalUser.get());
        facilit.setCategory(OptionalCategory.get());

        System.out.println(facilit);
         Facilit facilitysaved = facilitService.addFacilit(facilit);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                 .buildAndExpand(facilitysaved.getId()).toUri();
         return ResponseEntity.created(uri).body(facilitysaved);

    }

  /*  @GetMapping("/{id}")
    public ResponseEntity<Facilit> findFacilitById(@PathVariable Long id){
        return ResponseEntity.ok().body(facilitService.findFacilityById(id));
    }*/
    @GetMapping("/category/{CategoryId}")
    public ResponseEntity<List<Facilit>> findFacilityByCategoryId(@PathVariable("CategoryId") Long CategoryId){

       return ResponseEntity.ok().body(facilitService.getAllFacilitiesByCategoryId(CategoryId));
    }

@GetMapping("/{categoryName}")
    public ResponseEntity<List<Facilit>> findFacilityByCategoryName(@PathVariable("categoryName") String categoryName) {
    return ResponseEntity.ok().body(facilitService.getAllFacilitiesByCategoryName(categoryName));
}

    @PutMapping("/edit")
    public ResponseEntity<Facilit> editFacilit(@RequestBody Facilit facilit){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/save").toUriString());
        return ResponseEntity.created(uri).body(facilitService.updateFacilit(facilit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFacilitById(@PathVariable Long id){
        facilitService.deleteFacilitById(id);
        return ResponseEntity.noContent().build();
    }

}
