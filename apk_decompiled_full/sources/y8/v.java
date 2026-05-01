package y8;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import y8.l;

/* loaded from: classes3.dex */
public final class v {

    /* renamed from: c, reason: collision with root package name */
    public static final Joiner f20021c = Joiner.on(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);

    /* renamed from: d, reason: collision with root package name */
    public static final v f20022d = a().f(new l.a(), true).f(l.b.f19933a, false);

    /* renamed from: a, reason: collision with root package name */
    public final Map f20023a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f20024b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final u f20025a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20026b;

        public a(u uVar, boolean z10) {
            this.f20025a = (u) Preconditions.checkNotNull(uVar, "decompressor");
            this.f20026b = z10;
        }
    }

    public v(u uVar, boolean z10, v vVar) {
        String a10 = uVar.a();
        Preconditions.checkArgument(!a10.contains(","), "Comma is currently not allowed in message encoding");
        int size = vVar.f20023a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(vVar.f20023a.containsKey(uVar.a()) ? size : size + 1);
        for (a aVar : vVar.f20023a.values()) {
            String a11 = aVar.f20025a.a();
            if (!a11.equals(a10)) {
                linkedHashMap.put(a11, new a(aVar.f20025a, aVar.f20026b));
            }
        }
        linkedHashMap.put(a10, new a(uVar, z10));
        this.f20023a = Collections.unmodifiableMap(linkedHashMap);
        this.f20024b = f20021c.join(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static v a() {
        return new v();
    }

    public static v c() {
        return f20022d;
    }

    public Set b() {
        HashSet hashSet = new HashSet(this.f20023a.size());
        for (Map.Entry entry : this.f20023a.entrySet()) {
            if (((a) entry.getValue()).f20026b) {
                hashSet.add((String) entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f20024b;
    }

    public u e(String str) {
        a aVar = (a) this.f20023a.get(str);
        if (aVar != null) {
            return aVar.f20025a;
        }
        return null;
    }

    public v f(u uVar, boolean z10) {
        return new v(uVar, z10, this);
    }

    public v() {
        this.f20023a = new LinkedHashMap(0);
        this.f20024b = new byte[0];
    }
}
