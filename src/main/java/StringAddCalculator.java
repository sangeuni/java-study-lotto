import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public boolean nullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    public int add(String text) {
        if (nullOrEmpty(text)) return 0;
        String tokens[] = separateText(text);
        int numbers[] = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            checkNegative(tokens[i]);
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return sum(numbers);
    }

    public String[] separateText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    public int sum(int[] numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            answer += numbers[i];
        }
        return answer;
    }

    public void checkNegative(String element) {
        int number = Integer.parseInt(element);
        if (number < 0) throw new RuntimeException();
    }
}