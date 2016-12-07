package com.techstar.eventbus30;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.techstar.eventbus30.entity.DataSynEvent;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView mHello_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHello_tv = (TextView) findViewById(R.id.tv_hello);
        EventBus.getDefault().register(this);
    }


    public void onSend(View view){

        String str="发送测试字符串";
        EventBus.getDefault().post(str);
    }

    public void onLikes(View view){

        EventBus.getDefault().post(new DataSynEvent(10));

    }

    public void openTwoActivity(View view){

        startActivity(new Intent(this,TwoActivity.class));
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void helloEventBus(String message){
        mHello_tv.setText(message);

    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void likesEventBus(DataSynEvent event){
        mHello_tv.setText(""+event.count);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
