package com.example.a16022934.lyrics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etArtist, etSong;
    Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch = findViewById(R.id.btnSearch);
        etArtist = findViewById(R.id.etArtist);
        etSong = findViewById(R.id.etSong);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String artist = etArtist.getText().toString();
                String song = etSong.getText().toString();
                String apiKey = "xIkE2KocTQFad6ZJ1DpBVmMABoFi4IVmL8kqxYcGFmhdWT7ZBNeuzw0ue3xEp3ht";
                String url = "https://orion.apiseeds.com/api/music/lyric/" + artist + "/"+ song + "?apikey=" + apiKey;
                String format = url.replace(" ", "%20");
                Intent intent = new Intent(MainActivity.this, Lyrics.class);
                intent.putExtra("url", format);
                startActivity(intent);
            }
        });
    }



    // Code for step 2 end
}
