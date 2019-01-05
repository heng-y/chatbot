package org.yeheng.chatbot;

/**
 * 
 * This is a generic implementation of SentimentResponse.
 * 
 * When the sentiment is Positive or higher, it prints Great!
 * 
 * If it is negative or lower, it prints I'm sorry to hear that.
 * 
 * If it is neutral, it prints Ok.
 * 
 * 
 * @author The YeHeng.org Chatbot Project
 *
 */
public class GenericSentimentResponse implements SentimentResponse {

	@Override
	public String getReaction(String sentiment) {
		if (sentiment.toLowerCase().contains("positive"))
			return "Great! ";
		else if (sentiment.toLowerCase().contains("negative"))
			return "I'm sorry to hear that. ";
		else
			return "Ok. ";
				
	}

}
