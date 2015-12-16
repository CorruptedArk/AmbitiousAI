package com.corruptedark.ambitiousai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LanguageProcessing {

	ReadFile reader = new ReadFile("data.txt");
	String[] textData;
	ReadFile beliefReader = new ReadFile("beliefs.txt");
	HashMap<String,List<String>> beliefs;
	
	
	private boolean isFunctional;
	
	public LanguageProcessing(boolean isFunctional){
		this.isFunctional = isFunctional;
	}
	
	boolean isFunctional(){
		return isFunctional;
	}
	
	void takeInputFromFile(){
		try {
			textData = reader.openFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	HashMap<String,List<String>> readBeliefs(){
		beliefs = new HashMap<String,List<String>>();
		
		try {
			String[] rawBeliefs = beliefReader.openFile();
			for(String line : rawBeliefs){
				String key = line.split(": ")[0];
				List<String> values = new ArrayList<String>();
				
				String rawItems = line.split(": ")[1];
				String[] items = rawItems.split(", ");
				
				for(int i = 0; i <= items.length - 1; i++){
					values.add(items[i]);
				}
				beliefs.put(key, values);
			}
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			System.out.println("I dont know what I believe");
			e.printStackTrace();
		}
		
		return beliefs;
	}
	
	
}
