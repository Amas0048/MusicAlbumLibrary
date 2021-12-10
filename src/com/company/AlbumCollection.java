package com.company;

import java.util.List;

/*
AlbumCollection Class with getters and setters
 */
public class AlbumCollection {
    private List<Album> albums;

    public AlbumCollection() {
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "AlbumCollection{" +
                "albums=" + albums +
                '}';
    }
}
