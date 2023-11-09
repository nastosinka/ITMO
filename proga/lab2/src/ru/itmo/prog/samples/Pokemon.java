package ru.itmo.prog.samples;

public class Pokemon {

		String name;
		int age;

		static int count = 0;

	public static void main(String args[]) {

		Pokemon pikachu = new Pokemon();
		pikachu.name = "Pikachu";
		pikachu.age = 4;
		count ++;

		Pokemon rhydon = new Pokemon();
		rhydon.name = "Rhydon";
		rhydon.age = 3;
		count ++;

		System.out.println("Nomer odin:" + pikachu.name + ", age:" + pikachu.age);
		System.out.println("Nomer dva:" + rhydon.name + ", age:" + rhydon.age);

		System.out.println(asking());
	}

	public static void speaking() {

		System.out.println("I'm speaking");

	}

	public static String asking() {

		return ("I'm asking");

	}

}