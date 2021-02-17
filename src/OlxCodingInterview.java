
import java.util.ArrayList;
import java.util.List;

public class OlxCodingInterview {

    public static List<String> run(char[][] keyboard, String reportedPin) {

        return buildPossiblePin(keyboard, reportedPin, 0);
    }

    private static ArrayList<String> buildPossiblePin(char[][] keyboard, String reportedPin, int i) {

        if (i == reportedPin.length()) {
            return null;
        }
        if (i == reportedPin.length() - 1) {
            List<Character> variations = getVariations(keyboard, reportedPin.charAt(i));
            ArrayList<String> values = new ArrayList<>();
            for (Character ch : variations) {
                values.add(Character.toString(ch));
            }
            return values;
        }
        ArrayList<String> values = buildPossiblePin(keyboard, reportedPin, i + 1);
        List<Character> variations = getVariations(keyboard, reportedPin.charAt(i));
        ArrayList<String> result = new ArrayList<>();
        for (Character ch : variations) {
            for (String string : values) {
                result.add(ch + string);
            }
        }
        return result;
    }

    private static List<Character> getVariations(char[][] keyboard, char ch) {

        List<Character> result = new ArrayList<>();

        result.add(ch);

        int row = -1;
        int col = -1;

        loop:
        for (int i = 0; i < keyboard.length; i++) {
            int length = keyboard[i].length;
            for (int j = 0; j < length; j++) {
                if (keyboard[i][j] == ch) {
                    row = i;
                    col = j;
                    break loop;
                }
            }
        }

        if (row != -1 && col != -1) {
            if (row + 1 < keyboard.length) {
                result.add(keyboard[row + 1][col]);
            }
            if (row - 1 >= 0) {
                result.add(keyboard[row - 1][col]);
            }
            if (col + 1 < keyboard[0].length) {
                result.add(keyboard[row][col + 1]);
            }
            if (col - 1 >= 0) {
                result.add(keyboard[row][col - 1]);
            }
        }

        return result;
    }
}
