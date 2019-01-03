package org.yeheng.chatbot;

/**
 * 
 * This class is a data class - it does not define any methods.
 * It declares the definition of a Chatbot Match Pattern.
 * A match pattern consists of a required subject, required predicate, and required object.
 * If one of those clauses is not required to be matched, you should use the regex meta character *;
 * 
 * @author The YeHeng.org Chatbot Project
 *
 */
public abstract class Pattern {
	public String requiredSubject;
	public String requiredPredicate;
	public String requiredObject;
	public MatchType type;
	
	/**
	 * 
	 * @param s Required subject
	 * @param r Required relation (predicate)
	 * @param o Required object
	 * @param t MatchType of this pattern
	 * 
	 * @see MatchType
	 */
	public Pattern(String s, String r, String o, MatchType t) {
		requiredSubject = s;
		requiredPredicate = r;
		requiredObject = o;
		type = t;
	}
	/**
	 * This is an event handler for when the pattern is matched.
	 * 
	 * No hardcoded values are given because the YeHeng.org chatbot is meant to be a library,
	 * and not a ready-to-use chatbot.
	 * 
	 * This is regarded to be an advantage rather than a deficiency because every chatbot should give a
	 * different response considering the context of the conversation.
	 * 
	 * The ChatEngine calls this event handler.
	 * 
	 * @return The response that the custom bot will give.
	 * @see ChatEngine
	 */
	public abstract String onMatch();
	

}
