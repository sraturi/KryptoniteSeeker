package com.example.sachin.mineseeker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
        setupSizeOption();
        setupMineOption();
        
    }

    private void setupMineOption() {
        RadioGroup MineRadioGroup = (RadioGroup) findViewById(R.id.mineOptionRadio);
        int[] sizeList = getResources().getIntArray(R.array.numberOfMines);
        for (int i =0; i<sizeList.length;i++) {
        RadioButton rButton = new RadioButton(this);
        rButton.setText(sizeList[i]+ " Mines");
            MineRadioGroup.addView(rButton);
            }
        }

    private void setupSizeOption() {
        RadioGroup sizeRadioGroup = (RadioGroup) findViewById(R.id.sizeOptionRadio);
       int[] sizeList = getResources().getIntArray(R.array.number_of_Row_and_Column);
        for (int i =0; i<sizeList.length;i++){
            int currentSize = sizeList[i];
            RadioButton rButton = new RadioButton(this);
            if(currentSize == 4)
            rButton.setText(currentSize+" x "+ 6 );
            else if (currentSize == 5)
                rButton.setText(currentSize+" x "+10);
            else if (currentSize == 6)
                rButton.setText(currentSize+" x "+ 15);
            rButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            sizeRadioGroup.addView(rButton);
        }
    }
}
