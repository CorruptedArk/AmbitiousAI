package com.corruptedark.ambitiousai;



public class Mind {
	
	
	VisualProcessing sight;
	AuditoryProcessing hearing;
	HapticPerception touch;
	LanguageProcessing speech;
	MotorControl movement;
	SystemRegulation regulation;
	Reasoning highReasoning;
	
	public Mind(){
		sight = new VisualProcessing(false);
		hearing = new AuditoryProcessing(false);
		touch = new HapticPerception(false);
		speech = new LanguageProcessing(true);
		movement = new MotorControl(false);
		regulation = new SystemRegulation(false);
		highReasoning = new Reasoning(hearing, touch, speech, sight);
	}
	
	void run(){
		highReasoning.reason();
	}

}
