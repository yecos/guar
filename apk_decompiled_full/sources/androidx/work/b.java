package androidx.work;

import a1.k;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String f3644b = k.f("Data");

    /* renamed from: c, reason: collision with root package name */
    public static final b f3645c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public Map f3646a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Map f3647a = new HashMap();

        public b a() {
            b bVar = new b(this.f3647a);
            b.k(bVar);
            return bVar;
        }

        public a b(String str, Object obj) {
            if (obj == null) {
                this.f3647a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f3647a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f3647a.put(str, b.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f3647a.put(str, b.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f3647a.put(str, b.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.f3647a.put(str, b.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.f3647a.put(str, b.d((float[]) obj));
                } else {
                    if (cls != double[].class) {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                    }
                    this.f3647a.put(str, b.c((double[]) obj));
                }
            }
            return this;
        }

        public a c(b bVar) {
            d(bVar.f3646a);
            return this;
        }

        public a d(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                b((String) entry.getKey(), entry.getValue());
            }
            return this;
        }

        public a e(String str, String str2) {
            this.f3647a.put(str, str2);
            return this;
        }
    }

    public b(b bVar) {
        this.f3646a = new HashMap(bVar.f3646a);
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x005d -> B:16:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b g(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream;
        Throwable e10;
        if (bArr.length > 10240) {
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }
        HashMap hashMap = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
        } catch (IOException e11) {
            Log.e(f3644b, "Error in Data#fromByteArray: ", e11);
        }
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                        hashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e12) {
                        Log.e(f3644b, "Error in Data#fromByteArray: ", e12);
                    }
                    byteArrayInputStream.close();
                } catch (IOException e13) {
                    e10 = e13;
                    Log.e(f3644b, "Error in Data#fromByteArray: ", e10);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e14) {
                            Log.e(f3644b, "Error in Data#fromByteArray: ", e14);
                        }
                    }
                    byteArrayInputStream.close();
                    return new b(hashMap);
                } catch (ClassNotFoundException e15) {
                    e10 = e15;
                    Log.e(f3644b, "Error in Data#fromByteArray: ", e10);
                    if (objectInputStream != null) {
                    }
                    byteArrayInputStream.close();
                    return new b(hashMap);
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e16) {
                        Log.e(f3644b, "Error in Data#fromByteArray: ", e16);
                    }
                }
                try {
                    byteArrayInputStream.close();
                    throw th;
                } catch (IOException e17) {
                    Log.e(f3644b, "Error in Data#fromByteArray: ", e17);
                    throw th;
                }
            }
        } catch (IOException e18) {
            e = e18;
            Throwable th3 = e;
            objectInputStream = null;
            e10 = th3;
            Log.e(f3644b, "Error in Data#fromByteArray: ", e10);
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            return new b(hashMap);
        } catch (ClassNotFoundException e19) {
            e = e19;
            Throwable th32 = e;
            objectInputStream = null;
            e10 = th32;
            Log.e(f3644b, "Error in Data#fromByteArray: ", e10);
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            return new b(hashMap);
        } catch (Throwable th4) {
            th = th4;
            if (0 != 0) {
            }
            byteArrayInputStream.close();
            throw th;
        }
        return new b(hashMap);
    }

    public static byte[] k(b bVar) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e10) {
            e = e10;
        }
        try {
            objectOutputStream.writeInt(bVar.j());
            for (Map.Entry entry : bVar.f3646a.entrySet()) {
                objectOutputStream.writeUTF((String) entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e11) {
                Log.e(f3644b, "Error in Data#toByteArray: ", e11);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e12) {
                Log.e(f3644b, "Error in Data#toByteArray: ", e12);
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException e13) {
            e = e13;
            objectOutputStream2 = objectOutputStream;
            Log.e(f3644b, "Error in Data#toByteArray: ", e);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e14) {
                    Log.e(f3644b, "Error in Data#toByteArray: ", e14);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e15) {
                Log.e(f3644b, "Error in Data#toByteArray: ", e15);
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e16) {
                    Log.e(f3644b, "Error in Data#toByteArray: ", e16);
                }
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (IOException e17) {
                Log.e(f3644b, "Error in Data#toByteArray: ", e17);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        Set<String> keySet = this.f3646a.keySet();
        if (!keySet.equals(bVar.f3646a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.f3646a.get(str);
            Object obj3 = bVar.f3646a.get(str);
            if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                return false;
            }
        }
        return true;
    }

    public Map h() {
        return Collections.unmodifiableMap(this.f3646a);
    }

    public int hashCode() {
        return this.f3646a.hashCode() * 31;
    }

    public String i(String str) {
        Object obj = this.f3646a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int j() {
        return this.f3646a.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f3646a.isEmpty()) {
            for (String str : this.f3646a.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.f3646a.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public b(Map map) {
        this.f3646a = new HashMap(map);
    }
}
