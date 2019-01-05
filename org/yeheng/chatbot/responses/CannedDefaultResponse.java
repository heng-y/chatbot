package org.yeheng.chatbot.responses;

import org.yeheng.chatbot.DefaultResponse;

/**
 * 
 * A canned default response.
 * 
 * 
 * @author The YeHeng.org Chatbot Project
 * 
 *
 */

public class CannedDefaultResponse implements DefaultResponse {

	@Override
	public String getDefaultResponse() {
		return "I don't think I could help you with that.";
	}

}
