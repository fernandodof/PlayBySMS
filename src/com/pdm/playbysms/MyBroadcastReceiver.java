package com.pdm.playbysms;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
//		Bundle bundle = intent.getExtras();
//		Object[] smsbytes = (Object[]) bundle.get("pdus");
//		for (Object raw : smsbytes) {
//			SmsMessage msg = SmsMessage.createFromPdu((byte[]) raw);
//			Log.i("SMS:" + msg.getOriginatingAddress(), msg.getMessageBody());
//		}
		Mp3DownloadManager downloadManager = new Mp3DownloadManager(context);	
		String number = null;
		String message = null;
		Bundle bundle = intent.getExtras();
		Object[] smsbytes = (Object[])bundle.get("pdus");
		for (  Object raw : smsbytes) {
		  SmsMessage msg =SmsMessage.createFromPdu((byte[])raw);
		  number = msg.getOriginatingAddress();
		  message  = msg.getMessageBody();
		  Log.i("Degug", "Number: " + number + "Message: " + message);
		  downloadManager.download(msg);
		}	
		
		final String messageFull =  "Number: " + number + "Message: " + message;
		
		  final MainActivity mainActivity = (MainActivity) context;
		  mainActivity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					mainActivity.setMessage(messageFull);
				}
			});
		  
	}

}
