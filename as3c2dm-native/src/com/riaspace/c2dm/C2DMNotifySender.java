package com.riaspace.c2dm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class C2DMNotifySender {
	
//	private static int notifyCount = 0; 
	
	public static void showNotify(Context context, String tickerText, String contentTitle, String contentText, String args)
	{
		try
		{
			Intent notificationIntent = new Intent(context, 
					Class.forName(context.getPackageName() + ".AppEntry"));
			NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
			
			long when = System.currentTimeMillis();
	
			int icon = context.getApplicationInfo().icon;
			notificationIntent.setData(Uri.parse(args));
	
			PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
					notificationIntent, 0);
	
			Notification notification = new Notification();
			notification.iconLevel = 1;
			notification.icon = icon;
			notification.tickerText = tickerText;
			notification.when = when;
			notification.flags |= Notification.FLAG_AUTO_CANCEL;
			notification.defaults = Notification.DEFAULT_ALL;
			notification.setLatestEventInfo(context, contentTitle, contentText,
					contentIntent);
	
			nm.notify(0, notification);
		} catch (Exception e) {
			Log.e("as3c2dm", "Error showing notify:", e);
		}
	}
		
}
