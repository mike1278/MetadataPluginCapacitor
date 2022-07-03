package com.mike.metadata;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.util.HashMap;

public class Metadata {
    Context context;

    public Metadata(Context context) {
        this.context = context;
    }

    public HashMap<String, String> metadata(String pathFile) {
        Log.i("Metadata", pathFile);
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            retriever.setDataSource(pathFile);
        } catch (Exception e) {
            Log.i("Metadata Exception", e.getMessage());
        }

        HashMap<String, String> value = new HashMap<>();
        value.put("album", retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
        value.put("albumArtist", retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST));
        value.put("artist", retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
        value.put("author", retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_AUTHOR));
        value.put("date", retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DATE));
        value.put("title", retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        value.put("duration", retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));

        return value;
    }

    public HashMap<String, String> cursor(String pathFile) {
        Log.i("Metadata", pathFile.replace("file:///storage/emulated/0//Music/", ""));
        String[] projection = {
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DISPLAY_NAME,
        };
        Cursor cursor = null;
        try {
            Log.i("Cursor", "Getting cursor");

            cursor = this.context.getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    projection,
                    null,
                    null,
                    null
            );

            Log.i("Cursor", "Obtained");
        } catch (Exception e) {
            Log.i("Cursor", "Error");
            Log.e("Cursor", e.getMessage());
        }

        HashMap<String, String> value = new HashMap<>();

        Log.i("Cursor", cursor == null ? "I am null" : "Yeah");
        if (cursor != null) {
            Log.i("Cursor message", "Cursor is not null");
            Log.i("Cursor count", "" + cursor.getCount());
            while (cursor.moveToNext()) {
                Log.i("Metadata message", "Cursor is not empty");
                value.put("album", cursor.getString(0));
                value.put("title", cursor.getString(1));
                value.put("duration", cursor.getString(2));
                value.put("date", cursor.getString(3));
                value.put("artist", cursor.getString(4));
                value.put("displayName", cursor.getString(5));
            }
            cursor.close();
        }
        Log.i("Cursor", "Finished");

        return value;
    }
}
