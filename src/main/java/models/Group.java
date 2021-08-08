package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Group {
    List<User> usersList = new ArrayList<>();
    List<Bill> billList = new ArrayList<>() ;
    List<Pay> payList = new ArrayList<>() ;
    String groupId ;

    public Group() {
        this.groupId = UUID.randomUUID().toString() ;
    }

    public List<Pay> getPayList() {
        return payList;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
