package com.yaksha.training.insurancepolicy.controller;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import com.yaksha.training.insurancepolicy.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(value = {"/insurancePolicy", "/"})
public class InsurancePolicyController {

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    private InsurancePolicyService insurancePolicyService;

    @GetMapping(value = {"/list", "/"})
    public String listInsurancePolicys(Model model) {
        List<InsurancePolicy> insurancePolicys = insurancePolicyService.getInsurancePolicys();
        model.addAttribute("insurancePolicys", insurancePolicys);
        return "list-insurancePolicies";
    }

    @GetMapping("/addInsurancePolicyForm")
    public String showFormForAdd(Model model) {
        InsurancePolicy insurancePolicy = new InsurancePolicy();
        model.addAttribute("insurancePolicy", insurancePolicy);
        return "add-insurancePolicy-form";
    }

    @PostMapping("/saveInsurancePolicy")
    public String saveInsurancePolicy(@Valid @ModelAttribute("insurancePolicy") InsurancePolicy insurancePolicy, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if (insurancePolicy.getId() != null) {
                return "update-insurancePolicy-form";
            }
            return "add-insurancePolicy-form";
        } else {
            insurancePolicyService.saveInsurancePolicy(insurancePolicy);
            return "redirect:/insurancePolicy/list";
        }
    }

    @GetMapping("/updateInsurancePolicyForm")
    public String showFormForUpdate(@RequestParam("insurancePolicyId") Long id, Model model) {
        InsurancePolicy insurancePolicy = insurancePolicyService.getInsurancePolicy(id);
        model.addAttribute("insurancePolicy", insurancePolicy);
        return "update-insurancePolicy-form";
    }

    @GetMapping("/delete")
    public String deleteInsurancePolicy(@RequestParam("insurancePolicyId") Long id) {
        insurancePolicyService.deleteInsurancePolicy(id);
        return "redirect:/insurancePolicy/list";
    }

    @PostMapping("/search")
    public String searchInsurancePolicys(@RequestParam("theSearchName") String theSearchName,
                                         Model theModel) {

        List<InsurancePolicy> theInsurancePolicys = insurancePolicyService.searchInsurancePolicys(theSearchName);
        theModel.addAttribute("insurancePolicys", theInsurancePolicys);
        return "list-insurancePolicies";
    }
}
