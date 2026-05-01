package com.fasterxml.jackson.databind.ser.std;

import java.text.DateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class k extends l {

    /* renamed from: d, reason: collision with root package name */
    public static final k f6693d = new k();

    public k() {
        this(null, null);
    }

    public long g(Date date) {
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void serialize(Date date, c3.h hVar, k3.c0 c0Var) {
        if (d(c0Var)) {
            hVar.e0(g(date));
        } else {
            e(date, hVar, c0Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.l
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public k f(Boolean bool, DateFormat dateFormat) {
        return new k(bool, dateFormat);
    }

    public k(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }
}
