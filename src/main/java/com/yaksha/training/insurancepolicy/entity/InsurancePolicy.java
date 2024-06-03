package com.yaksha.training.insurancepolicy.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "InsurancePolicy")
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;

    @NotNull
    private Double amount;

    @NotNull
    private Long interest;

    @NotNull
    private Long tenure;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotBlank
    private String nominee;

    @NotBlank
    private String policyName;

    @NotNull
    private Boolean is_claimed = false;

    public InsurancePolicy() {

    }

    public InsurancePolicy(Long id, String firstName, String lastName, Double amount, Long interest, Long tenure, LocalDate startDate, String nominee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.interest = interest;
        this.tenure = tenure;
        this.startDate = startDate;
        this.nominee = nominee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getInterest() {
        return interest;
    }

    public void setInterest(Long interest) {
        this.interest = interest;
    }

    public Long getTenure() {
        return tenure;
    }

    public void setTenure(Long tenure) {
        this.tenure = tenure;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Boolean getIs_claimed() {
        return is_claimed;
    }

    public void setIs_claimed(Boolean is_claimed) {
        this.is_claimed = is_claimed;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amount=" + amount +
                ", interest=" + interest +
                ", tenure='" + tenure + '\'' +
                ", startDate='" + startDate + '\'' +
                ", nominee='" + nominee + '\'' +
                '}';
    }
}

