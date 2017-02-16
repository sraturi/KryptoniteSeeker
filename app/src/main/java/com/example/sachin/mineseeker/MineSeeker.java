package com.example.sachin.mineseeker;

import android.widget.Button;

/**
 * Created by Sachin on 2017-02-15.
 */

public class MineSeeker {
    private static Button Mines[][];
    private static int rows = 0;
    private static int cols = 0;
    public MineSeeker(){
        rows = 5;
        cols = 5;
    }
    public MineSeeker(int row,int col){
        rows = row;
        cols = col;
        Mines = new Button[rows][cols];
    }
    public  int getCols() {
        return cols;
    }

    public  int getRows() {
        return rows;
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
    public int getTotalMinesInCol(int col){
        int totalMines =0;
        for(int rows = 0; rows<=getRows();rows++){
            for(int cols = col;cols==col;cols++){

                //find the mines here
            }
        }

        return totalMines;
    }
}
