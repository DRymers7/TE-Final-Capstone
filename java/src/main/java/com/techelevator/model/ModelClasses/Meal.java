package com.techelevator.model.ModelClasses;

import java.sql.Timestamp;
import java.util.Objects;

public class Meal {

    private int mealId;
    private int carbs;
    private String food;
    private int glycemicIndex;
    private Timestamp mealTime;

    public Meal() {};

    public Meal(int mealId, int carbs, String food, int glycemicIndex, Timestamp mealTime) {
        this.mealId = mealId;
        this.carbs = carbs;
        this.glycemicIndex = glycemicIndex;
        this.mealTime = mealTime;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setGlycemicIndex(int glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public Timestamp getMealTime() {
        return mealTime;
    }

    public void setMealTime(Timestamp mealTime) {
        this.mealTime = mealTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return mealId == meal.mealId && carbs == meal.carbs && glycemicIndex == meal.glycemicIndex && Objects.equals(food, meal.food) && Objects.equals(mealTime, meal.mealTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, carbs, food, glycemicIndex, mealTime);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", carbs=" + carbs +
                ", food='" + food + '\'' +
                ", glycemicIndex=" + glycemicIndex +
                ", mealTime=" + mealTime +
                '}';
    }
}
