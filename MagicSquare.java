/****************************************************************************
 *
 * Created by: Nicholas Brean
 * Created on: Dec 2018
 * Created for: ICS4U
 * Magic square program
 * 		Generates all possible 3 by 3 magic squares
 *
 ****************************************************************************/

public class main {
    public static void main(String[] args) {
        // main stub, get user input here
        int[] magicSquare = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, 0);
    }
    
    public static void genSquare(int[] square, int index) {
    	// generates magic square
    	if(index == square.length) {
    		boolean magic = isMagic(square);
    		if(magic == true) {
    			printMagicSquare(square);
    		}
    	}
    	else {
    		for(int count = index; count <= square.length-1; count++) {
    			swapElements(square, index, count);
    			genSquare(square, index + 1);
    			swapElements(square, index, count);
    		}
    	}
    }
    
    public static void swapElements(int[] currentSquare, int currentInd, int iteration) {
    	// swaps elements in array
    	int temp = currentSquare[currentInd];
    	currentSquare[currentInd] = currentSquare[iteration];
    	currentSquare[iteration] = temp;
    }

    public static boolean isMagic(int[] possibleSquare) {
        // returns true or false for whether or not inputted array is a magic square
        int MAGICNUM = 15;

        int row1 = possibleSquare[0] + possibleSquare[1] + possibleSquare[2];
        int row2 = possibleSquare[3] + possibleSquare[4] + possibleSquare[5];
        int row3 = possibleSquare[6] + possibleSquare[7] + possibleSquare[8];

        int col1 = possibleSquare[0] + possibleSquare[3] + possibleSquare[6];
        int col2 = possibleSquare[1] + possibleSquare[4] + possibleSquare[7];
        int col3 = possibleSquare[2] + possibleSquare[5] + possibleSquare[8];

        int diag1 = possibleSquare[0] + possibleSquare[4] + possibleSquare[8];
        int diag2 = possibleSquare[2] + possibleSquare[4] + possibleSquare[6];

        if(row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM && col1 == MAGICNUM && col2 == MAGICNUM && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void printMagicSquare(int[] outputSquare) {
    	// prints inputted array in a magic square format
        for(int count = 0; count < outputSquare.length; count ++) {
            if(count == 3 || count == 6) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            }
            else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println("\n\n***\n");
    }
}
