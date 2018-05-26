/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        final String[] morseAlphabet = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", // a-f
            "--.", "....", "..", ".---", "-.-", ".-..", // g-l
            "--", "-.", "---", ".--.", "--.-", ".-.", // m-r
            "...", "-", "..-", "...-", ".--", "-..-", // s-x
            "-.--", "--.." //y y-z
        };
        String result = englishToMorse("my name is rian", morseAlphabet);
        System.out.println(result);
        result = morseToEnglish("-- -.-- / -. .- -- . / .. ... / .-. .. .- -.", morseAlphabet);
        System.out.println(result);
    }
    
    public static String englishToMorse(String input, String[] morseAlphabet) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c != ' ') {
                result += morseAlphabet[((int) c) - 97] + " ";
            } else {
                result += "/ ";
            }
        }
        return result;
    }

    public static String morseToEnglish(String input, String[] morseAlphabet) {
        String[] morseWords = input.split("\\/");
        String result = "";
        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.trim().split(" ");
            for (String letter : morseLetters) {
                int morseIndex =  searchForLetter(letter, morseAlphabet);
                char englishLetter = (char)(morseIndex + 97);
                result += englishLetter;
            }
            result += " ";
        }
        return result;
    }

    public static int searchForLetter(String morse, String[] morseLetters) {
        int index = 0;
        for (int i = 0; i < morseLetters.length; i++) {
            if(morseLetters[i].equals(morse)) {
                index = i;
            }
        }
        return index;
    }
}