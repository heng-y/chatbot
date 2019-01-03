package org.yeheng.chatbot;

/**
 * 
 * Display is an interface to something that displays.
 * 
 * A generic display function is <strong>not</strong> included in the ChatEngine because
 * every chatbot needs to display information in a different way. For example, a servlet
 * might send the data to the HTTP response while a console app might send it to standard output.
 * 
 * @author The YeHeng.org Chatbot Project
 *
 */
public interface Display {
	/**
	 * Displays something
	 * @param what to display
	 */
	public void display(String what);

}
