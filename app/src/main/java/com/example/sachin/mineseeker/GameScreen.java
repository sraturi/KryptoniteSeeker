package com.example.sachin.mineseeker;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

import static android.R.attr.button;

public class GameScreen extends AppCompatActivity {

    private  int NumberOfMinesRevealed = 0;
    private int totalNumberOfScans = 0;
    private MineSeeker minesSeeker = new MineSeeker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        populateButtons();
        setupTotalScans();
        setupMinesFound();
    }

    private void setupMinesFound() {
        TextView totalMines = (TextView) findViewById(R.id.numMinesFound);
        totalMines.setText("Mines Found "+ NumberOfMinesRevealed+"/" +minesSeeker.getNumberOfMines());

    }

    private void setupTotalScans() {
        TextView totalNumScans = (TextView) findViewById(R.id.totalNumScans);
        totalNumScans.setText("Number Of Scans: "+ totalNumberOfScans+"");
    }



    private void populateButtons() {
        TableLayout buttonTable = (TableLayout) findViewById(R.id.buttonTable);

        for(int rows = 0; rows<minesSeeker.getRows();rows++){
            final int currentRow = rows;
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,1.0f));
            buttonTable.addView(tableRow);
            for(int cols = 0;cols<minesSeeker.getCols();cols++) {
                final Button button = new Button(this);
                final int currentCol = cols;
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT, 1.0f));

                if(minesSeeker.getMineCellArray(rows,cols).getCellNumber() == 1){
                    minesSeeker.getMineCellArray(rows,cols).setIsMine(true);
                }
                button.setPadding(0, 0, 0, 0);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Random rand = new Random();
                        lockButtonSizes();
                        if(minesSeeker.getMineCellArray(currentRow,currentCol).isMine()) {
                            if(minesSeeker.getMineCellArray(currentRow,currentCol).isMineHidden()) {
                                setButtonSizeAndImage(button);
                                NumberOfMinesRevealed++;
                                setupMinesFound();
                                minesSeeker.getMineCellArray(currentRow,currentCol).setIsMineHidden(false);
                                resetbutton(currentRow,currentCol);
                            }
                            if(NumberOfMinesRevealed ==minesSeeker.getNumberOfMines()){
                              setupWinScreen();
                            }
                            if(minesSeeker.getMineCellArray(currentRow,currentCol).isMineRevealed()){
                                totalNumberOfScans++;
                                setupTotalScans();

                            }
                            else {
                                minesSeeker.getMineCellArray(currentRow,currentCol).setIsMineRevealed(true);

                            }
                        }

                        else if(!minesSeeker.getMineCellArray(currentRow,currentCol).isReavled()) {
                            totalNumberOfScans++;
                            setupTotalScans();
                            int totalMinesInColRow = minesSeeker.getTotalMinesInCol(currentCol) +
                                    minesSeeker.getTotalMinesInRow(currentRow);
                            button.setText(totalMinesInColRow+"");
                        minesSeeker.getMineCellArray(currentRow,currentCol).setReavled(true);
                        }
                    }
                });
            tableRow.addView(button);
           minesSeeker.setMines(rows,cols,button);
            }

        }
    }
    private void lockButtonSizes () {
        for (int row = 0; row != minesSeeker.getRows(); row++) {
            for (int col = 0; col != minesSeeker.getCols(); col++) {
                Button button = minesSeeker.getMines(row,col);
                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);
                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }
    private void setButtonSizeAndImage(Button button){
        int newWidth = button.getWidth();
        int newHeight = button.getHeight();
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mine);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
        Resources resource = getResources();
        button.setBackground(new BitmapDrawable(resource, scaledBitmap));
    }
    private void setupWinScreen(){
        FragmentManager manager = getSupportFragmentManager();
        WinScreen winScreen = new WinScreen();
        winScreen.show(manager,"winScreen");
    }
private void resetbutton(int row, int col){

    for(int i = 0; i <minesSeeker.getRows();i++){
        for(int j = col;j==col;j++){
            int k = 0;
            if(!minesSeeker.getMines(i,j).getText().toString().equals("")){
                k = Integer.parseInt(minesSeeker.getMines(i,j).getText().toString())-1;
                minesSeeker.getMines(i,j).setText(k+"");
            }
        }
    }

    for(int i = 0; i <minesSeeker.getCols();i++){
        for(int j = row;j==row;j++){
            int k = 0;
            if(!(minesSeeker.getMines(j,i).getText().toString().equals(""))){
                k = Integer.parseInt(minesSeeker.getMines(j,i).getText().toString())-1;
                minesSeeker.getMines(j,i).setText(k+"");
            }
        }
    }
}
}

