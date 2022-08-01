package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.models.Facility;

import com.uniquecare.pedagogico_backend.payload.response.MessageResponse;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import com.uniquecare.pedagogico_backend.services.IContractService;
import com.uniquecare.pedagogico_backend.services.IFacilityService;
import com.uniquecare.pedagogico_backend.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin(origins="*")
public class ContractController {

    private final IContractService contractService;
    private final IUserService userService;
    private final IFacilityService facilityService;

    @Autowired
    public ContractController(IContractService contractService, IUserService userService, IFacilityService facilityService ){
        this.contractService = contractService;
        this.userService = userService;
        this.facilityService = facilityService;
    }

    /**Lista todos los contractos de la base de datos, sus datos como fechas, assistente y cliente - works! */
    @GetMapping("/contract")
    public ResponseEntity<List<Contract>> getContract() {
        return ResponseEntity.ok().body(contractService.findAllContracts());
    }

    /*@GetMapping("/contract")
    @PreAuthorize("hasRole('USER')")
    List<Facility> getContracts(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return contractService.getFacilityByUser(userDetails.getId());
    }
*/
    /*@PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<?> addToContract(@RequestParam("id") Long contractId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        contractService.addContract(userDetails.getId(), contractId);

        return ResponseEntity.ok(new MessageResponse("Solicitud enviada"));
    }*/

    /*@DeleteMapping("/remove")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<?> removeContract(@RequestParam("id") Long contractId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        contractService.removeFromContract(userDetails.getId(), contractId);

        return ResponseEntity.ok(new MessageResponse("Solicitud removida"));
    }*/




    /*@GetMapping("/contract/{id}")
    public ResponseEntity<List<Contract>> getContractByUserId(@PathVariable Long id) {
        return contractService.findContractById(id);
    }
*/
    /*@PostMapping("/user/{user_id}/addContract/{facilit_id}")
    public ResponseEntity<?> addContract1(Authentication authentication, @RequestBody Contract contract) {
        Optional<User> user = userService.getUserByUsername(authentication.getPrincipal().toString());
        System.out.println("Current user contract: " + user.get().getUsername());
        return ResponseEntity.ok(contractService.addContract(authentication, contract));
    }*/


          /* UUID uuid = UUID.randomUUID();
        items.forEach((contract) -> {
            Contract contracts = new Contract();
            contracts.setFacilit(facilitService.findFacilityById(contract.getFacilit().getId()));
            contracts.setTotalPrice(contract.getTotalPrice());
            contracts.setUser(user);
            contractService.addContract(contracts);
        });
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/uniquecare/contract/{id}/").toUriString());
        return ResponseEntity.created(uri).build();*/
}

