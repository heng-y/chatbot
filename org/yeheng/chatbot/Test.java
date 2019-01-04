package org.yeheng.chatbot;

import java.util.Scanner;

import org.yeheng.chatbot.displays.StandardOutputDisplay;

public final class Test{
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Pattern pattern = new TestPattern("Socrates|Plato","be","man|animal",MatchType.BasicInclude);
		ChatEngine bot = new ChatEngine(new StandardOutputDisplay());
		bot.addPattern(pattern);
		bot.setSentimentResponse(new GenericSentimentResponse());
		for (;;) {
			System.out.print("You > ");
			
			String line = s.nextLine();
			
			if (line.equals("exit"))
				break;
			
			//TODO provide method for user to input serialized arraylist of pattern during test session or in argument
			bot.getResponse(line);
					
		}
		s.close();
	 

	}

}
