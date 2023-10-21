package org.example;

import org.example.cli.HttpImageStatusCli;

public class Main {
    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
       while (true){
           cli.askStatus();
       }
    }
}
