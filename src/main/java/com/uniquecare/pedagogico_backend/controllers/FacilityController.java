package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.*;
import com.uniquecare.pedagogico_backend.payload.request.FacilityRequest;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import com.uniquecare.pedagogico_backend.services.IFacilityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpSession;

import java.net.URI;

import java.util.List;
import java.util.Set;

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
    @GetMapping("/single/{id}")
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
        }
        return ResponseEntity.ok().body(facilityService.getAllFacilities());
    }
    @GetMapping("/{assistantId}")
    public ResponseEntity<List<Facility>> getAllFacilitiesByAssistantId(@PathVariable(value = "assistantId") Long assistantId) {
        if (!userRepository.existsById(assistantId)) {
            throw new ResourceNotFoundException("Not found facilities  with this assistant id = " + assistantId);
        }
        List<Facility> facilities =facilityService.getAllFacilitiesByAssistantId (assistantId);
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }
/* Filtra x ubicacion! /*
    @GetMapping ("/ubication/{city}")
    public ResponseEntity<List<Facility>> findFacilitiesByCity(@PathVariable String city){
        return ResponseEntity.ok().body(facilityService.getAllFacilitiesByCity(city));
    }*/
    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('FACILITY') or hasRole('ADMIN')")
    /**Crea un nuevo servicio y le pasa el user que lo ha creado (user logueado)- works! */

    public ResponseEntity<?> addFacility(Authentication authentication, @RequestBody FacilityRequest facilityRequest) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/create").toUriString());
        Facility facility;

        if (authentication == null) {
            System.out.println("Es necesario que hagas el login");
            return ResponseEntity.badRequest().body("Es necesario que hagas el login");
        } else {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            System.out.println(userDetails.getUsername());
            User user = userRepository.getByUsername(userDetails.getUsername());

            Category category = categoryRepository.findById(facilityRequest.getCategoryId()).orElseThrow(RuntimeException::new);

            facility = new Facility();
            facility.setTitle(facilityRequest.getTitle());
            facility.setDescription(facilityRequest.getDescription());
            facility.setPricePerHour(facilityRequest.getPricePerHour());
            facility.setAssistant(user);
            facility.getCategories().add(category);


        }
        return ResponseEntity.created(uri).body(facilityService.addNewFacility(facility));
    }
  /*    FILTERING BY LOCATION EXAMPLE

  @GetMapping("/employee")
    public List<Employee> getEmployee(@RequestParam(defaultValue = "empty") String name, @RequestParam(defaultValue = "empty") String designation, ....
    {
        // check which one is not empty and perform logic
        if (!name.equals("empty")) {
            // do something
        }
    }*/
     /*   List <Facility> facilityAssist= facilityService.getAllFacilitiesByAssistantId(userDetails.getId());*/


         /*  if(facilityAssist.size()== 0){
                Role facilityRole = roleRepository.findByName(ERole.ROLE_FACILITY)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                userDetails;
                User userId = userRepository.findUserById(userDetails.getId());

            }*/

            //System.out.println(username);


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
