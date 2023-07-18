package com.java21.lesson4;
import java.util.Scanner;
public class PrimeCheck {
    public static void main(String args[]) {
        int temp;

        boolean isPrime = true;
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                isPrime = false;
                temp = num % i;
                System.out.println(temp);
                break;
            }

        }
        System.out.println(num + ((isPrime)?" is":" is not") + " a prime number");
    }
}
