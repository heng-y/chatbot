package org.yeheng.chatbot.displays;

import org.yeheng.chatbot.Display;

/**
 * 
 * StandardOutputDisplay is a Display that sends its output to the Standard Output, followed
 * by a newline.
 * 
 * This is useful when you just want a generic display, since the class Display does not provide a
 * default implementation.
 * 
 * @author The YeHeng.org Chatbot Project
 *
 */
public class StandardOutputDisplay implements Display {

	@Override
	public void display(String what) {
		System.out.println(what);

	}

}
