package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
AlbumDatabase Class containing the main functions of the program
 */
public class AlbumDatabase {

    /**
     * For sorting albumcollection by artist name and release year
     * @param albumCollections
     */
    public void orderCollection(AlbumCollection albumCollections) {
        List<Album> albumList = new ArrayList<>();
        albumList = albumCollections.getAlbums().stream().sorted(Comparator.comparing(Album::getArtistName).thenComparing(Album::getReleaseYear)).collect(Collectors.toList());
                        albumList.stream().forEach(e -> {
            System.out.println(e.getArtistName() + ":" + e.getTitle() + "(" +e.getReleaseYear() + ")");
        });

    }

    /**
     * For getting the total playtime of Pink Floyd album from album collections
     * @param albumCollections
     */
    public void totalPlayTime(AlbumCollection albumCollections) {
        List<List<Track>> pfA = albumCollections.getAlbums().stream().filter(e -> e.getArtistName().equalsIgnoreCase("Pink Floyd "))
                .map(c -> c.getTracks()).collect(Collectors.toList());
        List<Track> a = new ArrayList<>();
        pfA.stream().forEach(x -> a.addAll(x));
        int d = a.stream().mapToInt(o -> o.getDuration().totalPlayTime()).sum();
        Duration _d = getDuration(d);
        System.out.println("\n" + "Total Play Time for Pink Floyd => " + _d.getHours() + ":" + _d.getMinutes() + ":" + _d.getSeconds());
    }

    /**
     * For getting the album with the longest play time from album collections
     * @param albumCollection
     */
    public void longestTitle(AlbumCollection albumCollection) {
        final String[] ost = {""};
        albumCollection.getAlbums().stream().forEach(x -> {
            if (ost[0].length() < x.getTitle().length()) {
                ost[0] = x.getTitle();
            }
        });
        albumCollection.getAlbums().stream().forEach(e -> {
            if (e.getTitle().equalsIgnoreCase(ost[0])) {
                System.out.println("\n" +"Longest Title => " + e.getArtistName() + ":" + e.getTitle() + "(" +e.getReleaseYear() + ")");
            }

        });
    }

    /**
     * For getting the track with the shortest play time from album collections
     * @param albumCollection
     */
    public void shortestTrack(AlbumCollection albumCollection){
        List<List<Track>> tracks = albumCollection.getAlbums().stream().map(c -> c.getTracks()).collect(Collectors.toList());

        List<Track> a = new ArrayList<>();
        tracks.stream().forEach(x -> a.addAll(x));
        final int[] _shortest = {1000000000};
        a.stream().forEach(x -> {
            if(_shortest[0] > x.getDuration().totalPlayTime()){
                _shortest[0] = x.getDuration().totalPlayTime();
            }
        });
        a.stream().forEach(e -> {
            if(e.getDuration().totalPlayTime() == _shortest[0]){
                System.out.println("\n" +"Shortest Track => "+ e.getDuration().getHours() + ":" + e.getDuration().getMinutes() + ":" + e.getDuration().getSeconds() + " -" + e.getTitle());
            }
        });
    }

    /**
     * helps get Duration object
     * @param seconds
     * @return
     */
    public Duration getDuration(int seconds){
        Duration _d = new Duration();
        _d.setHours(0);
        _d.setMinutes(0);
        _d.setSeconds(0);
        int remainder = 0;
        if(seconds > 3600){
            _d.setHours(seconds / 3600);
            remainder = seconds - _d.getHours() * 3600;
        }
        if(remainder > 0){
            _d.setMinutes(remainder / 60);
            remainder = remainder - _d.getMinutes() * 60;
        }
        _d.setSeconds(remainder);

        return _d;
    }
}