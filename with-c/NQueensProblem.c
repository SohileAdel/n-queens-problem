#include<stdio.h>
#include<stdbool.h>

int N=8;

void printBoard(int board[N][N]){
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            printf(" ");
            printf("%d",board[i][j]);
            printf(" ");
        }                 
        printf("\n");
    }
}

bool notKilled(int board[N][N], int row, int col){
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

bool recursiveSolve(int board[N][N], int col){
    if (col >= N)
        return true;

    for (int i = 0; i < N; i++) {
        if (notKilled(board, i, col)){
            board[i][col] = 1;

            if (recursiveSolve(board, col + 1) == true)
                return true;
            board[i][col] = 0; 
            // Backtrack technique if there is no solution for this place 
        }
    }
    return false;
}

bool solve(){
    int board[N][N];
    memset(board, 0, sizeof(board));

    if (recursiveSolve(board, 0) == false) {
        printf("Solution does not exist");
        return false;
    }
    printBoard(board);
    return true;
}

int main(){
    solve();
    return 0;
}
