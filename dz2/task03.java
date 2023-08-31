package exceptions_and_mistakes.dz2;

import java.util.Scanner;

public class task03 {

    public static void checkNumber(int number1, int number2, int number3) throws NumberOutOfRangeException,
            NumberSumException, DivisionByZeroException {

        if (number1 > 100)  {
            throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        }if(number2 < 0) {
            throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        }if((number1 + number2) < 10) {
            throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        }if(number3 == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        } else System.out.println("Проверка пройдена успешно");
    }

    static class NumberOutOfRangeException extends Exception {
        public NumberOutOfRangeException(String message) {
            super(message);
        }
    }

    static class NumberSumException extends Exception {
        public NumberSumException(String message) {
            super(message);
        }
    }

    static class DivisionByZeroException extends Exception {
        public DivisionByZeroException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

// Задача3: - по желанию
// Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:
// Если первое число больше 100, выбросить исключение NumberOutOfRangeException с сообщением "Первое число вне допустимого диапазона".
// Если второе число меньше 0, выбросить исключение NumberOutOfRangeException с сообщением "Второе число вне допустимого диапазона".
// Если сумма первого и второго чисел меньше 10, выбросить исключение NumberSumException с сообщением "Сумма первого и второго чисел слишком мала".
// Если третье число равно 0, выбросить исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
// В противном случае программа должна выводить сообщение "Проверка пройдена успешно".
// Необходимо создать 3 класса собственных исключений.

        Scanner iScannerInt = new Scanner(System.in);
        System.out.println("Введите поочередно три целых числа: ");
        int num1 = iScannerInt.nextInt();
        int num2 = iScannerInt.nextInt();
        int num3 = iScannerInt.nextInt();
        try {
            checkNumber(num1, num2, num3);
        } catch (NumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        } catch (NumberSumException e) {
            System.out.println(e.getMessage());
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}
