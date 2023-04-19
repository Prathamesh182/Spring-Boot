package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach{

	IDiet diet;
	
	@Autowired
	public CricketCoach(@Qualifier (value="weightLossDiet")IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTrainingDetails() {
		return "Practice in net for 3 Hours";
	}

	@Override
	public String getDietPlan() {
		return diet.getDietPlan();
	}
 
}
