package com.riaspace.c2dm.events
{
	import flash.events.Event;
	
	public class C2DMMessageEvent extends Event
	{
		public static const MESSAGE:String = "message";
		
		public function C2DMMessageEvent(bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(MESSAGE, bubbles, cancelable);
		}
		
		override public function clone():Event
		{
			return new C2DMMessageEvent(bubbles, cancelable);
		}
	}
}