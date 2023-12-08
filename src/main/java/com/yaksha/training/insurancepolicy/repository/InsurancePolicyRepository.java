package com.yaksha.training.insurancepolicy.repository;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

    @Query(value = "Select c from InsurancePolicy c where lower(firstName) like %:keyword% or lower(lastName) like %:keyword%")
    List<InsurancePolicy> findByFirstNameAndLastName(@Param("keyword") String keyword);
}
