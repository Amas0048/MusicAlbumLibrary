package com.company;

/*
Track Class with getters and setters
 */
public class Track {
    private String title;
    private Duration duration;

    public Track() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
