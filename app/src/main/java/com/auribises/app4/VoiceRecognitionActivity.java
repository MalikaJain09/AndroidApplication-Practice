package com.auribises.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VoiceRecognitionActivity extends AppCompatActivity implements RecognitionListener {
    TextView txtVoiceData;
    Button btnSpeak;
    SpeechRecognizer speechRecognizer;
    TextToSpeech tts;
    boolean isTtsOk=true;
    void initViews(){
        txtVoiceData=findViewById(R.id.textViewData);
        btnSpeak=findViewById(R.id.buttonSpeak);

        speechRecognizer= SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(this);
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i!= TextToSpeech.SUCCESS){
                    isTtsOk=false;
                    Toast.makeText(VoiceRecognitionActivity.this, "Please Enable Text To Speech Settings", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){

                Intent intent = RecognizerIntent.getVoiceDetailsIntent(VoiceRecognitionActivity.this);
                speechRecognizer.startListening(intent);
            }});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_recognition);
        initViews();
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int i) {

    }

    @Override
    public void onResults(Bundle bundle) {
        ArrayList<String> data=bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if(data!=null && data.size()>0){
            String text =data.get(0);
            txtVoiceData.setText(text);
            if(text.toLowerCase().contains("hello")){
                String response=" Hello ! Its Good To hear From You !";
                if(isTtsOk==true){
                    tts.speak(response,TextToSpeech.QUEUE_FLUSH,null,null);
                }

            }
        }
        else {
            txtVoiceData.setText("Please Speak Again!!");
        }

    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }
}
