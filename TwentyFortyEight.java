package edu.purdue.cui102.project5;

/**
 * Created by cui102 on 4/6/17.
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class TwentyFortyEight {
    //This instance variable represents the board. Use this to make changes.
    private int[][] board;
    //This variable keeps track of the current score.
    private int score;
    private int boardWidth;
    private Deque<int[][]> stack = new ArrayDeque<>();
    private Deque<int[][]> redoStack = new ArrayDeque<>();
    //Constructor
    public TwentyFortyEight(int boardWidth){
        this.boardWidth = boardWidth;
        board = new int[boardWidth][boardWidth];
        reset();
    }

    //This function resets the board to its initial state
    public void reset() {
        for(int i=0; i<board.length;i++){
            for(int j =0; j<board[0].length; j++){
                board[i][j] = 0;
            }
        }
        score = 2;
        stack.clear();
        redoStack.clear();
        placeRandom();
    }

    //This function returns the total number of blank spaces on the board
    public int numBlanks() {
        int num=0;
        for(int i =0; i<board.length; i++){
            for(int j =0; j <board[0].length; j++){
                if(board[i][j]==0){
                    num++;
                }
            }
        }
        return num;
    }

    //This function places a 2 at a random blank space on the board.
    //It does nothing if there are no blank spaces.
    public void placeRandom() {
        if (numBlanks() == 0) {
            return;
        }
        Random rand = new Random();
        for (int i = 0; i < 1; ) {
            int x = rand.nextInt(board.length);
            int y = rand.nextInt(board[0].length);
            if (board[x][y] == 0) {
                board[x][y] = 2;
                i++;
            }
        }
        int[][] temp = new int[4][4];
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                temp[i][j] = board[i][j];
            }
        }
        this.stack.push(temp);
    }
    public Deque<int[][]> getStack(){return this.stack;}
    public Deque<int[][]> getRedoStack(){return this.redoStack;}
    //This function attempts to move a cell at coordinates fromRow,fromCol to
    //the cell toRow,toCol. Refer to the handout for movement rules.
    public boolean moveTo(int fromRow, int fromCol, int toRow, int toCol) {

        if(fromRow>=board.length||fromRow<0||fromCol>=board.length||fromCol<0
                ||toRow>=board.length||toRow<0||toCol>=board.length||toCol<0) {
            return false;
        }
        if(((fromCol-toCol)*(fromCol-toCol)+(fromRow-toRow)*(fromRow-toRow))!=1){
            return false;
        }
        if(board[fromRow][fromCol]==0){
            return false;
        }
        if(board[fromRow][fromCol]==board[toRow][toCol]){
            board[toRow][toCol]=2*board[toRow][toCol];
            board[fromRow][fromCol]=0;
            return true;
        }
        if(board[toRow][toCol]==0){
            board[toRow][toCol]=board[fromRow][fromCol];
            board[fromRow][fromCol]=0;
            return true;
        }
        if(board[fromRow][fromCol]!=0 && board[toRow][toCol]!=0){
            if(board[fromRow][fromCol]>0 && board[toRow][toCol]>0){
                return false;
            }
        } return false;
    }

    //The following four functions move the board in a single direction.
    public boolean moveUp(){
        boolean movecheck = false;
        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board.length; j++){
                if(moveTo(i,j,i-1,j)== true){
                    movecheck = true;
                }
                moveTo(i,j,i-1,j);

            }
        }
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board.length; j++){
                if(board[i][j]>score){
                    score = board[i][j];
                }
            }
        }
        redoStack.clear();
        return movecheck;
    }

    public boolean moveDown() {
        boolean movecheck = false;
        for(int i = board.length-1; i>=0; i--){
            for(int j = 0; j<board.length; j++){
                if(moveTo(i,j,i+1,j)== true){
                    movecheck = true;
                }
                moveTo(i,j,i+1,j);

            }
        }
        for(int i=0 ; i<board.length; i++){
            for(int j =0; j<board.length; j++){
                if(board[i][j]>score){
                    score = board[i][j];
                }
            }
        }
        redoStack.clear();
        return movecheck;
    }

    public boolean moveRight() {
        boolean movecheck = false;
        for(int i =0; i< board.length; i++){
            for(int j =board.length-1; j>=0; j--){
                if(moveTo(i,j,i,j+1)== true){
                    movecheck = true;
                }
                moveTo(i,j,i,j+1);

            }
        }
        for(int i=0 ;i<board.length; i++){
            for(int j =0; j<board.length; j++){
                if(board[i][j]>score){
                    score = board[i][j];
                }
            }
        }
        redoStack.clear();
        return movecheck;
    }

    public boolean moveLeft() {
        boolean movecheck = false;
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (moveTo(i, j, i, j - 1) == true) {
                    movecheck = true;
                }
                moveTo(i, j, i, j - 1);

            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > score) {
                    score = board[i][j];
                }
            }
        }
        redoStack.clear();
        return movecheck;
    }

    ////////////////////////////////////////////////////////////////////////
    // Do not edit the methods below, they are for testing and running the
    // program.
    ////////////////////////////////////////////////////////////////////////
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] newBoard) {
        board = newBoard;
    }

    public void updateScore(){
        score = 0;
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board.length; j++){
                if(board[i][j]>score){
                    score = board[i][j];
                    //MainActivity a = new MainActivity();
                    //if(a.getBestScore()<score) {
                      //  a.setBestScore(score);
                    }
                }
            }
        }


















        



    /**
     * The main will allow you to play the game.
     *
     * @param args
     */
    public static void main(String args[]) {
        TwentyFortyEight tfe = new TwentyFortyEight(4);


        Scanner s = new Scanner(System.in);
        int bestScore = 0;
        boolean resetFlag = false;

        while(true) {
            System.out.println("Current score: " + tfe.getScore() + " | Best score: " + bestScore);
            tfe.showBoard();

            System.out.println("Enter up, down, left or right to move in that direction.");
            System.out.println("Enter reset to reset the game or quit to exit.");
            String line = s.nextLine();

            switch(line){
                case "up":
                    while(tfe.moveUp()){
                        // do nothing
                    }
                    break;
                case "down":
                    while(tfe.moveDown()){
                        // do nothing
                    }
                    break;
                case "left":
                    while(tfe.moveLeft()){
                        // do nothing
                    }
                    break;
                case "right":
                    while(tfe.moveRight()){
                        // do nothing
                    }
                    break;
                case "reset":
                    tfe.reset();
                    resetFlag = true;
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Invalid move, Please try again!!!!\n");
                    continue;

            }

            bestScore = Math.max(bestScore, tfe.getScore());
            if(!resetFlag) {
                tfe.placeRandom();
                resetFlag = false;
            }
        }
    }



    public void showBoard() {
        for(int x = 0; x < boardWidth * 6 + 1; x++){
            System.out.print("-");
        }
        System.out.println();

        for(int x = 0; x < boardWidth; x++) {
            for(int y = 0; y < boardWidth; y++) {
                String square = (board[x][y] == 0)? "":board[x][y] + "";
                System.out.printf("|%5s", square);
            }
            System.out.println("|");

            for(int y = 0; y < boardWidth * 6 + 1; y++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public int getScore() {
        return score;
    }

}
