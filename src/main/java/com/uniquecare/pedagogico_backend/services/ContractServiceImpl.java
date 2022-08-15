package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.repositories.ContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ContractServiceImpl implements IContractService {

   private final ContractRepository contractRepository;
   private final IUserService userService;
   private final IFacilityService facilityService;

   @Autowired
   public ContractServiceImpl (IUserService userService, IFacilityService facilityService, ContractRepository contractRepository){
       this.userService = userService;
       this.facilityService = facilityService;
       this.contractRepository = contractRepository;
   }

    @Override
        public Contract addContract(Contract contract) {
            return contractRepository.save(contract);
        }
@Override
    public List<Contract> findAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findContractById(Long id) {
        return contractRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("Contrato no encontrado"));
    }


    @Override
    public void deleteContractById(Long id) {
        contractRepository.deleteById(id);

    }

    @Override
    public Contract updateContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> getContractByUser(Long userId) {
        return userService.getContractByUserId(userId);
    }

    @Override
    public List<Contract> getContractByAssistant(Long assistantId) {
        return userService.getContractByAssistantId(assistantId);
    }

/*    @Override
    public Contract addContract(Authentication authentication, Contract contract) {
        return contractRepository.save(contract);
    }*/

   /* @Override
    public Contract addContract(Long userId, Long facilityId) {
        User user = userService.getUserById(userId);

        Facility facility = facilityService.findFacilityById(facilityId);

        if (!user.sendRequest(facility)) {
            user.addContract(facility);

            userService.save(user);
        } else {
            throw new RuntimeException("Solicitud enviada previament");
        }
        return null;
    }*/



   /* @Override
    public List<Facility> getFacilityByUser(Long userId) {
        return facilityService.getContractByUserID(userId);
    }
*/


    /*@Override
    public void removeFromContract(Long userId, Long facilityId) {
        facilityService.removeFacilityFromContract(userId, facilityId);
    }*/
    /*
    @Override
    public void deleteContractById(Long UserId, Long facilityId) {

    }*/

}
