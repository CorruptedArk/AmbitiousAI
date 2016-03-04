package com.corruptedark.neuralnet;

import java.util.ArrayList;

public class NeuralNet {
	private int numInputs, numOutputs, numHiddenLayers, neuronsPerHiddenLayer;
	
	private ArrayList<PerceptronLayer> layers;
	
	public NeuralNet(int numInputs, int numOutputs, int numHiddenLayers, int neuronsPerHiddenLayer){
		this.numInputs = numInputs;
		this.numOutputs = numOutputs;
		this.numHiddenLayers = numHiddenLayers;
		this.neuronsPerHiddenLayer = neuronsPerHiddenLayer;
		layers = new ArrayList<PerceptronLayer>(numHiddenLayers + 2);
		
		layers.add(new PerceptronLayer(numInputs,1));
		layers.add(new PerceptronLayer(neuronsPerHiddenLayer,numInputs));
		for(int i = 0; i < numHiddenLayers - 1; i++){
			layers.add(new PerceptronLayer(neuronsPerHiddenLayer,neuronsPerHiddenLayer));
		}
		layers.add(new PerceptronLayer(numOutputs, neuronsPerHiddenLayer));
	}
	
	public ArrayList<Double> processInputs(ArrayList<Double> inputs){
		ArrayList<Double> outPut = layers.get(0).processInputs(inputs);
		for(int i = 1; i < layers.size()-1; i++){
			outPut = layers.get(i).processInputs(outPut);
		}
		return outPut;
	}
}
