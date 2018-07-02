package com.robynandcory.podfav;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import static com.robynandcory.podfav.MainActivity.KEY_PODCAST;
import static com.robynandcory.podfav.MainActivity.KEY_RANKING;
import static com.robynandcory.podfav.MainActivity.KEY_IMG;


public class PodcastPlayer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_podcast);

Intent receivePodcastIntent = getIntent();
//check if the intent was received, otherwise use public static String
if (null!= receivePodcastIntent) {
    String podcastName = receivePodcastIntent.getStringExtra(KEY_PODCAST);
    String podcastRanking = receivePodcastIntent.getStringExtra(KEY_RANKING);
    int podcastRid = Integer.parseInt(receivePodcastIntent.getStringExtra(KEY_IMG));


    TextView nameTextView = findViewById(R.id.podcastName);
    nameTextView.setText(podcastName);

    TextView rankingTextView = findViewById(R.id.podcastRanking);
    rankingTextView.setText(podcastRanking);

    ImageView podcastImageView = findViewById(R.id.podcastImage);
   podcastImageView.setImageResource(podcastRid);
}

    }
}