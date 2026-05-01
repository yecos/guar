package com.raizlabs.android.dbflow.converter;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class BigIntegerConverter extends TypeConverter<String, BigInteger> {
    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public String getDBValue(BigInteger bigInteger) {
        if (bigInteger == null) {
            return null;
        }
        return bigInteger.toString();
    }

    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public BigInteger getModelValue(String str) {
        if (str == null) {
            return null;
        }
        return new BigInteger(str);
    }
}
