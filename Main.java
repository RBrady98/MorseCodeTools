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
        String pattern = "[\\w\\s]{1,}";
        String result = "";
        if(args.length != 1) {
            result += "Usage: java Main.java morse sentence";
        } else if(!(args[0].matches(pattern))) {
            result += "Please enter either a \'.\' or a \'-\'";
        } else {
            String input = args[0];
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c != ' ') {
                    result += morseAlphabet[((int) c) - 97] + " ";
                } else {
                    result += "/ ";
                }
            }
        }
        System.out.println(result);
    }
}