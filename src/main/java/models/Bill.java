package models;

import enums.SplitMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Bill {
    Double expense ;
    User paidBy ;
    SplitMethod splitMethod ;
    HashMap<String, Double> splitMap = new HashMap<String, Double>() ;
    String uuid ;

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public SplitMethod getSplitMethod() {
        return splitMethod;
    }

    public void setSplitMethod(SplitMethod splitMethod) {
        this.splitMethod = splitMethod;
    }

    public HashMap<String, Double> getSplitMap() {
        return splitMap;
    }

    public void setSplitMap(HashMap<String, Double> splitMap) {
        this.splitMap = new HashMap<String, Double>();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Bill(Double expense, User paidBy, SplitMethod splitMethod, HashMap<String, Double> splitMap) {
        this.expense = expense;
        this.paidBy = paidBy;
        this.splitMethod = splitMethod;
        this.splitMap = splitMap;
        UUID u = UUID.randomUUID();
        this.uuid  = u.toString();

    }






}
