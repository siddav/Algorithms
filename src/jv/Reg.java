package jv;

import java.util.Arrays;

public class Reg {
	public static void main(String[] args) {
		String regex = "(\\B[\r*|\n*]\\b)";
		String text = "Redeem Online Only\r\n\r\nDuring checkout on eBay.com:\r\n1. Enter the 13-digit redemption code, then click Apply.\r\n2. Click Continue to proceed to PayPal.\r\n3. Log in to your PayPal account.\r\n4. Review the payment details and click Confirm and Pay.";
		String[] s = text.split(regex,2);
		/* System.out.println(Arrays.asList(s)); */
		System.out.println("size of the array" + s.length);
		System.out.println("string 1 : " + s[0]);
		System.out.println("string 2 : " + s[1]);
	}
}
