package org.yeheng.chatbot;

import edu.mit.jwi.Dictionary;
import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

import java.io.File;
import java.util.*;

/**
 * The ChatEngine class is the core of YeHeng.org Chatbot.
 * 
 * This engine works by separating the clauses and matching the clauses with synsets or antsets.
 * It can also match by Includes or ExactMatch which are both simple but lacking usability.
 * 
 * The clause separation is provided by Stanford CoreNLP OpenIE, and the Synsets and Antsets are provided by
 * Princeton WordNet, with the MIT JWI wrapper.
 * 
 * @version 0.1
 * @author The YeHeng.org Chatbot Project
 * @see "Stanford CoreNLP"
 * @see "Princeton WordNet"
 * @see "MIT JWI"
 *
 */
//total-hours-wasted-here=4 (please increment after you try to optimize)
public class ChatEngine {
	StanfordCoreNLP nlpPipeline;
	ArrayList<Pattern> matchPatterns;
	SentimentResponse response;
	Display display;
	Dictionary dict;
	public ChatEngine(Display display) {
		Properties properties = new Properties();
		properties.setProperty("annotators","tokenize,ssplit,pos,parse,lemma,depparse,natlog,openie,sentiment");
		nlpPipeline = new StanfordCoreNLP(properties);
		matchPatterns = new ArrayList<Pattern>();
		this.display = display;
		dict = new Dictionary(new File("/home/heng/WordNet-3.0/dict"));
		response = new DefaultSentimentResponse();
	}
	public void addPattern(Pattern pattern) {
		matchPatterns.add(pattern);
	}
	public void setSentimentResponse(SentimentResponse r) {
		response = r;
	}
	/**
	 * getResponse is the core engine of this library- it converses with the user.
	 * 
	 * @param userInput The input that the user will give
	 * 
	 * 
	 * @see Pattern
	 * @see ChatTriplet
	 * @throws UnImplementedException when a pattern provided's MatchType does not have an implemented handler
	 */
	public void getResponse(String userInput) {
		

		
		//CoreDocument doc = new CoreDocument(userInput); --not-needed-for-now
		Annotation annot = new Annotation(userInput);
		nlpPipeline.annotate(annot);
		
		//Get All Split Results
		
		
		ArrayList< ArrayList<ChatTriplet> > allTripletsBySentence = new ArrayList< ArrayList<ChatTriplet> >();
		D.d(allTripletsBySentence);
		for (CoreMap sentence : annot.get(CoreAnnotations.SentencesAnnotation.class)) {
			String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
			display.display(response.getReaction(sentiment));
			
				Collection<RelationTriple> triples = sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
				ArrayList<ChatTriplet> list = new ArrayList<ChatTriplet>();
				for (RelationTriple triple : triples) {
					list.add(new ChatTriplet(triple.subjectLemmaGloss(),triple.relationLemmaGloss(),triple.objectLemmaGloss()));
					
				}
				allTripletsBySentence.add(list);
		}
		
		//D.d(allTripletsBySentence);
		
		//Remove all subsets of triplets
		
		for (ArrayList<ChatTriplet> sentence : allTripletsBySentence) {
			for (int i = 0; i < sentence.size(); i++) {
				for (int b = 0; b < sentence.size(); b++) {
					if (b == i)
						continue;
					//D.d(b + "/" + i);
					if (sentence.get(b).isSub(sentence.get(i)))
						sentence.get(i).isExtra = true;
					else if (sentence.get(i).isSub(sentence.get(b)))
						sentence.get(b).isExtra = true;
						
				}
			}
		}
		//D.d(allTripletsBySentence);
		
		//Optimize to remove all extra triplets
		
		for (ArrayList<ChatTriplet> sentence : allTripletsBySentence) {
			sentence.removeIf(ct -> ct.isExtra);
		}
		
		//new Java 8 Optimization --
		
		
		
		//Match Patterns
		
	
		for (Pattern pattern : matchPatterns) {
			if (pattern.type == MatchType.BasicInclude) {
				for (ArrayList<ChatTriplet> sentence : allTripletsBySentence) {
					for (ChatTriplet triplet : sentence) {
						if (triplet.isUsed)
							continue;
						if (triplet.subject.matches(pattern.requiredSubject)
								&& triplet.relation.matches(pattern.requiredPredicate) 
								&& triplet.object.matches(pattern.requiredObject)) {
							display.display(pattern.onMatch());
							triplet.isUsed = true;
						}
					}
				}
			}
			else if (pattern.type == MatchType.ExactMatch) {
				//TODO implement
				throw new UnImplementedException();
				
			} else if (pattern.type == MatchType.SynsetMatch) {
				//TODO implement
				throw new UnImplementedException();
			} else if (pattern.type == MatchType.AntMatch) {
				//TODO implement
				throw new UnImplementedException();
			} 
			
		}
		
		
		
		
	
	}
}
