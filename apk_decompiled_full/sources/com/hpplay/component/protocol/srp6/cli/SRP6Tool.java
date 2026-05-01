package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
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
    */
    public SRP6CryptoParams getConfig(String str) {
        boolean z10;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        println(str + "Enter prime 'N' (hex): ");
        println(str + "\t1 = select precomputed 256-bit");
        println(str + "\t2 = select precomputed 512-bit");
        println(str + "\t3 = select precomputed 768-bit");
        println(str + "\t4 = select precomputed 1024-bit");
        println(str + "\t5 = select precomputed 2048-bit");
        println(str + "\t6 = enter prime 'N' and generator 'g'");
        println();
        print(str + "Your choice [1]: ");
        String readInput = readInput("1");
        readInput.hashCode();
        z10 = false;
        switch (readInput) {
            case "1":
                bigInteger = SRP6CryptoParams.N_256;
                bigInteger2 = SRP6CryptoParams.g_common;
                z10 = true;
                println();
                if (z10) {
                    println(str + "Selected prime 'N' (hex): " + BigIntegerUtils.toHex(bigInteger));
                    println(str + "Selected generator 'g' (hex): " + BigIntegerUtils.toHex(bigInteger2));
                    println();
                }
                print(str + "Enter hash algorithm 'H' [SHA-1]: ");
                String readInput2 = readInput("SHA-1");
                println();
                return new SRP6CryptoParams(bigInteger, bigInteger2, readInput2);
            case "2":
                bigInteger = SRP6CryptoParams.N_512;
                bigInteger2 = SRP6CryptoParams.g_common;
                z10 = true;
                println();
                if (z10) {
                }
                print(str + "Enter hash algorithm 'H' [SHA-1]: ");
                String readInput22 = readInput("SHA-1");
                println();
                return new SRP6CryptoParams(bigInteger, bigInteger2, readInput22);
            case "3":
                bigInteger = SRP6CryptoParams.N_768;
                bigInteger2 = SRP6CryptoParams.g_common;
                z10 = true;
                println();
                if (z10) {
                }
                print(str + "Enter hash algorithm 'H' [SHA-1]: ");
                String readInput222 = readInput("SHA-1");
                println();
                return new SRP6CryptoParams(bigInteger, bigInteger2, readInput222);
            case "4":
                bigInteger = SRP6CryptoParams.N_1024;
                bigInteger2 = SRP6CryptoParams.g_common;
                z10 = true;
                println();
                if (z10) {
                }
                print(str + "Enter hash algorithm 'H' [SHA-1]: ");
                String readInput2222 = readInput("SHA-1");
                println();
                return new SRP6CryptoParams(bigInteger, bigInteger2, readInput2222);
            case "5":
                bigInteger = SRP6CryptoParams.N_2048;
                bigInteger2 = SRP6CryptoParams.g_common;
                z10 = true;
                println();
                if (z10) {
                }
                print(str + "Enter hash algorithm 'H' [SHA-1]: ");
                String readInput22222 = readInput("SHA-1");
                println();
                return new SRP6CryptoParams(bigInteger, bigInteger2, readInput22222);
            case "6":
                println();
                print(str + "Enter prime 'N' (hex): ");
                bigInteger = readBigInteger();
                print(str + "Enter generator 'g' (hex): ");
                bigInteger2 = readBigInteger();
                println();
                if (z10) {
                }
                print(str + "Enter hash algorithm 'H' [SHA-1]: ");
                String readInput222222 = readInput("SHA-1");
                println();
                return new SRP6CryptoParams(bigInteger, bigInteger2, readInput222222);
            default:
                throw new IOException("Unknown choice");
        }
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
