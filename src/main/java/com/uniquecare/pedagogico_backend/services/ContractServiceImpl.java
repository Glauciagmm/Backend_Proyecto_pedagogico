package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.repositories.ContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
