package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Category;
import com.uniquecare.pedagogico_backend.models.Facilit;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.services.IFacilitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facility")
@CrossOrigin(origins="*")
public class FacilitController {
    @Autowired
    private final IFacilitService facilitService;

    @Autowired
    private CategoryRepository categoryRepository;

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
    public ResponseEntity<Facilit> addFacilit(Authentication authentication, @RequestBody Facilit facilit) {
        Optional<Category> OptionalCategory= categoryRepository.findById(facilit.getCategory().getId());
         if(!OptionalCategory.isPresent()){
             return ResponseEntity.unprocessableEntity().build();
         }
         facilit.setCategory(OptionalCategory.get());
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
