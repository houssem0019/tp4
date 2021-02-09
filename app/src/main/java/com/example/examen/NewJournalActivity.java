package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewJournalActivity extends AppCompatActivity {
    private EditText mEditWordView;
    private TextView date;
    private EditText content;
    public static final String EXTRA_REPLY =
            "com.example.android.roomwordssample.REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_journal);
        mEditWordView = findViewById(R.id.editTextTextPersonName);
        content = findViewById(R.id.editTextTextPersonName5);
        date = findViewById(R.id.date);

        final Button button = findViewById(R.id.button);
        final Button button_save = findViewById(R.id.button2);

        button_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    String word1 = content.getText().toString();
                    String dateText = date.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    replyIntent.putExtra(EXTRA_REPLY, word1);
                    replyIntent.putExtra(EXTRA_REPLY,dateText);


                }
                finish();
            }
        });

    }
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),
                getString(R.string.datepicker));
    }
    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string +
                "/" + year_string);

        date.setText(dateMessage);

    }
}