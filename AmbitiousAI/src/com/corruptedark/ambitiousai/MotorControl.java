package com.corruptedark.ambitiousai;

public class MotorControl {

	
    private boolean isFunctional;
	
    public MotorControl(boolean isFunctional){
    	this.isFunctional = isFunctional;
    }
	
	boolean isFunctional(){
		return isFunctional;
	}
}
