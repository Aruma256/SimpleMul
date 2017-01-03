package com.github.obsproth.simplemul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private MyRecyclerAdapter adapter;
    private TextView ansText;
    private EditText valA, valB;
    private Switch switchView;
    private Button button;

    private double a, b;
    private boolean isMul;
    private String ansStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ansText = (TextView) findViewById(R.id.text_ans);
        valA = (EditText) findViewById(R.id.edit_val_a);
        valB = (EditText) findViewById(R.id.edit_val_b);
        switchView = (Switch) findViewById(R.id.switch_view);
        button = (Button) findViewById(R.id.button);
        //
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        adapter.removeItem(position);
                    }
                }).attachToRecyclerView(recyclerView);
        valA.addTextChangedListener(this);
        valB.addTextChangedListener(this);
        switchView.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        adapter.addItem(new Formula(a, b, isMul, ansStr));
    }

    private void update() {
        try {
            a = Double.parseDouble(valA.getText().toString());
            b = Double.parseDouble(valB.getText().toString());
        } catch (NumberFormatException e) {
            return;
        }
        isMul = !switchView.isChecked();
        double ans;
        if (isMul) {
            ans = a * b;
        } else {
            ans = b != 0 ? a / b : Double.NaN;
        }
        ansStr = String.format("%.3f", ans);
        ansText.setText(ansStr);
    }

}
