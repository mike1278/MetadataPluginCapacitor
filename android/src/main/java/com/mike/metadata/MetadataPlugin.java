package com.mike.metadata;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Metadata")
public class MetadataPlugin extends Plugin {

    private Metadata implementation = new Metadata();

    @PluginMethod
    public void metadata(PluginCall call) {
        String pathFile = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("metadata", implementation.metadata(pathFile));
        call.resolve(ret);
    }
}
