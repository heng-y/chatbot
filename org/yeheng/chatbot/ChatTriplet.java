package org.yeheng.chatbot;

public class ChatTriplet {
	public String subject;
	public String relation;
	public String object;
	
	public boolean isExtra = false;
	
	public ChatTriplet(String s, String r, String o) {
		subject = s;
		relation = r;
		object = o;
				
	}
	@Override
	public String toString() {
		return subject + "\t" + relation + "\t" + object + " : " + isExtra;
	}
	public boolean isSub(ChatTriplet other) {
		boolean ret = false;
		if (subject.contains(other.subject) && relation.contains(other.relation) && object.contains(other.object))
			ret = true;
		return ret;
	}

}
