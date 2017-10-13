package com.example.pascual.texttospeech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityHomePage extends AppCompatActivity
{
    Button bstart;
    Button bHelp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page);

        bHelp = (Button) findViewById(R.id.bHelp);

        bHelp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent neo = new Intent(MainActivityHomePage.this, HelpPage.class);
                startActivity(neo);
            }
        });

        bstart = (Button)findViewById(R.id.bstart);

        bstart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent neo = new Intent(MainActivityHomePage.this, GesturePage.class);
                startActivity(neo);

            }
        });
    }
    public void clickexit(View view)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}
