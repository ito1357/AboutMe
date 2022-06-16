package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.done_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNickname(view);

                // Hide the keyboard.
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });

        ((TextView)findViewById(R.id.nickname_text)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNickname(view);
            }
        });
    }

    private void addNickname(View view){
        EditText editText = findViewById(R.id.nickname_edit);
        TextView nicknameTextView = findViewById(R.id.nickname_text);

        nicknameTextView.setText(editText.getText());
        editText.setVisibility(View.GONE);
        view.setVisibility(View.GONE);
        nicknameTextView.setVisibility(View.VISIBLE);
    }

    private void updateNickname(View view){
        EditText editText = findViewById(R.id.nickname_edit);
        Button doneButton = findViewById(R.id.done_button);

        editText.setVisibility(View.VISIBLE);
        doneButton.setVisibility(View.VISIBLE);
        view.setVisibility(View.GONE);

        // Set the focus to the edit text.
        editText.requestFocus();

        //Show the keyboard.
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editText, 0);
    }
}