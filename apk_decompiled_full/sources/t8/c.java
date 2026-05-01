package t8;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import s8.d;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Function f18934a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Function f18935b = new b();

    public static class a implements Function {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public t8.a apply(t8.a aVar) {
            switch (C0324c.f18936a[aVar.ordinal()]) {
                case 1:
                    return t8.a.DESTROY;
                case 2:
                    return t8.a.STOP;
                case 3:
                    return t8.a.PAUSE;
                case 4:
                    return t8.a.STOP;
                case 5:
                    return t8.a.DESTROY;
                case 6:
                    throw new s8.c("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + aVar + " not yet implemented");
            }
        }
    }

    public static class b implements Function {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public t8.b apply(t8.b bVar) {
            switch (C0324c.f18937b[bVar.ordinal()]) {
                case 1:
                    return t8.b.DETACH;
                case 2:
                    return t8.b.DESTROY;
                case 3:
                    return t8.b.DESTROY_VIEW;
                case 4:
                    return t8.b.STOP;
                case 5:
                    return t8.b.PAUSE;
                case 6:
                    return t8.b.STOP;
                case 7:
                    return t8.b.DESTROY_VIEW;
                case 8:
                    return t8.b.DESTROY;
                case 9:
                    return t8.b.DETACH;
                case 10:
                    throw new s8.c("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + bVar + " not yet implemented");
            }
        }
    }

    /* renamed from: t8.c$c, reason: collision with other inner class name */
    public static /* synthetic */ class C0324c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18936a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18937b;

        static {
            int[] iArr = new int[t8.b.values().length];
            f18937b = iArr;
            try {
                iArr[t8.b.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18937b[t8.b.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18937b[t8.b.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18937b[t8.b.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18937b[t8.b.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18937b[t8.b.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18937b[t8.b.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18937b[t8.b.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18937b[t8.b.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f18937b[t8.b.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[t8.a.values().length];
            f18936a = iArr2;
            try {
                iArr2[t8.a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f18936a[t8.a.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f18936a[t8.a.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f18936a[t8.a.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f18936a[t8.a.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f18936a[t8.a.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public static s8.b a(Observable observable) {
        return d.b(observable, f18934a);
    }

    public static s8.b b(Observable observable) {
        return d.b(observable, f18935b);
    }
}
