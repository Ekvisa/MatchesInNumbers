package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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

        //предположим, что есть нули перед старшим регистром:
        boolean isNullsBefore_n1 = true;
        boolean isNullsBefore_n2 = true;

        for (int i = 4; i > 0; i--) {
            int sn1 = symbolByNumber (n1, i);
            //System.out.println("Символ на " + i + "-й позиции с конца числа " + n1 + ": " + sn1);
            if (sn1 != 0) {isNullsBefore_n1 = false;} //ура, найденный символ - не ноль перед регистром...
            if (isNullsBefore_n1 == false) {  //...тогда будем сравнивать его с символами второго числа...
                for (int j = 4; j > 0; j--) {
                    int sn2 = symbolByNumber (n2, j);
                    if (sn2 != 0) {isNullsBefore_n2 = false;} //...если они, в свою очередь, не нули перед регистром.
                    if (isNullsBefore_n2 == false) {
                        if (sn1 == sn2) {
                            //System.out.println("Есть совпадение: " + sn1 + ", i = " + i + ", j = " + j);
                            System.out.print(sn1);
                            break; //чтобы не выводить лишнего, если встречается во втором числе больше одного раза
                        }
                    }
                }
            }
            isNullsBefore_n2 = true; //перед следующим прогоном по символам первого числа вспомним, что во втором числе может быть спереди ноль
        }

    }

    public static int symbolByNumber (int n, int i) { //в числе n ищет i-й символ с конца
        return (n % (int)Math.pow(10, i)) / (int)Math.pow(10, i -1);
    }
}
