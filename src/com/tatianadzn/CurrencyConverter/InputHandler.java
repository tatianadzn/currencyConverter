package com.tatianadzn.CurrencyConverter;

import java.util.Scanner;

public abstract class InputHandler {
    private static double inputValue;


    public static double getInputValue(){
        scanUserInput();
        while(!isInputCorrect()){
            System.out.println("Input is incorrect, try again");
            scanUserInput();
        }
        return inputValue;
    }

    private static void scanUserInput(){
        Scanner scanner = new Scanner(System.in);
        inputValue = scanner.nextDouble();
    }

    private static boolean isInputCorrect(){
        return inputValue > 0;
    }
}
