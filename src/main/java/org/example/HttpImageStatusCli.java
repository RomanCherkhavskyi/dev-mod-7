package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть код запиту");
        String codeStr = scanner.nextLine();
        int code;

        if (!codeStr.matches("^\\d{1,3}$")) {
            System.out.println("Please enter valid number");
        }
        else {
            code = Integer.parseInt(codeStr);
            try {
                new HttpStatusImageDownloader().downloadStatusImage(code);
            } catch (Exception e){
                System.out.println("There is not image for HTTP status "+code);
            }

        }



    }
}
