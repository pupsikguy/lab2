package ru.mirea.nikitina.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ckick(View view) {
        editText=findViewById(R.id.edittext);
        String textEntred =editText.getText().toString();
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("key", textEntred);
        startActivity(intent);
    }
}
