package org.example.niit.jukebox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {
    public Connection getAllSongDetails() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/anubhab1", "root", "root@123");
            System.out.println("connection established");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        boolean b = false;
        try {
            Statement st = connection.createStatement();
            String createQuery = "create table players(song_id int ,title varchar(100),artistName varchar(100),albumName varchar(100),duration double,path varchar(250),genere varchar(100))";
            b = st.execute(createQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("insert into players values(1,'Yaaro','kk','Pal',4.22,'E:/Project/jukebox/MusicPlayer/src/Players/Yaaron Dosti Badi Hi Haseen Hai.wav','sad')");
            st.executeUpdate("insert into players values(2,'Sochenge','Kumar Sanu','Deewana',6.03,'E:/Project/jukebox/MusicPlayer/src/Players/Sochenge Tumhe Pyar.wav','romantic')");
            st.executeUpdate("insert into players values(3,'Dill','Babul Supriyo','Kaho Na Pyar Hai',7.56,'E:/Project/jukebox/MusicPlayer/src/Players/Dil Ne Dil Ko Pukara.wav','romantic')");
            st.executeUpdate("insert into players values(4,'Chand','Raghab Chatterjee','Amar Akash',6.02,'E:/Project/jukebox/MusicPlayer/src/Players/Chand-Keno-Aase-Na.wav','sad')");
            st.executeUpdate("insert into players values(5,'Nilanjana','Nachiketa Chakroborty','Ei Besh Bhalo Achi',5.35,'E:/Project/jukebox/MusicPlayer/src/Players/Nilanjana---Pt.-1-Nachiketa.wav','romantic')");
            st.executeUpdate("insert into players values(6,'Bela','Anjan Dutta','Sunta Ki Chao',5.11,'E:/Project/jukebox/MusicPlayer/src/Players/Bela-Bose-Anjan-Dutt.wav','sad')");
            st.executeUpdate("insert into players values(7,'Mon','Raghab Chatterjee','Ebong Rabindranath',4.27,'E:/Project/jukebox/MusicPlayer/src/Players/Mon-More-Meghero-Raghab-Chatterjee.wav','romantic')");
            st.executeUpdate("insert into players values(8,'Maharaja','Anup Ghosahl','Gupi Gayan Baga Bayan',3.37,'E:/Project/jukebox/MusicPlayer/src/Players/Maharaja Tomare Selam.wav','happy')");
            st.executeUpdate("insert into players values(9,'Aha','Anup Ghoshal','Hirak Rajar Deshe',2.53,'E:/Project/jukebox/MusicPlayer/src/Players/Aha-Ki-Ananda-Anup-Ghoshal.wav','happy')");
            st.executeUpdate("insert into players values(10,'Barandaye','Surojit Chatterjee','Bhoomi',4.40,'E:/Project/jukebox/MusicPlayer/src/Players/Barandaye-Roddur-Bhoomi.wav','dance')");
            st.executeUpdate("insert into players values(11,'Bandhu','Upal Sengupta','Chandrabindu',7.33,'E:/Project/jukebox/MusicPlayer/src/Players/Bondhu Tomay.wav','soul')");
            st.executeUpdate("insert into players values(12,'Rimjhim','Shaan','Premer Kahani',5.11,'E:/Project/jukebox/MusicPlayer/src/Players/Rimjhim-E-Dharate.wav','romantic')");
            st.executeUpdate("insert into players values(13,'Jadu','Udit Narayan','Darr',4.39,'E:/Project/jukebox/MusicPlayer/src/Players/Jaadu Teri Nazar.wav','romantic')");
            st.executeUpdate("insert into players values(14,'Mera','Kumar Sanu','Yeh Mumbai Meri Jaan',5.50,'E:/Project/jukebox/MusicPlayer/src/Players/Mera Chand Mujhe Aaya Hai Nazar.wav','romantic')");
            st.executeUpdate("insert into players values(15,'Saanson','Kumar Sanu','Aashiqui',6.12,'E:/Project/jukebox/MusicPlayer/src/Players/Saanson Ki Zaroorat.wav','romantic')");
            st.executeUpdate("insert into players values(16,'Har','Sonu Nigam','Kal Ho Na Ho',4.47,'E:/Project/jukebox/MusicPlayer/src/Players/Har-Ghadi-Badal-Rahi-Hai.wav','sad')");
            st.executeUpdate("insert into players values(17,'Ruk','Udit Narayan','DDLJ',5.12,'E:/Project/jukebox/MusicPlayer/src/Players/Ruk Ja O Dil Deewane.wav','happy')");
            st.executeUpdate("insert into players values(18,'Tumse','SPB','Sajan',5.30,'E:/Project/jukebox/MusicPlayer/src/Players/Tumse Milne Ki Tamanna Hai Saajan.wav','happy')");
            st.executeUpdate("insert into players values(19,'Koto','Babul Supriyo','Katobaro Bhebechhinu',3.59,'E:/Project/jukebox/MusicPlayer/src/Players/Kotobaro Bhebechhinu.wav','romantic')");
            st.executeUpdate("insert into players values(20,'Sei','Abhijeet Bhattachariya','Sei Bhalo Sei Bhalo Abhijeet Bhattacharya',3.40,'E:/Project/jukebox/MusicPlayer/src/Players/Sei Bhalo, Sei Bhalo.wav','romantic')");
            st.executeUpdate("insert into players values(21,'Amake','Anupam Roy','Autograph',5.21,'E:/Project/jukebox/MusicPlayer/src/Players/Aamake-Amar-Moto-Thakte-Dao.wav','soul')");
            st.executeUpdate("insert into players values(22,'Pehli','Atif Aslam','Race',5.13,'E:/Project/jukebox/MusicPlayer/src/Players/Players/Pehli Nazar Mein Race.wav','romantic')");
            st.executeUpdate("insert into players values(23,'Tumi','Anupam Roy','Prakton',4.59,'E:/Project/jukebox/MusicPlayer/src/Players/Tumi Jake Bhalobaso.wav','sad')");
            st.executeUpdate("insert into players values(24,'Ki','Papon','ki kora bolbo tomai',4.56 ,'E:/Project/jukebox/MusicPlayer/src/Players/Ki Kore Bolbo Tomaye.wav','sad')");
            st.executeUpdate("insert into players values(25,'Maa','Shankar Mahadevan','Tare Zameen Par',5.10,'E:/Project/jukebox/MusicPlayer/src/Players/Taare Zameen Par.wav','sad')");
            st.executeUpdate("insert into players values(26,'Zara','kk','Jannat',5.03,'E:/Project/jukebox/MusicPlayer/src/Players/Zara Sa.wav','romantic')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Statement st = connection.createStatement();
            String createQuery = "create table users (userID varchar(100) primary key ,password varchar(100))";
            b = st.execute(createQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement st = connection.createStatement();
            st.executeUpdate("insert into users values('rootuser','pass1')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Song> songList= new ArrayList<>();
        Song song=null;

        Statement st= null;
        try {
            st = connection.createStatement();

            ResultSet resultSet= st.executeQuery("select * from players");
            while(resultSet.next()) {
                song = new Song();
                song.setSong_id(resultSet.getInt(1));
                song.setTitle(resultSet.getString(2));
                song.setArtistName(resultSet.getString(3));
                song.setAlbumName(resultSet.getString(4));
                song.setDuration(resultSet.getDouble(5));
                song.setPath(resultSet.getString(6));
                song.setGenere(resultSet.getString(7));
                songList.add(song);
                for (Song s1 : songList) {//for(type variable : listName){}
                    System.out.println(s1);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        try {
            st = connection.createStatement();

            ResultSet resultSet = st.executeQuery("select * from users");
            while (resultSet.next()) {
                System.out.println("user");
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.getAllSongDetails();
    }
}
