//Name: Ernesto Aguilera
//PantherID: 002-54-2302
//Course: CSC2720
//Title: Rotating the matrix
//Note: Hello! I hope you are well. For part two I just used a new method but did a different rotation method I found the wording of the description odd.
//Note2: Nontheless, I rotated the array by subtracting and "swapping" the number placements. I ask that you please put any instructions on the lab assignment thank you!

//Overall comparison: Both ways implemented provide a solution to rotating the values yet I believe my alternate method uses more space for the temporary value.
//If I am asked which one is more efficient I would assume as far as time goes both programs run at the same time complexity yet the second one uses more space.
import java.util.Scanner; //Library for user input.
public class Lab3 {
    static int N = 4; //To avoid using 4 over and over again (and assumed that the matrix size would only be 4 by 4) I used N to represent the number 4 throughout the whole program.
    public static void main(String[] args) throws Exception {
        Scanner inputDevice = new Scanner(System.in); //Scanner initialized
        System.out.print("Welcome to Matrix Rotation! Please start entering numbers for your matrix (4x4): "); //Intro and prompt.
        int matrix[][] = new int[N][N]; //New 2D array initialized.
        for(int i=0;i<N;i++){ //Nested for loop to fill out the 2D array.
            for(int j=0;j<N;j++){
                matrix[i][j]=inputDevice.nextInt(); //User input for the values.
            }
        }
        System.out.println("\nMatrix Given: "); //Output One: This shows the original matrix.
        printOutput(matrix);
        System.out.println("Matrix Rotated: "); //Output Two: This shows the rotated matrix using a method that outputs using nested for loops.
        rotateClockwise(matrix);
        System.out.println("Matrix Rotated: (By swapping)"); //Output Three: This outputs by doing several line by line changes for the rotated result
        rotateAlternative(matrix); //Method called
        printOutput(matrix); //Method called to avoid rewriting code.
    }
    public static void rotateClockwise(int[][] matrix){ //Rotating method yet this one prints the values as well.
        for(int j = 0;j < N;j++){
            for(int i=N-1;i>=0;i--){
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    static void printOutput(int matrix[][]){ //Output method to print the matrix values.
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.printf("%4d", matrix[i][j]); //printf used to have a more aligned view.
            }
            System.out.println(); //New line after every 4th value.
        }
    }
    static void rotateAlternative(int matrix[][]){ //Alternate rotating method. Could be recalled for more loops.
        for(int i = 0;i < N / 2;i++){ //This moves each row
            for(int j = i;j<N - i - 1;j++){ //This all swaps each of the values line by line. 
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = temp;
            }
        }
    }
}