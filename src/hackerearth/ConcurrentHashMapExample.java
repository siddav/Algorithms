package hackerearth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ConcurrentHashMapExample {
    
    
    public static void main(String[] args)
    {
    	SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sdFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        System.out.println(sdFormat.format(new Date()));
    }
    
}
