package com.example.ctofconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ctofconverter.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText mCtof_edittext;
    Button mCtof_convert_button;
    TextView mCtof_value_display;

    ActivityMainBinding mMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mMainBinding.getRoot();

        setContentView(view);

        mCtof_edittext = mMainBinding.ctofInputEdittext;
        mCtof_convert_button = mMainBinding.ctofConvertButton;
        mCtof_value_display = mMainBinding.ctofConvertedValueTextview;

        mCtof_convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsius = mCtof_edittext.getText().toString();
                Double fahrenheit = 0.0;

                try{
                    fahrenheit = Double.parseDouble(celsius);
                    fahrenheit = Util.c_to_f(fahrenheit);
                }catch (NumberFormatException e){
                    Log.d("c_to_f", "Could not convert" + celsius);
                }

                mCtof_value_display.setText(String.format(Locale.US, "%.2f",fahrenheit) +"\u00B0F");
            }
        });

        mCtof_convert_button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = ftoc_Activity.getIntent(getApplicationContext());
                startActivity(intent);
                return false;
            }
        });

    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

}