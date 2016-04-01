package ideserve;

import java.util.Arrays;

public class SpaceString {
	public static void main(String[] args) {
		String str = "Hi,  How Are  you  ";
		SpaceString s = new SpaceString();
		System.out.println(s.removeSpaces(str));
	}

	private String removeSpaces(String str) {
		char[] ch = str.toCharArray();
		int spaces = 0;
		String s = "";
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				spaces = spaces + 1;
			} else {
				ch[i - spaces] = ch[i];
			}
		}
		ch = Arrays.copyOf(ch, ch.length - spaces);
		s = String.valueOf(ch);
		return s;
	}
}
