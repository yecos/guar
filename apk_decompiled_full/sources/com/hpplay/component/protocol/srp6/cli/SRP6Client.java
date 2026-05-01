package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6ClientCredentials;
import com.hpplay.component.protocol.srp6.SRP6ClientSession;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
import com.hpplay.component.protocol.srp6.SRP6Exception;
import com.hpplay.component.protocol.srp6.SRP6VerifierGenerator;
import com.hpplay.cybergarage.http.HTTP;
import java.math.BigInteger;
import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class SRP6Client extends SRP6Tool {
    protected SecureRandom random = new SecureRandom();

    public static class User {
        public final String I;
        public final String P;

        public User(String str, String str2) {
            this.I = str;
            this.P = str2;
        }
    }

    private void clientSession() {
        println("Client session step 1");
        SRP6ClientSession sRP6ClientSession = new SRP6ClientSession() { // from class: com.hpplay.component.protocol.srp6.cli.SRP6Client.1
            {
                this.random = SRP6Client.this.random;
            }
        };
        User user = getUser(HTTP.TAB);
        sRP6ClientSession.step1(user.I, user.P);
        println();
        println("Client session step 2");
        SRP6CryptoParams config = getConfig(HTTP.TAB);
        print("\tEnter salt 's' (hex): ");
        BigInteger readBigInteger = readBigInteger();
        println();
        print("\tEnter public server value 'B' (hex): ");
        BigInteger readBigInteger2 = readBigInteger();
        println();
        try {
            SRP6ClientCredentials step2 = sRP6ClientSession.step2(config, readBigInteger, readBigInteger2);
            logA(BigIntegerUtils.toHex(step2.A));
            logM1(BigIntegerUtils.toHex(step2.M1));
            println();
            println("Client session step 3");
            print("\tEnter server evidence message 'M2' (hex): ");
            try {
                sRP6ClientSession.step3(readBigInteger());
                println();
                println("Client authentication successfully completed");
                println();
                logS(BigIntegerUtils.toHex(sRP6ClientSession.getSessionKey()));
                logShash(sRP6ClientSession.getSessionKeyHash());
            } catch (SRP6Exception e10) {
                println(e10.getMessage());
                throw e10;
            }
        } catch (SRP6Exception e11) {
            println(e11.getMessage());
        }
    }

    private void generatePasswordVerifier() {
        println("Initialize verifier generator");
        SRP6VerifierGenerator sRP6VerifierGenerator = new SRP6VerifierGenerator(getConfig(HTTP.TAB));
        User user = getUser("");
        println();
        print("Enter preferred salt 's' byte size [16]: ");
        try {
            BigInteger bigIntegerFromBytes = BigIntegerUtils.bigIntegerFromBytes(sRP6VerifierGenerator.generateRandomSalt(Integer.parseInt(readInput("16")), this.random));
            BigInteger generateVerifier = sRP6VerifierGenerator.generateVerifier(bigIntegerFromBytes, user.I, user.P);
            logSalt(BigIntegerUtils.toHex(bigIntegerFromBytes));
            println();
            logV(BigIntegerUtils.toHex(generateVerifier));
        } catch (NumberFormatException e10) {
            println("Couldn't parse salt 's' byte size: " + e10.getMessage());
        }
    }

    private User getUser(String str) {
        print(str + "Enter user identity 'I': ");
        String readInput = readInput();
        print(str + "Enter user password 'P': ");
        return new User(readInput, readInput());
    }

    public static void main(String[] strArr) {
        new SRP6Client().run();
    }

    public void logA(String str) {
        println("\tComputed public value 'A' (hex): " + str);
    }

    public void logM1(String str) {
        println("\tComputed evidence message 'M1' (hex): " + str);
    }

    public void logSalt(String str) {
        println("Generated salt 's' (hex): " + str);
    }

    public void logV(String str) {
        println("Computed password verifier 'v' (hex): " + str);
    }

    @Override // com.hpplay.component.protocol.srp6.cli.SRP6Tool
    public void run() {
        println("*** Nimbus SRP-6a client / verifier generator ***");
        println();
        println("Choose mode: ");
        println("\t1 = generate password verifier");
        println("\t2 = client auth session");
        println();
        print("Your choice [1]: ");
        String readInput = readInput("1");
        readInput.hashCode();
        if (readInput.equals("1")) {
            println();
            generatePasswordVerifier();
        } else if (!readInput.equals("2")) {
            println("Unknown choice, aborting...");
        } else {
            println();
            clientSession();
        }
    }
}
