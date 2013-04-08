package com.example.citylife;




import java.util.ArrayList;
import java.util.List;

import com.example.citylife.R;
import com.netmera.mobile.NetmeraClient;
import com.netmera.mobile.NetmeraException;
import com.netmera.mobile.NetmeraGeoLocation;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity {
	private Button sendButton, registerButton;
	private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NetmeraClient.init(this, GlobalVariables.apiKey);
		
		sendButton = ( Button ) this.findViewById( R.id.buttonSendActivity );
		registerButton = ( Button ) findViewById( R.id.buttonRegister );
		checkBox1= (CheckBox) findViewById(R.id.checkBox1);
		checkBox2= (CheckBox) findViewById(R.id.checkBox2);
		checkBox3= (CheckBox) findViewById(R.id.checkBox3);
		checkBox4= (CheckBox) findViewById(R.id.checkBox4);
		checkBox5= (CheckBox) findViewById(R.id.checkBox5);
		checkBox6= (CheckBox) findViewById(R.id.checkBox6);
		
		
		
		registerButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				List<String> deviceGroups = new ArrayList<String>();
				if(checkBox1.isChecked()){
					deviceGroups.add((String)checkBox1.getText());
				}
				if(checkBox2.isChecked()){
					deviceGroups.add((String)checkBox2.getText());
				}
				if(checkBox3.isChecked()){
					deviceGroups.add((String)checkBox3.getText());
				}
				if(checkBox4.isChecked()){
					deviceGroups.add((String)checkBox4.getText());
				}
				if(checkBox5.isChecked()){
					deviceGroups.add((String)checkBox5.getText());
				}
				if(checkBox6.isChecked()){
					deviceGroups.add((String)checkBox6.getText());
				}
				
				try {
					NetmeraGeoLocation kosmosLocation = new NetmeraGeoLocation(52.517154,13.449958);
				} catch (NetmeraException e) {
					e.printStackTrace();
				}
			}
		});
		sendButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SendActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
