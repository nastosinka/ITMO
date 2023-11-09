package ru.itmo.prog.samples;

import java.lang.Math;

public class Main {

	public static void main(String args[]) {

		int a = 10;
		System.out.println(a++ + ++a);

		int[] c = new int[17];       // создаём массив с числами от 1 до 17
		for (int i = 0; i < 17; i++) { // заполняем массив чиселками
			c[i] = 17 - i;
		}

		double[] x = new double[20]; // создаём массив вещественных чисел
		for (int i = 0; i < 20; i++) { // заполняем его случайными числами с помощью метода Math.random()
			x[i] = (double) (Math.random() * (7.0 + 11.0)) - 11; // выводим гениальную формулу 
		}

		double[][] helpMe = new double[17][20]; // создаём двумерный массив
		for (int i = 0; i < 17; i++) { // перебираем элементы двумерного массива
			for (int j = 0; j < 20; j++) {
				switch (c[i]) { // ряд условий
					case 13:
						helpMe[i][j] = matic1(x[j]);
						break;
					case 2, 6, 7, 9, 10, 12, 15, 17: //костыль из одинаковых кейсов
						helpMe[i][j] = matic2(x[j]);
						break;
					default:
						helpMe[i][j] = matic3(x[j]);		
			}
		}

		for (int p = 0; p < 17; p++) { 
			System.out.printf("%d ", c[p]);
		}
		System.out.println();
		for (int r = 0; r < 20; r++) {
			System.out.printf("%f ", x[r]);
		}

		System.out.println();
		for (int s = 0; s < 17; s++) {
			for (int q = 0; q < 20; q++) {
				System.out.printf("%12.5f", helpMe[s][q]);
			}
			System.out.println();
		}
	}
}

	public static double matic1(double x) {
		return (Math.pow((((double) 1/3) / (Math.log(Math.pow((2 * Math.abs(x)), 2)))), 3));
	}

	public static double matic2(double x) {
		return (Math.pow((2 * Math.pow((((double) 2/3) * (Math.pow(x, (x / (x - ((double) 3/4)))) + 1)), (x * (1 - x)))), 3));
	}

	public static double matic3(double x) {
		return (Math.atan(0.25 * Math.sin(Math.pow(Math.asin((x - 2) / 18), Math.cos(x)))));				
	}
}









