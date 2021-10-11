/*
 * Task1. Посчитать сумму всех натуральных чисел, вывести в консоль.
 * Task2. Посчитать количество символов, вывести в консоль количество использований.
 * Task3. Определить время конца занятия, вывести время в консоль. Не использовать циклы и условные инструкции.
 *
 * @author Dmitriy Raschchupkin
 * @version dated 11.10.2021
 */

package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HomeWork1 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Menu");
		System.out.println("[1-3] Task1/Task2/Task3");
		System.out.println("[0] Quit");
		String position;
		while ((position = reader.readLine()) != null) {
			menu(position, reader);
			position = reader.readLine();
			switch (position) {
				case "0": {
					System.exit(0);
				}
				case "1": {
					menu(position, reader);
				}
				System.out.println("To get out, press [0]. Double-click to go to another task.");
			}
		}
		reader.close();
	}

	private static void menu(String position, BufferedReader bufferedReader) {
		switch (position) {
			case "1": //Первая задача
				System.out.print("Enter a line: ");
				Scanner input = new Scanner(System.in);
				String line = input.nextLine();
				char[] chars = line.toCharArray();
				int sum = 0;
				for (int i = 0; i < chars.length; i++) {
					if ((byte) chars[i] >= 48 && (byte) chars[i] <= 57)
						sum += (byte) chars[i] - 48;
				}
				System.out.println("The sum of the numbers in the row: " + sum);
				break;
			case "2": //Вторая задача
				System.out.print("Enter any line: ");
				Scanner inp = new Scanner(System.in);
				String lin = inp.nextLine();
				TreeMap<Character, Integer> lib = new TreeMap<>();
				for (int a = 0; a < lin.length(); a++) {
					if (Character.isLetter(lin.charAt(a))) {
						Integer rate = lib.get(lin.charAt(a));
						lib.put(lin.charAt(a), rate == null ? 1 : rate + 1);
					}
				}
				for (Map.Entry<Character, Integer> key : lib.entrySet()) {
					System.out.print(key.getKey() + " -> ");
					System.out.println(key.getValue());
				}
				break;
			case "3": //Третья задача
				Scanner in = new Scanner(System.in);
				System.out.print("Enter lesson number: ");
				int num = in.nextInt();
				int start = 9 * 60, les = 45, lite = 5, big = 15;
				int m = start + num * les;
				m += (num - 1) * lite;
				m += (num - 1) / 2 * (big - lite);
				System.out.print("End of lesson " + num + " -> ");
				System.out.println(m / 60 + ":" + m % 60);
				break;
		}
		System.out.println("To get out, press [0]. Double-click to go to another task.");
	}

}
