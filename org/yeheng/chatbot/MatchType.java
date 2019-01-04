package org.yeheng.chatbot;

/**
 * 
 * This enum defines the types of matches that are possible with the YeHeng.org Chatbot. 
 * All types are Case Insensitive.
 * In Version 0.1 of the YeHeng.org Chatbot, <b>Only BasicInclude is implemented.</b>
 * 
 * @author The YeHeng.org Chatbot Project
 *
 */
public enum MatchType {
	/**
	 * BasicInclude defines a type where if the user inputs a string and the pattern is a substring
	 * it matches.
	 */
	BasicInclude,
	/**
	 * ExactMatch matches only exact but case insensitive user inputs.
	 */
	ExactMatch,
	/**
	 * SynsetMatch instructs the ChatEngine to use the Princeton Wordnet to check for Synsets, then do an include check.
	 */
	SynsetMatch,
	/**
	 * Same as SynsetMatch except with antonyms.
	 * 
	 */
	AntMatch,

}
