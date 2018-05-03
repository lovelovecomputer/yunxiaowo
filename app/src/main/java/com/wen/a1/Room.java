package com.wen.a1;


import android.net.wifi.hotspot2.pps.HomeSp;

/**
 * Created by asus1 on 2018/4/28.
 */

public class Room {
    private String number;
    private String building;
    private  String room;
    private String beds;
    private String orientation;


    public Room(String number, String beds) {
        super();
        this.number = number;
        this.beds = beds;
    }

    public Room(String number,String building,String room,String beds,String orientation){
        super();
        this.number = number;
        this.building = building;
        this.room = room;
        this.beds = beds;
        this.orientation = orientation;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getBeds() {
        return beds;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "编号：" + number + ", 床位数：" + beds;
    }
}
