package com.desking;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private Set<String> phoneNumbers = new HashSet<>();
    Set<String> phoneNumbersFullFormat = new TreeSet<>();

    public static void main(String[] args) {
        // write your code here
        new Application().run();
    }

//    private void run() {
//        processFilesFromFolder(new File("D:\\TestData"));
//        leadPhoneNumberToTheFullFormat();
//        System.out.println(phoneNumbersFullFormat);
//    }



}
