package com.jb19011763.a189011763_opsc_poe12;

public class PersonalInfo {
    private String Height;
    private String Weight;
    private String CalorieIntake;
    private String WeightGoal;

    public PersonalInfo(String height, String weight) {
        Height = height;
        Weight = weight;
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
