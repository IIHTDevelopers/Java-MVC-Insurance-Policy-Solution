package com.yaksha.training.insurancepolicy.service;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import com.yaksha.training.insurancepolicy.repository.InsurancePolicyRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.yaksha.training.insurancepolicy.utils.MasterData.asJsonString;
import static com.yaksha.training.insurancepolicy.utils.MasterData.getInsurancePolicy;
import static com.yaksha.training.insurancepolicy.utils.MasterData.getInsurancePolicyList;
import static com.yaksha.training.insurancepolicy.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.businessTestFile;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.currentTest;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.testReport;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

public class InsurancePolicyServiceTest {

    @Mock
    private InsurancePolicyRepository insurancePolicyRepository;

    @InjectMocks
    private InsurancePolicyService insurancePolicyService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void afterAll() {
        testReport();
    }

    @Test
    public void testServiceGetInsurancePolicies() throws Exception {
        List<InsurancePolicy> actual = getInsurancePolicyList(5);
        Pageable pageable = PageRequest.of(0, 5);
        Page<InsurancePolicy> insurancePolicies = new PageImpl<>(actual);

        when(insurancePolicyRepository.findAllInsurancePolicy(pageable)).thenReturn(insurancePolicies);
        Page<InsurancePolicy> expected = insurancePolicyService.getInsurancePolicies(pageable);
        yakshaAssert(currentTest(),
                (asJsonString(expected.getContent()).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceSaveInsurancePolicy() throws Exception {
        InsurancePolicy actual = getInsurancePolicy();
        when(insurancePolicyRepository.save(actual)).thenReturn(actual);
        InsurancePolicy expected = insurancePolicyService.saveInsurancePolicy(actual);
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceGetInsurancePolicy() throws Exception {
        InsurancePolicy actual = getInsurancePolicy();
        when(insurancePolicyRepository.findById(actual.getId())).thenReturn(Optional.of(actual));
        InsurancePolicy expected = insurancePolicyService.getInsurancePolicy(actual.getId());
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceDeleteInsurancePolicy() throws Exception {
        InsurancePolicy actual = getInsurancePolicy();
        boolean expected = insurancePolicyService.deleteInsurancePolicy(actual.getId());
        yakshaAssert(currentTest(),
                (expected ? true : false),
                businessTestFile);
    }

    @Test
    public void testServiceSearchInsurancePolicyWithNull() throws Exception {
        List<InsurancePolicy> actual = getInsurancePolicyList(5);
        Pageable pageable = PageRequest.of(0, 5);
        Page<InsurancePolicy> insurancePolicies = new PageImpl<>(actual);
        when(insurancePolicyRepository.findAllInsurancePolicy(pageable)).thenReturn(insurancePolicies);
        Page<InsurancePolicy> expected = insurancePolicyService.searchInsurancePolicies(null, pageable);
        yakshaAssert(currentTest(),
                (asJsonString(expected.getContent()).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceSearchInsurancePolicyWithSearchName() throws Exception {
        String searchKey = randomStringWithSize(2);
        List<InsurancePolicy> actual = getInsurancePolicyList(5);
        Pageable pageable = PageRequest.of(0, 5);
        Page<InsurancePolicy> insurancePolicies = new PageImpl<>(actual);
        when(insurancePolicyRepository.findByFirstNameOrLastNameOrPolicyName(searchKey, pageable))
                .thenReturn(insurancePolicies);
        Page<InsurancePolicy> expected = insurancePolicyService.searchInsurancePolicies(searchKey, pageable);
        yakshaAssert(currentTest(),
                (asJsonString(expected.getContent()).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceUpdateClaimed() throws Exception {
        InsurancePolicy actual = getInsurancePolicy();
        boolean expected = insurancePolicyService.updateInsurancePolicyClaimed(actual.getId());
        yakshaAssert(currentTest(),
                (expected ? true : false),
                businessTestFile);
    }
}
