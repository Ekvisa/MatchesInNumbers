package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {

        int n1;
        int n2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Первое число: ");
            n1 = Integer.parseInt(reader.readLine());
            if (n1 >= 10000) {System.out.println("Слишком большое!");}
            else {break;}
        }

        while (true) {
            System.out.println("Второе число: ");
            n2 = Integer.parseInt(reader.readLine());
            if (n2 >= 10000) {System.out.println("Слишком большое!");}
            else {break;}
        }

        for (int i = 1000; i >= 1; i /= 10) { //идём по разрядям первого числа
            if ((n1 >= i) || (i == 1)) { //если в рассматриваемом разряде не ноль, кроме последнего разряда
                int sn1 = (n1 / i) % 10; //бьём на символы первое число
                for (int j = 1000; j >= 1; j /= 10) { //идём по разрядям второго числа
                    if ((n2 >= j) || (j == 1)) { //если в рассматриваемом разряде не ноль, кроме последнего разряда
                        int sn2 = (n2 / j) % 10; //бьём на символы второе число
                        if (sn1 == sn2) {
                            System.out.print(sn1);
                            break;
                        }
                    }
                }
            }
        }
    }

}
