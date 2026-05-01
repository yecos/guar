package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6Exception;
import com.hpplay.component.protocol.srp6.SRP6ServerSession;
import com.hpplay.cybergarage.http.HTTP;
import java.math.BigInteger;
import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class SRP6Server extends SRP6Tool {
    protected SecureRandom random = new SecureRandom();

    public static void main(String[] strArr) {
        new SRP6Server().run();
    }

    public void logB(String str) {
        println("\tComputed public server value 'B' (hex): " + str);
    }

    public void logM2(String str) {
        println("\tComputed server evidence message 'M2' (hex): " + str);
    }

    @Override // com.hpplay.component.protocol.srp6.cli.SRP6Tool
    public void run() {
        println("*** Nimbus SRP-6a server ***");
        println();
        println("Initialize server session");
        SRP6ServerSession sRP6ServerSession = new SRP6ServerSession(getConfig(HTTP.TAB)) { // from class: com.hpplay.component.protocol.srp6.cli.SRP6Server.1
            {
                this.random = SRP6Server.this.random;
            }
        };
        println("Server session step 1");
        print("\tEnter user identity 'I': ");
        String readInput = readInput();
        print("\tEnter password salt 's' (hex): ");
        BigInteger readBigInteger = readBigInteger();
        print("\tEnter password verifier 'v' (hex): ");
        BigInteger step1 = sRP6ServerSession.step1(readInput, readBigInteger, readBigInteger());
        println();
        logB(BigIntegerUtils.toHex(step1));
        println();
        println("Server session step 2");
        print("\tEnter client public value 'A' (hex): ");
        BigInteger readBigInteger2 = readBigInteger();
        print("\tEnter client evidence message 'M1' (hex): ");
        try {
            BigInteger step2 = sRP6ServerSession.step2(readBigInteger2, readBigInteger());
            println();
            logM2(BigIntegerUtils.toHex(step2));
            println();
            println("Mutual authentication successfully completed");
            println();
            logS(BigIntegerUtils.toHex(sRP6ServerSession.getSessionKey()));
            logShash(sRP6ServerSession.getSessionKeyHash());
        } catch (SRP6Exception e10) {
            println(e10.getMessage());
        }
    }
}
