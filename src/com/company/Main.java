package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static double inputValue;

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static double input() {
        while (true)
        {
            Scanner sc = new Scanner(System.in);
            try
            {
                System.out.println("Введите значение в метрах (формат - #####.##), чтобы перевести его в футы:");
                double inputValue = roundAvoid(sc.nextDouble(),2);
                if (inputValue < 0) throw new Exception("Нужно значение больше нуля!");
                return inputValue;
            } catch (InputMismatchException e)
            {
                sc.reset();
                System.out.println("Я не понимаю это значит! Повторите ввод!");
            }
            catch (Exception e)
            {
                sc.reset();
                System.out.println(e.getMessage());
            }
        }
    }

    public static void output_before(int meters, int centimeters) {
        System.out.println("Вы ввели "+ meters +" метра(ов) и "+ centimeters + " сантиметра(ов)");
    }

    public static void output_after(int foot, int inches) {
        System.out.println("При переводе получилось "+ foot +" фута(ов) и "+ inches + " дюйма(ов)");
    }

    public static void conversion(double inputValue) {
        int meters = (int) inputValue;
        int centimeters = (int) Math.round((inputValue - meters)*100);

        int totalCentimeters = meters * 100 + centimeters;
        double inches = totalCentimeters / 2.54;
        int foot = (int) inches / 12;
        inches = inches % 12;
        output_before(meters,centimeters);
        output_after(foot, (int) inches);
    }
    public static void main(String[] args) {
        inputValue = input();
        conversion(inputValue);
    }
}
