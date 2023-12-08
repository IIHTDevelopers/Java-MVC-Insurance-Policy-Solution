package com.yaksha.training.insurancepolicy.service;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import com.yaksha.training.insurancepolicy.repository.InsurancePolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService {

    private final InsurancePolicyRepository insurancePolicyRepository;

    public InsurancePolicyService(InsurancePolicyRepository insurancePolicyRepository) {
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    public List<InsurancePolicy> getInsurancePolicys() {
        List<InsurancePolicy> insurancePolicys = insurancePolicyRepository.findAll();
        return insurancePolicys;
    }

    public InsurancePolicy saveInsurancePolicy(InsurancePolicy insurancePolicy) {
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public InsurancePolicy getInsurancePolicy(Long id) {
        return insurancePolicyRepository.findById(id).get();
    }

    public boolean deleteInsurancePolicy(Long id) {
        insurancePolicyRepository.deleteById(id);
        return true;
    }

    public List<InsurancePolicy> searchInsurancePolicys(String theSearchName) {
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            return insurancePolicyRepository.findByFirstNameAndLastName(theSearchName);
        } else {
            return insurancePolicyRepository.findAll();
        }
    }
}
