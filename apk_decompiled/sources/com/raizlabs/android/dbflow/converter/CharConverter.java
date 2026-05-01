package com.raizlabs.android.dbflow.converter;

/* loaded from: classes3.dex */
public class CharConverter extends TypeConverter<String, Character> {
    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public String getDBValue(Character ch) {
        if (ch != null) {
            return new String(new char[]{ch.charValue()});
        }
        return null;
    }

    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public Character getModelValue(String str) {
        if (str != null) {
            return Character.valueOf(str.charAt(0));
        }
        return null;
    }
}
