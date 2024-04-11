

package pj5;

/*
 * @author Ashton Josh Kabou
 * 
 * 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
    private static MorseCodeTree tree = new MorseCodeTree();

    public static String printTree() {
        String treeData = "";
        ArrayList<String> treeList = tree.toArrayList();
        for (String treeString : treeList) {
            treeData += treeString;
        }
        return treeData.trim();
    }

    public static String convertToEnglish(String morseCodeInput) {
        String[] morseWords = morseCodeInput.split("/");
        String englishOutput = "";
        for (String word : morseWords) {
            word = word.trim();
            String[] morseLetters = word.split(" ");
            for (String letter : morseLetters) {
                englishOutput += tree.fetch(letter);
            }
            englishOutput += " ";
        }
        return englishOutput.trim();
    }

    public static String convertToEnglish(File morseCodeFile) throws FileNotFoundException {
        String englishOutput = "";
        try (Scanner fileScanner = new Scanner(morseCodeFile)) {
            while (fileScanner.hasNextLine()) {
                String morseLine = fileScanner.nextLine();
                String[] morseWords = morseLine.split("/");
                for (String word : morseWords) {
                    word = word.trim();
                    String[] morseLetters = word.split(" ");
                    for (String letter : morseLetters) {
                        englishOutput += tree.fetch(letter);
                    }
                    englishOutput += " ";
                }
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception (e.g., print an error message)
            e.printStackTrace();
        }
        return englishOutput.trim();
    }
}
