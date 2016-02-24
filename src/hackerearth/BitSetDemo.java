package hackerearth;

public class BitSetDemo {

	public static int sign(int n) {
		return (n >> 31 & 1);
	}

	public static int flip(int bit) {
		return 1 ^ bit;
	}

	public static int getMaxValue(int a, int b) {
		int q = sign(a - b);
		int k = flip(q);
		return a * k + b * q;
	}

	public static void main(String args[]) {
		System.out.println(getMaxValue(32,30));
	}
}