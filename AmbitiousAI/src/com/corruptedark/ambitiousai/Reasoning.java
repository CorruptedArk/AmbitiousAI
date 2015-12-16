package com.corruptedark.ambitiousai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reasoning {
	boolean isReasoning;
	AuditoryProcessing hearing;
	HapticPerception touch;
	LanguageProcessing speech;
	VisualProcessing sight;
	
	List<String> textData = new ArrayList<String>();
	HashMap<String, List<String>> beliefs;
	WriteFile writer = new WriteFile("beliefs.txt",false);
	
	public Reasoning(AuditoryProcessing hearing, HapticPerception touch, LanguageProcessing speech, VisualProcessing sight){
		this.hearing = hearing;
		this.touch = touch;
		this.speech = speech;
		this.sight = sight;
	}
	
	
	void reason(){
		
		new Thread(new Runnable(){

			
			@Override
			public void run() {
				isReasoning = true;
				while(isReasoning){
					System.out.println("I am reasoning");
					readBeliefs();
					takeInput();
					processData();
					modifyBelief();
					expressBelief();
					isReasoning = false;
				}
				
			}
			
		}).start();
		
		
	}
	
	void readBeliefs(){
		beliefs = speech.readBeliefs();
	}
	
	void takeInput(){
		if(hearing.isFunctional()){
			
		}
		if(touch.isFunctional()){
			
		}
		if(speech.isFunctional()){
			speech.takeInputFromFile();
		}
		if(sight.isFunctional()){
			
		}
	}
	
	
	void processData(){
		if(hearing.isFunctional()){
			
		}
		if(touch.isFunctional()){
			
		}
		if(speech.isFunctional()){
			for(int i=0; i < speech.textData.length; i++){
				textData.add(speech.textData[i]);
			}
		}
		if(sight.isFunctional()){
			
		}
	}
	
	void modifyBelief(){
		if(hearing.isFunctional()){
			
		}
		if(touch.isFunctional()){
			
		}
		if(speech.isFunctional()){
			for(String item : textData){
				sortData(item);
			}
		}
		if(sight.isFunctional()){
			
		}
	}
	
	void sortData(String string){
		String firstItem = string.split(" is ")[0];
		String secondItem = string.split(" is ")[1].split("; ")[0];
		String equivalence = string.split(" is ")[1].split("; ")[1];
		String truth;
		if(equivalence.contentEquals("true")){
			truth = "is";
		}else{
			truth = "is not";
		}
		
		if(beliefs.containsKey(firstItem)){
			beliefs.get(firstItem).add(truth + " " + secondItem);
		}else{
			List<String> value = new ArrayList<String>();
			value.add(truth + " " + secondItem);
			beliefs.put(firstItem, value);
		}
		if(beliefs.containsKey(secondItem)){
			beliefs.get(secondItem).add(truth + " " + firstItem);
		}else{
			List<String> value = new ArrayList<String>();
			value.add(truth + " " + firstItem);
			beliefs.put(secondItem, value);
		}
	}
	
	void expressBelief(){
		int j = 0;
		for(String key : beliefs.keySet()){
			
			List<String> attachedData = beliefs.get(key);
			
			String data = " ";
			for(int i = 0; i < attachedData.size(); i++){
				data = data + attachedData.get(i) +", ";
			}
			
			try {
				if(j == 0){
					writer.writeToFile(key+":"+data);
					j++;
				}else{
					writer.appendToFile(key+":"+data);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("I wrote a file");
	}
	
	void stopReasoning(){
		isReasoning = false;
	}

}
