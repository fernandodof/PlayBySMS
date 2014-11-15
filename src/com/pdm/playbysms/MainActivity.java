package com.pdm.playbysms;

import android.support.v7.app.ActionBarActivity;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	MyBroadcastReceiver receiver = new MyBroadcastReceiver();
	TextView messageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		setContentView(layout);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setGravity(Gravity.CENTER);
		//
		TextView textView = new TextView(this);
		textView.setTextSize(30);
		textView.setText("MainActivity has started!");
		layout.addView(textView);
		//
		messageView = new TextView(this);
		messageView.setTypeface(Typeface.DEFAULT_BOLD);
		layout.addView(messageView);
		
		registerReceiver(receiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
	}

	public void setMessage(String message){
		messageView.setText(message);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
