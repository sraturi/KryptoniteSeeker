package com.example.sachin.mineseeker;

import android.util.Log;
import android.widget.Button;

import java.util.Random;

/**
 * 1 is a mine
 * 0 is not a mine
 * dummy array keeps track of the total mines
 * Created by Sachin on 2017-02-15.
 */




public class MineSeeker {
    private static Button Mines[][];
    private static int rows = 0;
    private static int cols = 0;
    private static int numberOfMines = 0;
    private static int dummyArray[][];
    Random rand = new Random();
    public MineSeeker(){
        rows = 5;
        cols = 5;
        numberOfMines = 0;
        Mines = new Button[rows][cols];
        dummyArray = new int[rows][cols];
        for(int i =0;i<getRows();i++){
            for (int j = 0;j<getCols();j++){
                int x = rand.nextInt(2);
                if(x==1){
                    numberOfMines++;
                }
                Log.i("num",x+"");
                dummyArray[i][j] = x;
            }
            Log.i("total",numberOfMines+"");
        }
    }
    public MineSeeker(int row,int col){
        rows = row;
        cols = col;
        numberOfMines =0;
        Mines = new Button[rows][cols];
        dummyArray = new int[row][col];
        for(int i =0;i<getRows();i++){
            for (int j = 0;j<getCols();j++){
                int x = rand.nextInt(2);
                Log.i("num",x+"");
                if(x==1){
                    numberOfMines++;
                }
                dummyArray[i][j] = x;
            }
        }
        Log.i("total",numberOfMines+"");
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

    public  void setCols(int cols) {
        MineSeeker.cols = cols;
    }

    public  void setRows(int row) {
        rows = row;
    }

    public  void setMines(int row,int col,Button button) {
         Mines[row][col] = button;
    }

    public Button getMines(int row,int col) {
        return Mines[row][col];
    }
    public int getDummyMine(int row,int col) {
        return dummyArray[row][col];
    }
    public int getTotalMinesInCol(int currentCol){
        int totalMines =0;
        for(int rows = 0; rows<getRows();rows++){
            if(dummyArray[rows][currentCol] == 1){
                totalMines++;
            }
        }
        return totalMines;
    }
    public int getTotalMinesInRow(int currentRow){
        int totalMines =0;
        for(int cols = 0; cols<getCols();cols++){
            if(dummyArray[currentRow][cols] == 1){
                totalMines++;
            }
        }
        return totalMines;
    }
}
