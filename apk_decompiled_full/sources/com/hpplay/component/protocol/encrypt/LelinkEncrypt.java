package com.hpplay.component.protocol.encrypt;

import android.text.TextUtils;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.NLProtocolBuiler;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.encrypt.ChaCha20;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.PropertyListParser;
import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6ClientSession;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
import com.hpplay.component.protocol.srp6.SRP6Exception;
import com.hpplay.component.protocol.srp6.cli.ClientSessionImpl;
import com.taobao.accs.AccsClientConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

/* loaded from: classes2.dex */
public class LelinkEncrypt {
    private static final int ED25519_WAY = 0;
    private static final String IDE_NONCE = "LELINK-IDENTITY-NONCE";
    private static final String IDE_SALT_KEY = "LELINK-IDENTITY-KEY";
    private static final String IDE_VERIFY_NONCE = "LEINK-VERIFY-IDENTITY-NONCE";
    private static final String IDE_VERIFY_SALT_KEY = "LELINK-VERIFY_IDENTITY-KEY";
    public static final String KEY_ATV = "atv";
    public static final String KEY_ETV = "etv";
    public static final String KEY_HMD = "hmd";
    public static final String KEY_HSTV = "hstv";
    public static final String KEY_HTV = "htv";
    public static final String KEY_VV = "vv";
    private static final String LELINK_USER = "LELINK_USER";
    public static final int PAIR_AUTH_STAGE_BADLENGTH = 12;
    public static final int PAIR_AUTH_STAGE_ERROR = 11;
    public static final int PAIR_AUTH_STAGE_FINISHED = 10;
    public static final int PAIR_AUTH_STAGE_INIT = 0;
    public static final int PAIR_AUTH_STAGE_M1 = 7;
    public static final int PAIR_AUTH_STAGE_M1_REQ = 1;
    public static final int PAIR_AUTH_STAGE_M1_RSP = 2;
    public static final int PAIR_AUTH_STAGE_M2 = 8;
    public static final int PAIR_AUTH_STAGE_M2_REQ = 3;
    public static final int PAIR_AUTH_STAGE_M2_RSP = 4;
    public static final int PAIR_AUTH_STAGE_M3 = 9;
    public static final int PAIR_AUTH_STAGE_M3_REQ = 5;
    public static final int PAIR_AUTH_STAGE_M3_RSP = 6;
    public static final int PAIR_SETUP_M1_CLIENT = 3;
    public static final int PAIR_SETUP_M1_SERVER = 3;
    public static final int PAIR_TAG_AUTH_SRP_M1_CLIENT_METHOD = 3;
    public static final int PAIR_TAG_AUTH_SRP_M1_CLIENT_USERNAME = 4;
    public static final int PAIR_TAG_AUTH_SRP_M1_SERVER_PBULIC_KEY = 5;
    public static final int PAIR_TAG_AUTH_SRP_M1_SERVER_PUBLIC_SALT = 6;
    public static final int PAIR_TAG_AUTH_SRP_M2_CLIENT_PROOF = 8;
    public static final int PAIR_TAG_AUTH_SRP_M2_CLIENT_PUBLIC_KEY = 5;
    public static final int PAIR_TAG_AUTH_SRP_M2_SERVER_PROOF = 8;
    public static final int PAIR_TAG_AUTH_SRP_M3_CLIENT_PUBLIC_SALT = 11;
    public static final int PAIR_TAG_AUTH_SRP_M3_CLIENT_SIGN_BODY = 9;
    public static final int PAIR_TAG_AUTH_SRP_M3_CLIENT_SIGN_HEMAC = 10;
    public static final int PAIR_TAG_AUTH_SRP_M3_SERVER_PUBLIC_SALT = 11;
    public static final int PAIR_TAG_AUTH_SRP_M3_SERVER_SIGN_BODY = 9;
    public static final int PAIR_TAG_AUTH_SRP_M3_SERVER_SIGN_HEMAC = 10;
    public static final int PAIR_TAG_HAF = 0;
    public static final int PAIR_TAG_STAGE = 2;
    public static final int PAIR_TAG_TYPE = 1;
    public static final int PAIR_VRIFY_M2_CLIENT = 4;
    public static final int PAIR_VRIFY_M2_SERVER = 4;
    public static final int PAIR_VRIFY_M3_CLIENT = 5;
    public static final int PAIR_VRIFY_M3_SERVER = 5;
    public static final String SALT_IV = "LELINK-VERIFY-SIGNATURE-NONCE";
    public static final String SALT_KEY = "LELINK-VERIFY_SIGNATURE-KEY";
    private static final String SRP_IDE_NONCE = "LELINK-AUTH_IDENTITY-NONCE";
    private static final String SRP_IDE_SALT_KEY = "LELINK-AUTH_IDENTITY-KEY";
    private static final int SRP_RANDOM_WAY = 2;
    private static final String SRP_SALT_IV = "LEINK-VERIFY-ATV-NONCE";
    private static final String SRP_SALT_KEY = "LELINK-VERIFY_ATV-KEY";
    private static final int SRP_WAY = 1;
    private static final String TAG = "LelinkEncrypt";
    private byte[] chachaMaterKey;
    private byte[] chachaNonce;
    private byte[] mChachaSignMessage;
    private byte[] mCurvePrkey;
    private byte[] mCurvePukey;
    private ChaCha20 mDeChaCha20;
    private ChaCha20 mEnChaCha20;
    private byte[] mRcvCurvePkey;
    private byte[] mRcvSignatrue;
    private byte[] mRcvSrpPuk;
    private byte mRcvStage;
    private byte mRcvType;
    private String mSessionId;
    private byte[] mSrpPukey;
    private byte[] mSrpSalt;
    private byte mStage;
    private byte mType;
    private byte[] msrpSignMessage;
    private byte[] msrpSignature;
    private byte[] sharedSecret;
    private SRP6ClientSession srp6ClientSession;
    private String srpPassword = "000000";
    private boolean isDebug = true;
    private byte[] mRcvEdPk = new byte[32];
    private byte[] mRcvEdPkSalt = new byte[32];
    private byte[] mKeySalt = new byte[32];
    public byte[] mSecretkey = null;
    public byte[] mEdPukey = null;
    public byte[] mEdSalt = null;
    private boolean isRelase = false;
    private int mAtv = 0;
    private String mEncryptState = "successful";
    private ED25519Encrypt mEd25519Encrypt = new ED25519Encrypt();

