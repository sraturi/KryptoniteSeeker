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
    private final  int MINE =1;
    private final int NOT_MINE = 0;
    private static Button MineButtonArray[][];
    private  int rows = 0;
    private  int cols = 0;
    private static int numberOfMines = 0;
    private static Cell MineCellArray[][];
    Random rand = new Random(System.nanoTime());

    public MineSeeker(){
       int size = MainMenu.size;
        int maxNumMines = MainMenu.numMines;
        if(size == 4){
            rows = 4;
            cols = 6;
        }
        else if(size == 5){
            rows = 5;
            cols = 10;
        }
        else if (size == 6){
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
                   if (size == 4)
                       x = rand.nextInt(2);
                   else if (size == 5)
                       x = rand.nextInt(size/2);
                   else {
                       x = rand.nextInt(size-2);
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
