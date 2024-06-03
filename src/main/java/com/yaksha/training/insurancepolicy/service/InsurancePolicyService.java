package com.yaksha.training.insurancepolicy.service;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import com.yaksha.training.insurancepolicy.repository.InsurancePolicyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService {

    private final InsurancePolicyRepository insurancePolicyRepository;

    public InsurancePolicyService(InsurancePolicyRepository insurancePolicyRepository) {
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    public Page<InsurancePolicy> getInsurancePolicies(Pageable pageable) {
        return insurancePolicyRepository.findAllInsurancePolicy(pageable);
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

    public Page<InsurancePolicy> searchInsurancePolicies(String theSearchName, Pageable pageable) {
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            return insurancePolicyRepository.findByFirstNameOrLastNameOrPolicyName(theSearchName, pageable);
        } else {
            return insurancePolicyRepository.findAllInsurancePolicy(pageable);
        }
    }

    public boolean updateInsurancePolicyClaimed(Long id) {
        insurancePolicyRepository.updateInsurancePolicyClaimed(id);
        return true;
    }
}
