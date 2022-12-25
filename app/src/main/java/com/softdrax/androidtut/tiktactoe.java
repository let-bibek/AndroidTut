package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tiktactoe extends AppCompatActivity {
    Button ttcBtn1, ttcBtn2, ttcBtn3, ttcBtn4, ttcBtn5, ttcBtn6, ttcBtn7, ttcBtn8, ttcBtn9;
    String btnVAl1, btnVAl2, btnVAl3, btnVAl4, btnVAl5, btnVAl6, btnVAl7, btnVAl8, btnVAl9;
    Button btnTttReset;
    int flag = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiktactoe);
        init();


    }

    private void init() {
        ttcBtn1 = findViewById(R.id.tttBtn1);
        ttcBtn2 = findViewById(R.id.tttBtn2);
        ttcBtn3 = findViewById(R.id.tttBtn3);
        ttcBtn4 = findViewById(R.id.tttBtn4);
        ttcBtn5 = findViewById(R.id.tttBtn5);
        ttcBtn6 = findViewById(R.id.tttBtn6);
        ttcBtn7 = findViewById(R.id.tttBtn7);
        ttcBtn8 = findViewById(R.id.tttBtn8);
        ttcBtn9 = findViewById(R.id.tttBtn9);
    }

    public void check(View view) {
        Button btnCurrent = (Button) view;
        if(btnCurrent.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                btnCurrent.setText("o");
                flag = 1;
            } else {
                btnCurrent.setText("x");
                flag = 0;
            }

            if (count > 4) {
                btnVAl1 = ttcBtn1.getText().toString();
                btnVAl2 = ttcBtn2.getText().toString();
                btnVAl3 = ttcBtn3.getText().toString();
                btnVAl3 = ttcBtn3.getText().toString();
                btnVAl4 = ttcBtn4.getText().toString();
                btnVAl5 = ttcBtn5.getText().toString();
                btnVAl6 = ttcBtn6.getText().toString();
                btnVAl7 = ttcBtn7.getText().toString();
                btnVAl8 = ttcBtn8.getText().toString();
                btnVAl9 = ttcBtn9.getText().toString();


                if (btnVAl1.equals(btnVAl2) && btnVAl2.equals(btnVAl3) && !btnVAl1.equals("")) {
                    Toast.makeText(this, "Winner is: " + btnVAl1, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;
                } else if (btnVAl1.equals(btnVAl5) && btnVAl5.equals(btnVAl9) && !btnVAl1.equals("")) {
                    Toast.makeText(this, "Winner is: " + btnVAl1, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;

                } else if (btnVAl1.equals(btnVAl4) && btnVAl4.equals(btnVAl7) && !btnVAl1.equals("")) {
                    Toast.makeText(this, "Winner is: " + btnVAl1, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;

                } else if (btnVAl7.equals(btnVAl8) && btnVAl8.equals(btnVAl9) && !btnVAl7.equals("")) {
                    Toast.makeText(this, "Winner is: " + btnVAl7, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;

                } else if (btnVAl3.equals(btnVAl5) && btnVAl5.equals(btnVAl7) && !btnVAl3.equals("")) {
                    Toast.makeText(this, "Winner is: " + btnVAl3, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;

                } else if (btnVAl4.equals(btnVAl5) && btnVAl5.equals(btnVAl6) && !btnVAl4.equals("")) {
                    Toast.makeText(this, "Winner is: " + btnVAl4, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;

                } else if (btnVAl3.equals(btnVAl6) && btnVAl6.equals(btnVAl9) && !btnVAl3.equals("")) {
                    Toast.makeText(this, "Winner is: " + btnVAl3, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;

                } else if (btnVAl2.equals(btnVAl5) && btnVAl5.equals(btnVAl8) && !btnVAl3.equals("")) {
                    Toast.makeText(this, "Winner is: " + btnVAl3, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;

                }
                else if(count==9){
                    Toast.makeText(this, "It's a draw" + btnVAl3, Toast.LENGTH_SHORT).show();
                    ttcBtn1.setText("");
                    ttcBtn2.setText("");
                    ttcBtn3.setText("");
                    ttcBtn4.setText("");
                    ttcBtn5.setText("");
                    ttcBtn6.setText("");
                    ttcBtn7.setText("");
                    ttcBtn8.setText("");
                    ttcBtn9.setText("");
                    count=0;
                    flag=0;
                }

            }
        }

//        reset
        btnTttReset=findViewById(R.id.btnResetTtt);
        btnTttReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ttcBtn1.setText("");
                ttcBtn2.setText("");
                ttcBtn3.setText("");
                ttcBtn4.setText("");
                ttcBtn5.setText("");
                ttcBtn6.setText("");
                ttcBtn7.setText("");
                ttcBtn8.setText("");
                ttcBtn9.setText("");
                count=0;
                flag=0;
            }
        });
    }
}