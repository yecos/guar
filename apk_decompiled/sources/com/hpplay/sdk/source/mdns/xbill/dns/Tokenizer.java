package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base16;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base64;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
public class Tokenizer {
    public static final int COMMENT = 5;
    public static final int EOF = 0;
    public static final int EOL = 1;
    public static final int IDENTIFIER = 3;
    public static final int QUOTED_STRING = 4;
    public static final int WHITESPACE = 2;
    private static String delim = " \t\n;()\"";
    private static String quotes = "\"";
    private Token current;
    private String delimiters;
    private String filename;
    private PushbackInputStream is;
    private int line;
    private int multiline;
    private boolean quoting;
    private StringBuffer sb;
    private boolean ungottenToken;
    private boolean wantClose;

    public static class Token {
        public int type;
        public String value;

        /* JADX INFO: Access modifiers changed from: private */
        public Token set(int i10, StringBuffer stringBuffer) {
            if (i10 < 0) {
                throw new IllegalArgumentException();
            }
            this.type = i10;
            this.value = stringBuffer == null ? null : stringBuffer.toString();
            return this;
        }

        public boolean isString() {
            int i10 = this.type;
            return i10 == 3 || i10 == 4;
        }

        public String toString() {
            int i10 = this.type;
            if (i10 == 0) {
                return "<eof>";
            }
            if (i10 == 1) {
                return "<eol>";
            }
            if (i10 == 2) {
                return "<whitespace>";
            }
            if (i10 == 3) {
                return "<identifier: " + this.value + Operator.Operation.GREATER_THAN;
            }
            if (i10 == 4) {
                return "<quoted_string: " + this.value + Operator.Operation.GREATER_THAN;
            }
            if (i10 != 5) {
                return "<unknown>";
            }
            return "<comment: " + this.value + Operator.Operation.GREATER_THAN;
        }

        private Token() {
            this.type = -1;
            this.value = null;
        }
    }

    public static class TokenizerException extends Exception {
        String message;

        public TokenizerException(String str, int i10, String str2) {
            super(str + SOAP.DELIM + i10 + ": " + str2);
            this.message = str2;
        }

        public String getBaseMessage() {
            return this.message;
        }
    }

    public Tokenizer(InputStream inputStream) {
        this.is = new PushbackInputStream(inputStream instanceof BufferedInputStream ? inputStream : new BufferedInputStream(inputStream), 2);
        this.ungottenToken = false;
        this.multiline = 0;
        this.quoting = false;
        this.delimiters = delim;
        this.current = new Token();
        this.sb = new StringBuffer();
        this.filename = "<none>";
        this.line = 1;
    }

    private String _getIdentifier(String str) {
        Token token = get();
        if (token.type == 3) {
            return token.value;
        }
        throw exception("expected " + str);
    }

    private void checkUnbalancedParens() {
        if (this.multiline > 0) {
            throw exception("unbalanced parentheses");
        }
    }

    private int getChar() {
        int read = this.is.read();
        if (read == 13) {
            int read2 = this.is.read();
            if (read2 != 10) {
                this.is.unread(read2);
            }
            read = 10;
        }
        if (read == 10) {
            this.line++;
        }
        return read;
    }

    private String remainingStrings() {
        StringBuffer stringBuffer = null;
        while (true) {
            Token token = get();
            if (!token.isString()) {
                break;
            }
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            stringBuffer.append(token.value);
        }
        unget();
        if (stringBuffer == null) {
            return null;
        }
        return stringBuffer.toString();
    }

    private int skipWhitespace() {
        int i10;
        int i11;
        while (true) {
            i11 = getChar();
            i10 = (i11 == 32 || i11 == 9 || (i11 == 10 && this.multiline > 0)) ? i10 + 1 : 0;
        }
        ungetChar(i11);
        return i10;
    }

    private void ungetChar(int i10) {
        if (i10 != -1) {
            this.is.unread(i10);
            if (i10 == 10) {
                this.line--;
            }
        }
    }

    public void close() {
        if (this.wantClose) {
            try {
                this.is.close();
            } catch (Exception unused) {
            }
        }
    }

    public Exception exception(String str) {
        return new TokenizerException(this.filename, this.line, str);
    }

