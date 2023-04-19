package com.aurionpro.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aurionpro.model.ICoach;
public class CoachTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/aurionpro/model/applicationContext.xml");
		ICoach coach =(ICoach)context.getBean("CricketCoach",ICoach.class);
		ICoach coach1 =(ICoach)context.getBean("BasketBallCoach",ICoach.class);
		context.close();
		
		System.out.println(coach.getTrainingDetails());
		System.out.println(coach.getDietPlan());
		System.out.println(coach1.getTrainingDetails());
		System.out.println(coach1.getDietPlan());

		
	}

}
