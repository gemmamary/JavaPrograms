package matrix;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class CharacterMatrix {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int x = checkIntegerInputIsValid(in, 5, 10, "Enter a number between 5 and 10: ");
        String letters = checkStringInputIsValid(in, 6, "Enter 6 characters here: ");

        String outputString = getNewConcatenatedCharacters(x, letters);

        System.out.println(outputString);	
    }

    public static int checkIntegerInputIsValid(Scanner in, int minimum, int maximum, String prompt) {

        boolean validInput = false;
        int numberInput = 0;

        while(!validInput) {
            System.out.print(prompt);
            if(in.hasNextInt()) {
                numberInput = in.nextInt();
                if(numberInput >= minimum && numberInput <= maximum) {
                    validInput = true;
                }
            } else {
                in.next();
            }
        }	
        return numberInput;	
    }

    public static String checkStringInputIsValid(Scanner in, int len, String prompt) {

        boolean validInput = false;
        String stringInput = "";

        while(!validInput) {
            System.out.print(prompt);
            if(in.hasNext()) {
                stringInput = in.next();
                if(stringInput.length() == len) {
                    validInput = true;
                }
            } else {
                in.next();
            }
        }
        return stringInput;	
    }

    public static int[] getRandomNumbersForIndexPositions(int amount) {

        int[] indexesOf = new int[amount];

        for(int i = 0; i < amount; i++) {
            Random r = new Random();
            int y = r.nextInt((5 - 0) + 1);
            indexesOf[i] = y;
        }
    return indexesOf;	
    }  

    public static String getNewConcatenatedCharacters(int size, String letters) {

        int numberOfChars = size * size;

        char[] matrix = new char[size];
        ArrayList matrixList = new ArrayList(); 
        String oddNumbers = "";

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int[] indexes = getRandomNumbersForIndexPositions(size);
                char letter = letters.charAt(indexes[i]);
                matrix[i] = letter;
                matrixList.add(matrix[i]);
                System.out.print(matrix[i] + " ");	
            }	
        System.out.println();
        }

        int len = matrixList.size();

        for (int k = 0; k < len; k++) {
            if (k % 2 == 0) {
                oddNumbers += matrixList.get(k);
            }
            k++;		
        }

        int half = (size + 1) / 2;
        String[] odds = oddNumbers.split("(?<=\\G.{" + half + "})");
        String gotcha = "";

        for (int l = 0; l < odds.length; l++) {
            if (l % 2 == 0) {
                gotcha += odds[l];
            }
        }
        return "Odd letters from every odd row: " + gotcha;		 		
    }
}


