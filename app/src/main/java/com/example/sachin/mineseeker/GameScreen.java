package com.example.sachin.mineseeker;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GameScreen extends AppCompatActivity {

    private static final int NUMS_ROW = 3;
    private static final int NUMS_COL =3 ;
    public static MineSeeker minesSeeker = new MineSeeker(NUMS_ROW,NUMS_COL);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        populateButtons();
    }



    private void populateButtons() {
        TableLayout buttonTable = (TableLayout) findViewById(R.id.buttonTable);

        for(int rows = 0; rows<NUMS_ROW;rows++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,1.0f));
            buttonTable.addView(tableRow);
            for(int cols = 0;cols<NUMS_COL;cols++) {
                final Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT, 1.0f));

                button.setText("" + rows + "" + cols);
                button.setPadding(0, 0, 0, 0);


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lockButtonSizes(); // Change text on button:
                        setButtonSize(button);
                    }
                });

            tableRow.addView(button);
           minesSeeker.setMines(rows,cols,button);
            }

        }
    }
    private void lockButtonSizes () {
        for (int row = 0; row != NUMS_ROW; row++) {
            for (int col = 0; col != NUMS_COL; col++) {
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
    private void setButtonSize(Button button){
        int newWidth = button.getWidth();
        int newHeight = button.getHeight();
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shutterstock_82439548);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
        Resources resource = getResources();
        button.setBackground(new BitmapDrawable(resource, scaledBitmap));
    }
}
