/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifmg.prog4.tp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João
 */
public class Leitor {
public String caminhoDoArquivo;

    public Leitor(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }
     
    public ListaMusicas lerArquivoCSV() {
        
        ListaMusicas lista = new ListaMusicas();
        String arquivoCSV = caminhoDoArquivo;
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = splitCSVLine(linha);
                if (dados.length == 24) {
                    
                    String track_name = dados[0];
                    String artist_name = dados[1];
                    String artist_count = dados[2];
                    String released_year = dados[3];
                    String released_month = dados[4];
                    String released_day = dados[5];
                    String in_spotify_playlists = dados[6];
                    String in_spotify_charts = dados[7];
                    String streams = dados[8];
                    String in_apple_playlists = dados[9];
                    String in_apple_charts = dados[10];
                    String in_deezer_playlists = dados[11];
                    String in_deezer_charts = dados[12];
                    String in_shazam_charts = dados[13];
                    String bpm = dados[14];
                    String key = dados[15];
                    String mode = dados[16];
                    String danceability_porcentagem = dados[17];
                    String valence_porcentagem = dados[18];
                    String energy_porcentagem = dados[19];
                    String acousticness_porcentagem = dados[20];
                    String instrumentalness_porcentagem = dados[21];
                    String liveness_porcentagem = dados[22];
                    String speechiness_porcentagem = dados[23];

                    Musica música = new Musica(track_name, artist_name, artist_count, released_year, released_month, released_day, in_spotify_playlists, in_spotify_charts, streams, in_apple_playlists, in_apple_charts, in_deezer_playlists, in_deezer_charts, in_shazam_charts, bpm, key, mode, danceability_porcentagem, valence_porcentagem, energy_porcentagem, acousticness_porcentagem, instrumentalness_porcentagem, liveness_porcentagem, speechiness_porcentagem);;;
                    lista.add(música);
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    private static String[] splitCSVLine(String line) {
        List<String> data = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean withinQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                withinQuotes = !withinQuotes;
            } else if (c == ',' || (c == '"' && (i + 1 < line.length() && line.charAt(i + 1) == '"')) && !withinQuotes) {
                // Verifique se a vírgula é seguida por um espaço em branco
                if (i + 1 < line.length() && line.charAt(i + 1) == ' ') {
                    field.append(c); // Se seguida por espaço, adicione a vírgula ao campo
                }else if(i + 1 < line.length() && line.charAt(i + 1) == ',') {
                    field.append(0);
                }else {
                    data.add(field.toString().trim());
                    field.setLength(0);
                }
            } else {
                field.append(c);
            }
        }

        data.add(field.toString().trim());

        return data.toArray(new String[0]);
    }
    
}
