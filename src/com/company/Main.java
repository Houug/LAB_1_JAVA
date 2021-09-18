package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Перевод из метров в футы
 *
 * @author 1
 */
public class Main {

    /**
     * В этой переменной хранится введеное значение
     */
    static double inputValue;

    /**
     * Округление до n-ого знака поле запятой
     *
     * @param value округляемое занчение
     * @param places сколько знаков после запятой
     * @return Возвращает округленное значение
     */
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    /**
     * Ввод значений в определенном формате
     *
     * @return Возвращает введенное значение
     */
    public static double input() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("Введите значение в метрах (формат - #####,##), чтобы перевести его в футы:");
                double inputValue = roundAvoid(sc.nextDouble(), 2);
                if (inputValue < 0) {
                    throw new Exception("Нужно значение больше нуля!");
                }
                return inputValue;
            } catch (InputMismatchException e) {
                sc.reset();
                System.out.println("Я не понимаю это значит! Повторите ввод!");
            } catch (Exception e) {
                sc.reset();
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Выводит введенные значения метров и сантиментров
     *
     * @param meters метры
     * @param centimeters сантиметры
     */
    public static void output_before(int meters, int centimeters) {
        System.out.println("Вы ввели " + meters + " метра(ов) и " + centimeters + " сантиметра(ов)");
    }

    /**
     * Выводит полученыне значения футов и дюймов
     *
     * @param foot метры
     * @param inches сантиметры
     */
    public static void output_after(int foot, int inches) {
        System.out.println("При переводе получилось " + foot + " фута(ов) и " + inches + " дюйма(ов)");
    }

    /**
     * Обработка значений
     *
     * @param inputValue значение которое будем обрабатывать
     * @return Возвращает массив значений. 0 - метры, 1 - сантиметры, 2 - футы,
     * 3 - дюймы
     */
    public static int[] conversion(double inputValue) {
        int meters = (int) inputValue;
        int centimeters = (int) Math.round((inputValue - meters) * 100);

        int totalCentimeters = meters * 100 + centimeters;
        double inches = totalCentimeters / 2.54;
        int foot = (int) inches / 12;
        inches = inches % 12;

        int[] arr = new int[4];
        arr[0] = meters;
        arr[1] = centimeters;
        arr[2] = foot;
        arr[3] = (int) inches;

        return arr;

    }

    /**
     * Запуск
     */
    public static void start() {
        inputValue = input();
        int[] arr = conversion(inputValue);

        output_before(arr[0], arr[1]);
        output_after(arr[2], arr[3]);
    }

    public static void main(String[] args) {
        start();
    }
}
