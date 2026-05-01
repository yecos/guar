package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final a f3261a;

    public interface a {
        a.b a(int i10, int i11, int i12, Object obj);

        void b(a.b bVar);
    }

    public l(a aVar) {
        this.f3261a = aVar;
    }

    public final int a(List list) {
        boolean z10 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((a.b) list.get(size)).f3143a != 8) {
                z10 = true;
            } else if (z10) {
                return size;
            }
        }
        return -1;
    }

    public void b(List list) {
        while (true) {
            int a10 = a(list);
            if (a10 == -1) {
                return;
            } else {
                d(list, a10, a10 + 1);
            }
        }
    }

    public final void c(List list, int i10, a.b bVar, int i11, a.b bVar2) {
        int i12 = bVar.f3146d;
        int i13 = bVar2.f3144b;
        int i14 = i12 < i13 ? -1 : 0;
        int i15 = bVar.f3144b;
        if (i15 < i13) {
            i14++;
        }
        if (i13 <= i15) {
            bVar.f3144b = i15 + bVar2.f3146d;
        }
        int i16 = bVar2.f3144b;
        if (i16 <= i12) {
            bVar.f3146d = i12 + bVar2.f3146d;
        }
        bVar2.f3144b = i16 + i14;
        list.set(i10, bVar2);
        list.set(i11, bVar);
    }

    public final void d(List list, int i10, int i11) {
        a.b bVar = (a.b) list.get(i10);
        a.b bVar2 = (a.b) list.get(i11);
        int i12 = bVar2.f3143a;
        if (i12 == 1) {
            c(list, i10, bVar, i11, bVar2);
        } else if (i12 == 2) {
            e(list, i10, bVar, i11, bVar2);
        } else {
            if (i12 != 4) {
                return;
            }
            f(list, i10, bVar, i11, bVar2);
        }
    }

    public void e(List list, int i10, a.b bVar, int i11, a.b bVar2) {
        boolean z10;
        int i12 = bVar.f3144b;
        int i13 = bVar.f3146d;
        boolean z11 = false;
        if (i12 < i13) {
            if (bVar2.f3144b == i12 && bVar2.f3146d == i13 - i12) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
        } else if (bVar2.f3144b == i13 + 1 && bVar2.f3146d == i12 - i13) {
            z10 = true;
            z11 = true;
        } else {
            z10 = true;
        }
        int i14 = bVar2.f3144b;
        if (i13 < i14) {
            bVar2.f3144b = i14 - 1;
        } else {
            int i15 = bVar2.f3146d;
            if (i13 < i14 + i15) {
                bVar2.f3146d = i15 - 1;
                bVar.f3143a = 2;
                bVar.f3146d = 1;
                if (bVar2.f3146d == 0) {
                    list.remove(i11);
                    this.f3261a.b(bVar2);
                    return;
                }
                return;
            }
        }
        int i16 = bVar.f3144b;
        int i17 = bVar2.f3144b;
        a.b bVar3 = null;
        if (i16 <= i17) {
            bVar2.f3144b = i17 + 1;
        } else {
            int i18 = bVar2.f3146d;
            if (i16 < i17 + i18) {
                bVar3 = this.f3261a.a(2, i16 + 1, (i17 + i18) - i16, null);
                bVar2.f3146d = bVar.f3144b - bVar2.f3144b;
            }
        }
        if (z11) {
            list.set(i10, bVar2);
            list.remove(i11);
            this.f3261a.b(bVar);
            return;
        }
        if (z10) {
            if (bVar3 != null) {
                int i19 = bVar.f3144b;
                if (i19 > bVar3.f3144b) {
                    bVar.f3144b = i19 - bVar3.f3146d;
                }
                int i20 = bVar.f3146d;
                if (i20 > bVar3.f3144b) {
                    bVar.f3146d = i20 - bVar3.f3146d;
                }
            }
            int i21 = bVar.f3144b;
            if (i21 > bVar2.f3144b) {
                bVar.f3144b = i21 - bVar2.f3146d;
            }
            int i22 = bVar.f3146d;
            if (i22 > bVar2.f3144b) {
                bVar.f3146d = i22 - bVar2.f3146d;
            }
        } else {
            if (bVar3 != null) {
                int i23 = bVar.f3144b;
                if (i23 >= bVar3.f3144b) {
                    bVar.f3144b = i23 - bVar3.f3146d;
                }
                int i24 = bVar.f3146d;
                if (i24 >= bVar3.f3144b) {
                    bVar.f3146d = i24 - bVar3.f3146d;
                }
            }
            int i25 = bVar.f3144b;
            if (i25 >= bVar2.f3144b) {
                bVar.f3144b = i25 - bVar2.f3146d;
            }
            int i26 = bVar.f3146d;
            if (i26 >= bVar2.f3144b) {
                bVar.f3146d = i26 - bVar2.f3146d;
            }
        }
        list.set(i10, bVar2);
        if (bVar.f3144b != bVar.f3146d) {
            list.set(i11, bVar);
        } else {
            list.remove(i11);
        }
        if (bVar3 != null) {
            list.add(i10, bVar3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(List list, int i10, a.b bVar, int i11, a.b bVar2) {
        a.b a10;
        int i12;
        int i13;
        int i14 = bVar.f3146d;
        int i15 = bVar2.f3144b;
        a.b bVar3 = null;
        if (i14 < i15) {
            bVar2.f3144b = i15 - 1;
        } else {
            int i16 = bVar2.f3146d;
            if (i14 < i15 + i16) {
                bVar2.f3146d = i16 - 1;
                a10 = this.f3261a.a(4, bVar.f3144b, 1, bVar2.f3145c);
                i12 = bVar.f3144b;
                i13 = bVar2.f3144b;
                if (i12 > i13) {
                    bVar2.f3144b = i13 + 1;
                } else {
                    int i17 = bVar2.f3146d;
                    if (i12 < i13 + i17) {
                        int i18 = (i13 + i17) - i12;
                        bVar3 = this.f3261a.a(4, i12 + 1, i18, bVar2.f3145c);
                        bVar2.f3146d -= i18;
                    }
                }
                list.set(i11, bVar);
                if (bVar2.f3146d <= 0) {
                    list.set(i10, bVar2);
                } else {
                    list.remove(i10);
                    this.f3261a.b(bVar2);
                }
                if (a10 != null) {
                    list.add(i10, a10);
                }
                if (bVar3 == null) {
                    list.add(i10, bVar3);
                    return;
                }
                return;
            }
        }
        a10 = null;
        i12 = bVar.f3144b;
        i13 = bVar2.f3144b;
        if (i12 > i13) {
        }
        list.set(i11, bVar);
        if (bVar2.f3146d <= 0) {
        }
        if (a10 != null) {
        }
        if (bVar3 == null) {
        }
    }
}
