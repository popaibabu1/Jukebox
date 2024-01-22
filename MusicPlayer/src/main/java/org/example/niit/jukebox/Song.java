package org.example.niit.jukebox;

public class Song {
    int song_id;
    String title;
    String artistName;
    String albumName;
    double duration;
    String path;
    String genere;

    public Song() {
    }

    public Song(int song_id, String title, String artistName, String albumName, double duration, String path, String genere) {
        this.song_id=song_id;
        this.title = title;
        this.duration = duration;
        this.path = path;
        this.genere = genere;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    public int getSong_id() {
        return song_id;
    }

    public int setSong_id(int song_id) {
        this.song_id = song_id;
        return song_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenere() {
        return genere;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }
    @Override
    public String toString() {
        return "Song{" +
                "song_id=" + song_id +
                ", title='" + title + '\'' +
                ", artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", duration=" + duration +
                ", path='" + path + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
