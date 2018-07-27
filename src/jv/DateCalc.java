package com.reputation.meru.core.metrics;

import java.util.HashMap;
import java.util.Map;

public class DateCalc {
	static Map<Integer, Integer> days = new HashMap<>();
	static Map<Integer, Integer> leapDays = new HashMap<>();
	static {
		days.put(1, 31);
		days.put(2, 28);
		days.put(3, 31);
		days.put(4, 30);
		days.put(5, 31);
		days.put(6, 30);
		days.put(7, 31);
		days.put(8, 31);
		days.put(9, 30);
		days.put(10, 31);
		days.put(11, 30);
		days.put(12, 31);
		//
		leapDays.put(1, 31);
		leapDays.put(2, 29);
		leapDays.put(3, 31);
		leapDays.put(4, 30);
		leapDays.put(5, 31);
		leapDays.put(6, 30);
		leapDays.put(7, 31);
		leapDays.put(8, 31);
		leapDays.put(9, 30);
		leapDays.put(10, 31);
		leapDays.put(11, 30);
		leapDays.put(12, 31);
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0;
	}

	public static String nextDay(int day, int month, int year) {
		int nextDay = day;
		int nextMonth = month;
		int nextYear = year;
		Map<Integer, Integer> currentYearDays = days;
		if (isLeapYear(year)) {
			currentYearDays = leapDays;
		}
		nextDay = day % currentYearDays.get(month);
		if (nextDay == 0) {
			nextDay = 1;
			nextMonth = month % 12;
			if (nextMonth == 0) {
				nextMonth = 1;
				nextYear = nextYear + 1;
			} else {
				nextMonth = nextMonth + 1;
			}
		} else {
			nextDay = nextDay + 1;
		}

		return nextDay + "/" + nextMonth + "/" + nextYear;
	}

	public static String prevDay(int day, int month, int year) {
		int prevDay = day;
		int prevMonth = month;
		int prevYear = year;
		Map<Integer, Integer> currentYearDays = days;
		if (isLeapYear(year)) {
			currentYearDays = leapDays;
		}
		if (prevDay == 1) {
			if (month == 1) {
				prevMonth = 12;
				prevYear = prevYear - 1;
			} else {
				prevMonth = month - 1;
			}
			prevDay = currentYearDays.get(prevMonth);
		} else {
			prevDay = prevDay - 1;
		}

		return prevDay + "/" + prevMonth + "/" + prevYear;
	}

	public static String age(Date d1, Date d2) {
		String age = "";
		int _years = d2.year - d1.year;
		int _months = d2.month - d1.month;
		int _days = d2.day - d1.day;
		if (_months < 0) {
			_years = _years - 1;
			_months = _months + 12;
		}
		if (_days < 0) {
            _days = _days + 31;
		}
		return _years + " years " + _months + " months " + _days + " days";
	}

	public static void main(String[] args) {
		System.out.println(nextDay(31, 12, 2001));
		System.out.println(prevDay(31, 12, 2001));
		System.out.println("================");
		System.out.println(nextDay(1, 1, 2001));
		System.out.println(prevDay(1, 1, 2001));
		System.out.println("================");
		System.out.println(nextDay(31, 10, 2001));
		System.out.println(prevDay(31, 10, 2001));
		System.out.println("================");
		System.out.println(nextDay(28, 2, 2000));
		System.out.println(prevDay(28, 2, 2000));
		System.out.println("================");
		System.out.println(nextDay(14, 3, 2000));
		System.out.println(prevDay(14, 3, 2000));
		Date d1 = new Date(20, 8, 1990);
		Date d2 = new Date(27, 7, 2018);
		System.out.println(age(d1, d2));
	}
}

class Date {
	int day;
	int month;
	int year;

	Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
}
