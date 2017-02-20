package com.example.sachin.mineseeker;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;

import java.sql.Time;
import java.util.Random;

/**
 * 1 is a mine
 * 0 is not a mine
 * dummy array keeps track of the total mines
 * Created by Sachin on 2017-02-15.
 */




public class MineSeeker {
    private static Button Mines[][];
    private  int rows = 0;
    private  int cols = 0;
    private static int numberOfMines = 0;
    private static int dummyArray[][];
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
        Mines = new Button[rows][cols];
        dummyArray = new int[rows][cols];
           for (int i = 0; i < getRows(); i++) {
               for (int j = 0; j < getCols(); j++) {
                   int x = 0;
                   if (size == 4)
                       x = rand.nextInt(2);
                   else if (size == 5)
                       x = rand.nextInt(size/2);
                   else {
                       x = rand.nextInt(size-2);
                   }
                   if (x == 1 && (numberOfMines < maxNumMines)) {
                       numberOfMines++;

                       Log.i("num", x + "");
                       dummyArray[i][j] = x;
                   } else {
                       dummyArray[i][j] = 0;
                   }
               }
               Log.i("total", numberOfMines + "");
           }


    }
    public MineSeeker(int row,int col){
        rows = row;
        cols = col;
        numberOfMines =0;
        Mines = new Button[rows][cols];
        dummyArray = new int[row][col];
        Random rand = new Random();
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

    public  void setCols(int col) {
        cols = col;
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
