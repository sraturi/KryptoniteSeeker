package com.example.sachin.mineseeker;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Random;

public class GameScreen extends AppCompatActivity {

    private  int NumberOfMinesRevealed = 0;

    private MineSeeker minesSeeker = new MineSeeker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        populateButtons();
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

                if(minesSeeker.getDummyMine(rows,cols) == 0){
                    button.setBackgroundResource(R.drawable.grass);
                }
                else {
                    button.setBackgroundResource(R.drawable.grass);
                    button.setText("Mine");

                }
                button.setPadding(0, 0, 0, 0);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Random rand = new Random();
                        lockButtonSizes();
                        if(button.getText().equals("Mine")) {
                            setButtonSizeAndImage(button);
                            NumberOfMinesRevealed++;
                            if(NumberOfMinesRevealed ==minesSeeker.getNumberOfMines()){
                                Intent intent = new Intent(GameScreen.this,MainMenu.class);
                            //    startActivity(intent);
                                finish();
                            }
                        }
                        else {
                            if(rand.nextBoolean())
                            button.setText(minesSeeker.getTotalMinesInCol(currentCol)+"");
                            else{
                                button.setText(minesSeeker.getTotalMinesInRow(currentRow)+"");
                            }
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
}
