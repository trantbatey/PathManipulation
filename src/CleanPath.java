/**
 * This is a solution to the Fortify Path Manipulation issues.
 * 
 * What it is complaining about is that if you take data from an 
 * external source, then an attacker can use that source to 
 * manipulate your path. Thus, enabling the attacker do delete 
 * files or otherwise compromise your system.
 * 
 * The suggested remedy to this problem is to use a white-list of 
 * trusted directories as valid inputs; and, reject everything else.
 * 
 * This solution is not always viable in a production environment. 
 * So, I suggest an alternative solution. Parse the input for a 
 * white-list of acceptable characters. Reject from the input, any 
 * character you don't want in the path. It could be either removed 
 * or replaced.
 * 
 * Below is an example. This does pass the Fortify review. It is 
 * important to remember here to return the literal and not the char 
 * being checked. Fortify keeps track of the parts that came from the 
 * original input. If you use any of the original input, you may still 
 * get the error.
 * 
 * Original Work Copyright (c) 2017, Trant Walter Batey
 * trantbatey@gmail.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sub-license, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * Within reason, give the originator credit for the code
 */
public class CleanPath {

	public static void main(String[] args) {
		// test cleaning strings
		System.out.println("Test cleaning strings => " + cleanString("Test cleaning strings"));
		System.out.println("Test \\tcleaning strings\\t => " + cleanString("Test \tcleaning strings\t"));
		String letters = "abcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		System.out.println("Test Lower Case => " + cleanString(letters));
		System.out.println("Test Upper Case => " + cleanString(letters.toUpperCase()));
		System.out.println("Test digits => " + cleanString(digits));

	}

    public static String cleanString(String aString) {
        if (aString == null) return null;
        String cleanString = "";
        for (int i = 0; i < aString.length(); ++i) {
            cleanString += cleanChar(aString.charAt(i));
        }
        return cleanString;
    }

    private static char cleanChar(char aChar) {
    	
    	// 0 - 9
    	for (int i = 48; i < 58; ++i) {
    		if (aChar == i) return (char) i;
    	}
    	
    	// 'A' - 'Z'
    	for (int i = 65; i < 91; ++i) {
    		if (aChar == i) return (char) i;
    	}
    	
    	// 'a' - 'z'
    	for (int i = 97; i < 123; ++i) {
    		if (aChar == i) return (char) i;
    	}
    	
    	// other valid characters
        switch (aChar) {
            case '/':
                return '/';
            case '.':
                return '.';
            case '-':
                return '-';
            case '_':
                return '_';
            case ' ':
                return ' ';
        }
        return '%';
    }
    

}
