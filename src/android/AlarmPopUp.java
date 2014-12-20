package com.kk.alarmplugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

public class AlarmPopUp extends Activity {
	// An ID of the alarm dialog
	private static final int DIALOG_ALARM = 0;

	// The alarm ID
	private int m_alarmId;
	private String time = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get the alarm ID from the intent extra data
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		if (extras != null) {
			m_alarmId = extras.getInt("AlarmID", -1);
			time = extras.getString("AlarmTime");
		} else {
			m_alarmId = -1;
		}

		// Show the popup dialog
		showDialog(DIALOG_ALARM);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		super.onCreateDialog(id);
		System.out.println("==================Inside POPUP dialog==============");
		Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
		final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
		r.play();
	 
		// Build the dialog
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Alarm Received!!!");
		alert.setMessage("Its time for the alarm with ID: " + m_alarmId+"\n\n Time :: "+time);
		alert.setCancelable(false);

		alert.setPositiveButton("Dismiss",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					//	 mp.release();
						r.stop();
						AlarmPopUp.this.finish();
					}
				});

		// Create and return the dialog
		AlertDialog dlg = alert.create();

		return dlg;
	}
}
