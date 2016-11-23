package com.github.obsproth.simplemul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener {

    EditText input, mul;
    TextView output;
    Switch switchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.edit_input);
        mul = (EditText) findViewById(R.id.edit_mul);
        output = (TextView) findViewById(R.id.text_output);
        switchView = (Switch) findViewById(R.id.switch_view);
        //
        input.addTextChangedListener(this);
        mul.addTextChangedListener(this);
        switchView.setOnCheckedChangeListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        update();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        update();
    }

    private void update(){
        double d = 0, m = 0;
        try {
            d = Double.parseDouble(input.getText().toString());
            m = Double.parseDouble(mul.getText().toString());
        } catch (NumberFormatException e) {
        }
        if (!switchView.isChecked()) {
            output.setText(String.valueOf(d * m));
        } else {
            output.setText(m != 0 ? String.valueOf(d / m) : "");
        }
    }

}