    public void finalize() {
        close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x013b, code lost:
    
        ungetChar(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0144, code lost:
    
        if (r9.sb.length() != 0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0146, code lost:
    
        if (r10 == 4) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0148, code lost:
    
        checkUnbalancedParens();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0151, code lost:
    
        return r9.current.set(0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x015a, code lost:
    
        return r9.current.set(r10, r9.sb);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer.Token get(boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer.get(boolean, boolean):com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token");
    }

    public InetAddress getAddress(int i10) {
        try {
            return Address.getByAddress(_getIdentifier("an address"), i10);
        } catch (UnknownHostException e10) {
            throw exception(e10.getMessage());
        }
    }

    public byte[] getAddressBytes(int i10) {
        String _getIdentifier = _getIdentifier("an address");
        byte[] byteArray = Address.toByteArray(_getIdentifier, i10);
        if (byteArray != null) {
            return byteArray;
        }
        throw exception("Invalid address: " + _getIdentifier);
    }

    public byte[] getBase64(boolean z10) {
        String remainingStrings = remainingStrings();
        if (remainingStrings == null) {
            if (z10) {
                throw exception("expected base64 encoded string");
            }
            return null;
        }
        byte[] fromString = base64.fromString(remainingStrings);
        if (fromString != null) {
            return fromString;
        }
        throw exception("invalid base64 encoding");
    }

    public void getEOL() {
        int i10 = get().type;
        if (i10 != 1 && i10 != 0) {
            throw exception("expected EOL or EOF");
        }
    }

    public byte[] getHex(boolean z10) {
        String remainingStrings = remainingStrings();
        if (remainingStrings == null) {
            if (z10) {
                throw exception("expected hex encoded string");
            }
            return null;
        }
        byte[] fromString = base16.fromString(remainingStrings);
        if (fromString != null) {
            return fromString;
        }
        throw exception("invalid hex encoding");
    }

    public String getIdentifier() {
        return _getIdentifier("an identifier");
    }

    public long getLong() {
        String _getIdentifier = _getIdentifier("an integer");
        if (!Character.isDigit(_getIdentifier.charAt(0))) {
            throw exception("expected an integer");
        }
        try {
            return Long.parseLong(_getIdentifier);
        } catch (NumberFormatException unused) {
            throw exception("expected an integer");
        }
    }

    public Name getName(Name name) {
        try {
            Name fromString = Name.fromString(_getIdentifier("a name"), name);
            if (fromString.isAbsolute()) {
                return fromString;
            }
            throw new Exception("name.isAbsolute");
        } catch (Exception e10) {
            throw exception(e10.getMessage());
        }
    }

    public String getString() {
        Token token = get();
        if (token.isString()) {
            return token.value;
        }
        throw exception("expected a string");
    }

    public long getTTL() {
        try {
            return TTL.parseTTL(_getIdentifier("a TTL value"));
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL value");
        }
    }

    public long getTTLLike() {
        try {
            return TTL.parse(_getIdentifier("a TTL-like value"), false);
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL-like value");
        }
    }

    public int getUInt16() {
        long j10 = getLong();
        if (j10 < 0 || j10 > 65535) {
            throw exception("expected an 16 bit unsigned integer");
        }
        return (int) j10;
    }

    public long getUInt32() {
        long j10 = getLong();
        if (j10 < 0 || j10 > 4294967295L) {
            throw exception("expected an 32 bit unsigned integer");
        }
        return j10;
    }

    public int getUInt8() {
        long j10 = getLong();
        if (j10 < 0 || j10 > 255) {
            throw exception("expected an 8 bit unsigned integer");
        }
        return (int) j10;
    }

    public void unget() {
        if (this.ungottenToken) {
            throw new IllegalStateException("Cannot unget multiple tokens");
        }
        if (this.current.type == 1) {
            this.line--;
        }
        this.ungottenToken = true;
    }

    public byte[] getBase64() {
        return getBase64(false);
    }

    public byte[] getHex() {
        return getHex(false);
    }

    public Tokenizer(String str) {
        this(new ByteArrayInputStream(str.getBytes()));
    }

    public Tokenizer(File file) {
        this(new FileInputStream(file));
        this.wantClose = true;
        this.filename = file.getName();
    }

    public Token get() {
        return get(false, false);
    }
}
