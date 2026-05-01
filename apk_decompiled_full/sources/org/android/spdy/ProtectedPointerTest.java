package org.android.spdy;

import org.android.spdy.ProtectedPointer;

/* loaded from: classes.dex */
public class ProtectedPointerTest {

    public static class Data {

        /* renamed from: i, reason: collision with root package name */
        private int f17869i = 0;

        public void destroy() {
            System.out.println("destroy");
            this.f17869i = 1;
        }

        public void work() {
            System.out.println("work");
            if (this.f17869i == 1) {
                System.exit(-1);
            }
        }
    }

    public static void main(String[] strArr) {
        ProtectedPointer protectedPointer = new ProtectedPointer(new Data());
        protectedPointer.setHow2close(new ProtectedPointer.ProtectedPointerOnClose() { // from class: org.android.spdy.ProtectedPointerTest.3
            @Override // org.android.spdy.ProtectedPointer.ProtectedPointerOnClose
            public void close(Object obj) {
                ((Data) obj).destroy();
            }
        });
        test_close_with_work(protectedPointer);
    }

    public static void test_close_anywhere1(ProtectedPointer protectedPointer) {
        if (protectedPointer.enter()) {
            Data data = (Data) protectedPointer.getData();
            protectedPointer.release();
            data.work();
            protectedPointer.exit();
        }
    }

    public static void test_close_with_work(final ProtectedPointer protectedPointer) {
        Thread thread = new Thread(new Runnable() { // from class: org.android.spdy.ProtectedPointerTest.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i10 = 0; i10 < 1000; i10++) {
                    if (ProtectedPointer.this.enter()) {
                        ((Data) ProtectedPointer.this.getData()).work();
                        ProtectedPointer.this.exit();
                    } else {
                        System.out.println("the data has been destroy");
                    }
                }
            }
        });
        new Thread(new Runnable() { // from class: org.android.spdy.ProtectedPointerTest.2
            @Override // java.lang.Runnable
            public void run() {
                ProtectedPointer.this.release();
            }
        }).run();
        thread.run();
    }

    public static void test_sequece(ProtectedPointer protectedPointer) {
        protectedPointer.release();
    }
}
