package com.robynandcory.podfav;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.robynandcory.podfav.MainActivity.KEY_PODCAST;
import static com.robynandcory.podfav.MainActivity.KEY_RANKING;
import static com.robynandcory.podfav.MainActivity.KEY_IMG;


public class PodcastPlayer extends AppCompatActivity {

    /**
     * Shows a view with a single podcast in a classic player format.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_podcast);

        Intent receivePodcastIntent = getIntent();
        //check if the intent was received, otherwise use public static String
        if (null != receivePodcastIntent) {
            String podcastName = receivePodcastIntent.getStringExtra(KEY_PODCAST);
            String podcastRanking = receivePodcastIntent.getStringExtra(KEY_RANKING);
            int podcastRid = Integer.parseInt(receivePodcastIntent.getStringExtra(KEY_IMG));

            //Display the information from the Main Activity in the text views
            TextView nameTextView = findViewById(R.id.podcastName);
            nameTextView.setText(podcastName);

            TextView rankingTextView = findViewById(R.id.podcastRanking);
            rankingTextView.setText(podcastRanking);

            ImageView podcastImageView = findViewById(R.id.podcastImage);
            podcastImageView.setImageResource(podcastRid);

            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.elizabethjenningsgraham);


            ImageView play = findViewById(R.id.play);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start(); // no need to call prepare(); create() does that for you
                }
            });

            ImageView pause = findViewById(R.id.pause);
            pause.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            mediaPlayer.pause(); // no need to call prepare(); create() does that for you
                                        }
            });

        }




//public class podcastPlayer extends Service implements MediaPlayer.OnPreparedListener {
//            private static final String ACTION_PLAY = "com.example.action.Play";
//            MediaPlayer mMediaPlayer = null;
//
//            public int onPlay
//    //Add Media Player
//
//            podcastPlayer.release();
//    podcastPlayer =null;

    }
}