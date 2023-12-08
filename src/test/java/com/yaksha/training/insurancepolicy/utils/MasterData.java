package com.yaksha.training.insurancepolicy.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MasterData {

    private static Random rnd = new Random();

    public static InsurancePolicy getInsurancePolicy() {
        InsurancePolicy insurancePolicy = new InsurancePolicy();
        insurancePolicy.setId(1L);
        insurancePolicy.setFirstName(randomStringWithSize(10));
        insurancePolicy.setLastName(randomStringWithSize(10));
        insurancePolicy.setAmount(100D);
        insurancePolicy.setInterest(1L);
        insurancePolicy.setTenure(1L);
        insurancePolicy.setStartDate("2023-01-01");
        insurancePolicy.setNominee(randomStringWithSize(10));
        insurancePolicy.setPolicyName(randomStringWithSize(10));
        return insurancePolicy;
    }

    public static List<InsurancePolicy> getInsurancePolicyList(int size) {
        Long id = 0L;
        List<InsurancePolicy> insurancePolicys = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            InsurancePolicy insurancePolicy = new InsurancePolicy();
            insurancePolicy.setId(++id);
            insurancePolicy.setFirstName(randomStringWithSize(10));
            insurancePolicy.setLastName(randomStringWithSize(10));
            insurancePolicy.setAmount(100D);
            insurancePolicy.setInterest(1L);
            insurancePolicy.setTenure(1L);
            insurancePolicy.setStartDate("2023-01-01");
            insurancePolicy.setNominee(randomStringWithSize(10));
            insurancePolicy.setPolicyName(randomStringWithSize(10));
            insurancePolicys.add(insurancePolicy);
        }
        return insurancePolicys;
    }


    public static String randomStringWithSize(int size) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + (String.valueOf(alphabet.charAt(rnd.nextInt(alphabet.length()))));
        }
        return s;
    }

    public static boolean randomBoolean() {
        String alphabet = "1234567890";
        Random rnd = new Random();
        return rnd.nextInt(alphabet.length()) % 2 == 0;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            final String jsonContent = mapper.writeValueAsString(obj);

            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
