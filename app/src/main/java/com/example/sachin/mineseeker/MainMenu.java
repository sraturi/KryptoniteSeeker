package com.example.sachin.mineseeker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    public static int size = 0;
    public static int numMines = 0;
    public static int numGamesPlayed = 0;

    private void getNumberOfMines() {
        numMines = OptionMenu.getNumMInes(this);
    }

    private void getSize() {
        size = OptionMenu.getSize(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent newGameIntent = new Intent(MainMenu.this, GameScreen.class);
        Intent optionIntent = OptionMenu.makeIntent(this);
        OnButtonClick(R.id.newGameButton, newGameIntent);
        OnButtonClick(R.id.optionButton, optionIntent);
        getSize();
        getNumberOfMines();
        numGamesPlayed = getNumGamesPlayed();
        saveNumGamesPlayed(numGamesPlayed);
    }

    private void OnButtonClick(final int buttonId, final Intent intent) {
        Button button = (Button) findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonId == R.id.newGameButton){
                    numGamesPlayed++;
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSize();
        getNumberOfMines();
    }

    private void saveNumGamesPlayed(int currentSize) {
        SharedPreferences pref = getSharedPreferences("AppData", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("numGamesPlayed", currentSize);
        editor.apply();
    }

    private int getNumGamesPlayed() {
        SharedPreferences pref = getSharedPreferences("AppData", MODE_PRIVATE);
        return pref.getInt("numGamesPlayed", 0);
    }
}