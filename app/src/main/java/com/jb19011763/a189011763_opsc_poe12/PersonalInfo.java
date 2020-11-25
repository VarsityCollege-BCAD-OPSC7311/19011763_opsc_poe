package com.jb19011763.a189011763_opsc_poe12;

import java.util.HashMap;
import java.util.Map;

public class PersonalInfo {
    public String Height;
    public String Weight;
    public String CalorieIntake;
    public String WeightGoal;

    public PersonalInfo(String height, String weight, String calorieIntake, String weightGoal) {
        this.Height = height;
        this.Weight = weight;
        this.CalorieIntake = calorieIntake;
        this.WeightGoal = weightGoal;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("height", this.Height);
        result.put("weight", this.Weight);
        result.put("calorieIntake", this.CalorieIntake);
        result.put("weightGoal", this.WeightGoal);

        return result;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }


    public String getCalorieIntake() {
        return CalorieIntake;
    }

    public void setCalorieIntake(String calorieIntake) {
        CalorieIntake = calorieIntake;
    }

    public String getWeightGoal() {
        return WeightGoal;
    }

    public void setWeightGoal(String weightGoal) {
        WeightGoal = weightGoal;
    }

}
