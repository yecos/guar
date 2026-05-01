package com.taobao.accs.data;

import java.util.Comparator;

/* loaded from: classes3.dex */
class b implements Comparator<Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9101a;

    public b(a aVar) {
        this.f9101a = aVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Integer num, Integer num2) {
        return num.intValue() - num2.intValue();
    }
}
