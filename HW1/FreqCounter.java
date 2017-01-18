package com.counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class FreqCounter {

	public static void main(String[] args) throws Exception {
		//HashMap<String, Integer> map = new HashMap<>();
		
		List<String> words = new ArrayList<>();
		words = tokenize();
		System.out.println("----------");
		Map<String, Integer> answer = new HashMap<>();
		answer = countFreqs(words);
		
	}
	
	public static List<String> tokenize() throws Exception{
		FileReader lineReader = new FileReader("/Users/ameyaraje/Desktop/input.txt");
		BufferedReader reader = new BufferedReader(lineReader);
		String line;
		List<String> wordList = new ArrayList<>();
		
		while ((line = reader.readLine()) != null) {
			String lcase = line.toLowerCase();
			if (!wordList.contains(lcase)) {
				wordList.add(lcase);
			}
		}
		
		for (String s: wordList) {
			System.out.println(s);
		}
		reader.close();
		return wordList;
	}
	
	
	public static Map<String, Integer> countFreqs(List<String> words) {
		HashMap<String, Integer> map = new HashMap<>();
		
		for (String s: words) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			}
			else {
				map.put(s, map.get(s)+1);
			}
		}
		
		for (String s: map.keySet()) {
			System.out.println(s+ " " + map.get(s));
		}
		return map;
	}
}
