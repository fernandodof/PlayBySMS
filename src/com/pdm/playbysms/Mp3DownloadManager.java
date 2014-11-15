package com.pdm.playbysms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class Mp3DownloadManager {
	private final Context context;
	
	public Mp3DownloadManager(Context context){
		this.context = context;
	}
	
	@SuppressLint("ShowToast")
	public void download(SmsMessage message){
		if("88888888".equals(message.getOriginatingAddress()) &&
				"CODE-001".equals(message.getMessageBody())){
			Log.i("Degug", "Executar o download");
			MainActivity mainActivity = (MainActivity) context;
			ExecuteDownload executeDownload = new ExecuteDownload(context, "http://10f.b.sscdn.co/f/c/2/1/espectromusic-pharrell-williams-happy-myfreemp3eu-6111b6.mp3");
			executeDownload.execute(new String[]{"test"});
		}else{
			Toast.makeText(context,"Invasion Alert", Toast.LENGTH_LONG).show();
		}
	}
}
