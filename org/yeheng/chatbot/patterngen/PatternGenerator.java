package org.yeheng.chatbot.patterngen;

import org.yeheng.chatbot.D;

public class PatternGenerator {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: pgen infile outfile [--help] [--verbose]");
			System.exit(-1);
		}
		boolean verbose = false;
		String inFileName = "";
		String outFileName = "";
		for (String arg : args) {
			switch (arg) {
			case "--help":
				System.out.println("pgen is a Pattern Generator for the YeHeng Chatbot Library. It generates serialized patterns for storage for future use in the Chat Engine. ");
				System.out.println();
				System.out.println("Usage: pgen in=infile [out=outfile] [--help] [--verbose]");
				System.out.println();
				System.out.println("Options: ");
				System.out.println("\tinfile \t : input comma separated file");
				System.out.println("\toutfile\t : output file - default=infile.pattern");
				System.out.println("\t--help\t : Prints this help screen");
				System.out.println("\t--verbose: Prints extra info while processing");
				System.out.println();
				System.out.println("For support email chatbot@yeheng.org.");
				break;
			case "--verbose":
				verbose = true;
				break;
			default:
				if (arg.split("=")[0].equals("in")) {
					inFileName = arg.split("=")[1];
				} else if (arg.split("=")[0].equals("out")) {
					outFileName = arg.split("=")[1];
				}
					
			}
		}
		if (inFileName.equals("")) {
			System.out.println("No input file name was provided");
		}
			
		if (outFileName == "")
			outFileName = inFileName + ".pattern";
		if (verbose)
			D.d("Verbose is On.");

	}

}
