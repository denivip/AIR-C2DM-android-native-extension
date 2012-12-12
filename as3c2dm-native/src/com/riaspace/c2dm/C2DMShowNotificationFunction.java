package com.riaspace.c2dm;

import android.content.Context;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class C2DMShowNotificationFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		Log.d("as3c2dm", "C2DMShowNotificationFunction.call");
		try {
			Context appContext = context.getActivity().getApplicationContext();
			C2DMNotifySender.showNotify(appContext, args[0].getAsString(), args[1].getAsString(),args[2].getAsString(), args[3].getAsString());
		} catch (Exception e) {
			Log.e("as3c2dm", "Error showing notification.", e);
		}
		return null;
	}

}
