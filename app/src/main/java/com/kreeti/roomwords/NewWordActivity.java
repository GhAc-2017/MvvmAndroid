package com.kreeti.roomwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.kreeti.roomwords.REPLY";
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        edit = findViewById(R.id.edit_word);
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reply = new Intent();
                if (TextUtils.isEmpty(edit.getText())){
                    setResult(RESULT_CANCELED,reply);
                }
                else{
                    String word = edit.getText().toString();
                    reply.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, reply);
                }
                finish();
            }
        });
    }
}
