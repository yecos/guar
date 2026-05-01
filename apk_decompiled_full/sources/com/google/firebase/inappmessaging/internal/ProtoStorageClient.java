package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes2.dex */
public class ProtoStorageClient {
    private final Application application;
    private final String fileName;

    public ProtoStorageClient(Application application, String str) {
        this.application = application;
        this.fileName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AbstractMessageLite lambda$read$1(Parser parser) {
        synchronized (this) {
            try {
                FileInputStream openFileInput = this.application.openFileInput(this.fileName);
                try {
                    AbstractMessageLite abstractMessageLite = (AbstractMessageLite) parser.parseFrom(openFileInput);
                    if (openFileInput != null) {
                        openFileInput.close();
                    }
                    return abstractMessageLite;
                } catch (Throwable th) {
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (InvalidProtocolBufferException | FileNotFoundException e10) {
                Logging.logi("Recoverable exception while reading cache: " + e10.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$write$0(AbstractMessageLite abstractMessageLite) {
        synchronized (this) {
            FileOutputStream openFileOutput = this.application.openFileOutput(this.fileName, 0);
            try {
                openFileOutput.write(abstractMessageLite.toByteArray());
                openFileOutput.close();
            } finally {
            }
        }
        return abstractMessageLite;
    }

    public <T extends AbstractMessageLite> Maybe<T> read(final Parser<T> parser) {
        return Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.w1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                AbstractMessageLite lambda$read$1;
                lambda$read$1 = ProtoStorageClient.this.lambda$read$1(parser);
                return lambda$read$1;
            }
        });
    }

    public Completable write(final AbstractMessageLite abstractMessageLite) {
        return Completable.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.x1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object lambda$write$0;
                lambda$write$0 = ProtoStorageClient.this.lambda$write$0(abstractMessageLite);
                return lambda$write$0;
            }
        });
    }
}
