package com.example.sachin.mineseeker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionMenu extends AppCompatActivity {
    private static int Default_Val = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
        setupSizeOption();
        setupMineOption();
        int savedSize = getSize(this);
        setupOkButton();
    }

    private void setupOkButton() {
        Button ok = (Button) findViewById(R.id.okButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupMineOption() {
        RadioGroup MineRadioGroup = (RadioGroup) findViewById(R.id.mineOptionRadio);
        final int[] sizeList = getResources().getIntArray(R.array.numberOfMines);
        for (int i =0; i<sizeList.length;i++) {
        RadioButton rButton = new RadioButton(this);
            final int numMines = sizeList[i];
        rButton.setText(sizeList[i]+ " Cell");
            rButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveNumberOfMines(numMines);
                }
            });
            MineRadioGroup.addView(rButton);
            if(getNumMInes(this)== numMines){
                rButton.setChecked(true);
                }
            }
        }


    private void setupSizeOption() {
        RadioGroup sizeRadioGroup = (RadioGroup) findViewById(R.id.sizeOptionRadio);
       int[] sizeList = getResources().getIntArray(R.array.number_of_Row_and_Column);
        for (int i =0; i<sizeList.length;i++){
            final int currentSize = sizeList[i];
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
                    saveSizeOption(currentSize);
                }
            });

            sizeRadioGroup.addView(rButton);
            if(getSize(this)==currentSize){
                rButton.setChecked(true);
            }
        }
    }

    private void saveSizeOption(int currentSize) {
        SharedPreferences pref = getSharedPreferences("AppData",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("gameSize",currentSize);
        editor.apply();
    }
    public static int getSize(Context contex){
        SharedPreferences pref = contex.getSharedPreferences("AppData",MODE_PRIVATE);
        return pref.getInt("gameSize",Default_Val);
    }

    private void saveNumberOfMines(int NumMInes) {
        SharedPreferences pref = getSharedPreferences("AppData",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("numberOfMines",NumMInes);
        editor.apply();
    }

    public static int getNumMInes(Context contex){
        SharedPreferences pref = contex.getSharedPreferences("AppData",MODE_PRIVATE);
        return pref.getInt("numberOfMines", Default_Val);
    }
    public static Intent makeIntent(Context context){
        return  new Intent(context,OptionMenu.class);
    }

}
