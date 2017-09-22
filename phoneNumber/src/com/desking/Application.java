package com.desking;

/**
 * Created by User on 19.09.2017.
 */
public class Application {

    public void run(String nameCatalog) {
        FileController fileController = new FileController();
        PhoneNumberController phoneNumberController = new PhoneNumberController(fileController.getContentsOfFiles(nameCatalog));

    System.out.println(phoneNumberController.getPhoneNumbersFullFormat());

    }
}
