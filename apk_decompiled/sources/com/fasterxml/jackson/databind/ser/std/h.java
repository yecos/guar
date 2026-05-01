package com.fasterxml.jackson.databind.ser.std;

import java.text.DateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public class h extends l {

    /* renamed from: d, reason: collision with root package name */
    public static final h f6692d = new h();

    public h() {
        this(null, null);
    }

    public long g(Calendar calendar) {
        if (calendar == null) {
            return 0L;
        }
        return calendar.getTimeInMillis();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void serialize(Calendar calendar, c3.h hVar, k3.c0 c0Var) {
        if (d(c0Var)) {
            hVar.e0(g(calendar));
        } else {
            e(calendar.getTime(), hVar, c0Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.l
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public h f(Boolean bool, DateFormat dateFormat) {
        return new h(bool, dateFormat);
    }

    public h(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }
}
