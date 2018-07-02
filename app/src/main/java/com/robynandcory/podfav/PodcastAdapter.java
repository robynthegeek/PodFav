package com.robynandcory.podfav;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link PodcastAdapter} extends {@link ArrayAdapter}. Creates a layout for a given ArrayList of {@link Podcast} objects
 */
public class PodcastAdapter extends ArrayAdapter<Podcast> {
    private static final String LOG_TAG = PodcastAdapter.class.getSimpleName();

    /**
     * custom constructor, inflates layout file and populates the list.
     * @param context current context for layout file
     * @param podcasts an ArrayList of podcasts to display in list on screen
     */

    public PodcastAdapter(Activity context, ArrayList<Podcast> podcasts) {
        super(context, 0 , podcasts);
    }

    /**
     * Makes a view for the AdapterView
     * @param position position in the Array that should be displayed in the list
     * @param newView the view to populate
     * @param parent the parent ViewGroup where the new view will be inflated
     * @return the correct View for the position in the AdapterView
     */
    @NonNull

    @Override
    public View getView(int position, @Nullable View newView, @NonNull ViewGroup parent) {

        View podcastItemView = newView;
        if(podcastItemView == null) {
            podcastItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.podcasts, parent, false);
        }

        //get {@link Podcast} object located at this ArrayList Position
        Podcast currentPodcast = getItem(position);

        /**
         * find the Name TextView we want to populate in the podcasts.xml layout file
         * that has the ID podcastName and populate it with the name stored for the given podcast
         */

        TextView nameTextView = podcastItemView.findViewById(R.id.podcastName);
        nameTextView.setText(currentPodcast.getPodcastName());


        /**
         * find the TextView we want to populate in the podcasts.xml layout file
         * that has the ID podcastRanking and populate it with the ranking stored for the given podcast
         */

        TextView rankingTextView = podcastItemView.findViewById(R.id.podcastRanking);
        rankingTextView.setText(currentPodcast.getRanking());

        /**
         * find the ImageView we want to populate in the podcasts.xml layout file
         * that has the ID podcastRanking and populate it with the image stored for the given podcast
         */
        ImageView podcastImageView = podcastItemView.findViewById(R.id.podcastImage);
        podcastImageView.setImageResource(currentPodcast.getImageRid());

        return podcastItemView;
    }
}
