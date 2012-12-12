package com.riaspace.c2dm;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class C2DMEnableAutoNotifyFunction implements FREFunction {

	private static final String TAG = "ANE";
	
	public FREObject call(FREContext context, FREObject[] passedArgs) {
		Log.i(TAG, "C2DMEnableAutoNotifyFunction::call()");
		C2DMExtension.autoNotifyEnabled = true;
		return null;
	}

}
