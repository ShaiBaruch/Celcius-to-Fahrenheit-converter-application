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

import com.example.ctofconverter.databinding.ActivityFtocBinding;

import java.util.Locale;

public class ftoc_Activity extends AppCompatActivity {

    EditText mFtoc_edittext;
    Button mFtoc_button;
    TextView mFtoc_value_display;

    TextView mFtoc_label_textview;

    ActivityFtocBinding mFtoc_binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftoc);

        mFtoc_binding = ActivityFtocBinding.inflate(getLayoutInflater());

        setContentView(mFtoc_binding.getRoot());

        mFtoc_edittext = mFtoc_binding.ftocInputEdittext;
        mFtoc_button = mFtoc_binding.ftocConvertButton;
        mFtoc_value_display = mFtoc_binding.ftocConvertedValueTextview;
        mFtoc_label_textview =mFtoc_binding.ftocLabelTextview;
        mFtoc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double celsius = 0.0;
                try{
                    celsius = Util.f_to_c(Double.parseDouble(mFtoc_edittext.getText().toString()));
                } catch (NumberFormatException e){
                    Log.d("FTOC converter","Could not convert value " + mFtoc_edittext.getText().toString());
                }

                mFtoc_value_display.setText(String.format(Locale.US, "%.2f",celsius) +"\u00B0C");
            }
        });

        mFtoc_label_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivity.getIntent(getApplicationContext());
                startActivity(intent);
            }
        });

    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, ftoc_Activity.class);
        return intent;
    }
}