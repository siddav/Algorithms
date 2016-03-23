package jv;

public class ReverseNumber {
	public static void main(String[] args) {
		int number = 123;
		int copy = number;
		int reverse = 0, i = 0;
		while (number != 0) {
			/*int r = number % 10;
			number = number / 10;
			sum = (int) (sum * Math.pow(10, i) + r);
			i++;*/			
			reverse = reverse * 10 + number % 10;
			number = number / 10;
		}		
		System.out.println(reverse);
	}
}
