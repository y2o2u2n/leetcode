package me.y2o2u2n.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
public class Solution1 {
	public int solution(String[] deposits) {
		int totalPrincipal = 0;
		int totalInterest = 0;

		for (String deposit : deposits) {
			String[] split = deposit.split(" ");
			int dayOfYear = getDayOfYear(split[0]);
			int rateOfInterest = Integer.parseInt(split[1]);
			int principal = Integer.parseInt(split[2]);
			int determinedInterest = determinedInterest(principal, rateOfInterest, 365 - dayOfYear);
			totalPrincipal += principal;
			totalInterest += determinedInterest;
		}

		return totalPrincipal + totalInterest;
	}

	public int determinedInterest(int principal, int rateOfInterest, int leftDays) {
		double interest = (principal * rateOfInterest * 0.01d) * ((double)leftDays / 365);
		return (int)Math.floor(interest);
	}

	// TODO : refactor this
	public int getDayOfYear(String dayStr) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return LocalDate.parse(String.format("2021/%s", dayStr), fmt).getDayOfYear();
	}
}
