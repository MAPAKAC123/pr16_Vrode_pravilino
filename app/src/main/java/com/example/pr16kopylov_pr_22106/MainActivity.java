package com.example.pr16kopylov_pr_22106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button Save, Load;
    EditText etText;
    TextView text;
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    void saveText() {
     sPref = getPreferences(MODE_PRIVATE);
     SharedPreferences.Editor ed = sPref.edit();
     ed.putString(SAVED_TEXT, etText.getText().toString());
     ed.commit();
     Toast.makeText(this,"Text saved", Toast.LENGTH_SHORT).show();
    }
    void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT,"");
        text.setText(savedText);
        Toast.makeText(this,"Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Save = (Button) findViewById(R.id.btnSave);
        Save.setOnClickListener(this);
        Load = (Button) findViewById(R.id.btnLoad);
        Load.setOnClickListener(this);
        text = (TextView) findViewById(R.id.text1);
        etText=(EditText) findViewById(R.id.edText);
        loadText();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
    @Override
    public void onClick(View view){
        if(view.getId() == R.id.btnSave){
            saveText();
        }
        else if(view.getId() == R.id.btnLoad){
            loadText();
        }
    }

}