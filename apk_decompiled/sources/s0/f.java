package s0;

import android.database.Cursor;
import android.os.Build;
import com.google.firebase.messaging.Constants;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f18631a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f18632b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f18633c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f18634d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f18635a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18636b;

        /* renamed from: c, reason: collision with root package name */
        public final int f18637c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f18638d;

        /* renamed from: e, reason: collision with root package name */
        public final int f18639e;

        /* renamed from: f, reason: collision with root package name */
        public final String f18640f;

        /* renamed from: g, reason: collision with root package name */
        public final int f18641g;

        public a(String str, String str2, boolean z10, int i10, String str3, int i11) {
            this.f18635a = str;
            this.f18636b = str2;
            this.f18638d = z10;
            this.f18639e = i10;
            this.f18637c = a(str2);
            this.f18640f = str3;
            this.f18641g = i11;
        }

        public static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean b() {
            return this.f18639e > 0;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f18639e != aVar.f18639e) {
                    return false;
                }
            } else if (b() != aVar.b()) {
                return false;
            }
            if (!this.f18635a.equals(aVar.f18635a) || this.f18638d != aVar.f18638d) {
                return false;
            }
            if (this.f18641g == 1 && aVar.f18641g == 2 && (str3 = this.f18640f) != null && !str3.equals(aVar.f18640f)) {
                return false;
            }
            if (this.f18641g == 2 && aVar.f18641g == 1 && (str2 = aVar.f18640f) != null && !str2.equals(this.f18640f)) {
                return false;
            }
            int i10 = this.f18641g;
            return (i10 == 0 || i10 != aVar.f18641g || ((str = this.f18640f) == null ? aVar.f18640f == null : str.equals(aVar.f18640f))) && this.f18637c == aVar.f18637c;
        }

        public int hashCode() {
            return (((((this.f18635a.hashCode() * 31) + this.f18637c) * 31) + (this.f18638d ? 1231 : 1237)) * 31) + this.f18639e;
        }

        public String toString() {
            return "Column{name='" + this.f18635a + "', type='" + this.f18636b + "', affinity='" + this.f18637c + "', notNull=" + this.f18638d + ", primaryKeyPosition=" + this.f18639e + ", defaultValue='" + this.f18640f + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f18642a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18643b;

        /* renamed from: c, reason: collision with root package name */
        public final String f18644c;

        /* renamed from: d, reason: collision with root package name */
        public final List f18645d;

        /* renamed from: e, reason: collision with root package name */
        public final List f18646e;

        public b(String str, String str2, String str3, List list, List list2) {
            this.f18642a = str;
            this.f18643b = str2;
            this.f18644c = str3;
            this.f18645d = Collections.unmodifiableList(list);
            this.f18646e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f18642a.equals(bVar.f18642a) && this.f18643b.equals(bVar.f18643b) && this.f18644c.equals(bVar.f18644c) && this.f18645d.equals(bVar.f18645d)) {
                return this.f18646e.equals(bVar.f18646e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f18642a.hashCode() * 31) + this.f18643b.hashCode()) * 31) + this.f18644c.hashCode()) * 31) + this.f18645d.hashCode()) * 31) + this.f18646e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f18642a + "', onDelete='" + this.f18643b + "', onUpdate='" + this.f18644c + "', columnNames=" + this.f18645d + ", referenceColumnNames=" + this.f18646e + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public static class c implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final int f18647a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18648b;

        /* renamed from: c, reason: collision with root package name */
        public final String f18649c;

        /* renamed from: d, reason: collision with root package name */
        public final String f18650d;

        public c(int i10, int i11, String str, String str2) {
            this.f18647a = i10;
            this.f18648b = i11;
            this.f18649c = str;
            this.f18650d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int i10 = this.f18647a - cVar.f18647a;
            return i10 == 0 ? this.f18648b - cVar.f18648b : i10;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f18651a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f18652b;

        /* renamed from: c, reason: collision with root package name */
        public final List f18653c;

        public d(String str, boolean z10, List list) {
            this.f18651a = str;
            this.f18652b = z10;
            this.f18653c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f18652b == dVar.f18652b && this.f18653c.equals(dVar.f18653c)) {
                return this.f18651a.startsWith("index_") ? dVar.f18651a.startsWith("index_") : this.f18651a.equals(dVar.f18651a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f18651a.startsWith("index_") ? -1184239155 : this.f18651a.hashCode()) * 31) + (this.f18652b ? 1 : 0)) * 31) + this.f18653c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f18651a + "', unique=" + this.f18652b + ", columns=" + this.f18653c + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public f(String str, Map map, Set set, Set set2) {
        this.f18631a = str;
        this.f18632b = Collections.unmodifiableMap(map);
        this.f18633c = Collections.unmodifiableSet(set);
        this.f18634d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static f a(t0.b bVar, String str) {
        return new f(str, b(bVar, str), d(bVar, str), f(bVar, str));
    }

    public static Map b(t0.b bVar, String str) {
        Cursor B = bVar.B("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (B.getColumnCount() > 0) {
                int columnIndex = B.getColumnIndex("name");
                int columnIndex2 = B.getColumnIndex("type");
                int columnIndex3 = B.getColumnIndex("notnull");
                int columnIndex4 = B.getColumnIndex(com.umeng.analytics.pro.f.S);
                int columnIndex5 = B.getColumnIndex("dflt_value");
                while (B.moveToNext()) {
                    String string = B.getString(columnIndex);
                    hashMap.put(string, new a(string, B.getString(columnIndex2), B.getInt(columnIndex3) != 0, B.getInt(columnIndex4), B.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            B.close();
        }
    }

    public static List c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(Constants.MessagePayloadKeys.FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < count; i10++) {
            cursor.moveToPosition(i10);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Set d(t0.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor B = bVar.B("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = B.getColumnIndex("id");
            int columnIndex2 = B.getColumnIndex("seq");
            int columnIndex3 = B.getColumnIndex("table");
            int columnIndex4 = B.getColumnIndex("on_delete");
            int columnIndex5 = B.getColumnIndex("on_update");
            List<c> c10 = c(B);
            int count = B.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                B.moveToPosition(i10);
                if (B.getInt(columnIndex2) == 0) {
                    int i11 = B.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : c10) {
                        if (cVar.f18647a == i11) {
                            arrayList.add(cVar.f18649c);
                            arrayList2.add(cVar.f18650d);
                        }
                    }
                    hashSet.add(new b(B.getString(columnIndex3), B.getString(columnIndex4), B.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            B.close();
        }
    }

    public static d e(t0.b bVar, String str, boolean z10) {
        Cursor B = bVar.B("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = B.getColumnIndex("seqno");
            int columnIndex2 = B.getColumnIndex("cid");
            int columnIndex3 = B.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (B.moveToNext()) {
                    if (B.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(B.getInt(columnIndex)), B.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new d(str, z10, arrayList);
            }
            B.close();
            return null;
        } finally {
            B.close();
        }
    }

    public static Set f(t0.b bVar, String str) {
        Cursor B = bVar.B("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = B.getColumnIndex("name");
            int columnIndex2 = B.getColumnIndex("origin");
            int columnIndex3 = B.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (B.moveToNext()) {
                    if (bt.aL.equals(B.getString(columnIndex2))) {
                        String string = B.getString(columnIndex);
                        boolean z10 = true;
                        if (B.getInt(columnIndex3) != 1) {
                            z10 = false;
                        }
                        d e10 = e(bVar, string, z10);
                        if (e10 == null) {
                            return null;
                        }
                        hashSet.add(e10);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            B.close();
        }
    }

    public boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f18631a;
        if (str == null ? fVar.f18631a != null : !str.equals(fVar.f18631a)) {
            return false;
        }
        Map map = this.f18632b;
        if (map == null ? fVar.f18632b != null : !map.equals(fVar.f18632b)) {
            return false;
        }
        Set set2 = this.f18633c;
        if (set2 == null ? fVar.f18633c != null : !set2.equals(fVar.f18633c)) {
            return false;
        }
        Set set3 = this.f18634d;
        if (set3 == null || (set = fVar.f18634d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f18631a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.f18632b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set set = this.f18633c;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.f18631a + "', columns=" + this.f18632b + ", foreignKeys=" + this.f18633c + ", indices=" + this.f18634d + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
