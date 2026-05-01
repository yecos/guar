package com.hpplay.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.hpplay.glide.load.data.DataFetcher;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.File;

/* loaded from: classes2.dex */
public class StringLoader<T> implements ModelLoader<String, T> {
    private final ModelLoader<Uri, T> uriLoader;

    public StringLoader(ModelLoader<Uri, T> modelLoader) {
        this.uriLoader = modelLoader;
    }

    private static Uri toFileUri(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.hpplay.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(String str, int i10, int i11) {
        Uri fileUri;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(Operator.Operation.DIVISION)) {
            fileUri = toFileUri(str);
        } else {
            Uri parse = Uri.parse(str);
            fileUri = parse.getScheme() == null ? toFileUri(str) : parse;
        }
        return this.uriLoader.getResourceFetcher(fileUri, i10, i11);
    }
}
