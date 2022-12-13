package com.techelevator.model.ModelClasses;

import com.techelevator.dao.dao.UserDataDao;

import java.sql.Timestamp;
import java.util.Objects;

public class UserData {

    private int userId;
    private double a1c;
    private int fastingGlucose;
    private int diabetesType;
    private int userAge;
    private Timestamp lastUpdated;
    private int weight;
    private int height;
    private String activityLevel;
    private String emergencyContact1;
    private String emergencyContact2;
    private String username;

    public UserData() {};

    public UserData(int userId, double a1c, int fastingGlucose, int diabetesType, int userAge, Timestamp lastUpdated, int weight, int height, String activityLevel,
                    String emergencyContact1, String emergencyContact2, String username) {
        this.userId = userId;
        this.a1c = a1c;
        this.fastingGlucose = fastingGlucose;
        this.diabetesType = diabetesType;
        this.userAge = userAge;
        this.lastUpdated = lastUpdated;
        this.weight = weight;
        this.height = height;
        this.activityLevel = activityLevel;
        this.emergencyContact1 = emergencyContact1;
        this.emergencyContact2 = emergencyContact2;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getA1c() {
        return a1c;
    }

    public void setA1c(double a1c) {
        this.a1c = a1c;
    }

    public int getFastingGlucose() {
        return fastingGlucose;
    }

    public void setFastingGlucose(int fastingGlucose) {
        this.fastingGlucose = fastingGlucose;
    }

    public int getDiabetesType() {
        return diabetesType;
    }

    public void setDiabetesType(int diabetesType) {
        this.diabetesType = diabetesType;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getEmergencyContact1() {
        return emergencyContact1;
    }

    public void setEmergencyContact1(String emergencyContact1) {
        this.emergencyContact1 = emergencyContact1;
    }

    public String getEmergencyContact2() {
        return emergencyContact2;
    }

    public void setEmergencyContact2(String emergencyContact2) {
        this.emergencyContact2 = emergencyContact2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return userId == userData.userId && Double.compare(userData.a1c, a1c) == 0 && fastingGlucose == userData.fastingGlucose && diabetesType == userData.diabetesType && userAge == userData.userAge && weight == userData.weight && height == userData.height && Objects.equals(lastUpdated, userData.lastUpdated) && Objects.equals(activityLevel, userData.activityLevel) && Objects.equals(emergencyContact1, userData.emergencyContact1) && Objects.equals(emergencyContact2, userData.emergencyContact2) && Objects.equals(username, userData.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, a1c, fastingGlucose, diabetesType, userAge, lastUpdated, weight, height, activityLevel, emergencyContact1, emergencyContact2, username);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId=" + userId +
                ", a1c=" + a1c +
                ", fastingGlucose=" + fastingGlucose +
                ", diabetesType=" + diabetesType +
                ", userAge=" + userAge +
                ", lastUpdated=" + lastUpdated +
                ", weight=" + weight +
                ", height=" + height +
                ", activityLevel='" + activityLevel + '\'' +
                ", emergencyContact1='" + emergencyContact1 + '\'' +
                ", emergencyContact2='" + emergencyContact2 + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
