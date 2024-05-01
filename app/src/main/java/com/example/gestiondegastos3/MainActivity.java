package com.example.gestiondegastos3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextAmount;
    private Button buttonAdd;
    private ListView listViewExpenses;
    private ArrayList<String> expensesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewExpenses = findViewById(R.id.listViewExpenses);

        expensesList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, expensesList);
        listViewExpenses.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = editTextAmount.getText().toString();
                expensesList.add(amount);
                adapter.notifyDataSetChanged();
                editTextAmount.setText("");
            }
        });
    }
}
