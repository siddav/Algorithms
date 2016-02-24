package hackerearth;

import java.util.Scanner;

public class Summation {
	 static int B;
	    static int H;
	    static boolean flag = false;
	static {
	    Scanner scan = new Scanner(System.in);
	     B = scan.nextInt();
	     H = scan.nextInt();
	    if(B <= 0 || H <= 0) {
	        try {
				throw new Exception("Breadth and height must be positive");
			} catch (Exception e) {
				System.out.println(e);
			}
	    } else {
	        flag = true;
	    }
	};
	public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}
}
