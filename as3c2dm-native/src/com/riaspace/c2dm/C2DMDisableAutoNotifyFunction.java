package com.riaspace.c2dm;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class C2DMDisableAutoNotifyFunction implements FREFunction {

	private static final String TAG = "ANE";
	
	public FREObject call(FREContext context, FREObject[] passedArgs) {
		Log.i(TAG, "C2DMDisableAutoNotifyFunction::call()");
		C2DMExtension.autoNotifyEnabled = false;
		return null;
	}

}
