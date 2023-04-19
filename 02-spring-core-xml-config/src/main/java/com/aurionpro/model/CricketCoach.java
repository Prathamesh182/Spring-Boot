package com.aurionpro.model;

public class CricketCoach implements ICoach {

	private IDiet diet;
	
	public CricketCoach(IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTrainingDetails() {
		return "Do net practice for 30mins";
	}

	@Override
	public String getDietPlan() {
		return diet.getDietPlan();
	}

}
