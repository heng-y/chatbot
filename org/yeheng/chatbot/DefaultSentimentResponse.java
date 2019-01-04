package org.yeheng.chatbot;


/**
 * 
 * DefaultSentimentResponse is the simplest SentimentResponse.
 * It is the type created by the constructor of ChatEngine.
 * Use of this is not recommended, but when you don't want the bot to determine sentiment, use
 * of this class is ideal.
 * 
 * @author The YeHeng.org Chatbot Project
 *
 */
public class DefaultSentimentResponse implements SentimentResponse {

	@Override
	public String getReaction(String sentiment) {
		return "";
	}

}
