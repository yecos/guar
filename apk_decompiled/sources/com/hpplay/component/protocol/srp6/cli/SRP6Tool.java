package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class SRP6Tool {
    protected BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    /* JADX WARN: Removed duplicated region for block: B:28:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.hpplay.component.protocol.srp6.SRP6CryptoParams getConfig(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.srp6.cli.SRP6Tool.getConfig(java.lang.String):com.hpplay.component.protocol.srp6.SRP6CryptoParams");
    }

    public void logS(String str) {
        println("\tComputed shared key 'S' (hex): " + str);
    }

    public void logShash(byte[] bArr) {
    }

    public void print(String str) {
        System.out.print(str);
    }

    public void println(String str) {
    }

    public BigInteger readBigInteger() {
        BigInteger fromHex = BigIntegerUtils.fromHex(readInput());
        if (fromHex != null) {
            return fromHex;
        }
        throw new IOException("Bad hex encoding");
    }

    public String readInput(String str) {
        String readLine = this.console.readLine();
        if (readLine != null && !readLine.isEmpty()) {
            return readLine.trim();
        }
        if (str != null) {
            return str;
        }
        throw new IOException("Missing input");
    }

    public abstract void run();

    public void println() {
        System.out.println();
    }

    public String readInput() {
        return readInput(null);
    }
}
