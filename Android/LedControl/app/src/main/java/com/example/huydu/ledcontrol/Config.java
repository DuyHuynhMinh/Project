package com.example.huydu.ledcontrol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Config extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void connect(View v) {
        EditText ip = (EditText) findViewById(R.id.ip);
        String ipAddress = ip.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("IP", ipAddress);
        startActivity(intent);
    }

}
