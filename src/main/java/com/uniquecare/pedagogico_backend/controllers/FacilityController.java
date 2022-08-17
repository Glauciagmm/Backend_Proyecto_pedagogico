package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.*;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import com.uniquecare.pedagogico_backend.services.IFacilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/facility")
@CrossOrigin(origins="*")
public class FacilityController {

    private final IFacilityService facilityService;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public FacilityController(IFacilityService facilityService, CategoryRepository categoryRepository, UserRepository userRepository, RoleRepository roleRepository) {
    this.facilityService = facilityService;
    this.userRepository = userRepository;
    this.categoryRepository = categoryRepository;
    this.roleRepository = roleRepository;

    }

    /**Encuentra un servicio cuando le pasas su ID -  works! */
    @GetMapping("/{id}")
    public Facility findFacilityById(@PathVariable("id") Long id){
        return facilityService.findFacilityById(id);
    }

    /**Lista todos los servicios de la base de datos - works! */
    @GetMapping("/list")
    public ResponseEntity<List<Facility>>getFacility(Authentication authentication, HttpSession session){
        if (authentication == null){
            System.out.println("Es necesario que hagas el login");
        }else{
            String username = authentication.getPrincipal().toString();
            System.out.println(username);
        }return ResponseEntity.ok().body(facilityService.getAllFacilities());
    }

    /**Crea un nuevo servicio y le pasa el user que lo ha creado (user logueado)- works! */
    @PostMapping("/create")
    public ResponseEntity<Facility> addFacility(Authentication authentication, @RequestBody Facility facility) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/create").toUriString());
        if (authentication == null) {
            System.out.println("Es necesario que hagas el login");
        } else {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            System.out.println(userDetails.getUsername());
            User user = userRepository.getByUsername(userDetails.getUsername());
            facility.setAssistant(user);
            //System.out.println(username);
        }
        return ResponseEntity.created(uri).body(facilityService.addNewFacility(facility));
    }

    /**Edita un servicio de la base de datos - works! */
    @PutMapping("/edit")
    public ResponseEntity<Facility> editFacility(@RequestBody Facility facility){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/create").toUriString());
        return ResponseEntity.created(uri).body(facilityService.updateFacility(facility));
    }

    /**Borra un servicio de la base de datos - works! */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFacilityById(@PathVariable Long id){
        facilityService.deleteFacilityById(id);
        return ResponseEntity.noContent().build();
    }
}