    public LelinkEncrypt(String str) {
        this.mSessionId = str;
    }

    private boolean chachaDecrypt(byte[] bArr, byte[] bArr2) {
        if (bArr != null && !this.isRelase) {
            if (this.mDeChaCha20 == null) {
                this.mDeChaCha20 = chachaSetup();
            }
            ChaCha20 chaCha20 = this.mDeChaCha20;
            if (chaCha20 == null) {
                return false;
            }
            byte[] bArr3 = new byte[64];
            chaCha20.decrypt(bArr3, bArr3, 64);
            this.mDeChaCha20.decrypt(bArr, bArr, bArr.length);
            if (Poly1305.crypto_onetimeauth_verify(bArr2, 0, bArr, 0, bArr.length, bArr3) == 0) {
                return true;
            }
        }
        return false;
    }

    private byte[] chachaEncryptAndGenSignature(byte[] bArr) {
        if (bArr == null || this.isRelase) {
            return null;
        }
        byte[] bArr2 = new byte[64];
        ChaCha20 chaCha20 = this.mEnChaCha20;
        if (chaCha20 == null) {
            ChaCha20 chachaSetup = chachaSetup();
            this.mEnChaCha20 = chachaSetup;
            chachaSetup.encrypt(bArr2, bArr2, 64);
        } else {
            chaCha20.encrypt(bArr2, bArr2, 64);
        }
        byte[] bArr3 = new byte[16];
        Poly1305.crypto_onetimeauth(bArr3, 0, bArr, 0, bArr.length, bArr2);
        this.mEnChaCha20.encrypt(bArr, bArr, bArr.length);
        return bArr3;
    }

