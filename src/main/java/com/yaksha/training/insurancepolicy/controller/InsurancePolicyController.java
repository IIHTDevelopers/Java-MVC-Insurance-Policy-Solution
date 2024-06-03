package com.yaksha.training.insurancepolicy.controller;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import com.yaksha.training.insurancepolicy.service.InsurancePolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String listInsurancePolicies(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<InsurancePolicy> insurancePolicies = insurancePolicyService.getInsurancePolicies(pageable);
        model.addAttribute("insurancePolicys", insurancePolicies.getContent());
        model.addAttribute("theSearchName", "");
        model.addAttribute("totalPage", insurancePolicies.getTotalPages());
        model.addAttribute("page", pageable.getPageNumber());
        model.addAttribute("sortBy", pageable.getSort().get().count() != 0 ?
                pageable.getSort().get().findFirst().get().getProperty() + "," + pageable.getSort().get().findFirst().get().getDirection() : "");
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

    @RequestMapping("/search")
    public String searchInsurancePolicys(@RequestParam(value = "theSearchName", required = false) String theSearchName,
                                         @PageableDefault(size = 5) Pageable pageable,
                                         Model theModel) {

        Page<InsurancePolicy> insurancePolicies = insurancePolicyService.searchInsurancePolicies(theSearchName, pageable);
        theModel.addAttribute("insurancePolicys", insurancePolicies.getContent());
        theModel.addAttribute("theSearchName", theSearchName != null ? theSearchName : "");
        theModel.addAttribute("totalPage", insurancePolicies.getTotalPages());
        theModel.addAttribute("page", pageable.getPageNumber());
        theModel.addAttribute("sortBy", pageable.getSort().get().count() != 0 ?
                pageable.getSort().get().findFirst().get().getProperty() + "," + pageable.getSort().get().findFirst().get().getDirection() : "");

        return "list-insurancePolicies";
    }

    @GetMapping("/updateClaimed")
    public String updateAvailability(@RequestParam("policyId") Long id) {
        insurancePolicyService.updateInsurancePolicyClaimed(id);
        return "redirect:/insurancePolicy/list";
    }

}
