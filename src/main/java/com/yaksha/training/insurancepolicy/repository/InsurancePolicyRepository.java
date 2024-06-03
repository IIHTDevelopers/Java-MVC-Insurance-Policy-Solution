package com.yaksha.training.insurancepolicy.repository;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

    @Query("SELECT i FROM InsurancePolicy i")
    Page<InsurancePolicy> findAllInsurancePolicy(Pageable pageable);

    @Query(value = "Select c from InsurancePolicy c where lower(firstName) like %:keyword% " +
            "or lower(lastName) like %:keyword% " +
            "or lower(policyName) like %:keyword%")
    Page<InsurancePolicy> findByFirstNameOrLastNameOrPolicyName(@Param("keyword") String keyword, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE insurance_policy SET is_claimed = 1 where id = :id", nativeQuery = true)
    void updateInsurancePolicyClaimed(@Param("id") Long id);

}
