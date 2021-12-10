package com.company;

/*
Duration Class with getters and setters
 */
public class Duration{
    private int hours;
    private int minutes;
    private int seconds;

    public Duration() {
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
    public int totalPlayTime() {
        int total = hours * 60 * 60 + minutes * 60 + seconds;
        return total;
    }


}
