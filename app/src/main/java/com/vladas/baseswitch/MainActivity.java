package com.vladas.baseswitch;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        EditText decimalInput = findViewById(R.id.number_decimal);
        EditText binaryInput = findViewById(R.id.number_binary);
        EditText octalInput = findViewById(R.id.number_octal);
        EditText hexadecimalInput = findViewById(R.id.number_hexadecimal);

        setDefaultIfEmpty(decimalInput);
        setDefaultIfEmpty(binaryInput);
        setDefaultIfEmpty(octalInput);
        setDefaultIfEmpty(hexadecimalInput);

        TextView header = findViewById(R.id.header);

        Button convertButton = findViewById(R.id.button_convert);

        convertButton.setOnClickListener(v -> {
            long number = 0L;
            if (decimalInput.hasFocus()) {
                number = Integer.parseInt(decimalInput.getText().toString(), 10);
            } else if (binaryInput.hasFocus()) {
                number = Integer.parseInt(binaryInput.getText().toString(), 2);
            } else if (octalInput.hasFocus()) {
                number = Integer.parseInt(octalInput.getText().toString(), 8);
            } else if (hexadecimalInput.hasFocus()) {
                number = Integer.parseInt(hexadecimalInput.getText().toString(), 16);
            }
            setValues(number);
        });

        Button clearButton = findViewById(R.id.button_clear);

        clearButton.setOnClickListener(v -> {
            header.setText(getString(R.string.ask_for_number));
            binaryInput.setText(DEFAULT);
            octalInput.setText(DEFAULT);
            decimalInput.setText(DEFAULT);
            hexadecimalInput.setText(DEFAULT);
        });

    }

    private void setDefaultIfEmpty(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setText(DEFAULT);
        }
    }

    private void setValues(long number) {
        setBinaryValue(number);
        setOctalValue(number);
        setDecimalValue(number);
        setHexadecimalValue(number);
    }

    private void setBinaryValue(long number) {
        EditText binaryInput = findViewById(R.id.number_binary);
        binaryInput.setText(String.format(Long.toString(number, 2)));
    }

    private void setOctalValue(long number) {
        EditText octalInput = findViewById(R.id.number_octal);
        octalInput.setText(String.format(Long.toString(number, 8)));
    }

    private void setDecimalValue(long number) {
        EditText decimalInput = findViewById(R.id.number_decimal);
        decimalInput.setText(String.format(Long.toString(number, 10)));
    }

    private void setHexadecimalValue(long number) {
        EditText hexadecimalInput = findViewById(R.id.number_hexadecimal);
        hexadecimalInput.setText(String.format(Long.toString(number, 16)).toUpperCase());
    }

    private static final String DEFAULT = "0";
}
