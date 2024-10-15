package test;

import ComplexMatrix.ComplexNumber;

import java.util.Scanner;

public class main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 3; ++j){
                System.out.println("Enter numbers like: r and i: -5 6 (= -5+6i)");

                int real = scanner.nextInt(), img = scanner.nextInt();
                System.out.println(real + " " + img + "i");
            }
        }

        scanner.close();
    }
}
