package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.services.IContractService;
import com.uniquecare.pedagogico_backend.services.IFacilitService;
import com.uniquecare.pedagogico_backend.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/uniquecare")
@CrossOrigin(origins="*")
public class ContractController {

    private final IContractService contractService;
    private final IUserService userService;
    //private final IFacilitService facilitService;

    @GetMapping("/contract")
    public ResponseEntity<List<Contract>> getOrders() {
        return ResponseEntity.ok().body(contractService.findAllContracts());
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity <List<Contract>> getContractByUserId(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user.getContract());
    }

  /*  @PostMapping("/contract/checkout")
    public ResponseEntity<List<Contract>> checkout(Authentication authentication, @RequestBody List<Contract> items){
        User user = userService.getUserByUsername(authentication.getPrincipal().toString());
        System.out.println("Current user contract: " + user.getName());
        UUID uuid = UUID.randomUUID();
        items.forEach((contract) -> {
            Contract contracts = new Contract();
            contracts.setFacilit(facilitService.findFacilityById(contract.getFacilit().getId()));
            contracts.setTotalPrice(contract.getTotalPrice());
            contracts.setUser(user);
            contractService.addContract(contracts);
        });
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/uniquecare/contract/{id}/checkout").toUriString());
        return ResponseEntity.created(uri).build();
    }*/



}
