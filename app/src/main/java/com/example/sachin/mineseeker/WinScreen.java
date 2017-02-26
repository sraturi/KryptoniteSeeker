package com.example.sachin.mineseeker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Sachin on 2017-02-22.
 */

public class WinScreen extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.win_screen_layout,null);
        setupScore(v);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                getActivity().finish();
            }
        };
                return new AlertDialog.Builder(getActivity()).setView(v)
                        .setPositiveButton(android.R.string.ok,listener).create();
    }

    private void setupScore(View v) {
        TextView text = (TextView) v.findViewById(R.id.finalScoreText);
                TextView text1 = (TextView)getActivity().findViewById(R.id.totalNumScans);
        String score = text1.getText().toString();
        text.setText(score);
    }


}
