package com.aurionpro.model;

public class BasketBallCoach implements ICoach{

	private IDiet diet;
	
	public BasketBallCoach() {
		System.out.println("done for today");
	}

	public IDiet getDiet() {
		return diet;
	}

	public void setDiet(IDiet diet) {
		this.diet = diet;
		System.out.println("inside basketball setter");
	}

	@Override
	public String getTrainingDetails() {
		return "DO practice for 90mins";
	}

	

//	@Override
//	public String getDietPlan() {
//		return diet.getDietPlan();
//	}

}
