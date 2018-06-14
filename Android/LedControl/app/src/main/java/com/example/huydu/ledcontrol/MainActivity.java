package com.example.huydu.ledcontrol;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;


public class MainActivity extends Activity {

    private MqttAndroidClient client;
    private LedStatus ledStatus;
    private long message;
    private byte []deliveriedMessage;
    boolean []ledStat = new boolean[129];
    private int pressedButton;
    private String []receivedMessage = new String[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String ip =intent.getStringExtra("IP");

        String clientId = MqttClient.generateClientId();
        client =  new MqttAndroidClient(this.getApplicationContext(), "tcp://"+ip+":"+ConfigConnect.PORT,
                clientId);
        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    subscribeTopic();
                }
                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                }
            });

        } catch (MqttException e) {
            e.printStackTrace();
        }

    }


    public void controlRoom1(View view) {
        Button bt = findViewById(R.id.R17);
        pressedButton = 1;
        turnLedOnOff(bt,pressedButton);
    }

    public void controlRoom2(View view) {
       Button bt =  findViewById(R.id.R18);
        pressedButton = 2;
        turnLedOnOff(bt,pressedButton);
    }

    public void turnLedOnOff(Button bt , int pressedButton) {

        String s = "LED_"+pressedButton+"_";
        if(ledStat[pressedButton]) {
           s+="OFF";
        } else {
            s+="ON";
        }
        ledStatus=LedStatus.valueOf(s);

        if(ledStat[pressedButton]) {
            bt.setBackgroundResource(android.R.drawable.btn_default);
            bt.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        } else {
            bt.setBackgroundResource(android.R.drawable.btn_default);
            bt.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        }

       try {
            message=ledStatus.getValue();
            deliveriedMessage = covertLongToByte(message);
            MqttMessage message = new MqttMessage(deliveriedMessage);
            client.publish(ConfigConnect.TOPIC, message);

        } catch (MqttPersistenceException e) {
           e.printStackTrace();
       } catch (MqttException e) {
           e.printStackTrace();
       }
        ledStat[pressedButton] = !ledStat[pressedButton];

    }


    public String subscribeTopic() {
        String topic = ConfigConnect.TOPIC;
        int qos = 1;

        if (client.isConnected()) {

            try {
                client.subscribe(topic, qos);

            } catch (MqttException e1) {
                e1.printStackTrace();
            }
            client.setCallback(new MqttCallback() {

                @Override
                public void connectionLost(Throwable cause) {
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    receivedMessage[0] = (new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });
        }
            return receivedMessage[0];
        }

        public byte[] covertLongToByte(long mess ) {
            byte[] result = new byte[8];
            result[0] = (byte)(mess);
            mess>>>=8;
            result[1] = (byte)(mess);
            mess>>>=8;
            result[2] = (byte)(mess);
            mess>>>=8;
            result[3] = (byte)(mess);
            mess>>>=8;
            result[4] = (byte)(mess);
            mess>>>=8;
            result[5] = (byte)(mess);
            mess>>>=8;
            result[6] = (byte)(mess);
            mess>>>=8;
            result[7] = (byte)(mess);
            return result;
        }

}
