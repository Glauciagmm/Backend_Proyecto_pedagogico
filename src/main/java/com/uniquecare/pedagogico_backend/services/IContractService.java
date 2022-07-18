package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Contract;

import java.util.List;

public interface IContractService {

    Contract addContract (Contract contract);
    List<Contract> findAllContracts();
    Contract findContractById(Long id);
    void deleteContractById(Long id);
    Contract updateContract (Contract contract);
}
