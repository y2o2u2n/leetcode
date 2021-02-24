package me.y2o2u2n.p12;

/**
 * Created by JunSeok Youn on 2021-02-24
 */
public class IntegerToRoman {
	public static void main(String[] args) {
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(58));
		System.out.println(intToRoman(1994));
	}

	private static String intToRoman(int num) {
		StringBuilder builder = new StringBuilder();

		builder.append("M".repeat(num / 1000));
		num = num % 1000;

		builder.append("CM".repeat(num / 900));
		num = num % 900;

		builder.append("D".repeat(num / 500));
		num = num % 500;

		builder.append("CD".repeat(num / 400));
		num = num % 400;

		builder.append("C".repeat(num / 100));
		num = num % 100;

		builder.append("XC".repeat(num / 90));
		num = num % 90;

		builder.append("L".repeat(num / 50));
		num = num % 50;

		builder.append("XL".repeat(num / 40));
		num = num % 40;

		builder.append("X".repeat(num / 10));
		num = num % 10;

		builder.append("IX".repeat(num / 9));
		num = num % 9;

		builder.append("V".repeat(num / 5));
		num = num % 5;

		builder.append("IV".repeat(num / 4));
		num = num % 4;

		builder.append("I".repeat(num));

		return builder.toString();
	}

}
