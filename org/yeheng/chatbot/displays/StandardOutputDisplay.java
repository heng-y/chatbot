package org.yeheng.chatbot.displays;

import org.yeheng.chatbot.Display;

public class StandardOutputDisplay implements Display {

	@Override
	public void display(String what) {
		System.out.println(what);

	}

}
