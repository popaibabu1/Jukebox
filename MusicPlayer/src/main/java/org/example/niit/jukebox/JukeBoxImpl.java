package org.example.niit.jukebox;
import org.example.jukebox.JukeBox;
import org.example.jukebox.Playlist;
import org.example.niit.jukebox.Song;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class JukeBoxImpl {

    private static boolean incorrect(String username, String password){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/anubhab1", "root", "root@123");
            System.out.println("connection established");
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("Select * from users where (userID = '"+username+"' AND password = '"+password+"');");
            while(resultSet.next()){
                return false;
            }
            return true ;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false ;
    }
    private static void update_user(String username, String password){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/anubhab1", "root", "root@123");
            System.out.println("connection established");
            Statement st = connection.createStatement();
            String createQuery = "insert into users values('"+username+"','"+password+"');";
            boolean b = st.execute(createQuery);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        System.out.println("want to login or sign in");
        String response="";
        response=scanner.nextLine();
        switch (response) {
            case "login":
                System.out.println("Login");
                System.out.println("Enter username");
                String username = scanner.nextLine();
                System.out.println("Enter password");
                String password = scanner.nextLine();
                while (incorrect(username, password)) {
                    System.out.println("Incorrect username password pair. Login again.");
                    System.out.println("Enter username");
                    username = scanner.nextLine();
                    System.out.println("Enter password");
                    password = scanner.nextLine();

                }
                break;
            case "sign in":
                System.out.println("Enter username");
                String userID = scanner.nextLine();
                System.out.println("Enter password");
                String pass = scanner.nextLine();
                update_user(userID, pass);
                break;
            default:
                System.out.println("Enter \"login\" or \"sign in\"");
        }
        System.out.println("Successful log in");
        JukeBox jukeBox = new JukeBox();
        Playlist playlist=new Playlist();
        jukeBox.addSong(new Song(1,"Yaaro", "kk", "Pal", 4.22, "E:/Project/jukebox/MusicPlayer/src/Players/Yaaron Dosti Badi Hi Haseen Hai.wav", "sad"));
        jukeBox.addSong(new Song(2,"Sochenge", "Kumar Sanu", "Deewana", 6.02, "E:/Project/jukebox/MusicPlayer/src/Players/Sochenge Tumhe Pyar.wav", "romantic"));
        jukeBox.addSong(new Song(3,"Dil","Babul Supriyo","Kaho Na Pyar Hai",7.56,"E:/Project/jukebox/MusicPlayer/src/Players/Dil Ne Dil Ko Pukara.wav","romantic"));
        jukeBox.addSong(new Song(4,"Chand", "Raghab Chatterjee", "Amar Akash", 6.02, "E:/Project/jukebox/MusicPlayer/src/Players/Chand-Keno-Aase-Na.wav", "sad"));
        jukeBox.addSong(new Song(5,"Nilanjana", "Nachiketa Chakroborty", "Ei Besh Bhalo Achi", 5.35, "E:/Project/jukebox/MusicPlayer/src/Players/Nilanjana---Pt.-1-Nachiketa.wav", "romantic"));
        jukeBox.addSong(new Song(6,"Bela", "Anjan Dutta", "Sunta Ki Chao", 5.11, "E:/Project/jukebox/MusicPlayer/src/Players/Bela-Bose-Anjan-Dutt.wav", "sad"));
        jukeBox.addSong(new Song(7,"Mon","Raghab Chatterjee","Ebong Rabindranath",4.27,"E:/Project/jukebox/MusicPlayer/src/Players/Mon-More-Meghero-Raghab-Chatterjee.wav","romantic"));
        jukeBox.addSong(new Song(8,"Maharaja","Anup Ghoshal","Gupi Gayan Baga Bayan",3.37,"E:/Project/jukebox/MusicPlayer/src/Players/Maharaja Tomare Selam.wav","happy"));
        jukeBox.addSong(new Song(9,"Aha","Anup Ghoshal","Hirak Rajar Deshe",2.53,"E:/Project/jukebox/MusicPlayer/src/Players/Aha-Ki-Ananda-Anup-Ghoshal.wav","happy"));
        jukeBox.addSong(new Song(10,"Barandaye","Surojit Chatterjee","Bhoomi",4.40,"E:/Project/jukebox/MusicPlayer/src/Players/Barandaye-Roddur-Bhoomi.wav","happy"));
        jukeBox.addSong(new Song(11,"Bandhu","Upal Sengupta","Chandrabindu",7.33,"E:/Project/jukebox/MusicPlayer/src/Players/Bondhu Tomay.wav","soul"));
        jukeBox.addSong(new Song(12,"Rimjhim","Shaan","Premer Kahani",5.11,"E:/Project/jukebox/MusicPlayer/src/Players/Rimjhim-E-Dharate.wav","romantic"));
        jukeBox.addSong(new Song(13,"Jadu","Udit Narayan","Darr",4.39,"E:/Project/jukebox/MusicPlayer/src/Players/Jaadu Teri Nazar.wav","romantic"));
        jukeBox.addSong(new Song(14,"Mera","Kumar Sanu","Yeh Mumbai Meri Jaan",5.50,"E:/Project/jukebox/MusicPlayer/src/Players/Mera Chand Mujhe Aaya Hai Nazar.wav","romantic"));
        jukeBox.addSong(new Song(15,"Saanson","Kumar Sanu","Aashiqui",6.12,"E:/Project/jukebox/MusicPlayer/src/Players/Saanson Ki Zaroorat.wav","romantic"));
        jukeBox.addSong(new Song(16,"Har","Sonu Nigam","Kal Ho Na Ho",4.47,"E:/Project/jukebox/MusicPlayer/src/Players/Har-Ghadi-Badal-Rahi-Hai.wav","sad"));
        jukeBox.addSong(new Song(17,"Ruk","Udit Narayan","DDLJ",5.12,"E:/Project/jukebox/MusicPlayer/src/Players/Ruk Ja O Dil Deewane.wav","happy"));
        jukeBox.addSong(new Song(18,"Tumse","SPB","Sajan",5.30,"E:/Project/jukebox/MusicPlayer/src/Players/Tumse Milne Ki Tamanna Hai Saajan.wav","happy"));
        jukeBox.addSong(new Song(19,"Koto","Babul Supriyo","Katobaro Bhebechhinu",3.59,"E:/Project/jukebox/MusicPlayer/src/Players/Kotobaro Bhebechhinu.wav","romantic"));
        jukeBox.addSong(new Song(20,"Sei","Abhijeet Bhattachariya","Sei Bhalo Sei Bhalo Abhijeet Bhattacharya",3.40,"E:/Project/jukebox/MusicPlayer/src/Players/Sei Bhalo, Sei Bhalo.wav","romantic"));
        jukeBox.addSong(new Song(21,"Amake","Anupam Roy","Autograph",5.21,"E:/Project/jukebox/MusicPlayer/src/Players/Aamake-Amar-Moto-Thakte-Dao.wav","soul"));
        jukeBox.addSong(new Song(22,"Pehli","Atif Aslam","Race",5.13,"E:/Project/jukebox/MusicPlayer/src/Players/Pehli Nazar Mein Race.wav","romantic"));
        jukeBox.addSong(new Song(23,"Tumi","Anupam Roy","Prakton",4.59,"E:/Project/jukebox/MusicPlayer/src/Players/Tumi Jake Bhalobaso.wav","sad"));
        jukeBox.addSong(new Song(24,"Ki","Papon","Ki kora bolbo tomai",4.56,"E:/Project/jukebox/MusicPlayer/src/Players/Ki Kore Bolbo Tomaye.wav","sad"));
        jukeBox.addSong(new Song(25,"Maa","Shankar Mahadevan","Tara Zameen Par",5.10,"E:/Project/jukebox/MusicPlayer/src/Players/Taare Zameen Par.wav","sad"));
        jukeBox.addSong(new Song(26,"Zara","kk","Jannat",5.03,"E:/Project/jukebox/MusicPlayer/src/Players/Zara Sa.wav","romantic"));
        while (true) {
            System.out.println("\n option: ");
            System.out.println("1.songs list");
            System.out.println("2.search title and play song ");;
            System.out.println("3.search genere and play song ");
            System.out.println("4.search artist name and play song ");
            System.out.println("5.create playlist ");
            System.out.println("6.view playlists ");
            System.out.println("7.add song in playlists ");
            System.out.println("8. play song in playlists ");
            System.out.println("9.display songs in playlists ");
            System.out.println("10.search id and play song ");
            System.out.println("11.search album and play song ");
            System.out.println("12. search duration and play song ");
            System.out.println("13.play songs ");
            System.out.println("14.quit ");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("Choice " + choice);
            switch (choice) {
                case 1:
                    System.out.println("Case 1");
                    jukeBox.listSongs();
                    break;
                case 2:
                    System.out.println("Enter the title of the song to search: ");
                    Scanner scanner1=new Scanner(System.in);
                    String searchTitle;
                    searchTitle= scanner1.nextLine();
                    List<Song>result=jukeBox.searchByTitle(searchTitle);
                    if(result.isEmpty()){
                        System.out.println("no matching song: "+searchTitle);
                    }else{
                        System.out.println("Songs in the artists: "  + searchTitle);
                        for (Song song : result){
                            System.out.println("Title: "+song.getTitle());
                            System.out.println("Duration: "+song.getDuration());
                            System.out.println("Artist: "+song.getArtistName());
                            System.out.println("Id: "+song.getSong_id());
                            System.out.println("Genere: "+song.getGenere());
                            System.out.println();
                            jukeBox.playSongTitle(song.getTitle());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter genere of songs: ");
                    Scanner sc=new Scanner(System.in);
                    String searchGenre ;
                    searchGenre=sc.nextLine();
                    List<Song> matchingSongs = jukeBox.searchByGenre(searchGenre);

                    if (matchingSongs.isEmpty()) {
                        System.out.println("No songs found in the genre: " + searchGenre);
                    } else {
                        System.out.println("Songs in the genre: " + searchGenre);
                        for (Song song : matchingSongs) {
                            System.out.println("Title: "+song.getTitle());
                            System.out.println("Id : " + song.getSong_id());
                            System.out.println("Artist: " + song.getArtistName());
                            System.out.println("Album: " + song.getAlbumName());
                            System.out.println("Duration: "+song.getDuration());
                            System.out.println();
                            jukeBox.playSongByGenere(song.getTitle());
                        }
                    }
                    break;
                case 4:
                    System.out.println("enter the artist name: ");
                    Scanner scanner3=new Scanner(System.in);
                    String artistToSearch = scanner3.nextLine();
                    List<Song> songsByArtist = jukeBox.searchByArtist(artistToSearch);

                    if (songsByArtist.isEmpty()) {
                        System.out.println("No songs found by " + artistToSearch);
                    } else {
                        System.out.println("Songs by : " + artistToSearch);
                        for (Song song : songsByArtist) {
                            System.out.println("Id: "+song.getSong_id());
                            System.out.println("Title: " +song.getTitle());
                            System.out.println("Album: "+song.getAlbumName());
                            System.out.println("Duration: "+song.getDuration());
                            System.out.println("Genere: "+song.getGenere());
                            System.out.println();
                            jukeBox.playSongByArtist(song.getTitle());
                        }
                    }
                    break;
                case 5:
                    playlist.createPlaylist();
                    break;
                case 6:
                    playlist.viewPlaylists();
                    break;
                case 7:
                    playlist.addSongPlaylist();
                    break;
                case 8:
                    playlist.playSongPlaylist();
                    break;
                case 9:
                    playlist.displaySongsInPlaylist();
                    break;
                case 10:
                    System.out.println("Enter the id name: ");
                    Scanner scanner4=new Scanner(System.in);
                    int idToSearch = scanner4.nextInt();
                    List<Song>songById=jukeBox.findSongById(idToSearch);

                    if (songById.isEmpty()) {
                        System.out.println("No songs found by " + idToSearch);
                    } else {
                        System.out.println("Songs by: " + idToSearch);
                        for (Song song : songById) {
                            System.out.println("Artist: " + song.getArtistName());
                            System.out.println("Title: " +song.getTitle());
                            System.out.println("Album: "+song.getAlbumName());
                            System.out.println("Duration: "+song.getDuration());
                            System.out.println("Genere: "+song.getGenere());
                            System.out.println();
                            jukeBox.playSongId(song.getTitle());
                        }
                    }
                    break;
                case 11:
                    System.out.println("Enter album name: ");
                    Scanner scanner5=new Scanner(System.in);
                    String Album=scanner5.nextLine();
                    List<Song> searchResults = jukeBox.searchByAlbum(Album);
                    if(searchResults.isEmpty()){
                        System.out.println("No song found by: "+Album);
                    }else {
                        System.out.println("Songs in album : " + Album);
                        for (Song song : searchResults) {
                            System.out.println("Id : " + song.getSong_id());
                            System.out.println("Artist: " + song.getArtistName());
                            System.out.println("Title: " +song.getTitle());
                            System.out.println("Duration: " +song.getDuration());
                            System.out.println("Genere: " +song.getGenere());
                            System.out.println();
                            jukeBox.playSongAlbum(song.getTitle());
                        }
                    }
                    break;
                case 12:
                    System.out.println("enter the duration: ");
                    Scanner scanner6=new Scanner(System.in);
                    double duration=scanner6.nextDouble();
                    List<Song>results=jukeBox.searchByDuration(duration);
                    if(results.isEmpty()){
                        System.out.println("no song found by "+duration);
                    }else {
                        System.out.println("Songs in duration: " + duration);
                        for (Song song : results) {
                            System.out.println("Id : "+song.getSong_id());
                            System.out.println("Album : " +song.getAlbumName());
                            System.out.println("Artist: " +song.getArtistName());
                            System.out.println("Title: " +song.getTitle());
                            System.out.println("Genere: "+song.getGenere());
                            System.out.println();
                            jukeBox.playSongDuration(song.getTitle());
                        }
                    }
                    break;
                case 13:
                    System.out.println("Play song");
                    jukeBox.playSong();
                    break;
                case 14:
                    System.out.println("Good bye. Thank you to use jukebox.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
