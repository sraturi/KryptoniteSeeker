package com.example.sachin.mineseeker;

import android.widget.Button;

/**
 * Created by Sachin on 2017-02-22.
 */

public class Cell {
    private  boolean isReavled;
    private int cellNumber;
    private boolean isMine;
    private boolean isMineRevealed;
    private boolean isMineHidden;
    public Cell(){
        isReavled = false;
        isMine = false;
        isMineRevealed = false;
        cellNumber = 0;
        isMineHidden = true;
    }

    public boolean isMineHidden() {
        return isMineHidden;
    }

    public void setIsMineHidden(boolean mineHidden) {
        isMineHidden = mineHidden;
    }

    public boolean isMineRevealed() {
        return isMineRevealed;
    }

    public void setIsMineRevealed(boolean mineRevealed) {
        isMineRevealed = mineRevealed;
    }

    public boolean isMine() {
        return isMine;
    }

    public boolean isReavled() {
        return isReavled;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumb) {
        this.cellNumber = cellNumb;
    }

    public void setIsMine(boolean mine) {
        isMine = mine;
    }

    public void setReavled(boolean reavled) {
        isReavled = reavled;
    }


}
