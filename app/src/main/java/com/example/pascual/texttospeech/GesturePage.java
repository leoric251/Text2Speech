package com.example.pascual.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class GesturePage extends AppCompatActivity
{
    TextToSpeech toSpeech;
    int result;
    EditText editText;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_page);

        editText=(EditText) findViewById(R.id.editText);
        toSpeech=new TextToSpeech(GesturePage.this, new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int status)
            {
                if (status==TextToSpeech.SUCCESS)
                {
                    result=toSpeech.setLanguage(Locale.UK);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not Supported.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void TTS (View view)
    {
        switch (view.getId())
        {
            case R.id.bSpeak:
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(getApplicationContext(),"Feature not Supported.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    text = editText.getText().toString();
                    toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
            case R.id.bStop:
                if (toSpeech!=null)
                {
                    toSpeech.stop();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (toSpeech !=null)
        {
            toSpeech.stop();
            toSpeech.shutdown();
        }
    }
}
