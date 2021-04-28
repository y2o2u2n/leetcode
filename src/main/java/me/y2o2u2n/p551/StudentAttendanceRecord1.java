package me.y2o2u2n.p551;

/**
 * Created by JunSeok Youn on 2021-04-28
 */
public class StudentAttendanceRecord1 {

	public static void main(String[] args) {
		System.out.println(checkRecord("PPALLP"));
		System.out.println(checkRecord("PPALLL"));
		System.out.println(checkRecord("LLLALL"));
	}

	private static boolean checkRecord(String s) {
		int absentCount = 0;
		int consecutiveLateCount = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				absentCount++;
				consecutiveLateCount = 0;
			} else if (s.charAt(i) == 'L') {
				consecutiveLateCount++;
			} else if (s.charAt(i) == 'P') {
				consecutiveLateCount = 0;
			}

			if (absentCount >= 2) {
				return false;
			}

			if (consecutiveLateCount >= 3) {
				return false;
			}
		}

		return true;
	}
}
