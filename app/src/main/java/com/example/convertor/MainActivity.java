package com.example.convertor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.convertor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private double value, finalresult;
    private String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount = binding.amountET.getText().toString();
                if (amount.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter an Amount", Toast.LENGTH_LONG).show();
                } else {
                    if (binding.dollartotaka.isChecked()) {
                        value = Double.valueOf(amount);
                        finalresult = value * 80;
                        binding.resultET.setText(String.valueOf(finalresult)+"Tk");


                    } else if (binding.takatodollar.isChecked()) {
                        value = Double.valueOf(amount);
                        finalresult = value / 80;
                        binding.resultET.setText(String.valueOf(finalresult)+"Dollar");


                    }
                }


            }
        });
    }

}
