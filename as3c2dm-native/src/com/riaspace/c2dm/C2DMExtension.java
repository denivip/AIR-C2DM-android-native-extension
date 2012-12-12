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

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class C2DMExtension implements FREExtension {

	public static FREContext context;
	
	public static Boolean autoNotifyEnabled = false;
	
	public FREContext createContext(String extId) {
		Log.d("as3c2dm", "C2DMExtension.createContext extId: " + extId);
		return context = new C2DMExtensionContext();
	}

	public void dispose() {
		Log.d("as3c2dm", "C2DMExtension.dispose");
		context = null;
	}

	public void initialize() {
		Log.d("as3c2dm", "C2DMExtension.initialize");
	}
}
