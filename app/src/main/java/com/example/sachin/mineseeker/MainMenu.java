package com.example.sachin.mineseeker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    public static int gameSize = 0;
    public static int totalNumKryptonite = 0;
    private void getNumberOfMines() {
        totalNumKryptonite = OptionMenu.getNumMInes(this);
    }

    private void getGameSize() {
        gameSize = OptionMenu.getGameSize(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent newGameIntent = new Intent(MainMenu.this, GameScreen.class);
        Intent optionIntent = OptionMenu.makeIntent(this);
        Intent helpIntent = new Intent(MainMenu.this, HelpScreen.class);
        OnButtonClick(R.id.newGameButton, newGameIntent);
        OnButtonClick(R.id.optionButton, optionIntent);
        OnButtonClick(R.id.helpButton,helpIntent);
        getGameSize();
        getNumberOfMines();
    }

    private void OnButtonClick(final int buttonId, final Intent intent) {
        Button button = (Button) findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getGameSize();
        getNumberOfMines();
    }


}