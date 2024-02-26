package org.example.jukebox;
import org.example.niit.jukebox.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Playlist {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/anubhab1", "root", "root@123");
            System.out.println("connection established");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void createPlaylistsTable() {
        try {
            String sql = "create table playlists(playlist_id int auto_increment primary key ,Name varchar(255))";
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table 'playlists' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPlaylistSongsTable() {
        try {
            String sql = "create table playlist_Songs (song_id int auto_increment primary key ,playlist_id int, title varchar(100))";


            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table 'playlist_Songs' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void createPlaylist() {
        String choice="";
        do {
            System.out.println("Enter playlist name: ");
            Scanner scanner = new Scanner(System.in);
            String playlistName;
            playlistName = scanner.nextLine();
            Connection connection = getConnection();
            Connection connection1 = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/anubhab1", "root", "root@123");
                System.out.println("connection established");
                Statement st = connection.createStatement();
                String createQuery = "insert into playlists (Name) values('" + playlistName + "');";
                boolean b = st.execute(createQuery);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Playlist '" + playlistName + "' created.");
            System.out.println("Do you want to add more playlists press y if no then press n:");
            Scanner scanner1=new Scanner(System.in);
            choice=scanner1.nextLine();
        }while (choice.equalsIgnoreCase("y"));
    }
    public  void viewPlaylists() {
        try {
            String query = "select * from playlists";
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println("+-------------------------------+-----");
                System.out.println(" playlist_id.      Name         ");
                System.out.println("+-----------------------------+-------");
                System.out.println(resultSet.getString("playlist_id")+(" ")+(" ")+(" ")+(" ")+(" ")+(" ")+(" ")+(" ")+(" ")+ (" ")+(" ")+(" ")+(" ") +(" ")+(" ")+(" ")+resultSet.getString("Name"));
                System.out.println("+----------------------+------+-------");
            }
            resultSet.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void addSongPlaylist() {
        String insertQuery = "INSERT INTO playlist_songs (song_id, playlist_id, title) VALUES (?, ?, ?)";
        String response = "";
        do {
            System.out.println("Enter song id to the playlist: ");
            Scanner scanner=new Scanner(System.in);
            int songId=scanner.nextInt();
            System.out.println("Enter playlist id to the playlist: ");
            Scanner sc=new Scanner(System.in);
            int playlistId=sc.nextInt();
            System.out.println("Enter song name to add to the playlist: ");
            Scanner scanner1 = new Scanner(System.in);
            String songName = scanner1.nextLine();
            Connection connection = getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(2, playlistId);
                preparedStatement.setInt(1, songId);
                preparedStatement.setString(3, songName);
                preparedStatement.executeUpdate();
                System.out.println("Song added to the playlist successfully.");
                System.out.println("Do you want to add more song press y if no then press n: ");
                Scanner scanner2 = new Scanner(System.in);
                response = scanner2.nextLine();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (response.equalsIgnoreCase("y"));
    }

    public  void displaySongsInPlaylist() {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT song_id, title, artistName, albumName, duration,path,genere FROM players";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("song_id");
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artistName");
                String album = resultSet.getString("albumName");
                double duration = resultSet.getDouble("duration");
                String path = resultSet.getString("path");
                String genere = resultSet.getString("genere");

                Song song = new Song(id, title, artist, album, duration, path, genere);
                System.out.println(song);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void playSongPlaylist() {
        Scanner scanner = new Scanner(System.in);
        String choice="";
        do{
            System.out.println("Enter the song ID to play : ");
            int songId;
            songId = scanner.nextInt();
            System.out.println("Do you want to play more song press y and no then press n: ");
            Scanner in=new Scanner(System.in);
            choice=in.nextLine();
            try {
                String query = "SELECT title, path FROM players WHERE  song_id = ?";
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, songId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String songName = resultSet.getString("title");
                    String songFilePath = resultSet.getString("path");
                    System.out.println("Now playing: " + songName);
                    System.out.println("File path: " + songFilePath);
                } else {
                    System.out.println("No song found");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }while (choice.equalsIgnoreCase("y"));
    }
    public static void main(String[] arg) {
        Playlist playlist = new Playlist();
        playlist.createPlaylistsTable();
        playlist.createPlaylistSongsTable();

    }
}
