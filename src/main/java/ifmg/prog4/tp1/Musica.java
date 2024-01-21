/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifmg.prog4.tp1;

/**
 *
 * @author João
 */
public class Musica {
    
    String track_name;
    String artist_name;
    String artist_count;
    String released_year ;
    String released_month;
    String released_day;
    String in_spotify_playlists;
    String in_spotify_charts;
    String streams;
    String in_apple_playlists;
    String in_apple_charts;
    String in_deezer_playlists;
    String in_deezer_charts;
    String in_shazam_charts;
    String bpm;
    String key;
    String mode;
    String danceability_porcentagem;
    String valence_porcentagem;
    String energy_porcentagem;
    String acousticness_porcentagem;
    String instrumentalness_porcentagem;
    String liveness_porcentagem;
    String speechiness_porcentagem;

    public Musica(String track_name, String artist_name, String artist_count, String released_year, String released_month, String released_day, String in_spotify_playlists, String in_spotify_charts, String streams, String in_apple_playlists, String in_apple_charts, String in_deezer_playlists, String in_deezer_charts, String in_shazam_charts, String bpm, String key, String mode, String danceability_porcentagem, String valence_porcentagem, String energy_porcentagem, String acousticness_porcentagem, String instrumentalness_porcentagem, String liveness_porcentagem, String speechiness_porcentagem) {
        this.track_name = track_name;
        this.artist_name = artist_name;
        this.artist_count = artist_count;
        this.released_year = released_year;
        this.released_month = released_month;
        this.released_day = released_day;
        this.in_spotify_playlists = in_spotify_playlists;
        this.in_spotify_charts = in_spotify_charts;
        this.streams = streams;
        this.in_apple_playlists = in_apple_playlists;
        this.in_apple_charts = in_apple_charts;
        this.in_deezer_playlists = in_deezer_playlists;
        this.in_deezer_charts = in_deezer_charts;
        this.in_shazam_charts = in_shazam_charts;
        this.bpm = bpm;
        this.key = key;
        this.mode = mode;
        this.danceability_porcentagem = danceability_porcentagem;
        this.valence_porcentagem = valence_porcentagem;
        this.energy_porcentagem = energy_porcentagem;
        this.acousticness_porcentagem = acousticness_porcentagem;
        this.instrumentalness_porcentagem = instrumentalness_porcentagem;
        this.liveness_porcentagem = liveness_porcentagem;
        this.speechiness_porcentagem = speechiness_porcentagem;
    }

    public String getTrack_name() {
        return track_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    @Override
    public String toString() {
        return "música: " + track_name + " | artista: " + artist_name;
    }

    public int compareToArtistName(Musica o) {
        return this.artist_name.toLowerCase().compareTo(o.artist_name.toLowerCase());
    }
    
    
    public int compareToTrackName(Musica o) {
        return this.track_name.toLowerCase().compareTo(o.track_name.toLowerCase());
    }
   
}
