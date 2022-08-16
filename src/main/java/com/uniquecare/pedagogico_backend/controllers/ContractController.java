package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.models.Facility;

import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.payload.request.ContractRequest;
import com.uniquecare.pedagogico_backend.payload.response.MessageResponse;
import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin(origins="*")
public class ContractController {

    private final IContractService contractService;
    private final IUserService userService;
    private final IFacilityService facilityService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FacilityRepository facilityRepository;

    @Autowired
    public ContractController(IContractService contractService, IUserService userService, IFacilityService facilityService) {
        this.contractService = contractService;
        this.userService = userService;
        this.facilityService = facilityService;
    }

    /**
     * Lista todos los contractos de la base de datos, sus datos como fechas, assistente y cliente - works!
     */
    @GetMapping("/contract")
    public ResponseEntity<List<Contract>> getContract() {
        return ResponseEntity.ok().body(contractService.findAllContracts());
    }

    /**
     * Encuentra un contracto cuando le pasas su ID -  works!
     */
    @GetMapping("/contract/{id}")
    public Contract findContractById(@PathVariable("id") Long id) {
        return contractService.findContractById(id);
    }

    /**
     * Lista todos los contractos de la base de datos, sus datos como fechas, assistente y cliente - works! Preciso controlar que sea los contractos que tenga el user logueado
     */
    @GetMapping("/contract/list")
    public ResponseEntity<List<Contract>> getContract(Authentication authentication, HttpSession session) {
        if (authentication == null) {
            System.out.println("Es necesario que hagas el login");
        } else {
            String username = authentication.getPrincipal().toString();
            System.out.println(username);
        }
        return ResponseEntity.ok().body(contractService.findAllContracts());
    }

    @PostMapping("/contract/add")
    public ResponseEntity<Contract> addContract(Authentication authentication, @RequestBody ContractRequest contractRequest) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/contract/add").toUriString());
        if (authentication == null) {
            System.out.println("Es necesario que hagas el login");
        } else {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            System.out.println(userDetails.getUsername());
            User user = userRepository.getByUsername(userDetails.getUsername());
            Facility facility = facilityService.findFacilityById(contractRequest.getFacility_id());
            Contract contract = new Contract();
            contract.setStart(contractRequest.getStart());
            contract.setFinish(contractRequest.getFinish());
            contract.setTotalPrice(contractRequest.getTotalPrice());
            contract.setFacility(facility);
            contract.setClient(user);
            return ResponseEntity.created(uri).body(contractService.addContract(contract));
        }
        return ResponseEntity.internalServerError().build();
    }





/*    @PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<?> addToContract(@RequestParam("id") Long contractId, @RequestBody ContractRequest contractRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.getByUsername(userDetails.getUsername());
        Facility facility = facilityService.findFacilityById(contractRequest.getFacility_id());
        Contract contract = new Contract();
        contract.setStart(contractRequest.getStart());
        contract.setFinish(contractRequest.getFinish());
        contract.setTotalPrice(contractRequest.getTotalPrice());
        contract.setFacility(facility);
        contract.setClient(user);
    return ResponseEntity.created(authentication).body(contractService.addContract(contract));

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

