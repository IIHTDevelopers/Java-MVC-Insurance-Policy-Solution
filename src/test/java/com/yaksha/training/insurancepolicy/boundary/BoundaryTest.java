package com.yaksha.training.insurancepolicy.boundary;


import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.yaksha.training.insurancepolicy.utils.MasterData.getInsurancePolicy;
import static com.yaksha.training.insurancepolicy.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.boundaryTestFile;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.currentTest;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.testReport;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.yakshaAssert;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    public void testFirstNameNotBlank() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setFirstName("");
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testFirstNameNotNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setFirstName(null);
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testFirstNameMinThree() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setFirstName(randomStringWithSize(2));
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testFirstNameMaxFifty() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setFirstName(randomStringWithSize(51));
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLastNameNotBlank() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setLastName("");
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLastNameNotNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setLastName(null);
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLastNameMinThree() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setLastName(randomStringWithSize(2));
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLastNameMaxFifty() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setLastName(randomStringWithSize(51));
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testAmountNotNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setAmount(null);
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testInterestNotNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setInterest(null);
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testTenureNotNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setTenure(null);
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testNomineeNotBlank() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setNominee("");
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testNomineeNotNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setNominee(null);
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testPolicyNameNotBlank() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setPolicyName("");
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testPolicyNameNotNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setPolicyName(null);
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testInsurancePolicyStartDateDateNotBlank() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setStartDate("");
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testInsurancePolicyStartDateDateNotNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setStartDate(null);
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testInsurancePolicyStartDateDateInValidFormat() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setStartDate(randomStringWithSize(10));
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testInsurancePolicyStartDateDateValidFormat() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setStartDate("2023-01-01");
        Set<ConstraintViolation<InsurancePolicy>> violations = validator.validate(insurancePolicy);
        yakshaAssert(currentTest(), !violations.isEmpty() ? false : true, boundaryTestFile);
    }

}
