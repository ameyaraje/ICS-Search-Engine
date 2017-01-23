import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TotalFreq {
	
	static HashMap<String, Integer> result = new HashMap<>();
	static FileInputStream input = null;
	static Scanner sc = null;
	
	public static void main(String[] args) throws Exception {
		
		DateFormat format = new SimpleDateFormat("HH:MM:SS");
		Date startTime = new Date();
		
		result = tokenize(args[0]);
		result = tokenize(args[1]);
		sortAndPrint(result);
		
		Date endTime = new Date();
		System.out.println("Time taken to execute is : " + (endTime.getTime()-startTime.getTime()) + " ms");
		
	}
	
	public static HashMap<String, Integer> tokenize(String filePath) throws Exception {
		
		input = new FileInputStream(filePath);
		sc = new Scanner(input);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			
			String[] tokens = line.split(",");
			
			if (tokens.length != 2)
				continue;
			
			String word = tokens[0];
			int freq = Integer.parseInt(tokens[1]);
			
			if (!result.containsKey(word))
				result.put(word, freq);
			else
				result.put(word, result.get(word)+freq);
		}
		
//		for (String s: result.keySet()) {
//			
//			System.out.println("Tokens " + s + " Freq " + result.get(s));
//		}
		sc.close();
		
		return result;
	}

	public static void sortAndPrint(HashMap<String, Integer> map) {
		Set<Map.Entry<String,Integer>> set = map.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
		Collections.sort( list, (o1, o2) -> (o2.getValue()).compareTo( o1.getValue() ));
		
		for (Map.Entry<String, Integer> entry:list) {
            System.out.println("Token: " + entry.getKey()+" Freq: "+entry.getValue());
        }
		
	}
}