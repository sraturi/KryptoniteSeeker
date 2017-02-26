package com.example.sachin.mineseeker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Path;
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
        int savedSize = getGameSize(this);
        setupOkButton();
        setupResetButton();
    }

    private void setupResetButton() {
        Button reset = (Button) findViewById(R.id.resetButton);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameScreen.removeNumGamesPlayed(OptionMenu.this);
            }
        });
    }

    private void setupOkButton() {
        Button ok = (Button) findViewById(R.id.okButton);
        ok.setOnClickListener(
                new View.OnClickListener() {
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
        rButton.setText(sizeList[i]+ " Kryptomite");
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
            rButton.setText(currentSize+" x "+ 6 +" Planets");
            else if (currentSize == 5)
                rButton.setText(currentSize+" x "+10+" Planets");
            else if (currentSize == 6)
                rButton.setText(currentSize+" x "+ 15+" Planets");
            rButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveGameSizeOption(currentSize);
                }
            });

            sizeRadioGroup.addView(rButton);
            if(getGameSize(this)==currentSize){
                rButton.setChecked(true);
            }
        }
    }

    private void saveGameSizeOption(int currentSize) {
        SharedPreferences pref = getSharedPreferences("AppData",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("gameSize",currentSize);
        editor.apply();
    }
    public static int getGameSize(Context contex){
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
