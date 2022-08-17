package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.models.Facility;

import java.util.List;

public interface IContractService {


    Contract addContract (Contract contract);
    /** works*/
    List<Contract> findAllContracts();
    Contract findContractById(Long id);
    void deleteContractById(Long id);
    Contract updateContract (Contract contract);
    List<Contract> getContractByUser(Long userId);
    List<Contract> getContractByAssistant(Long assistantId);

}
