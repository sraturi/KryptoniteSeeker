package com.example.sachin.mineseeker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent newGameIntent = new Intent(MainMenu.this,GameScreen.class);
        OnButtonClick(R.id.button,newGameIntent);

    }

    private void OnButtonClick(int buttonId, final Intent intent) {
        Button button = (Button) findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
    }
}
