package com.riaspace.c2dm;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class C2DMMessage {

        private String highlightsCount;
		
        private String itemId;
        
        private String itemName;
		
        private String messageType;
		

        public void setHlCount(String n) {
                this.highlightsCount = n;
        }

        public void setItemId(String itemId) {
                this.itemId = itemId;
        }

        public void setItemName(String name) {
                this.itemName = name;
        }

        public void setMessageType(String n) {
            this.messageType = n;
        }

        public FREObject getFREObject() throws FREWrongThreadException,
                IllegalStateException, FRETypeMismatchException, FREInvalidObjectException, FREASErrorException, FRENoSuchNameException, FREReadOnlyException {
                FREObject obj = FREObject.newObject("com.riaspace.c2dm.C2DMMessage", null);

                obj.setProperty("highlightsCount", getValue(highlightsCount));
                obj.setProperty("itemId", getValue(itemId));
                obj.setProperty("itemName", getValue(itemName));
                obj.setProperty("messageType", getValue(messageType));

                return obj;
        }

        private FREObject getValue(String value) throws FREWrongThreadException {
                return FREObject.newObject(value);
        }
}


