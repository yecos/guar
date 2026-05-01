package a8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.umeng.analytics.pro.f;
import t9.i;

/* loaded from: classes3.dex */
public final class d implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f295a;

    /* renamed from: b, reason: collision with root package name */
    public final int f296b;

    /* renamed from: c, reason: collision with root package name */
    public GoogleSignInClient f297c;

    /* renamed from: d, reason: collision with root package name */
    public z7.a f298d;

    public d(Activity activity, String str) {
        i.g(activity, "activity");
        i.g(str, "serverClientId");
        this.f295a = d.class.getSimpleName();
        this.f296b = 17;
        GoogleSignInOptions build = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestServerAuthCode(str).requestIdToken(str).requestId().requestEmail().requestProfile().build();
        i.f(build, "Builder(GoogleSignInOpti…\n                .build()");
        this.f297c = GoogleSignIn.getClient(activity, build);
    }

    public static final void k(d dVar, Task task) {
        i.g(dVar, "this$0");
        i.g(task, "it");
        String str = dVar.f295a;
    }

    public static final void l(d dVar, Activity activity, Task task) {
        i.g(dVar, "this$0");
        i.g(activity, "$activity");
        i.g(task, "it");
        dVar.j(activity);
    }

    @Override // z7.b
    public boolean a(int i10) {
        return i10 == 0;
    }

    @Override // z7.b
    public void b(z7.a aVar) {
        i.g(aVar, "callback");
        this.f298d = aVar;
    }

    @Override // z7.b
    public int c(Context context) {
        i.g(context, f.X);
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }

    @Override // z7.b
    public void d(Activity activity) {
        i.g(activity, "activity");
        GoogleSignInClient googleSignInClient = this.f297c;
        activity.startActivityForResult(googleSignInClient != null ? googleSignInClient.getSignInIntent() : null, this.f296b);
    }

    @Override // z7.b
    public void e(int i10, int i11, Intent intent) {
        if (i10 == this.f296b) {
            Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
            i.f(signedInAccountFromIntent, "task");
            i(signedInAccountFromIntent);
        }
    }

    @Override // z7.b
    public void f(final Activity activity) {
        Task<Void> signOut;
        i.g(activity, "activity");
        GoogleSignInClient googleSignInClient = this.f297c;
        if (googleSignInClient == null || (signOut = googleSignInClient.signOut()) == null) {
            return;
        }
        signOut.addOnCompleteListener(activity, new OnCompleteListener() { // from class: a8.b
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                d.l(d.this, activity, task);
            }
        });
    }

    public final void i(Task task) {
        Uri photoUrl;
        try {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) task.getResult(ApiException.class);
            x7.a aVar = new x7.a();
            String serverAuthCode = googleSignInAccount != null ? googleSignInAccount.getServerAuthCode() : null;
            String str = "";
            if (serverAuthCode == null) {
                serverAuthCode = "";
            }
            aVar.b(serverAuthCode);
            String idToken = googleSignInAccount != null ? googleSignInAccount.getIdToken() : null;
            if (idToken == null) {
                idToken = "";
            }
            aVar.d(idToken);
            String id = googleSignInAccount != null ? googleSignInAccount.getId() : null;
            if (id == null) {
                id = "";
            }
            aVar.f(id);
            String displayName = googleSignInAccount != null ? googleSignInAccount.getDisplayName() : null;
            if (displayName == null) {
                displayName = "";
            }
            aVar.e(displayName);
            String uri = (googleSignInAccount == null || (photoUrl = googleSignInAccount.getPhotoUrl()) == null) ? null : photoUrl.toString();
            if (uri == null) {
                uri = "";
            }
            aVar.g(uri);
            String email = googleSignInAccount != null ? googleSignInAccount.getEmail() : null;
            if (email != null) {
                str = email;
            }
            aVar.c(str);
            z7.a aVar2 = this.f298d;
            if (aVar2 != null) {
                aVar2.S0(1, aVar);
            }
        } catch (ApiException e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("signInResult:failed code=");
            sb.append(e10.getStatusCode());
            sb.append(" msg: ");
            sb.append(e10.getStatusMessage());
            z7.a aVar3 = this.f298d;
            if (aVar3 != null) {
                aVar3.p1(1, new y7.a(e10));
            }
        }
    }

    public final void j(Activity activity) {
        Task<Void> revokeAccess;
        GoogleSignInClient googleSignInClient = this.f297c;
        if (googleSignInClient == null || (revokeAccess = googleSignInClient.revokeAccess()) == null) {
            return;
        }
        revokeAccess.addOnCompleteListener(activity, new OnCompleteListener() { // from class: a8.c
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                d.k(d.this, task);
            }
        });
    }
}
