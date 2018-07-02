package com.robynandcory.podfav;

/**
 * defines a new object called Podcast with a name, ranking and an image resource
 */

public class Podcast {
    //name of the podcast
    private String mPodcastName;

    //ranking of the podcast, an integer indicating position in the ranking table
    private int mRanking;

    //Drawable resource ID links to image from the podcast's free feed
    private int mImageRid;

    /**
     * Create a new Podcast:
     *
     * @param podcastName name of the podcast
     * @param ranking     integer indicating position in the ranking table
     * @param imageRid    Drawable resource ID links to image from the podcast's free feed
     */

    public Podcast(String podcastName, int ranking, int imageRid) {
        mPodcastName = podcastName;
        mRanking = ranking;
        mImageRid = imageRid;
    }

    //get the name of the podcast.
    public String getPodcastName() {
        return mPodcastName;
    }

    //get the ranking of the podcast
    public String getRanking() {
        return Integer.toString(mRanking);
    }

    //get the id of the image resource
    public int getImageRid() {
        return mImageRid;
    }
}
