package com.example.sachin.mineseeker;

import android.widget.Button;

import java.util.Random;

/**
 * 1 is a mine
 * 0 is not a mine
 * dummy array keeps track of the total mines
 * Created by Sachin on 2017-02-15.
 */




public class MineSeeker {
    private final int FOURbySIX = 4;
    private final int FIVEbyTEN = 5;
    private final int SIXbyFIFTEEN = 6;
    private final  int MINE =1;
    private final int NOT_MINE = 0;
    private static Button MineButtonArray[][];
    private  int rows = 0;
    private  int cols = 0;
    private static int numberOfMines = 0;
    private static Cell MineCellArray[][];
    Random rand = new Random(System.nanoTime());

    public MineSeeker(int gameSize, int numMines){
       int boardSize = gameSize;
        int maxNumMines = numMines;
        if(boardSize == FOURbySIX){
            rows = 4;
            cols = 6;
        }
        else if(boardSize == FIVEbyTEN){
            rows = 5;
            cols = 10;
        }
        else if (boardSize == SIXbyFIFTEEN){
            rows = 6;
            cols = 15;
        }
        else {
            rows = 5;
            cols = 5;
        }
        numberOfMines = 0;
        MineButtonArray = new Button[rows][cols];
        MineCellArray = new Cell[rows][cols];
           for (int i = 0; i < getRows(); i++) {
               for (int j = 0; j < getCols(); j++) {
                   Cell mine = new Cell();
                   MineCellArray[i][j] = mine;
                   int x = NOT_MINE;
                   if (boardSize == FOURbySIX){
                       if (maxNumMines == 6)
                           x = rand.nextInt(boardSize);
                       else if (maxNumMines == 10) {
                           x = rand.nextInt(boardSize-2);
                       } else if (maxNumMines == 15) {
                           x = rand.nextInt(2);
                           if(numberOfMines <maxNumMines && ((getRows()-i == 1)||(getRows()-i==2))){
                               x = MINE;
                           }
                       } else if (maxNumMines == 20) {
                           x = rand.nextInt(2);
                           if(numberOfMines <maxNumMines && ((getRows()-i == 1)||(getRows()-i==2))){
                               x = MINE;
                           }
                       }
                   }

                   else if (boardSize == FIVEbyTEN) {
                       if (maxNumMines == 6)
                           x = rand.nextInt(boardSize+2);
                       else if (maxNumMines == 10) {
                           x = rand.nextInt(boardSize-1);
                       } else if (maxNumMines == 15) {
                           x = rand.nextInt(boardSize -2);
                       } else if (maxNumMines == 20) {
                           x = rand.nextInt(boardSize-3);
                       }
                   }
                   else if (boardSize == SIXbyFIFTEEN){
                       if (maxNumMines == 6)
                           x = rand.nextInt(boardSize*2);
                       else if (maxNumMines == 10) {
                           x = rand.nextInt(boardSize+2);
                       } else if (maxNumMines == 15) {
                           x = rand.nextInt(boardSize-2);
                       } else if (maxNumMines == 20) {
                           x = rand.nextInt(boardSize-3);
                       }
                   }
                   if (x == MINE && (numberOfMines < maxNumMines)) {
                       numberOfMines++;
                       MineCellArray[i][j].setCellNumber(x);
                   } else {
                       MineCellArray[i][j].setCellNumber(0);
                   }
               }

           }


    }
    public  int getCols() {
        return cols;
    }

    public  int getRows() {
        return rows;
    }
    public int getNumberOfMines(){
        return numberOfMines;
    }

    public  void setCols(int col) {
        cols = col;
    }

    public  void setRows(int row) {
        rows = row;
    }

    public  void setMines(int row,int col,Button button) {
         MineButtonArray[row][col] = button;
    }

    public Button getMines(int row,int col) {
        return MineButtonArray[row][col];
    }
    public Cell getMineCellArray(int row, int col) {
        return MineCellArray[row][col];
    }


    public int getTotalMinesInCol(int currentCol){
        int totalMines =0;
        for(int rows = 0; rows<getRows();rows++){
            if(MineCellArray[rows][currentCol].getCellNumber() == MINE &&(MineCellArray[rows][currentCol].isMineHidden())){
                totalMines++;
            }
        }
        return totalMines;
    }
    public int getTotalMinesInRow(int currentRow){
        int totalMines =0;
        for(int cols = 0; cols<getCols();cols++){
            if(MineCellArray[currentRow][cols].getCellNumber() ==  MINE &&
                    MineCellArray[currentRow][cols].isMineHidden()){
                totalMines++;
            }
        }
        return totalMines;
    }

    public static Button[][] getMineButtonArray() {
        return MineButtonArray;
    }
}
