package com.yaksha.training.insurancepolicy.service;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import com.yaksha.training.insurancepolicy.repository.InsurancePolicyRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    public void testServiceGetInsurancePolicys() throws Exception {
        List<InsurancePolicy> actual = getInsurancePolicyList(5);
        when(insurancePolicyRepository.findAll()).thenReturn(actual);
        List<InsurancePolicy> expected = insurancePolicyService.getInsurancePolicys();
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
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
        when(insurancePolicyRepository.findAll()).thenReturn(actual);
        List<InsurancePolicy> expected = insurancePolicyService.searchInsurancePolicys(null);
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceSearchInsurancePolicyWithSearchName() throws Exception {
        String searchKey = randomStringWithSize(2);
        List<InsurancePolicy> actual = getInsurancePolicyList(5);
        when(insurancePolicyRepository.findByFirstNameAndLastName(searchKey)).thenReturn(actual);
        List<InsurancePolicy> expected = insurancePolicyService.searchInsurancePolicys(searchKey);
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

}
