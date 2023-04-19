package com.aurionpro.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WeightLossDiet implements IDiet {

	@Override
	public String getDietPlan() {
		return "reduce carbs";
	}

}
