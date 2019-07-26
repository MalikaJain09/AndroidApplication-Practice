//package com.auribises.app4;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.os.Environment;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStreamReader;
//
//public class PersistanceActivity extends AppCompatActivity {
//    EditText eTxtData;
//    Button btnSave;
//
//    String data;
//    SharedPreferences preferences;
//    SharedPreferences.Editor editor;
//    void initViews(){
//
//
//        eTxtData=findViewById(R.id.editTextName);
//        btnSave=findViewById(R.id.buttonSave);
//
//        preferences = getSharedPreferences("appdata",MODE_PRIVATE);
//        editor=preferences.edit();
//
//        btnSave.setOnClickListener(new View.OnClickListener(){
//            public  void onClick(View view){
//                data=eTxtData.getText().toString();
////                saveDataInInternalFile();
//                //saveDataInExternalFile();
//                editor.putString("keyData",data);
//                editor.putInt("keySalary", 30000);
//                editor.apply();
//                Toast.makeText(getApplicationContext(), "datSaved in Shared Preferences", Toast.LENGTH_SHORT).show();
//            }
//        });
//        String fetchData=preferences.getString("keyData","NA");
//        int num = preferences.getInt("keySalary",0);
//        eTxtData.setText(fetchData+" | "+ num);
//    }
//    void saveDataInInternalFile(){
//        try {
//            String path= Environment.getExternalStorageDirectory().getPath();
//            File file = new File(path+"/data.txt");
//            FileOutputStream outputStream = openFileOutput("data.txt",MODE_PRIVATE);
//            outputStream.write(data.getBytes());
//            outputStream.close();
//            Toast.makeText(this, "Data Saved in File", Toast.LENGTH_SHORT).show();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    void saveDataInExternalFile(){
//        try {
//
//            String path= Environment.getExternalStorageDirectory().getPath();
//            File file = new File(path+"/data.txt");
//            FileOutputStream outputStream = new FileOutputStream(file);
//            outputStream.write(data.getBytes());
//            outputStream.close();
//            Toast.makeText(this, "Data Saved in File"+file.getPath(), Toast.LENGTH_SHORT).show();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    void readDataFromInternalFile(){
//        try{
//            FileInputStream inputStream =openFileInput("data.txt");
//            BufferedReader reader =new BufferedReader(new InputStreamReader(inputStream));
//            String line =reader.readLine();
//            eTxtData.setText(line);
//            getSupportActionBar().setTitle(line);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    void readDataFromExternalFile(){
//        try{
//            String path= Environment.getExternalStorageDirectory().getPath();
//            File file = new File(path+"/data.txt");
//            FileInputStream inputStream =new FileInputStream(file);
//            BufferedReader reader =new BufferedReader(new InputStreamReader(inputStream));
//            String line =reader.readLine();
//            eTxtData.setText(line);
//            getSupportActionBar().setTitle(line);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_persistance);
//        initViews();
////        readDataFromInternalFile();
//        //readDataFromExternalFile();
//    }
//}
