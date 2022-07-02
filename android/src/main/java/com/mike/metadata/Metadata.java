package com.mike.metadata;

import android.media.MediaMetadataRetriever;
import android.util.Log;

public class Metadata {

    public String[] metadata(String pathFile) {
        Log.i("Metadata", pathFile);
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(pathFile);

        String album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
        String albumArtist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST);
        String artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        String author = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_AUTHOR);
        String date = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DATE);
        String title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        String duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

        return new String[]{
                album,
                albumArtist,
                artist,
                author,
                date,
                title,
                duration,
        };
    }
}
