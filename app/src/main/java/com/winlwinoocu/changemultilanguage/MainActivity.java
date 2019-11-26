package com.winlwinoocu.changemultilanguage;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.winlwinoocu.multilanguage.MultiLanguage;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button click;
    AlertDialog alertDialog;

    MultiLanguage multiLanguage;//first declare

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        multiLanguage = new MultiLanguage(this);//create object
        /*
         * Use loadLanguage method
         * For load current language
         */
        multiLanguage.loadLanguage();
        setContentView(R.layout.activity_main);

        click = findViewById(R.id.click);
        click.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.click){
            showChangeLanguageAlert();
        }
    }

    private void showChangeLanguageAlert() {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View alertView = inflater.inflate(R.layout.change_language,null);

        RelativeLayout mm_layout = alertView.findViewById(R.id.mm_layout);
        RelativeLayout eng_layout = alertView.findViewById(R.id.eng_layout);

        mm_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiLanguage.setLanguage("mm");
                recreate();

                alertDialog.dismiss();
            }
        });
        eng_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                multiLanguage.setLanguage("en-us");
                recreate();
                alertDialog.dismiss();
            }
        });

        alert.setView(alertView);
        alertDialog = alert.create();
        alertDialog.show();
    }
}
