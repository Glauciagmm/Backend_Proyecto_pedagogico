package com.uniquecare.pedagogico_backend.controllers;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping ("/uniquecare")
//@CrossOrigin(origins="*")
//public class ContractController {
//
//    private final IContractService contractService;
//    private final IUserService userService;
//    private final IFacilitService facilitService;
//
//    @GetMapping("/contract")
//    public ResponseEntity<List<Contract>> getContract() {
//        return ResponseEntity.ok().body(contractService.findAllContracts());
//    }
//
///*    @GetMapping("/contract/{id}")
//    public ResponseEntity<List<Contract>> getContractByUserId(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok().body(user.getContract());
//    }*/
//
//    @PostMapping("/user/{user_id}/addContract/{facilit_id}")
//    public ResponseEntity<?> addContract(Authentication authentication, @RequestBody Contract contract) {
//        Optional<User> user = userService.getUserByUsername(authentication.getPrincipal().toString());
//        System.out.println("Current user contract: " + user.get().getUsername());
//        return ResponseEntity.ok(contractService.addContract(authentication, contract));
//    }
//          /* UUID uuid = UUID.randomUUID();
//        items.forEach((contract) -> {
//            Contract contracts = new Contract();
//            contracts.setFacilit(facilitService.findFacilityById(contract.getFacilit().getId()));
//            contracts.setTotalPrice(contract.getTotalPrice());
//            contracts.setUser(user);
//            contractService.addContract(contracts);
//        });
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/uniquecare/contract/{id}/").toUriString());
//        return ResponseEntity.created(uri).build();*/
//
//
//
//
//
//}
