//This program represents the queen as 1 and empty square as 0

package main.java.nqueensproblem;
import java.util.Scanner;

public class NQueensProblem {
    static Scanner c=new Scanner(System.in);
    static int N;
    
    public static void main(String args[]){
        System.out.print("Enter the number of queens: ");
        N=c.nextInt();
        new NQueensProblem().solve();
    }
    
    
    void printBoard(int board[][]){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }

    boolean notKilled(int board[][], int row, int col){
        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean recursiveSolve(int board[][], int col){
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (notKilled(board, i, col)){
                board[i][col] = 1;

                if (recursiveSolve(board, col + 1) == true)
                    return true;
                board[i][col] = 0; // Backtrack technique if there is no solution for this place 
            }
        }
        return false;
    }

     boolean solve(){
        int board[][] = new int[N][N];

        if (recursiveSolve(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }
        printBoard(board);
        return true;
    }
}