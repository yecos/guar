package com.raizlabs.android.dbflow.sql;

import com.raizlabs.android.dbflow.data.Blob;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum SQLiteType {
    INTEGER,
    REAL,
    TEXT,
    BLOB;

    private static final Map<String, SQLiteType> sTypeMap = new HashMap<String, SQLiteType>() { // from class: com.raizlabs.android.dbflow.sql.SQLiteType.1
        {
            String name = Byte.TYPE.getName();
            SQLiteType sQLiteType = SQLiteType.INTEGER;
            put(name, sQLiteType);
            put(Short.TYPE.getName(), sQLiteType);
            put(Integer.TYPE.getName(), sQLiteType);
            put(Long.TYPE.getName(), sQLiteType);
            String name2 = Float.TYPE.getName();
            SQLiteType sQLiteType2 = SQLiteType.REAL;
            put(name2, sQLiteType2);
            put(Double.TYPE.getName(), sQLiteType2);
            put(Boolean.TYPE.getName(), sQLiteType);
            String name3 = Character.TYPE.getName();
            SQLiteType sQLiteType3 = SQLiteType.TEXT;
            put(name3, sQLiteType3);
            String name4 = byte[].class.getName();
            SQLiteType sQLiteType4 = SQLiteType.BLOB;
            put(name4, sQLiteType4);
            put(Byte.class.getName(), sQLiteType);
            put(Short.class.getName(), sQLiteType);
            put(Integer.class.getName(), sQLiteType);
            put(Long.class.getName(), sQLiteType);
            put(Float.class.getName(), sQLiteType2);
            put(Double.class.getName(), sQLiteType2);
            put(Boolean.class.getName(), sQLiteType);
            put(Character.class.getName(), sQLiteType3);
            put(CharSequence.class.getName(), sQLiteType3);
            put(String.class.getName(), sQLiteType3);
            put(Byte[].class.getName(), sQLiteType4);
            put(Blob.class.getName(), sQLiteType4);
        }
    };

    public static boolean containsClass(String str) {
        return sTypeMap.containsKey(str);
    }

    public static SQLiteType get(String str) {
        return sTypeMap.get(str);
    }
}
