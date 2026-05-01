package o;

import android.app.RemoteInput;

/* loaded from: classes.dex */
public abstract class j1 {
    public static RemoteInput a(j1 j1Var) {
        throw null;
    }

    public static RemoteInput[] b(j1[] j1VarArr) {
        if (j1VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[j1VarArr.length];
        for (int i10 = 0; i10 < j1VarArr.length; i10++) {
            j1 j1Var = j1VarArr[i10];
            remoteInputArr[i10] = a(null);
        }
        return remoteInputArr;
    }
}
