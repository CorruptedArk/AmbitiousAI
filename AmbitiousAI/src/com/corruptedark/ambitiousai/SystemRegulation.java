package com.corruptedark.ambitiousai;

public class SystemRegulation {

	private boolean isFunctional;
	
	
	public SystemRegulation(boolean isFunctional){
		this.isFunctional = isFunctional;
	}
	
	
	boolean isFunctional(){
		return isFunctional;
	}
	
	void regulate(){
		
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				
				
			};
				
		}).start();
	}
	
}
