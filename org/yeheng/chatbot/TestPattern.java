package org.yeheng.chatbot;

final class TestPattern extends Pattern {

	public TestPattern(String s, String r, String o, MatchType t) {
		super(s, r, o, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String onMatch() {
		return "hi";
	}

}
