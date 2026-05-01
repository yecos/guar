package com.umeng.commonsdk.statistics.proto;

import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dg;
import com.umeng.analytics.pro.dh;
import com.umeng.analytics.pro.dj;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dm;
import com.umeng.analytics.pro.dp;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class Response implements ch<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, ct> metaDataMap;
    private static final Map<Class<? extends Cdo>, dp> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final dl STRUCT_DESC = new dl(SOAP.RESPONSE);
    private static final db RESP_CODE_FIELD_DESC = new db("resp_code", (byte) 8, 1);
    private static final db MSG_FIELD_DESC = new db(Constant.KEY_MSG, (byte) 11, 2);
    private static final db IMPRINT_FIELD_DESC = new db(bt.X, (byte) 12, 3);

    public static class a extends dq<Response> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, Response response) {
            dgVar.j();
            while (true) {
                db l10 = dgVar.l();
                byte b10 = l10.f10263b;
                if (b10 == 0) {
                    break;
                }
                short s10 = l10.f10264c;
                if (s10 != 1) {
                    if (s10 != 2) {
                        if (s10 != 3) {
                            dj.a(dgVar, b10);
                        } else if (b10 == 12) {
                            com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                            response.imprint = dVar;
                            dVar.read(dgVar);
                            response.setImprintIsSet(true);
                        } else {
                            dj.a(dgVar, b10);
                        }
                    } else if (b10 == 11) {
                        response.msg = dgVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        dj.a(dgVar, b10);
                    }
                } else if (b10 == 8) {
                    response.resp_code = dgVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    dj.a(dgVar, b10);
                }
                dgVar.m();
            }
            dgVar.k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new dh("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, Response response) {
            response.validate();
            dgVar.a(Response.STRUCT_DESC);
            dgVar.a(Response.RESP_CODE_FIELD_DESC);
            dgVar.a(response.resp_code);
            dgVar.c();
            if (response.msg != null && response.isSetMsg()) {
                dgVar.a(Response.MSG_FIELD_DESC);
                dgVar.a(response.msg);
                dgVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                dgVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(dgVar);
                dgVar.c();
            }
            dgVar.d();
            dgVar.b();
        }
    }

    public static class b implements dp {
        private b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    public static class c extends dr<Response> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, Response response) {
            dm dmVar = (dm) dgVar;
            dmVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            dmVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                dmVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(dmVar);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, Response response) {
            dm dmVar = (dm) dgVar;
            response.resp_code = dmVar.w();
            response.setResp_codeIsSet(true);
            BitSet b10 = dmVar.b(2);
            if (b10.get(0)) {
                response.msg = dmVar.z();
                response.setMsgIsSet(true);
            }
            if (b10.get(1)) {
                com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint = dVar;
                dVar.read(dmVar);
                response.setImprintIsSet(true);
            }
        }
    }

    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        hashMap.put(dq.class, new b());
        hashMap.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.RESP_CODE, (e) new ct("resp_code", (byte) 1, new cu((byte) 8)));
        enumMap.put((EnumMap) e.MSG, (e) new ct(Constant.KEY_MSG, (byte) 2, new cu((byte) 11)));
        enumMap.put((EnumMap) e.IMPRINT, (e) new ct(bt.X, (byte) 2, new cy((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, ct> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        ct.a(Response.class, unmodifiableMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e10) {
            throw new IOException(e10.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return ce.a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        schemes.get(dgVar.D()).b().b(dgVar, this);
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z10) {
        if (z10) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z10) {
        if (z10) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i10) {
        this.resp_code = i10;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z10) {
        this.__isset_bitfield = ce.a(this.__isset_bitfield, 0, z10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = ce.b(this.__isset_bitfield, 0);
    }

    public void validate() {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        schemes.get(dgVar.D()).b().a(dgVar, this);
    }

    public enum e implements co {
        RESP_CODE(1, "resp_code"),
        MSG(2, Constant.KEY_MSG),
        IMPRINT(3, bt.X);


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f11124d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f11126e;

        /* renamed from: f, reason: collision with root package name */
        private final String f11127f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11124d.put(eVar.b(), eVar);
            }
        }

        e(short s10, String str) {
            this.f11126e = s10;
            this.f11127f = str;
        }

        public static e a(int i10) {
            if (i10 == 1) {
                return RESP_CODE;
            }
            if (i10 == 2) {
                return MSG;
            }
            if (i10 != 3) {
                return null;
            }
            return IMPRINT;
        }

        public static e b(int i10) {
            e a10 = a(i10);
            if (a10 != null) {
                return a10;
            }
            throw new IllegalArgumentException("Field " + i10 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.co
        public String b() {
            return this.f11127f;
        }

        public static e a(String str) {
            return f11124d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f11126e;
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public ch<Response, e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.ch
    public e fieldForId(int i10) {
        return e.a(i10);
    }

    public Response(int i10) {
        this();
        this.resp_code = i10;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }
}
