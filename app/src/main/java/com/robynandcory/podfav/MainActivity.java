package com.robynandcory.podfav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * This app displays a list of podcasts and allows the user to click one to navigate to a Podcast Player activity.
 *
 * Sources:
 * Icons: All Icons in the app were provided for free use by CC 3.0 BY. from www.flaticon.com
 * Reference and instructions for how to set an OnclickListener on a custom adapter from Lizzy.
 * Thanks Lizzy! https://github.com/dizzy-miss-lizzy/MusicPlayer
 */

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Keys for the Podcast Data to pass into the Podcast Player
    public static final String KEY_PODCAST = "Podcast goes here";
    public static final String KEY_RANKING = "Ranking goes here";
    public static final String KEY_IMG = "Image R.id goes here";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add ArrayList of podcast objects
        ArrayList<Podcast> podcasts = new ArrayList<>();
        podcasts.add(new Podcast("Stuff You Missed In History Class", 1, R.drawable.mih));
        podcasts.add(new Podcast("My Favorite Murder", 2, R.drawable.mfm));
        podcasts.add(new Podcast("RadioLab", 3, R.drawable.rl));
        podcasts.add(new Podcast("Pod Save America", 4, R.drawable.psa));
        podcasts.add(new Podcast("This American Life", 5, R.drawable.tal));
        podcasts.add(new Podcast("Planet Money", 6, R.drawable.pm));
        podcasts.add(new Podcast("The Rachel Maddow Show", 7, R.drawable.rms));
        podcasts.add(new Podcast("99% invisible", 8, R.drawable.i99));
        podcasts.add(new Podcast("The Daily", 9, R.drawable.td));
        podcasts.add(new Podcast("Ted Radio Hour", 10, R.drawable.trh));


        final PodcastAdapter podcastAdapter =
                new PodcastAdapter(this, podcasts);

//link the custom adapter to the created ListView

        final ListView listView = findViewById(R.id.listview_podcasts);
        listView.setAdapter(podcastAdapter);

//Add an OnClickListener to the ListView. When Clicked, the intent transfers user to the PlayPodcast activity.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Podcast currentPodcast = podcastAdapter.getItem(position);
                Intent playPodcast = new Intent(getApplicationContext(), PodcastPlayer.class);
                playPodcast.putExtra(KEY_PODCAST, currentPodcast.getPodcastName());
                playPodcast.putExtra(KEY_RANKING, currentPodcast.getRanking());
                playPodcast.putExtra(KEY_IMG, currentPodcast.getImageRid() + "");
                startActivity(playPodcast);

            }
        });


    }
}

