package com.aurionpro.model;

public class CricketCoach implements ICoach {
	
	private String name;
	private String email;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private IDiet diet;
	
	public CricketCoach() {
		System.out.println("practising for 30hrs");
	}

	public IDiet getDiet() {
		return diet;
	}

	public void setDiet(IDiet diet) {
		this.diet = diet;
		System.out.println("inside cricket setter");
	}

	@Override
	public String getTrainingDetails() {
		return "Do net practice for 30mins";
	}
	@Override
	public String toString() {
		return "CricketCoach [name=" + name + ", email=" + email + "]";
	}

//	@Override
//	public String getDietPlan() {
//		return diet.getDietPlan();
//	}
	
	public void initMethod() {
		System.out.println("This is INIT method");
	}
	public void destroy() {
		System.out.println("This is Destroy method");
	}

}
