package com.jet.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class SwitchActivity extends AppCompatActivity {
    private LinearLayout ll = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        ll = (LinearLayout) findViewById(R.id.ll);
        int count = ll.getChildCount();
        for(int i =0;i<count;i++){
            final int index = i;
            ll.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SwitchActivity.this,TestActivity.class);
                    intent.putExtra("index",index);
                    startActivity(intent);
                }
            });
        }
    }
}
