package org.example.cli;

import org.example.httpdownload.HttpStatusImageDownloader;

import java.util.Scanner;

public class HttpImageStatusCli {
    HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
    private static final Scanner SCANNER = new Scanner(System.in);
    public void askStatus(){
        System.out.println("Enter HTTP status code");
        int statusCode = 0;
       do {
           try {
               String s = SCANNER.nextLine();
               statusCode = Integer.parseInt(s);
           } catch (Exception ex){
               System.out.println("Please enter valid number");
           }
       } while (statusCode == 0);


        try {
            imageDownloader.downloadStatusImage(statusCode);
        } catch (Exception e) {
            System.out.printf("There isn't any image for HTTP status %d\n",statusCode);
        }
    }
}
