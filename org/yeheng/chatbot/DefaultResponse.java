/**
 * 
 */
package org.yeheng.chatbot;

/**
 * 
 * This interface encapuslates a response that the chatbot will give if none
 * of the Pattern's are matched.
 * 
 * This is called by ChatEngine and then is sent to the Display.
 * 
 * @author The YeHeng.org Chatbot Project
 *
 */
public interface DefaultResponse {
	public String getDefaultResponse();

}