    public static byte[] protocolMerge(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public byte[] buildEncryptData(byte[]... bArr) {
        byte[] bArr2 = bArr[0];
        if (bArr2 != null && bArr2.length != 0 && !this.isRelase) {
            int length = bArr2.length;
            byte[] bArr3 = {(byte) (length & 255), (byte) ((length >> 8) & 255), (byte) ((length >> 16) & 255), (byte) ((length >> 24) & 255)};
            try {
                byte[] chachaEncryptAndGenSignature = chachaEncryptAndGenSignature(bArr2);
                byte[] bArr4 = new byte[bArr2.length + 4 + chachaEncryptAndGenSignature.length];
                System.arraycopy(bArr3, 0, bArr4, 0, 4);
                System.arraycopy(bArr2, 0, bArr4, 4, bArr2.length);
                System.arraycopy(chachaEncryptAndGenSignature, 0, bArr4, 4 + bArr2.length, chachaEncryptAndGenSignature.length);
                return bArr4;
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        return null;
    }

    public String buildHeader(NLProtocolBuiler nLProtocolBuiler, int i10) {
        return nLProtocolBuiler.setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewLelinkClientId("0xff99ffex0022").setNewSessionId(this.mSessionId).setContentType("application/octet-stream").setContentLength(i10 + "").getString(true);
    }

    public String bytesToHex(byte[] bArr) {
        return this.isDebug ? ProtocolUtils.bytesToHex(bArr) : "";
    }

    public ChaCha20 chachaSetup() {
        ChaCha20 chaCha20;
        try {
            if (this.isRelase) {
                return null;
            }
            byte[] bArr = this.chachaMaterKey;
            if (bArr.length > 8) {
                byte[] bArr2 = new byte[8];
                System.arraycopy(this.chachaNonce, 0, bArr2, 0, 8);
                chaCha20 = new ChaCha20(this.chachaMaterKey, bArr2, 0);
            } else {
                chaCha20 = new ChaCha20(bArr, this.chachaNonce, 0);
            }
            return chaCha20;
        } catch (ChaCha20.WrongKeySizeException | ChaCha20.WrongNonceSizeException e10) {
            CLog.w(TAG, e10);
            return null;
        }
    }

    public byte[] decryptData(byte[] bArr) {
        int i10;
        if (bArr == null || bArr.length == 0 || this.isRelase || (i10 = (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24)) > 5120) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[i10];
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, 4, bArr2, 0, i10);
            System.arraycopy(bArr, i10 + 4, bArr3, 0, 16);
            chachaDecrypt(bArr2, bArr3);
            return bArr2;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return null;
        }
    }

    public byte[] genPlayInfoRequest() {
        return buildHeader(new NLProtocolBuiler().getNewLelinkPlayerinfoCmd(), 0).getBytes();
    }

    public byte[] genSetupRequest() {
        if (this.isRelase) {
            return null;
        }
        byte[] bArr = new byte[4];
        bArr[0] = 0;
        bArr[2] = (byte) this.mAtv;
        bArr[3] = 1;
        byte[] bArr2 = new byte[2];
        TlvBox tlvBox = new TlvBox();
        int i10 = this.mAtv;
        if (i10 == 0) {
            bArr[1] = 1;
            bArr2[0] = 1;
            bArr2[1] = 1;
            byte[] bArr3 = new byte[64];
            this.mSecretkey = bArr3;
            byte[] bArr4 = new byte[32];
            this.mEdPukey = bArr4;
            byte[] bArr5 = new byte[32];
            this.mEdSalt = bArr5;
            this.mEd25519Encrypt.publicKeyGen(bArr3, bArr4, bArr5);
            byte[] bArr6 = new byte[64];
            byte[] bArr7 = this.mEdPukey;
            System.arraycopy(bArr7, 0, bArr6, 0, bArr7.length);
            this.mKeySalt = new byte[32];
            new Random().nextBytes(this.mKeySalt);
            byte[] bArr8 = this.mKeySalt;
            System.arraycopy(bArr8, 0, bArr6, 32, bArr8.length);
            tlvBox.putBytesValue(0, bArr);
            tlvBox.putByteValue(1, bArr2[0]);
            tlvBox.putByteValue(2, bArr2[1]);
            tlvBox.putBytesValue(3, bArr6);
        } else if (i10 == 1 || i10 == 2) {
            bArr[1] = 2;
            bArr2[0] = 2;
            bArr2[1] = 1;
            tlvBox.putBytesValue(0, bArr);
            tlvBox.putByteValue(1, bArr2[0]);
            tlvBox.putByteValue(2, bArr2[1]);
            tlvBox.putStringValue(4, LELINK_USER);
            tlvBox.putStringValue(3, AccsClientConfig.DEFAULT_CONFIGTAG);
        }
        byte[] serialize = tlvBox.serialize();
        CLog.d(TAG, bytesToHex(serialize));
        byte[] protocolMerge = protocolMerge(buildHeader(new NLProtocolBuiler().getSetupCmd(), serialize.length).getBytes(), serialize);
        CLog.d(TAG, new String(protocolMerge));
        return protocolMerge;
    }

    public byte[] genSha512(byte[] bArr, byte[] bArr2, int i10) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(bArr);
            messageDigest.update(bArr2);
            return Arrays.copyOfRange(messageDigest.digest(), 0, i10);
        } catch (NoSuchAlgorithmException e10) {
            CLog.w(TAG, e10);
            return null;
        }
    }

    public byte[] genVerrifyM1Request() {
        if (this.isRelase) {
            return null;
        }
        byte[] bArr = new byte[2];
        TlvBox tlvBox = new TlvBox();
        int i10 = this.mAtv;
        if (i10 == 0) {
            bArr[0] = 1;
            bArr[1] = 3;
            byte[] bArr2 = new byte[64];
            this.mCurvePrkey = new byte[32];
            new Random().nextBytes(this.mCurvePrkey);
            byte[] bArr3 = new byte[32];
            this.mCurvePukey = bArr3;
            Curve25519.keygen(bArr3, null, this.mCurvePrkey);
            byte[] bArr4 = this.mCurvePukey;
            System.arraycopy(bArr4, 0, bArr2, 0, bArr4.length);
            byte[] bArr5 = this.mEdPukey;
            System.arraycopy(bArr5, 0, bArr2, 32, bArr5.length);
            tlvBox.putByteValue(1, bArr[0]);
            tlvBox.putByteValue(2, bArr[1]);
            tlvBox.putBytesValue(4, bArr2);
        } else if (i10 == 1 || i10 == 2) {
            bArr[0] = 2;
            bArr[1] = 3;
            tlvBox.putByteValue(1, (byte) 2);
            tlvBox.putByteValue(2, bArr[1]);
            byte[] bigIntegerToBytes = BigIntegerUtils.bigIntegerToBytes(this.srp6ClientSession.getPublicClientValue());
            this.mSrpPukey = bigIntegerToBytes;
            tlvBox.putBytesValue(5, bigIntegerToBytes);
            tlvBox.putBytesValue(8, BigIntegerUtils.bigIntegerToBytes(this.srp6ClientSession.getClientEvidenceMessage()));
        }
        byte[] serialize = tlvBox.serialize();
        byte[] protocolMerge = protocolMerge(buildHeader(new NLProtocolBuiler().getVerifyCmd(), serialize.length).getBytes(), serialize);
        CLog.d(TAG, new String(protocolMerge));
        return protocolMerge;
    }

    public byte[] genVerrifyM2Request() {
        if (this.isRelase) {
            return null;
        }
        byte[] bArr = new byte[2];
        TlvBox tlvBox = new TlvBox();
        int i10 = this.mAtv;
        if (i10 == 0) {
            bArr[0] = 1;
            bArr[1] = 5;
            byte[] bArr2 = new byte[64];
            byte[] bArr3 = this.mCurvePukey;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            byte[] bArr4 = this.mRcvCurvePkey;
            System.arraycopy(bArr4, 0, bArr2, 32, bArr4.length);
            byte[] bArr5 = new byte[64];
            this.mEd25519Encrypt.sign(this.mEdPukey, this.mSecretkey, bArr2, bArr5);
            try {
                byte[] bArr6 = new byte[64];
                this.mEd25519Encrypt.aecrypt(genSha512(IDE_VERIFY_SALT_KEY.getBytes(), this.sharedSecret, 16), genSha512(IDE_VERIFY_NONCE.getBytes(), this.sharedSecret, 16), bArr5, 0, 64, bArr6, 0, true);
                tlvBox.putByteValue(1, bArr[0]);
                tlvBox.putByteValue(2, bArr[1]);
                tlvBox.putBytesValue(5, bArr6);
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        } else if (i10 == 1 || i10 == 2) {
            bArr[0] = 2;
            bArr[1] = 5;
            tlvBox.putByteValue(1, (byte) 2);
            tlvBox.putByteValue(2, bArr[1]);
            tlvBox.putBytesValue(9, this.msrpSignMessage);
            tlvBox.putBytesValue(10, this.msrpSignature);
            this.mSrpSalt = new byte[32];
            new Random().nextBytes(this.mSrpSalt);
            tlvBox.putBytesValue(11, this.mSrpSalt);
        }
        byte[] serialize = tlvBox.serialize();
        byte[] protocolMerge = protocolMerge(buildHeader(new NLProtocolBuiler().getVerifyCmd(), serialize.length).getBytes(), serialize);
        CLog.d(TAG, new String(protocolMerge));
        return protocolMerge;
    }

    public String getEncryptState() {
        return this.mEncryptState;
    }

    public String getSrpPassword() {
        return this.srpPassword;
    }

    public boolean parsePlayerInfoResponse(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        String str = new String(bArr);
        CLog.d(TAG, str);
        try {
            NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(str.getBytes()));
            if (nSDictionary != null && nSDictionary.containsKey("atv")) {
                String obj = nSDictionary.get((Object) "atv").toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mAtv = Integer.valueOf(obj).intValue();
                }
            }
            CLog.d(TAG, "atv : " + this.mAtv);
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public boolean parseSetupResponse(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        String firstLineOfHeader = ProtocolUtils.getFirstLineOfHeader(bArr);
        CLog.i(TAG, "parseSetupResponse  ->" + firstLineOfHeader);
        if (firstLineOfHeader.contains(ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT)) {
            this.mEncryptState = ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT;
            return false;
        }
        byte[] body = ProtocolUtils.getBody(bArr);
        if (body == null || this.isRelase) {
            this.mEncryptState = "failed";
            return false;
        }
        TlvBox parse = TlvBox.parse(body, 0, body.length, 2);
        if (parse == null) {
            this.mEncryptState = "failed";
            return false;
        }
        this.mRcvType = parse.getByteValue(1).byteValue();
        this.mRcvStage = parse.getByteValue(2).byteValue();
        int i10 = this.mAtv;
        if (i10 == 0) {
            byte[] bytesValue = parse.getBytesValue(3);
            byte[] bArr2 = this.mRcvEdPk;
            System.arraycopy(bytesValue, 0, bArr2, 0, bArr2.length);
            byte[] bArr3 = this.mRcvEdPkSalt;
            System.arraycopy(bytesValue, 32, bArr3, 0, bArr3.length);
        } else if (i10 == 1 || i10 == 2) {
            this.mRcvSrpPuk = parse.getBytesValue(5);
            byte[] bytesValue2 = parse.getBytesValue(6);
            ClientSessionImpl clientSessionImpl = new ClientSessionImpl();
            this.srp6ClientSession = clientSessionImpl;
            clientSessionImpl.step1(LELINK_USER, this.srpPassword);
            try {
                this.srp6ClientSession.step2(SRP6CryptoParams.getInstance(2048, "SHA-1"), BigIntegerUtils.bigIntegerFromBytes(bytesValue2), BigIntegerUtils.bigIntegerFromBytes(this.mRcvSrpPuk));
            } catch (SRP6Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        return true;
    }

    public boolean parseVerifyM1Response(byte[] bArr) {
        String firstLineOfHeader = ProtocolUtils.getFirstLineOfHeader(bArr);
        CLog.i(TAG, "parseVerifyM1Response  ->" + firstLineOfHeader);
        if (firstLineOfHeader.contains(ProtocolBuilder.LELINK_AUTH_ERROR)) {
            this.mEncryptState = ProtocolBuilder.LELINK_AUTH_ERROR;
            return false;
        }
        byte[] body = ProtocolUtils.getBody(bArr);
        if (body == null || this.isRelase) {
            this.mEncryptState = "failed";
            return false;
        }
        TlvBox parse = TlvBox.parse(body, 0, body.length, 3);
        if (parse == null) {
            this.mEncryptState = "failed";
            return false;
        }
        this.mRcvType = parse.getByteValue(1).byteValue();
        this.mRcvStage = parse.getByteValue(2).byteValue();
        int i10 = this.mAtv;
        if (i10 == 0) {
            byte[] bytesValue = parse.getBytesValue(4);
            byte[] bArr2 = new byte[32];
            this.mRcvCurvePkey = bArr2;
            this.mRcvSignatrue = new byte[64];
            System.arraycopy(bytesValue, 0, bArr2, 0, bArr2.length);
            byte[] bArr3 = this.mRcvSignatrue;
            System.arraycopy(bytesValue, 32, bArr3, 0, bArr3.length);
            byte[] bArr4 = new byte[32];
            this.sharedSecret = bArr4;
            Curve25519.curve(bArr4, this.mCurvePrkey, this.mRcvCurvePkey);
            try {
                byte[] bArr5 = new byte[64];
                this.mEd25519Encrypt.aecrypt(genSha512(SALT_KEY.getBytes(), this.sharedSecret, 16), genSha512(SALT_IV.getBytes(), this.sharedSecret, 16), this.mRcvSignatrue, 0, 64, bArr5, 0, false);
                byte[] bArr6 = new byte[64];
                byte[] bArr7 = this.mRcvCurvePkey;
                System.arraycopy(bArr7, 0, bArr6, 0, bArr7.length);
                byte[] bArr8 = this.mCurvePukey;
                System.arraycopy(bArr8, 0, bArr6, 32, bArr8.length);
                if (this.mEd25519Encrypt.verify(this.mRcvEdPk, bArr6, bArr5)) {
                    this.mEncryptState = "successful";
                } else {
                    this.mEncryptState = "failed";
                }
                return this.mEncryptState.equals("successful");
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        } else if (i10 == 1 || i10 == 2) {
            try {
                this.srp6ClientSession.step3(BigIntegerUtils.bigIntegerFromBytes(parse.getBytesValue(8)));
                this.chachaMaterKey = genSha512(SRP_SALT_KEY.getBytes(), this.srp6ClientSession.getSessionKeyHash(), 32);
                this.chachaNonce = genSha512(SRP_SALT_IV.getBytes(), this.srp6ClientSession.getSessionKeyHash(), 16);
                byte[] bArr9 = new byte[64];
                this.msrpSignMessage = bArr9;
                System.arraycopy(this.mSrpPukey, 0, bArr9, 0, 32);
                System.arraycopy(this.mRcvSrpPuk, 0, this.msrpSignMessage, 32, 32);
                byte[] bArr10 = new byte[64];
                this.mChachaSignMessage = bArr10;
                System.arraycopy(this.msrpSignMessage, 0, bArr10, 0, bArr10.length);
                this.msrpSignature = chachaEncryptAndGenSignature(this.msrpSignMessage);
                return true;
            } catch (SRP6Exception e11) {
                CLog.w(TAG, e11);
            }
        }
        this.mEncryptState = "failed";
        return false;
    }

    public boolean parseVerifyM2Response(byte[] bArr) {
        String firstLineOfHeader = ProtocolUtils.getFirstLineOfHeader(bArr);
        CLog.i(TAG, "parseVerifyM2Response  ->" + firstLineOfHeader);
        if (firstLineOfHeader.contains(ProtocolBuilder.LELINK_AUTH_ERROR)) {
            this.mEncryptState = ProtocolBuilder.LELINK_AUTH_ERROR;
            return false;
        }
        byte[] body = ProtocolUtils.getBody(bArr);
        if (body == null || body.length == 0 || this.isRelase) {
            this.mEncryptState = "failed";
            return false;
        }
        TlvBox parse = TlvBox.parse(body, 0, body.length, 4);
        if (parse == null) {
            this.mEncryptState = "failed";
            return false;
        }
        int i10 = this.mAtv;
        if (i10 == 0) {
            this.mRcvType = parse.getByteValue(1).byteValue();
            this.mRcvStage = parse.getByteValue(2).byteValue();
            parse.getBytesValue(5);
            byte[] genSha512 = genSha512(this.sharedSecret, genSha512(this.sharedSecret, genSha512(this.mKeySalt, this.mRcvEdPkSalt, 32), 32), 32);
            this.chachaMaterKey = genSha512(genSha512, IDE_SALT_KEY.getBytes(), 32);
            this.chachaNonce = genSha512(genSha512, IDE_NONCE.getBytes(), 32);
        } else if (i10 == 1 || i10 == 2) {
            this.mRcvType = parse.getByteValue(1).byteValue();
            this.mRcvStage = parse.getByteValue(2).byteValue();
            byte[] bytesValue = parse.getBytesValue(9);
            byte[] bytesValue2 = parse.getBytesValue(10);
            byte[] bytesValue3 = parse.getBytesValue(11);
            if (chachaDecrypt(bytesValue, bytesValue2)) {
                this.mDeChaCha20 = null;
                this.mEnChaCha20 = null;
                byte[] genSha5122 = genSha512(this.mSrpSalt, bytesValue3, 32);
                byte[] bArr2 = new byte[32];
                System.arraycopy(this.srp6ClientSession.getSessionKeyHash(), 0, bArr2, 0, 32);
                byte[] genSha5123 = genSha512(bArr2, genSha512(bArr2, genSha5122, 32), 32);
                this.chachaMaterKey = genSha512(genSha5123, SRP_IDE_SALT_KEY.getBytes(), 32);
                this.chachaNonce = genSha512(genSha5123, SRP_IDE_NONCE.getBytes(), 32);
            }
        }
        return true;
    }

    public void release() {
        this.isRelase = true;
        this.mRcvEdPk = null;
        this.mRcvEdPkSalt = null;
        this.mRcvType = (byte) 0;
        this.mRcvStage = (byte) 0;
        this.mSecretkey = null;
        this.mEdPukey = null;
        this.mKeySalt = null;
        this.mType = (byte) 0;
        this.mStage = (byte) 0;
        this.mCurvePukey = null;
        this.mCurvePrkey = null;
        this.mRcvCurvePkey = null;
        this.mRcvSignatrue = null;
        this.sharedSecret = null;
        this.mSessionId = null;
        this.chachaMaterKey = null;
        this.chachaNonce = null;
        this.mEnChaCha20 = null;
        this.mDeChaCha20 = null;
    }

    public void setSrpPassword(String str) {
        if (TextUtils.isEmpty(str)) {
            this.srpPassword = "000000";
        } else {
            this.srpPassword = str;
        }
    }
}
