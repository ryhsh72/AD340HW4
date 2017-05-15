package jamesno.hw1;

/**
 * Created by James No on 5/10/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("song_name")
    private String songTitle;
    @SerializedName("song_id")
    private String songYear;
    @SerializedName("artist_name")
    private String songAuthor;

    public Post(String songTitle, String songYear, String songAuthor) {
        this.songTitle = songTitle;
        this.songYear = songYear;
        this.songAuthor = songAuthor;
    }
    public String getSongTitle() {
        return songTitle;
    }
    public String getSongYear() {
        return songYear;
    }
    public String getSongAuthor() {
        return songAuthor;
    }
}