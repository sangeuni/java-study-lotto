import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public int add(String text) {
        if (isNullOrEmpty(text)) return 0;
        String tokens[] = separateText(text);
        for (int i = 0; i < tokens.length; i++) {
            checkNegative(tokens[i]);
        }
        return sum(tokens);
    }

    public String[] separateText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    public int sum(String[] tokens) {
        int answer = 0;
        for (int i = 0; i < tokens.length; i++) {
            answer += Integer.parseInt(tokens[i]);
        }
        return answer;
    }

    public void checkNegative(String element) {
        int number = Integer.parseInt(element);
        if (number < 0) throw new RuntimeException();
    }
}