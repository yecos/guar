package org.simpleframework.xml.stream;

/* loaded from: classes2.dex */
final class ProviderFactory {
    public static Provider getInstance() {
        try {
            try {
                return new StreamProvider();
            } catch (Throwable unused) {
                return new PullProvider();
            }
        } catch (Throwable unused2) {
            return new DocumentProvider();
        }
    }
}
