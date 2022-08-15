package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.models.Facility;

import java.util.List;

public interface IContractService {


    Contract addContract (Contract contract);
    List<Contract> findAllContracts();
    Contract findContractById(Long id);
    void deleteContractById(Long id);
    Contract updateContract (Contract contract);
    List<Contract> getContractByUser(Long userId);

    List<Contract> getContractByAssistant(Long assistantId);

    //List<Facility> getFacilityByUser(Long id);
    //void removeFromContract(Long id, Long contractId);
    //void deleteContractById(Long UserId, Long facilityId);
    //List<Contract> getContractByUser (Long userId);
    //Contract addContract (Long authentication, Long contract);
}
