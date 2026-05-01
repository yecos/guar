package com.raizlabs.android.dbflow.structure.listener;

import android.content.ContentValues;

@Deprecated
/* loaded from: classes3.dex */
public interface ContentValuesListener {
    void onBindToContentValues(ContentValues contentValues);

    void onBindToInsertValues(ContentValues contentValues);
}
