package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: classes.dex */
public class IdentifierIdObserver extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17969a = "VMS_SDK_Observer";

    /* renamed from: b, reason: collision with root package name */
    private String f17970b;

    /* renamed from: c, reason: collision with root package name */
    private int f17971c;

    /* renamed from: d, reason: collision with root package name */
    private IdentifierIdClient f17972d;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i10, String str) {
        super(null);
        this.f17972d = identifierIdClient;
        this.f17971c = i10;
        this.f17970b = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        IdentifierIdClient identifierIdClient = this.f17972d;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.f17971c, this.f17970b);
        } else {
            Log.e(f17969a, "mIdentifierIdClient is null");
        }
    }
}
