package org.yeheng.chatbot;

public class GenericSentimentResponse implements SentimentResponse {

	@Override
	public String getReaction(String sentiment) {
		if (sentiment.toLowerCase().contains("positive"))
			return "Great! ";
		else
			return "I'm sorry to hear that. ";
				
	}

}
