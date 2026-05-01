package com.hpplay.cybergarage.upnp.device;

import java.io.File;

/* loaded from: classes2.dex */
public class InvalidDescriptionException extends Exception {
    public InvalidDescriptionException() {
    }

    public InvalidDescriptionException(String str) {
        super(str);
    }

    public InvalidDescriptionException(String str, File file) {
        super(str + " (" + file.toString() + ")");
    }

    public InvalidDescriptionException(Exception exc) {
        super(exc.getMessage());
    }
}
