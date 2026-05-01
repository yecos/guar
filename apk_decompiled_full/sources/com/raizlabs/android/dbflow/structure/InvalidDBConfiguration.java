package com.raizlabs.android.dbflow.structure;

/* loaded from: classes3.dex */
public class InvalidDBConfiguration extends RuntimeException {
    public InvalidDBConfiguration() {
        super("No Databases were found. Did you create a Database Annotation placeholder class?");
    }

    public InvalidDBConfiguration(String str) {
        super(str);
    }
}
