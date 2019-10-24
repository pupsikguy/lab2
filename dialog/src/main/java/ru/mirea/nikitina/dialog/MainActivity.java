package ru.mirea.nikitina.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener {
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
        Button button2 = (Button) findViewById(R.id.bDate);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }

        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView2 = (TextView)findViewById(R.id.textView);
        textView2.setText("Hour: "+ hourOfDay + " Minute: " + minute);
    }

    public void Cl(View view) {
        MyAlterDialogFragment dialogFragment = new MyAlterDialogFragment ();
        dialogFragment.show(getSupportFragmentManager(), "dialog");
    }
    public void onOkClicked()
    {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",Toast.LENGTH_LONG).show();
    }

    public void onCancelClicked()
    {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",Toast.LENGTH_LONG).show();
    }

    public void onNeutralClicked()
    {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        tvDate.setText(currentDateString);
    }

    public void click(View view) {
        progress =new ProgressDialog(MainActivity.this);
        progress.setMax(100);
        progress.setTitle("KRY");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
    }
}



