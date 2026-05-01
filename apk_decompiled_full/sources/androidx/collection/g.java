package androidx.collection;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class g {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public g() {
        this.mHashes = c.f1804a;
        this.mArray = c.f1806c;
        this.mSize = 0;
    }

    private void a(int i10) {
        if (i10 == 8) {
            synchronized (g.class) {
                Object[] objArr = mTwiceBaseCache;
                if (objArr != null) {
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = mBaseCache;
                if (objArr2 != null) {
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i10];
        this.mArray = new Object[i10 << 1];
    }

    public static int b(int[] iArr, int i10, int i11) {
        try {
            return c.a(iArr, i10, i11);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void c(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public void clear() {
        int i10 = this.mSize;
        if (i10 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = c.f1804a;
            this.mArray = c.f1806c;
            this.mSize = 0;
            c(iArr, objArr, i10);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i10) {
        int i11 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i10) {
            Object[] objArr = this.mArray;
            a(i10);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i11);
                System.arraycopy(objArr, 0, this.mArray, 0, i11 << 1);
            }
            c(iArr, objArr, i11);
        }
        if (this.mSize != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.mSize; i10++) {
                try {
                    Object keyAt = keyAt(i10);
                    Object valueAt = valueAt(i10);
                    Object obj2 = gVar.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !gVar.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.mSize; i11++) {
                try {
                    Object keyAt2 = keyAt(i11);
                    Object valueAt2 = valueAt(i11);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.mArray[(indexOfKey << 1) + 1] : obj2;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i10 = this.mSize;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            i13 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return i13;
    }

    int indexOf(Object obj, int i10) {
        int i11 = this.mSize;
        if (i11 == 0) {
            return -1;
        }
        int b10 = b(this.mHashes, i11, i10);
        if (b10 < 0) {
            return b10;
        }
        if (obj.equals(this.mArray[b10 << 1])) {
            return b10;
        }
        int i12 = b10 + 1;
        while (i12 < i11 && this.mHashes[i12] == i10) {
            if (obj.equals(this.mArray[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = b10 - 1; i13 >= 0 && this.mHashes[i13] == i10; i13--) {
            if (obj.equals(this.mArray[i13 << 1])) {
                return i13;
            }
        }
        return i12 ^ (-1);
    }

    public int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public int indexOfNull() {
        int i10 = this.mSize;
        if (i10 == 0) {
            return -1;
        }
        int b10 = b(this.mHashes, i10, 0);
        if (b10 < 0) {
            return b10;
        }
        if (this.mArray[b10 << 1] == null) {
            return b10;
        }
        int i11 = b10 + 1;
        while (i11 < i10 && this.mHashes[i11] == 0) {
            if (this.mArray[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = b10 - 1; i12 >= 0 && this.mHashes[i12] == 0; i12--) {
            if (this.mArray[i12 << 1] == null) {
                return i12;
            }
        }
        return i11 ^ (-1);
    }

    int indexOfValue(Object obj) {
        int i10 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public Object keyAt(int i10) {
        return this.mArray[i10 << 1];
    }

    public Object put(Object obj, Object obj2) {
        int i10;
        int indexOf;
        int i11 = this.mSize;
        if (obj == null) {
            indexOf = indexOfNull();
            i10 = 0;
        } else {
            int hashCode = obj.hashCode();
            i10 = hashCode;
            indexOf = indexOf(obj, hashCode);
        }
        if (indexOf >= 0) {
            int i12 = (indexOf << 1) + 1;
            Object[] objArr = this.mArray;
            Object obj3 = objArr[i12];
            objArr[i12] = obj2;
            return obj3;
        }
        int i13 = indexOf ^ (-1);
        int[] iArr = this.mHashes;
        if (i11 >= iArr.length) {
            int i14 = 8;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i14 = 4;
            }
            Object[] objArr2 = this.mArray;
            a(i14);
            if (i11 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
            }
            c(iArr, objArr2, i11);
        }
        if (i13 < i11) {
            int[] iArr3 = this.mHashes;
            int i15 = i13 + 1;
            System.arraycopy(iArr3, i13, iArr3, i15, i11 - i13);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i13 << 1, objArr3, i15 << 1, (this.mSize - i13) << 1);
        }
        int i16 = this.mSize;
        if (i11 == i16) {
            int[] iArr4 = this.mHashes;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                Object[] objArr4 = this.mArray;
                int i17 = i13 << 1;
                objArr4[i17] = obj;
                objArr4[i17 + 1] = obj2;
                this.mSize = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(g gVar) {
        int i10 = gVar.mSize;
        ensureCapacity(this.mSize + i10);
        if (this.mSize != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(gVar.keyAt(i11), gVar.valueAt(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(gVar.mHashes, 0, this.mHashes, 0, i10);
            System.arraycopy(gVar.mArray, 0, this.mArray, 0, i10 << 1);
            this.mSize = i10;
        }
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public Object removeAt(int i10) {
        Object[] objArr = this.mArray;
        int i11 = i10 << 1;
        Object obj = objArr[i11 + 1];
        int i12 = this.mSize;
        int i13 = 0;
        if (i12 <= 1) {
            c(this.mHashes, objArr, i12);
            this.mHashes = c.f1804a;
            this.mArray = c.f1806c;
        } else {
            int i14 = i12 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    int i16 = i14 - i10;
                    System.arraycopy(iArr, i15, iArr, i10, i16);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i15 << 1, objArr2, i11, i16 << 1);
                }
                Object[] objArr3 = this.mArray;
                int i17 = i14 << 1;
                objArr3[i17] = null;
                objArr3[i17 + 1] = null;
            } else {
                a(i12 > 8 ? i12 + (i12 >> 1) : 8);
                if (i12 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i10);
                    System.arraycopy(objArr, 0, this.mArray, 0, i11);
                }
                if (i10 < i14) {
                    int i18 = i10 + 1;
                    int i19 = i14 - i10;
                    System.arraycopy(iArr, i18, this.mHashes, i10, i19);
                    System.arraycopy(objArr, i18 << 1, this.mArray, i11, i19 << 1);
                }
            }
            i13 = i14;
        }
        if (i12 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i13;
        return obj;
    }

    public Object replace(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, obj2);
        }
        return null;
    }

    public Object setValueAt(int i10, Object obj) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.mArray;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        return obj2;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i10);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
            Object valueAt = valueAt(i10);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }

    public Object valueAt(int i10) {
        return this.mArray[(i10 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj2 != valueAt && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (valueAt != obj2 && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        setValueAt(indexOfKey, obj3);
        return true;
    }

    public g(int i10) {
        if (i10 == 0) {
            this.mHashes = c.f1804a;
            this.mArray = c.f1806c;
        } else {
            a(i10);
        }
        this.mSize = 0;
    }

    public g(g gVar) {
        this();
        if (gVar != null) {
            putAll(gVar);
        }
    }
}
