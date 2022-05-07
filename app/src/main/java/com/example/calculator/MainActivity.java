package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private String btnText = "";
    private String calc = "";
    private float num1;
    private float num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txtView);
    }

    public void btnclicked(View actionView)
    {
        Button btn = (Button) actionView;
        String text = btn.getText().toString();
        if(text.equals("C"))
        {
            txt.setText("");
            btnText = "";
            calc = "";
        }
        else if(text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/"))
        {
            if(btnText.length() == 0)
            {
                txt.setText("");
            }
            else{
                num1 = Float.parseFloat(btnText);
                btnText = "";
                calc = text;
            }
        }
        else if(text.equals("="))
        {
            if(btnText.length() == 0)
            {
                txt.setText("");
            }
            else
            {
                Float result = 0f;
                num2 = Float.parseFloat(btnText);
                switch (calc)
                {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": if(num2!=0)
                    {
                        result = num1/num2;
                    }
                    else
                    {
                        result = 0f;
                    }; break;
                }
                txt.setText(String.valueOf(result));
                calc = "";
            }
        }
        else
        {
            btnText += text;
            int num = Integer.parseInt(btnText);
            btnText = String.valueOf(num);
            txt.setText(btnText);
        }
    }
}