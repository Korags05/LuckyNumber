package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView text_View2;
    TextView luckynumber;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text_View2 = findViewById(R.id.text_view2);
        luckynumber = findViewById(R.id.luckynumber);
        btn2 = findViewById(R.id.btn2);

        Intent i = getIntent();
        String UserName = i.getStringExtra("name");

        int number = generator();
        luckynumber.setText(""+number);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(UserName, number);
            }
        });
    }

    public int generator(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumber = random.nextInt(upper_limit);
        return randomNumber;
    }

    public void shareData(String userName, int number){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, userName+" generated a lucky number!!!!");
        i.putExtra(Intent.EXTRA_TEXT, userName+"'s lucky number is: "+number+"\nWhat are you waiting for?"+"\nGenerate your lucky number ASAP!"+"\nInstall the app NOW!");

        startActivity(Intent.createChooser(i, "Choose a platform"));
    }

}