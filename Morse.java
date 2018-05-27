/**
 * Morse
 */ 
public class Morse {
    private static final String[] morseAlphabet = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", // a-f
        "--.", "....", "..", ".---", "-.-", ".-..", // g-l
        "--", "-.", "---", ".--.", "--.-", ".-.", // m-r
        "...", "-", "..-", "...-", ".--", "-..-", // s-x
        "-.--", "--.." //y y-z
    };
    
    public static String morseToEnglish(String input) {
        String[] morseWords = input.split("\\/");
        String result = "";
        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.trim().split(" ");
            for (String letter : morseLetters) {
                int morseIndex =  searchForLetter(letter);
                char englishLetter = (char)(morseIndex + 97);
                result += englishLetter;
            }
            result += " ";
        }
        return result;
    }

    public static String englishToMorse(String input) {
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

    private static int searchForLetter(String morse) {
        int index = 0;
        for (int i = 0; i < morseAlphabet.length; i++) {
            if(morseAlphabet[i].equals(morse)) {
                index = i;
            }
        }
        return index;
    }
}