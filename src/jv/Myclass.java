package jv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Myclass {

	public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < line.length(); i++) {
            sb.append(line.charAt(i) - 96);
        }
        
        long l = Long.valueOf(sb.toString());
        if( l % 6 == 0) {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
        }
    }
}
