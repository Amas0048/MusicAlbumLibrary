package com.company;

import java.util.ArrayList;
import java.util.List;

/*
Album Class with getters and setters
 */
public class Album {
    private String artistName;
    private String title;
    private int releaseYear;
    private List<Track> tracks = new ArrayList<>();

    public Album() {
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "artistName='" + artistName + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", tracks=" + tracks +
                '}';
    }
}
