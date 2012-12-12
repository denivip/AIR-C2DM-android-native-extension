package com.riaspace.c2dm;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class C2DMGetMessageFunction implements FREFunction {

	private static final String TAG = "ANE";
	
	public FREObject call(FREContext context, FREObject[] passedArgs) {
		Log.i(TAG, "C2DMGetMessageFunction::call()");
		FREObject result = null;
		C2DMExtensionContext cec = (C2DMExtensionContext)context;
		try {
			result = cec.message.getFREObject();
		} catch (Exception e) {
			Log.e(TAG, "C2DMGetMessageFunction::call() "+e.getMessage());
		}
        return result;
	}

}
