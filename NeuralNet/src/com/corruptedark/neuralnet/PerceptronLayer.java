package com.corruptedark.neuralnet;

import java.util.ArrayList;

public class PerceptronLayer {
	int numPerceptrons;

	ArrayList<Perceptron> perceptrons;
	
	public PerceptronLayer(int numPerceptrons, int inputsPerPerceptron){
		perceptrons = new ArrayList<Perceptron>(numPerceptrons);
		
		for(int i = 0; i < numPerceptrons; i++){
			perceptrons.add(new Perceptron(inputsPerPerceptron));
		}
	}
	
	public ArrayList<Double> processInputs(ArrayList<Double> inputs){
		ArrayList<Double> outPuts = new ArrayList<Double>(numPerceptrons);
		for(int i = 0; i < numPerceptrons; i++){
			outPuts.add(perceptrons.get(i).processInputs(inputs));
		}
		return outPuts;
	}
}
