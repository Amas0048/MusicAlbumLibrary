package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here

        AlbumCollection albumCollection = readFile("album.txt");

        AlbumDatabase albumDatabase = new AlbumDatabase();
        albumDatabase.orderCollection(albumCollection);
        albumDatabase.totalPlayTime(albumCollection);
        albumDatabase.longestTitle(albumCollection);
        albumDatabase.shortestTrack(albumCollection);

    }

    public static AlbumCollection readFile(String fileName) throws FileNotFoundException {
        AlbumCollection albumCollection = new AlbumCollection();
        List<Album> albumList = new ArrayList<>();
        Album _s = null;

        File fileNames = new File(fileName);

        if (fileNames.canRead()) {
            Scanner scFileNames = new Scanner(fileNames);

            while (scFileNames.hasNextLine()) {
                Duration _d = new Duration();
                Track _t = new Track();

                String record = scFileNames.nextLine();
                if (!record.equals("")) {
                    Album _album = new Album();
                    if (!record.startsWith("0")) {
                        Scanner scR = new Scanner(record);
                        scR.useDelimiter("[\\Q():\\E]");
                        _album.setArtistName(scR.next());
                        _album.setTitle(scR.next());
                        _album.setReleaseYear(scR.nextInt());
                        _s = _album;
                        albumList.add(_album);
                    }
                    if (record.startsWith("0")) {
                        Scanner scR = new Scanner(record);
                        scR.useDelimiter("[\\Q:-\\E]");
                        _d.setHours(scR.nextInt());
                        _d.setMinutes(scR.nextInt());
                        _d.setSeconds(Integer.parseInt(scR.next().replaceAll("\\s+", "")));
                        _t.setTitle(scR.next());
                        _t.setDuration(_d);
                        _s.getTracks().add(_t);
                    }

                }
            }
        }

        albumCollection.setAlbums(albumList);
        return albumCollection;
    }


}
