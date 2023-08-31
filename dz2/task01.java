package exceptions_and_mistakes.dz2;

import java.util.Scanner;

public class task01 {


    public static void main(String[] args) {
// Задача 1:
// Напишите программу, которая запрашивает у пользователя число и проверяет, является ли оно положительным.
// Если число отрицательное или равно нулю, программа должна выбрасывать исключение InvalidNumberException с
// сообщением "Некорректное число". В противном случае программа должна выводить сообщение "Число корректно".

        Scanner iScannerInt = new Scanner(System.in);
        System.out.println("Введите любое целое число: ");
        int num = iScannerInt.nextInt();
        try {
            inputNumber(num);
        } catch (InvalidNumberException e){
            System.out.println(e.getMessage());
        }
    }

    public static void inputNumber(int number) throws InvalidNumberException {

        if(number > 0){
            System.out.println("Число корректно");
        }else {
            throw new InvalidNumberException("Некорректное число");
        }
    }

    static class InvalidNumberException extends Exception {
        public InvalidNumberException(String message) {
            super(message);
        }
    }
}
