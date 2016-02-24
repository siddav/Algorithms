package hackerearth;

import java.util.Scanner;

public class TimeFormat {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s%3d",s1,x);
        }
        System.out.println("================================");
	}
}