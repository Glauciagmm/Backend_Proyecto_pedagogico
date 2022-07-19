package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Facilit;
import com.uniquecare.pedagogico_backend.services.IFacilitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class FacilitController {

    private final IFacilitService facilitService;

    @GetMapping("/facility")
    public ResponseEntity<List<Facilit>>getFacilit(Authentication authentication, HttpSession session){
        if (authentication == null){
            System.out.println("Es necesario que hagas el login");
        }else{
            String username = authentication.getPrincipal().toString();
            System.out.println(username);
        }return ResponseEntity.ok().body(facilitService.getAllFacilities());
    }

    @PostMapping("/facility/save")
    public ResponseEntity<Facilit> addFacilit(Authentication authentication, @RequestBody Facilit facilit) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/save").toUriString());
        if (authentication == null) {
            System.out.println("Es necesario que hagas el login");
        } else {
            String username = authentication.getPrincipal().toString();
            System.out.println(username);
        }
        return ResponseEntity.created(uri).body(facilitService.addFacilit(facilit));
    }

    @GetMapping("/facility/{id}")
    public ResponseEntity<Facilit> findFacilitById(@PathVariable Long id){
        return ResponseEntity.ok().body(facilitService.findFacilityById(id));
    }

    @PutMapping("/facility/edit")
    public ResponseEntity<Facilit> editFacilit(@RequestBody Facilit facilit){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facility/save").toUriString());
        return ResponseEntity.created(uri).body(facilitService.updateFacilit(facilit));
    }

    @DeleteMapping("/facility/delete/{id}")
    public ResponseEntity<Void> deleteFacilitById(@PathVariable Long id){
        facilitService.deleteFacilitById(id);
        return ResponseEntity.noContent().build();
    }

}
