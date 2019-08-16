package com.mycomp.interviewUtils;

import java.util.Scanner;

import com.mycomp.prime.Singleton;

public class App {
	public static void main(String[] args) {
		getUserInput();
	}

	public static void getUserInput() {
		System.out.println("***Find nth prime app***\\nPress 0 to exit..");
		Scanner sc = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("Enter n to compute nth prime number>>");
				int nth = sc.nextInt();
				if (nth == 0) {
					System.out.println("Have a good Day.. :)");
					System.exit(0);
				}
				int nthPrimeNumber = Singleton.getInsance().findNthPrimeNumber(nth);
				System.out.println("***Nth Prime Number Result***>>"+nthPrimeNumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}
}
