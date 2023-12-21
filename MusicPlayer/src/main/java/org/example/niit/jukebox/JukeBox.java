package org.example.jukebox;
import org.example.niit.jukebox.Song;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JukeBox {
    public static List<Song> songlist;
    int currentSongIndex;
    public  boolean playing;
    static Clip clip;


    public JukeBox() {
        playing = false;
        songlist = new ArrayList<>();
    }

    public void addSong(Song song) {
        songlist.add(song);
    }

    public List<Song> searchByTitle(String title) {
        List<Song> results = new ArrayList<>();

        for (Song song : songlist) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                results.add(song);
                System.out.println(song);
            }
        }

        return results;
    }

    public void playSongTitle(String title) {
        try {
            for (int i = 0; i < songlist.size(); i++) {
                Song song = songlist.get(i);
                if (song.getTitle().equalsIgnoreCase(title)) {
                    currentSongIndex = i + 1;
                    break;
                }
            }
            Song song = songlist.get(currentSongIndex - 1);
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(song.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream1);
            System.out.println("song id: " + song.getSong_id() + ","+ " " + "Title: " + song.getTitle() + "," + " " + "Genere: " + song.getGenere() + "," + " " + "Artist: " + " " + song.getArtistName() + "," + " " + "Album: " + " " + song.getAlbumName() + "," + " " + "Duration: " + " " + song.getDuration());
            clip.start();
            playing = true;
            while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
                Scanner scanner1 = new Scanner(System.in);
                String choice1 = "";
                System.out.println("Enter the choice1: ");
                System.out.println("Enter s to stop: ");
                System.out.println("Enter p to play: ");
                System.out.println("Enter r to restart: ");
                System.out.println("Enter n to next: ");
                choice1 = scanner1.nextLine();
                System.out.println("choice 1: " + choice1);
                switch (choice1) {
                    case "s":
                        stop();
                        System.out.println("stop song");
                        break;
                    case "p":
                        resume();
                        System.out.println("resume song");
                        break;
                    case "r":
                        reset();
                        System.out.println("restart song");
                        break;
                    case "n":
                        quit();
                        return;
                }
                System.out.println("check");
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        System.out.println("check3");
                        playing = false;
                    }
                });
            }

            return;


        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Song> searchByGenre(String genre) {
        List<Song> matchingSongs = new ArrayList<>();

        for (Song song : songlist) {
            if (song.getGenere().equalsIgnoreCase(genre)) {
                matchingSongs.add(song);
                System.out.println(song);
            }
        }

        return matchingSongs;
    }

    public void playSongByGenere(String title) {
        try {
            for (int i = 0; i < songlist.size(); i++) {
                Song song = songlist.get(i);
                if (song.getTitle().equalsIgnoreCase(title)) {
                    currentSongIndex = i + 1;
                    break;
                }
            }
            Song song = songlist.get(currentSongIndex - 1);
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(song.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream1);
            System.out.println("song id: " + song.getSong_id() + ","+ " " + "Title: " + song.getTitle() + "," + " " + "Genere: " + song.getGenere() + "," + " " + "Artist: " + " " + song.getArtistName() + "," + " " + "Album: " + " " + song.getAlbumName() + "," + " " + "Duration: " + " " + song.getDuration());
            clip.start();
            playing = true;
            while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
                Scanner scanner1 = new Scanner(System.in);
                String choice1 = "";
                System.out.println("Enter the choice1: ");
                System.out.println("Enter s to stop: ");
                System.out.println("Enter p to play: ");
                System.out.println("Enter r to restart: ");
                System.out.println("Enter n to next: ");
                choice1 = scanner1.nextLine();
                System.out.println("choice 1: " + choice1);
                switch (choice1) {
                    case "s":
                        stop();
                        System.out.println("stop song");
                        break;
                    case "p":
                        resume();
                        System.out.println("resume song");
                        break;
                    case "r":
                        reset();
                        System.out.println("restart song");
                        break;
                    case "n":
                        quit();
                        return;
                }
                System.out.println("check");
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        System.out.println("check3");
                        playing = false;
                    }
                });
            }

            return;


        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Song> searchByArtist(String artist) {
        List<Song> result = new ArrayList<>();
        for (Song song : songlist) {
            if (song.getArtistName().equalsIgnoreCase(artist)) {
                result.add(song);
                System.out.println(song);
            }
        }
        return result;
    }

    public void playSongByArtist(String title) {
        try {
            for (int i = 0; i < songlist.size(); i++) {
                Song song = songlist.get(i);
                if (song.getTitle().equalsIgnoreCase(title)) {
                    currentSongIndex = i + 1;
                    break;
                }
            }
            Song song = songlist.get(currentSongIndex - 1);
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(song.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream1);
            System.out.println("song id: " + song.getSong_id() + "," + " " + "Title: " + song.getTitle() + "," + " " + "Genere: " + song.getGenere() + "," + " " + "Artist: " + " " + song.getArtistName() + "," + " " + "Album: " + " " + song.getAlbumName() + "," + " " + "Duration: " + " " + song.getDuration());
            clip.start();
            playing = true;
            while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
                Scanner scanner1 = new Scanner(System.in);
                String choice1 = "";
                System.out.println("Enter the choice1: ");
                System.out.println("Enter s to stop: ");
                System.out.println("Enter p to play: ");
                System.out.println("Enter r to restart: ");
                System.out.println("Enter n to next: ");
                choice1 = scanner1.nextLine();
                System.out.println("choice 1 : " + choice1);
                switch (choice1) {
                    case "s":
                        stop();
                        System.out.println("stop song");
                        break;
                    case "p":
                        resume();
                        System.out.println("resume song");
                        break;
                    case "r":
                        reset();
                        System.out.println("restart song");
                        break;
                    case "n":
                        quit();
                        return;
                }
                System.out.println("check");
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        System.out.println("check3");
                        playing = false;
                    }
                });
            }

            return;


        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Song> findSongById(int id) {
        List<Song> result = new ArrayList<>();
        for (Song song : songlist) {
            if (song.getSong_id() == id) {
                result.add(song);
                System.out.println(song);
            }
        }
        return result;
    }

    public void playSongId(String title) {
        try {
            for (int i = 0; i < songlist.size(); i++) {
                Song song = songlist.get(i);
                if (song.getTitle().equalsIgnoreCase(title)) {
                    currentSongIndex = i + 1;
                    break;
                }
            }
            Song song = songlist.get(currentSongIndex - 1);
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(song.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream1);
            System.out.println("song id: " + song.getSong_id() + "," + " " + "Title: " + song.getTitle() + "," + " " + "Genere: " + song.getGenere() + "," + " " + "Artist: " + " " + song.getArtistName() + "," + " " + "Album: " + " " + song.getAlbumName() + "," + " " + "Duration: " + " " + song.getDuration());
            clip.start();
            playing = true;
            while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
                Scanner scanner1 = new Scanner(System.in);
                String choice1 = "";
                System.out.println("Enter the choice1: ");
                System.out.println("Enter s to stop: ");
                System.out.println("Enter p to play: ");
                System.out.println("Enter r to restart: ");
                System.out.println("Enter n to next: ");
                choice1 = scanner1.nextLine();
                System.out.println("choice 1: " + choice1);
                switch (choice1) {
                    case "s":
                        stop();
                        System.out.println("stop Song");
                        break;
                    case "p":
                        resume();
                        System.out.println("resume Song");
                        break;
                    case "r":
                        reset();
                        System.out.println("restart song");
                        break;
                    case "n":
                        quit();
                        return;
                }
                System.out.println("check");
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        System.out.println("check3");
                        playing = false;
                    }
                });
            }

            return;


        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Song> searchByAlbum(String albumName) {
        List<Song> result = new ArrayList<>();
        for (Song song : songlist) {
            if (song.getAlbumName().equalsIgnoreCase(albumName)) {
                result.add(song);
                System.out.println(song);
            }
        }
        return result;
    }

    public void playSongAlbum(String title) {
        try {
            for (int i = 0; i < songlist.size(); i++) {
                Song song = songlist.get(i);
                if (song.getTitle().equalsIgnoreCase(title)) {
                    currentSongIndex = i + 1;
                    break;
                }
            }
            Song song = songlist.get(currentSongIndex - 1);
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(song.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream1);
            System.out.println("song id: " + song.getSong_id() + ","+" " + "Title: " + song.getTitle() + "," + " " + "Genere: " + song.getGenere() + "," + " " + "Artist: " + " " + song.getArtistName() + "," + " " + "Album: " + " " + song.getAlbumName() + "," + " " + "Duration: " + " " + song.getDuration());
            clip.start();
            playing = true;
            while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
                Scanner scanner1 = new Scanner(System.in);
                String choice1 = "";
                System.out.println("Enter the choice1: ");
                System.out.println("Enter s to stop: ");
                System.out.println("Enter p to play: ");
                System.out.println("Enter r to restart: ");
                System.out.println("Enter n to next: ");
                choice1 = scanner1.nextLine();
                System.out.println("choice 1: " + choice1);
                switch (choice1) {
                    case "s":
                        stop();
                        System.out.println("stop song");
                        break;
                    case "p":
                        resume();
                        System.out.println("resume song");
                        break;
                    case "r":
                        reset();
                        System.out.println("restart song");
                        break;
                    case "n":
                        quit();
                        return;
                }
                System.out.println("check");
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        System.out.println("check3");
                        playing = false;
                    }
                });
            }

            return;


        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Song> searchByDuration(double duration) {
        List<Song> matchingSongs = new ArrayList<>();
        for (Song song : songlist) {
            if (song.getDuration() == duration) {
                matchingSongs.add(song);
                System.out.println(song);
            }
        }
        return matchingSongs;
    }
    public void playSongDuration(String title) {
        try {
            for (int i = 0; i < songlist.size(); i++) {
                Song song = songlist.get(i);
                if (song.getTitle().equalsIgnoreCase(title)) {
                    currentSongIndex = i + 1;
                    break;
                }
            }
            Song song = songlist.get(currentSongIndex - 1);
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(song.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream1);
            System.out.println("song id: " + song.getSong_id() + "," + " " + "Title: " + song.getTitle() + "," + " " + "Genere: " + song.getGenere() + "," + " " + "Artist: " + " " + song.getArtistName() + "," + " " + "Album: " + " " + song.getAlbumName() + "," + " " + "Duration: " + " " + song.getDuration());
            clip.start();
            playing = true;
            while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
                Scanner scanner1 = new Scanner(System.in);
                String choice1 = "";
                System.out.println("Enter the choice1: ");
                System.out.println("Enter s to stop: ");
                System.out.println("Enter p to play: ");
                System.out.println("Enter r to restart: ");
                System.out.println("Enter n to next: ");
                choice1 = scanner1.nextLine();
                System.out.println("choice 1: " + choice1);
                switch (choice1) {
                    case "s":
                        stop();
                        System.out.println("stop song");
                        break;
                    case "p":
                        resume();
                        System.out.println("resume song");
                        break;
                    case "r":
                        reset();
                        System.out.println("restart song");
                        break;
                    case "n":
                        quit();
                        return;
                }
                System.out.println("check");
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        System.out.println("check3");
                        playing = false;
                    }
                });
            }

            return;


        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void listSongs() {
        System.out.println("Available Songs:");
        for (int i = 0; i < songlist.size(); i++) {//for(initialization;condition,updatation;)
            System.out.println((i + 1) + ". " + songlist.get(i).getTitle());//statement
        }
    }

    public void playSong() {
        Scanner scanner = new Scanner(System.in);
        currentSongIndex = scanner.nextInt();
        Song song = songlist.get(currentSongIndex - 1);//Adjust the 1-based index to 0-based index.
        try {
            AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(song.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream1);
            System.out.println("song id: " + song.getSong_id() + "," + " " + "Title: " + song.getTitle() + "," + " " + "Genere: " + song.getGenere() + "," + " " + "Artist: " + " " + song.getArtistName() + "," + " " + "Album: " + " " + song.getAlbumName() + "," + " " + "Duration: " + " " + song.getDuration());
            clip.start();
            playing = true;
            while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
                Scanner scanner1 = new Scanner(System.in);
                String choice1 = "";
                System.out.println("Enter the choice1: ");
                System.out.println("Enter s to stop: ");
                System.out.println("Enter p to play: ");
                System.out.println("Enter r to reset: ");
                System.out.println("Enter n to next: ");
                System.out.println("Enter q to quit: ");

                choice1 = scanner1.nextLine();
                System.out.println("choice 1: " + choice1);
                switch (choice1) {
                    case "s":
                        stop();
                        System.out.println("stop song");
                        break;
                    case "p":
                        resume();
                        System.out.println("resume song");
                        break;
                    case "r":
                        reset();
                        System.out.println("restart song");
                        break;
                    case "q":
                        quit();
                        System.out.println("quit song");
                        return;
                    case "n":

                        clip.stop();
                        clip.close();
                        currentSongIndex += 1;
                        if (currentSongIndex == songlist.size() + 1) {
                            currentSongIndex = 1;
                        }
                        Song song1 = songlist.get(currentSongIndex - 1);//Adjust the 1-based index to 0-based index.
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(song1.getPath()));
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        System.out.println("song id " + song1.getSong_id() + "," + "Title: " + song1.getTitle() + "," + " " + "Genere: " + song1.getGenere() + "," + " " + "Artist: " + " " + song1.getArtistName() + "," + " " + "Album: " + " " + song1.getAlbumName() + "," + " " + "Duration: " + " " + song1.getDuration());
                        clip.start();
                        playing = true;
                        break;
                }
                System.out.println("check");
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        System.out.println("check3");
                        playing = false;
                    }
                });
            }

            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void reset() {
        if (clip != null) {
            clip.setFramePosition(0); // Set the frame position to the beginning in 0.
            clip.start();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();


        }
    }

    public void resume() {
        if (clip != null) {
            clip.start();

        }
    }

    public void quit() {
        if (clip != null) {
            clip.stop();
            clip.close();

        }
    }
}

