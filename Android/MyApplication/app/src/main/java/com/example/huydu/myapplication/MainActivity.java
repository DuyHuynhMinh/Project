package com.example.huydu.myapplication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    MqttAndroidClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String clientId = MqttClient.generateClientId();
      client =  new MqttAndroidClient(this.getApplicationContext(), "tcp://"+Config.IP+":"+Config.PORT,
                        clientId);
        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                }
                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    boolean statuesRoom1 = true;
    boolean statuesRoom2 = true;

    public void controlRoom1(View view) {
        Button bt = (Button) findViewById(R.id.R1);
        String mess =null;
        if(statuesRoom1) {
            mess="LED 1 OFF";
        } else {
            mess="LED 1 ON";
        }
        turnLedOnOff(bt,statuesRoom1,mess);
        statuesRoom1=!statuesRoom1;
    }

    public void controlRoom2(View view) {
        Button bt = (Button) findViewById(R.id.R2);
        String mess =null;
        if(statuesRoom2) {
            mess="LED 2 OFF";
        } else {
            mess="LED 2 ON";
        }
        turnLedOnOff(bt,statuesRoom2,mess);
        statuesRoom2=!statuesRoom2;
    }

    public void turnLedOnOff(Button bt , boolean status, String mess) {
        if(status) {
            bt.setBackgroundResource(android.R.drawable.btn_default);
            bt.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        } else {
            bt.setBackgroundResource(android.R.drawable.btn_default);
            bt.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        }
        try {
            byte[] encodedMessage = mess.getBytes("UTF-8");
            MqttMessage message = new MqttMessage(encodedMessage);
            client.publish(Config.TOPIC, message);
        } catch (UnsupportedEncodingException | MqttException e) {
            e.printStackTrace();
        }

    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
