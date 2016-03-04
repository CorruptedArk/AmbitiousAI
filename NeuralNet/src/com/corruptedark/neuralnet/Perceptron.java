package com.corruptedark.neuralnet;

import java.util.ArrayList;
import java.util.Random;

public class Perceptron {
	int numInputs;
	
	ArrayList<Double> weights;
	
	Random rand;
	
	public Perceptron(int numInputs){
		weights = new ArrayList<Double>(numInputs);
		
		for(int i = 0; i < numInputs; i++){
			weights.add(new Double(rand.nextDouble()));
		}
	}
	
	public Double processInputs(ArrayList<Double> inputs){
		double activation = 0;
		for(int i = 0; i < weights.size(); i++){
			activation += inputs.get(i) * weights.get(i);
		}
		
		return new Double(1/(1+Math.exp(-activation)));
	}
	
}
