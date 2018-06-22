import java.io.*;
import javax.sound.sampled.*;

/**
 * Morse class for encoding, decoding and playing morse code sequences
 */ 
public class Morse {
    private static final String[] morseAlphabet = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", // a-f
        "--.", "....", "..", ".---", "-.-", ".-..", // g-l
        "--", "-.", "---", ".--.", "--.-", ".-.", // m-r
        "...", "-", "..-", "...-", ".--", "-..-", // s-x
        "-.--", "--.." //y-z
    };
    
    public static String morseToEnglish(String input) {
        input = input.trim();
        String[] morseWords = input.split("\\/");
        String result = "";
        //loop through each morse word in the word array
        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.trim().split(" ");
            //loop through each morse letter in the morse word and find its english letter equivalent
            for (String letter : morseLetters) {
                int morseIndex =  getLetterIndex(letter);
                if(morseIndex == -1) {
                    result += "INVALID ";
                } else {
                    char englishLetter = (char)(morseIndex + 97);
                    result += englishLetter;
                }
            }
            result += " ";
        }
        return result;
    }

    public static String englishToMorse(String input) {
        input = input.trim();
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.toLowerCase().charAt(i);
            if(c != ' ') {
                result += morseAlphabet[((int) c) - 97] + " ";
            } else {
                result += "/ ";
            }
        }
        return result;
    }

    private static int getLetterIndex(String morse) {
        int index = -1;
        for (int i = 0; i < morseAlphabet.length; i++) {
            if(morseAlphabet[i].equals(morse)) {
                index = i;
            }
        }
        return index;
    }

    public static void playMorseSequence(String morseSequence) {
        String englishFromMorse = morseToEnglish(morseSequence).toUpperCase().trim();
        char[] letters = englishFromMorse.toCharArray();
        for (char c : letters) {
            if (c == ' ') {
                try {
                    // Wait between words and go to the next iteration of the loop
                    Thread.sleep(1000);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // All sound files named as letter.wav eg A.wav, char is then used in the file path string
                // Get file system path to the sound folder
                String basePath = new File("").getAbsolutePath();
                String fileName = basePath + "\\sound\\" + c + ".wav";
                try {
                    System.out.println("currently playing: " + fileName);
                    File file = new File(fileName);
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                    Thread.sleep(1250);
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}