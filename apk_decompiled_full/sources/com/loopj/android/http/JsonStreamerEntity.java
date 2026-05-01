package com.loopj.android.http;

import android.text.TextUtils;
import com.loopj.android.http.RequestParams;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsonStreamerEntity implements HttpEntity {
    private static final int BUFFER_SIZE = 4096;
    private static final String LOG_TAG = "JsonStreamerEntity";
    private final Header contentEncoding;
    private final byte[] elapsedField;
    private final ResponseHandlerInterface progressHandler;
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final byte[] JSON_TRUE = "true".getBytes();
    private static final byte[] JSON_FALSE = "false".getBytes();
    private static final byte[] JSON_NULL = "null".getBytes();
    private static final byte[] STREAM_NAME = escape("name");
    private static final byte[] STREAM_TYPE = escape("type");
    private static final byte[] STREAM_CONTENTS = escape("contents");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
    private final byte[] buffer = new byte[4096];
    private final Map<String, Object> jsonParams = new HashMap();

    public JsonStreamerEntity(ResponseHandlerInterface responseHandlerInterface, boolean z10, String str) {
        this.progressHandler = responseHandlerInterface;
        this.contentEncoding = z10 ? HEADER_GZIP_ENCODING : null;
        this.elapsedField = TextUtils.isEmpty(str) ? null : escape(str);
    }

    private void endMetaData(OutputStream outputStream) {
        outputStream.write(34);
    }

    public static byte[] escape(String str) {
        if (str == null) {
            return JSON_NULL;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append('\"');
        int length = str.length();
        int i10 = -1;
        while (true) {
            i10++;
            if (i10 >= length) {
                sb.append('\"');
                return sb.toString().getBytes();
            }
            char charAt = str.charAt(i10);
            if (charAt == '\f') {
                sb.append("\\f");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (charAt <= 31 || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                            String hexString = Integer.toHexString(charAt);
                            sb.append("\\u");
                            int length2 = 4 - hexString.length();
                            for (int i11 = 0; i11 < length2; i11++) {
                                sb.append('0');
                            }
                            sb.append(hexString.toUpperCase(Locale.US));
                            break;
                        } else {
                            sb.append(charAt);
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
    }

    private void writeMetaData(OutputStream outputStream, String str, String str2) {
        outputStream.write(STREAM_NAME);
        outputStream.write(58);
        outputStream.write(escape(str));
        outputStream.write(44);
        outputStream.write(STREAM_TYPE);
        outputStream.write(58);
        outputStream.write(escape(str2));
        outputStream.write(44);
        outputStream.write(STREAM_CONTENTS);
        outputStream.write(58);
        outputStream.write(34);
    }

    private void writeToFromFile(OutputStream outputStream, RequestParams.FileWrapper fileWrapper) {
        writeMetaData(outputStream, fileWrapper.file.getName(), fileWrapper.contentType);
        long length = fileWrapper.file.length();
        FileInputStream fileInputStream = new FileInputStream(fileWrapper.file);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        long j10 = 0;
        while (true) {
            int read = fileInputStream.read(this.buffer);
            if (read == -1) {
                AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
                endMetaData(outputStream);
                AsyncHttpClient.silentCloseInputStream(fileInputStream);
                return;
            } else {
                base64OutputStream.write(this.buffer, 0, read);
                j10 += read;
                this.progressHandler.sendProgressMessage(j10, length);
            }
        }
    }

    private void writeToFromStream(OutputStream outputStream, RequestParams.StreamWrapper streamWrapper) {
        writeMetaData(outputStream, streamWrapper.name, streamWrapper.contentType);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        while (true) {
            int read = streamWrapper.inputStream.read(this.buffer);
            if (read == -1) {
                break;
            } else {
                base64OutputStream.write(this.buffer, 0, read);
            }
        }
        AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
        endMetaData(outputStream);
        if (streamWrapper.autoClose) {
            AsyncHttpClient.silentCloseInputStream(streamWrapper.inputStream);
        }
    }

    public void addPart(String str, Object obj) {
        this.jsonParams.put(str, obj);
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() {
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw ERR_UNSUPPORTED;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return HEADER_JSON_CONTENT;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.contentEncoding != null) {
            outputStream = new GZIPOutputStream(outputStream, 4096);
        }
        outputStream.write(123);
        Set<String> keySet = this.jsonParams.keySet();
        int size = keySet.size();
        if (size > 0) {
            int i10 = 0;
            for (String str : keySet) {
                i10++;
                try {
                    Object obj = this.jsonParams.get(str);
                    outputStream.write(escape(str));
                    outputStream.write(58);
                    if (obj == null) {
                        outputStream.write(JSON_NULL);
                    } else {
                        boolean z10 = obj instanceof RequestParams.FileWrapper;
                        if (!z10 && !(obj instanceof RequestParams.StreamWrapper)) {
                            if (obj instanceof JsonValueInterface) {
                                outputStream.write(((JsonValueInterface) obj).getEscapedJsonValue());
                            } else if (obj instanceof JSONObject) {
                                outputStream.write(obj.toString().getBytes());
                            } else if (obj instanceof JSONArray) {
                                outputStream.write(obj.toString().getBytes());
                            } else if (obj instanceof Boolean) {
                                outputStream.write(((Boolean) obj).booleanValue() ? JSON_TRUE : JSON_FALSE);
                            } else if (obj instanceof Long) {
                                outputStream.write((((Number) obj).longValue() + "").getBytes());
                            } else if (obj instanceof Double) {
                                outputStream.write((((Number) obj).doubleValue() + "").getBytes());
                            } else if (obj instanceof Float) {
                                outputStream.write((((Number) obj).floatValue() + "").getBytes());
                            } else if (obj instanceof Integer) {
                                outputStream.write((((Number) obj).intValue() + "").getBytes());
                            } else {
                                outputStream.write(escape(obj.toString()));
                            }
                        }
                        outputStream.write(123);
                        if (z10) {
                            writeToFromFile(outputStream, (RequestParams.FileWrapper) obj);
                        } else {
                            writeToFromStream(outputStream, (RequestParams.StreamWrapper) obj);
                        }
                        outputStream.write(125);
                    }
                    if (this.elapsedField != null || i10 < size) {
                        outputStream.write(44);
                    }
                } catch (Throwable th) {
                    if (this.elapsedField != null || i10 < size) {
                        outputStream.write(44);
                    }
                    throw th;
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            byte[] bArr = this.elapsedField;
            if (bArr != null) {
                outputStream.write(bArr);
                outputStream.write(58);
                outputStream.write((currentTimeMillis2 + "").getBytes());
            }
            AsyncHttpClient.log.i(LOG_TAG, "Uploaded JSON in " + Math.floor(currentTimeMillis2 / 1000) + " seconds");
        }
        outputStream.write(125);
        outputStream.flush();
        AsyncHttpClient.silentCloseOutputStream(outputStream);
    }
}
