package codility;

public class BinaryGap {
	public static void main(String[] args) {
		int i = 529;
		int count = 0;
		int max = 0;
		for (; i > 0; i = i >> 1) {
			int j = i & 1;
			if (j == 1) {
				if (count > max) {
					max = count;
				}
				count = 0;
			} else {
				count++;
			}
		}
		System.out.println(max);				
	}
}
