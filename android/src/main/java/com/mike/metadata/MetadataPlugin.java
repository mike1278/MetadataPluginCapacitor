package com.mike.metadata;

import android.os.Build;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.util.HashMap;

@CapacitorPlugin(name = "Metadata")
public class MetadataPlugin extends Plugin {

    private Metadata implementation;

    @Override
    public void load() {
        implementation = new Metadata(getContext());
    }

    @PluginMethod
    public void metadata(PluginCall call) throws Exception {
        String pathFile = call.getString("value");

        JSObject ret = new JSObject();
        HashMap<String, String> value;
        if (Build.VERSION.SDK_INT >= 30) {
            value = implementation.metadata(pathFile);
        } else {
            value = implementation.cursor(pathFile);
        }
        ret.put("metadata",value);
        call.resolve(ret);
    }
}
