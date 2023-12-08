package com.yaksha.training.insurancepolicy.exception;

import com.yaksha.training.insurancepolicy.controller.InsurancePolicyController;
import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import static com.yaksha.training.insurancepolicy.utils.MasterData.getInsurancePolicy;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.currentTest;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.exceptionTestFile;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.testReport;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class InsurancePolicyExceptionTest {

    @InjectMocks
    private InsurancePolicyController insurancePolicyController;

    private MockMvc mockMvc;

    BindingResult bindingResult = mock(BindingResult.class);

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(insurancePolicyController).build();
    }

    @After
    public void afterAll() {
        testReport();
    }

    @Test
    public void testExceptionSaveInsurancePolicyFirstNameAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setId(null);
        insurancePolicy.setFirstName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveInsurancePolicyLastNameAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setId(null);
        insurancePolicy.setLastName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveInsurancePolicyDateAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setId(null);
        insurancePolicy.setStartDate(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveInsurancePolicyAmountAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setId(null);
        insurancePolicy.setAmount(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveInsurancePolicyInterestAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setId(null);
        insurancePolicy.setInterest(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveInsurancePolicyTenureAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setId(null);
        insurancePolicy.setTenure(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form")), exceptionTestFile);
    }


    @Test
    public void testExceptionSaveInsurancePolicyNomineeAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setId(null);
        insurancePolicy.setNominee(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveInsurancePolicyNameAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setId(null);
        insurancePolicy.setPolicyName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form")), exceptionTestFile);
    }


    @Test
    public void testExceptionUpdateInsurancePolicyFirstNameAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setFirstName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateInsurancePolicyLastNameAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setLastName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateInsurancePolicyDateAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setStartDate(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateInsurancePolicyAmountAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setAmount(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateInsurancePolicyInterestAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setInterest(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateInsurancePolicyTenureAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setTenure(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form")), exceptionTestFile);
    }


    @Test
    public void testExceptionUpdateInsurancePolicyNomineeAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setNominee(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateInsurancePolicyNameAsNull() throws Exception {
        InsurancePolicy insurancePolicy = getInsurancePolicy();
        insurancePolicy.setPolicyName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveInsurancePolicy")
                .flashAttr("insurancePolicy", insurancePolicy)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form")), exceptionTestFile);
    }


}