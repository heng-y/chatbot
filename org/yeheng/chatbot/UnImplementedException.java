package org.yeheng.chatbot;

class UnImplementedException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public UnImplementedException() {
		super("The developer has attempted to access an API function of the YeHeng.org Chatbot that is not implemented.");
	}

}
