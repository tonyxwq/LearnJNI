package com.rx.learnjni;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity
{

    TextView textView;

    static
    {

        System.loadLibrary("jnitext");
    }

    public native String helloJni();

    public native String openFile();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        //textView.setText(openFile());
        textView.setText(loadFromSDFile("demo.txt"));
    }

    private String loadFromSDFile(String fname)
    {
        fname = "/" + fname;
        String result = null;
        try
        {
            File f = new File(Environment.getExternalStorageDirectory().getPath() + fname);
            Log.d("mmp",f.getAbsolutePath());
            int length = (int) f.length();
            byte[] buff = new byte[length];
            FileInputStream fin = new FileInputStream(f);
            fin.read(buff);
            fin.close();
            result = new String(buff, "UTF-8");
        } catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "没有找到指定文件", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

}
