package com.wong.databaseoptimize;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;

    private TextView textView2;
    private MyDao myDao;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int i = msg.what;
            switch (i){
                case 1:
                    textView1.setText((String)msg.obj);

                    break;
                case 2:
                    textView2.setText((String)msg.obj);

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);

        myDao = new MyDao(MainActivity.this);

        insertTable1();
        insertTable2();


    }
    public void insertTable1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long sTime = SystemClock.uptimeMillis();

                myDao.insertTable1(1,"John","school1",5);

                long endTime = SystemClock.uptimeMillis() - sTime;
                Message message = handler.obtainMessage();
                message.what = 1;
                message.obj = "没有加autoincrement的耗时："+endTime;
                handler.sendMessage(message);





            }
        }).start();
    }

    public void insertTable2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long sTime2 = SystemClock.uptimeMillis();

                myDao.insertTable2("Tom","school2",6);

                long endTime2 = SystemClock.uptimeMillis() - sTime2;
                Message message2 = handler.obtainMessage();
                message2.what = 2;
                message2.obj = "加autoincrement的耗时："+endTime2;
                handler.sendMessage(message2);

            }
        }).start();

    }
}
