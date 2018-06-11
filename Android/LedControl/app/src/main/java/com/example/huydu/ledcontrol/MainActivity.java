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

import java.io.UnsupportedEncodingException;


public class MainActivity extends Activity {
    MqttAndroidClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String ip =intent.getStringExtra("IP");

        String clientId = MqttClient.generateClientId();
       client =  new MqttAndroidClient(this.getApplicationContext(), "tcp://"+ip+":1883",
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
        Button bt = (Button) findViewById(R.id.R17);
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
        String mess =subscribeTopic();

       Button bt = (Button) findViewById(R.id.R18);
       /*if(statuesRoom2) {
            mess="LED 2 OFF";
        } else {
            mess="LED 2 ON";
        }*/
       if(mess==null) {
            mess="LED 2 OFF";
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
           //byte[] encodedMessage  =new byte[1];
          // encodedMessage[0] =65;

            MqttMessage message = new MqttMessage(encodedMessage);
            client.publish("sensor", message);

        } catch (MqttPersistenceException e) {
           e.printStackTrace();
       } catch (MqttException e) {
           e.printStackTrace();
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }

    }


    public String subscribeTopic() {
        String topic = "sensor";
        final String[] mess = new String[1];
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
                    System.out.println("Herererer");
                    mess[0] = (new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });
        }
            return mess[0];
        }

}
