package ramana;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample {
    public static void main(String[] args) {
        final String regex = "accounts/(\\d+)/locations/(\\d+)";
        Pattern locationNamePattern = Pattern.compile(regex);
        String locationName = null;
        Matcher matcher = locationNamePattern.matcher(locationName);

    }
}
