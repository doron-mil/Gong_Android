package org.beyachad.gongandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicServerData {
    @SerializedName("currentServerTime")
    @Expose
    private Date currentServerTime = new Date();

    @SerializedName("nextScheduledJobTime")
    @Expose
    private String nextScheduledJobTime;

    @SerializedName("isManual")
    @Expose
    private boolean isManual;

    public Date getCurrentServerTime() {
        return currentServerTime;
    }

    public void setCurrentServerTime(Date currentServerTime) {
        this.currentServerTime = currentServerTime;
    }

    public void setCurrentServerTime(String currentServerTime) {
        try {
            this.currentServerTime = new SimpleDateFormat("dd/MM/yyyy").parse(currentServerTime);
        } catch (ParseException e) {
            this.currentServerTime = new Date();
            e.printStackTrace();
        }
    }

    public String getNextScheduledJobTime() {
        return nextScheduledJobTime;
    }

    public void setNextScheduledJobTime(String nextScheduledJobTime) {
        this.nextScheduledJobTime = nextScheduledJobTime;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public void setManual(String manual) {
        isManual = Boolean.getBoolean(manual);
    }
}
