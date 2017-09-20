package com.desking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by User on 19.09.2017.
 */
public class PhoneNumberController {
private Set<String> contentsOfFiles;
private Set<String> phoneNumbersFullFormat;

    public PhoneNumberController(List<String> contentsOfFiles) {
        this.contentsOfFiles = new HashSet<>(contentsOfFiles);
        phoneNumbersFullFormat = new TreeSet<>();
    }

    public Set<String> getPhoneNumbersFullFormat() {
       stringLeadingFullFormatOfPhoneNumber();
        return phoneNumbersFullFormat;
    }



    private void  stringLeadingFullFormatOfPhoneNumber() {
        for(String string: contentsOfFiles){
            string = string.replaceAll("(?u)[^0-9]", "");
        if(isNumberPhone(string)) {
            phoneNumbersFullFormat.add(leadPhoneNumberToTheFullFormat(additionSymbolsOfPhoneNumber(string)));

        }
        }

    }

    private String additionSymbolsOfPhoneNumber(String string) {
        StringBuilder phoneNumber = new StringBuilder(string);
        int lengthPhoneNumber = phoneNumber.length();

        if (lengthPhoneNumber == 10) {
            phoneNumber.insert(0, "7");
        } else if (lengthPhoneNumber == 7) {
            phoneNumber.insert(0, "7812");
        }
        return phoneNumber.toString();
    }

    private boolean isNumberPhone(String string) {
        int lenght = string.length();
        return lenght == 11 || lenght ==10 || lenght ==7;
    }

    private String leadPhoneNumberToTheFullFormat(String phoneNumber) {
            return leadPhoneNumberToTheFullFormat(new StringBuilder(phoneNumber));

    }

    private String leadPhoneNumberToTheFullFormat(StringBuilder phoneNumber) {
        phoneNumber.insert(0, "+");
        phoneNumber.insert(2, " ");
        phoneNumber.insert(3, "(");
        phoneNumber.insert(7, ")");
        phoneNumber.insert(8, " ");
        phoneNumber.insert(12, "-");

        return phoneNumber.toString();
    }



}
