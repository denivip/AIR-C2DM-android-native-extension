//////////////////////////////////////////////////////////////////////////////////////
//
//	Copyright 2011 Piotr Walczyszyn (http://riaspace.com | @pwalczyszyn)
//	
//	Licensed under the Apache License, Version 2.0 (the "License");
//	you may not use this file except in compliance with the License.
//	You may obtain a copy of the License at
//	
//		http://www.apache.org/licenses/LICENSE-2.0
//	
//	Unless required by applicable law or agreed to in writing, software
//	distributed under the License is distributed on an "AS IS" BASIS,
//	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//	See the License for the specific language governing permissions and
//	limitations under the License.
//	
//////////////////////////////////////////////////////////////////////////////////////

package com.riaspace.c2dm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREContext;

public class C2DMBroadcastReceiver extends BroadcastReceiver {

	public C2DMBroadcastReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(
				"com.google.android.c2dm.intent.REGISTRATION")) {
			handleRegistration(context, intent);
		} else if (intent.getAction().equals(
				"com.google.android.c2dm.intent.RECEIVE")) {
			handleMessage(context, intent);
		}
	}

	private void handleRegistration(Context context, Intent intent) {
		FREContext freContext = C2DMExtension.context;
		String registration = intent.getStringExtra("registration_id");

		if (intent.getStringExtra("error") != null) {
			String error = intent.getStringExtra("error");
			Log.d("as3c2dm", "Registration failed with error: " + error);
			if (freContext != null) {
				freContext.dispatchStatusEventAsync(error, "error");
			}
		} else if (intent.getStringExtra("unregistered") != null) {
			Log.d("as3c2dm", "Unregistered successfully");
			if (freContext != null) {
				freContext.dispatchStatusEventAsync("unregistered", "unregistered");
			}
		} else if (registration != null) {
			Log.d("as3c2dm", "Registered successfully");
			if (freContext != null) {
				freContext.dispatchStatusEventAsync(registration, "registered");
			}
		}
	}

	private void handleMessage(Context context, Intent intent) {
		try {
			if (C2DMExtension.autoNotifyEnabled){
				C2DMNotifySender.showNotify(context, intent.getStringExtra("tickerText"), intent.getStringExtra("contentTitle"), intent.getStringExtra("contentText"), intent.getStringExtra("parameters"));
			}
			
			FREContext freContext = C2DMExtension.context;
			C2DMExtensionContext cec = (C2DMExtensionContext)freContext;
			
			String hlCount = intent.getStringExtra("highlightsCount");
			String itemId = intent.getStringExtra("itemId");
			String itemName = intent.getStringExtra("itemName");
			String messageType = intent.getStringExtra("messageType");
			
			cec.message.setHlCount(hlCount);
			cec.message.setItemId(itemId);
			cec.message.setItemName(itemName);
			cec.message.setMessageType(messageType);
			
			freContext.dispatchStatusEventAsync("message", "message");
			
		} catch (Exception e) {
			Log.e("as3c2dm", "Error activating application:", e);
		}
	}
}