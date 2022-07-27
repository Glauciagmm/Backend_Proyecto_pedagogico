package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Contract;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.List;

public interface IContractService {

    Contract addContract (Authentication authentication,Contract contract);
    List<Contract> findAllContracts();
    Contract findContractById(Long id);
    void deleteContractById(Long id);
    Contract updateContract (Contract contract);

}
