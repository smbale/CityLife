package com.example.citylife;



import com.example.citylife.R;
import com.netmera.mobile.NetmeraClient;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SendActivity extends Activity {
	private Button sendNotificationButton;
	private Spinner spinner;
	private EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send);
		
		sendNotificationButton = ( Button )this.findViewById( R.id.buttonSend );
		spinner = (Spinner) findViewById(R.id.spinner1);
		editText = (EditText) findViewById(R.id.editText1);
		
		NetmeraClient.init(this, GlobalVariables.apiKey);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.activities_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		sendNotificationButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				new Thread() {
					public void run() {
					
						String category = (String)spinner.getSelectedItem();
						String message = editText.getText().toString();
						
					};
				}.start();
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_send, menu);
		return true;
	}

}
