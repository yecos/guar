package e9;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import y8.n0;
import y8.w;

/* loaded from: classes3.dex */
public final class a extends InputStream implements w, n0 {

    /* renamed from: a, reason: collision with root package name */
    public MessageLite f12959a;

    /* renamed from: b, reason: collision with root package name */
    public final Parser f12960b;

    /* renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f12961c;

    public a(MessageLite messageLite, Parser parser) {
        this.f12959a = messageLite;
        this.f12960b = parser;
    }

    @Override // y8.w
    public int a(OutputStream outputStream) {
        MessageLite messageLite = this.f12959a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            this.f12959a.writeTo(outputStream);
            this.f12959a = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.f12961c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int a10 = (int) b.a(byteArrayInputStream, outputStream);
        this.f12961c = null;
        return a10;
    }

    @Override // java.io.InputStream
    public int available() {
        MessageLite messageLite = this.f12959a;
        if (messageLite != null) {
            return messageLite.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.f12961c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    public MessageLite b() {
        MessageLite messageLite = this.f12959a;
        if (messageLite != null) {
            return messageLite;
        }
        throw new IllegalStateException("message not available");
    }

    public Parser c() {
        return this.f12960b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f12959a != null) {
            this.f12961c = new ByteArrayInputStream(this.f12959a.toByteArray());
            this.f12959a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f12961c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        MessageLite messageLite = this.f12959a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            if (serializedSize == 0) {
                this.f12959a = null;
                this.f12961c = null;
                return -1;
            }
            if (i11 >= serializedSize) {
                CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr, i10, serializedSize);
                this.f12959a.writeTo(newInstance);
                newInstance.flush();
                newInstance.checkNoSpaceLeft();
                this.f12959a = null;
                this.f12961c = null;
                return serializedSize;
            }
            this.f12961c = new ByteArrayInputStream(this.f12959a.toByteArray());
            this.f12959a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f12961c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i10, i11);
        }
        return -1;
    }
}
