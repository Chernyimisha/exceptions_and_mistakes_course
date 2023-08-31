package exceptions_and_mistakes.dz2;

import java.util.Scanner;

public class task02 {

    public static double divide(int dividend, int divisor) throws DivisionByZeroException {
        if (divisor == 0)  {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }

        return (double) dividend / divisor;
    }

    static class DivisionByZeroException extends Exception {
        public DivisionByZeroException(String message) {
            super(message);
        }
    }
    public static void main(String[] args) {

// Задача 2:
// Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление. Если второе число равно
// нулю, программа должна выбрасывать исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
// В противном случае программа должна выводить результат деления.
// Обратите внимание, что в обеих задачах используются собственные исключения, которые наследуются от класса Exception.
// Это позволяет нам определить специфическую причину ошибки и передать информацию об ошибке для последующей обработки.

        Scanner iScannerInt = new Scanner(System.in);
        System.out.println("Введите делимое целое число: ");
        int num1 = iScannerInt.nextInt();
        System.out.println("Введите делимое целое число: ");
        int num2 = iScannerInt.nextInt();
        try {
            System.out.println(divide(num1, num2));
        } catch (DivisionByZeroException e){
            System.out.println(e.getMessage());
        }
    }
}
