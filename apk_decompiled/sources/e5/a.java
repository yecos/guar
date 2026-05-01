package e5;

import android.content.Context;
import android.os.Environment;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import s6.b;
import t9.i;

/* loaded from: classes.dex */
public final class a extends b {
    @Override // s6.b
    public String b() {
        return "3";
    }

    @Override // s6.b
    public String c() {
        return "es";
    }

    @Override // s6.b
    public String d() {
        return "Mobile.apk";
    }

    @Override // s6.b
    public String e() {
        return "www.magistvec.com/download";
    }

    @Override // s6.b
    public String f(Context context) {
        i.g(context, f.X);
        StringBuilder sb = new StringBuilder();
        File externalCacheDir = context.getExternalCacheDir();
        i.d(externalCacheDir);
        sb.append(externalCacheDir.getAbsolutePath());
        sb.append("/sub/%s/%s/%s.srt");
        return sb.toString();
    }

    @Override // s6.b
    public String g() {
        return "27";
    }

    @Override // s6.b
    public String h() {
        return "www.magis4K.com";
    }

    @Override // s6.b
    public String i() {
        return "https://www.magistvec.com/download";
    }

    @Override // s6.b
    public String j() {
        return "05fe10da-f5c8-4a31-acbe-4ea02c5841e3";
    }

    @Override // s6.b
    public String k() {
        return "c6768bbe-189f-4d9d-b35c-f235a9fd7587";
    }

    @Override // s6.b
    public String l() {
        return "nsmm";
    }

    @Override // s6.b
    public String m() {
        return "system_m";
    }

    @Override // s6.b
    public List n() {
        ArrayList arrayList = new ArrayList();
        String path = Environment.getExternalStorageDirectory().getPath();
        arrayList.add(path + "/Android/.MMMobile/.sys");
        arrayList.add(path + "/Android/.MMconfig");
        arrayList.add(path + "/.MMMobile/.sys");
        return arrayList;
    }

    @Override // s6.b
    public boolean o() {
        return false;
    }

    @Override // s6.b
    public boolean p() {
        return true;
    }

    @Override // s6.b
    public boolean q() {
        return true;
    }

    @Override // s6.b
    public boolean r() {
        return false;
    }

    @Override // s6.b
    public boolean s() {
        return false;
    }

    @Override // s6.b
    public boolean t() {
        return false;
    }

    @Override // s6.b
    public boolean u() {
        return false;
    }
}
