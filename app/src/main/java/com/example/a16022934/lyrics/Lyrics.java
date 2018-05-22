package com.example.a16022934.lyrics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class Lyrics extends AppCompatActivity {
    TextView tvArtist, tvSong, tvLyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
        tvArtist = findViewById(R.id.tvArtist);
        tvLyrics = findViewById(R.id.tvLyrics);
        tvSong = findViewById(R.id.tvSong);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvArtist = findViewById(R.id.tvArtist);
        tvLyrics = findViewById(R.id.tvLyrics);
        tvSong = findViewById(R.id.tvSong);

        Intent i = getIntent();
        String url = i.getStringExtra("url");
        HttpRequest request = new HttpRequest(url);
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
    }

    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response) {

                    // process response here
                    try {

                        tvArtist = findViewById(R.id.tvArtist);
                        tvLyrics = findViewById(R.id.tvLyrics);
                        tvSong = findViewById(R.id.tvSong);
                        JSONObject jsonObj = new JSONObject(response);
                        JSONObject result = (JSONObject) jsonObj.get("result");
                        JSONObject artist = (JSONObject) result.get("artist");
                        JSONObject song = (JSONObject) result.get("track");
                        String name = (String)artist.get("name");
                        String songName = (String)song.get("name");
                        String lyrics = (String)song.get("text");
                        tvArtist.setText(name);
                        tvLyrics.setText(lyrics);
                        tvSong.setText(songName);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
}
