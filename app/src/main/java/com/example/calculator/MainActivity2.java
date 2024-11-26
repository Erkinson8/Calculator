package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner typeSpinner = findViewById(R.id.type_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_array,
                android.R.layout.test_list_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);


        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        TextView resultTextView = findViewById(R.id.result_text_view);
        resultTextView.setText(result);
    }

    public void onLikeButtonClick(View view) {
        Button likeButton = (Button) view;

        if (likeButton.getTag() == null || (int) likeButton.getTag() == R.drawable.ic_heart_empty) {
            likeButton.setBackgroundResource(R.drawable.ic_heart_full);
            likeButton.setTag(R.drawable.ic_heart_full);
        } else {
            likeButton.setBackgroundResource(R.drawable.ic_heart_empty);
            likeButton.setTag(R.drawable.ic_heart_empty);
        }

    }

    public void onNextButtonClick(View view) {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);

        finishAffinity();

    }
}