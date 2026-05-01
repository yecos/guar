package com.raizlabs.android.dbflow.converter;

import java.util.UUID;

/* loaded from: classes3.dex */
public class UUIDConverter extends TypeConverter<String, UUID> {
    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public String getDBValue(UUID uuid) {
        if (uuid != null) {
            return uuid.toString();
        }
        return null;
    }

    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public UUID getModelValue(String str) {
        if (str == null) {
            return null;
        }
        return UUID.fromString(str);
    }
}
