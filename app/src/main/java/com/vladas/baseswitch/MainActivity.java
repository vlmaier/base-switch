package com.vladas.baseswitch;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Typeface font = Typeface.createFromAsset(getAssets(), "ostrich-regular.ttf");

        TextView header = (TextView) findViewById(R.id.header);
        header.setTypeface(font);
        TextView header10 = (TextView) findViewById(R.id.header10);
        header10.setTypeface(font);
        TextView header2 = (TextView) findViewById(R.id.header2);
        header2.setTypeface(font);
        TextView header8 = (TextView) findViewById(R.id.header8);
        header8.setTypeface(font);
        TextView header16 = (TextView) findViewById(R.id.header16);
        header16.setTypeface(font);

        EditText z10 = (EditText) findViewById(R.id.z10);
        z10.setTypeface(font);
        EditText z2 = (EditText) findViewById(R.id.z2);
        z2.setTypeface(font);
        EditText z8 = (EditText) findViewById(R.id.z8);
        z8.setTypeface(font);
        EditText z16 = (EditText) findViewById(R.id.z16);
        z16.setTypeface(font);

        Button b = (Button) findViewById(R.id.b);
        b.setTypeface(font);
        Button c = (Button) findViewById(R.id.c);
        c.setTypeface(font);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView header = (TextView) findViewById(R.id.header);
                EditText z10 = (EditText) findViewById(R.id.z10);
                EditText z2 = (EditText) findViewById(R.id.z2);
                EditText z8 = (EditText) findViewById(R.id.z8);
                EditText z16 = (EditText) findViewById(R.id.z16);

                if (z10.getText().length() != 0 && z2.getText().length() == 0 && z8.getText().length() == 0 && z16.getText().length() == 0) {
                    header.setText("Geben Sie die Zahl entsprechend ein");
                    int input = Integer.parseInt(z10.getText().toString());

                    z2.setText(Integer.toString(input, 2));
                    z8.setText(Integer.toString(input, 8));
                    z16.setText(Integer.toString(input, 16));
                } else if(z2.getText().length() != 0 && z8.getText().length() == 0 && z10.getText().length() == 0 && z16.getText().length() == 0) {
                    header.setText("Geben Sie die Zahl entsprechend ein");
                    String input = z2.getText().toString();
                    int dez = Integer.parseInt(input, 2);

                    z10.setText(Integer.toString(dez, 10));
                    z8.setText(Integer.toString(dez, 8));
                    z16.setText(Integer.toString(dez, 16));
                } else if(z8.getText().length() != 0 && z2.getText().length() == 0 && z10.getText().length() == 0 && z16.getText().length() == 0) {
                    header.setText("Geben Sie die Zahl entsprechend ein");
                    String input = z8.getText().toString();
                    int dez = Integer.parseInt(input, 8);

                    z10.setText(Integer.toString(dez, 10));
                    z2.setText(Integer.toString(dez, 2));
                    z16.setText(Integer.toString(dez, 16));
                } else if(z16.getText().length() != 0 && z2.getText().length() == 0 && z8.getText().length() == 0 && z10.getText().length() == 0) {
                    header.setText("Geben Sie die Zahl entsprechend ein");
                    String input = z16.getText().toString();
                    int dez = Integer.parseInt(input, 16);

                    z10.setText(Integer.toString(dez, 10));
                    z2.setText(Integer.toString(dez, 2));
                    z8.setText(Integer.toString(dez, 8));
                } else
                    header.setText("Falsche Eingabe!");
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText z10 = (EditText) findViewById(R.id.z10);
                EditText z2 = (EditText) findViewById(R.id.z2);
                EditText z8 = (EditText) findViewById(R.id.z8);
                EditText z16 = (EditText) findViewById(R.id.z16);

                z2.setText("");
                z8.setText("");
                z10.setText("");
                z16.setText("");
            }
        });
    }
}
