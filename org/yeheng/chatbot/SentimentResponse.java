package org.yeheng.chatbot;

/**
 *
 * This interface encapsulates a response to a sentiment.
 * 
 * 
 * @author The YeHeng.org Chatbot Project
 *
 */
public interface SentimentResponse {
	/**
	 * 
	 * This method is called when the ChatEngine gets a sentiment level, in float.
	 * 
	 * The ChatEngine sends the response from this method to the Display.
	 * 
	 * @param sentiment the sentiment level, provided by Stanford CoreNLP: they can be Positive, Very positive, Very negative, or Negative
	 * @return the reaction
	 */
	public String getReaction(String sentiment);

}
