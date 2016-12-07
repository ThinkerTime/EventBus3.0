package com.techstar.eventbus30;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.techstar.eventbus30.entity.DataSynEvent;

import de.greenrobot.event.EventBus;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }


    public void onSendMain(View view){
        EventBus.getDefault().post(new DataSynEvent(10));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
