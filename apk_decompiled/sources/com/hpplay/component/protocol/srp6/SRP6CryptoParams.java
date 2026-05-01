package com.hpplay.component.protocol.srp6;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class SRP6CryptoParams implements Serializable {
    private static final long serialVersionUID = -8758433435502894107L;
    public final String H;
    public final BigInteger N;

    /* renamed from: g, reason: collision with root package name */
    public final BigInteger f7365g;
    public static final BigInteger N_256 = new BigInteger("125617018995153554710546479714086468244499594888726646874671447258204721048803");
    public static final BigInteger N_512 = new BigInteger("11144252439149533417835749556168991736939157778924947037200268358613863350040339017097790259154750906072491181606044774215413467851989724116331597513345603");
    public static final BigInteger N_768 = new BigInteger("1087179135105457859072065649059069760280540086975817629066444682366896187793570736574549981488868217843627094867924800342887096064844227836735667168319981288765377499806385489913341488724152562880918438701129530606139552645689583147");
    public static final BigInteger N_1024 = new BigInteger("167609434410335061345139523764350090260135525329813904557420930309800865859473551531551523800013916573891864789934747039010546328480848979516637673776605610374669426214776197828492691384519453218253702788022233205683635831626913357154941914129985489522629902540768368409482248290641036967659389658897350067939");
    public static final BigInteger N_1536 = new BigInteger("1486998185923128292816507353619409521152457662596380074614818966810244974827752411420380336514078832314731499938313197533147998565301020797040787428051479639316928015998415709101293902971072960487527411068082311763171549170528008620813391411445907584912865222076100726050255271567749213905330659264908657221124284665444825474741087704974475795505492821585749417639344967192301749033325359286273431675492866492416941152646940908101472416714421046022696100064262587");
    public static final BigInteger N_2048 = new BigInteger("21766174458617435773191008891802753781907668374255538511144643224689886235383840957210909013086056401571399717235807266581649606472148410291413364152197364477180887395655483738115072677402235101762521901569820740293149529620419333266262073471054548368736039519702486226506248861060256971802984953561121442680157668000761429988222457090413873973970171927093992114751765168063614761119615476233422096442783117971236371647333871414335895773474667308967050807005509320424799678417036867928316761272274230314067548291133582479583061439577559347101961771406173684378522703483495337037655006751328447510550299250924469288819");
    public static final BigInteger g_common = BigInteger.valueOf(2);

    public SRP6CryptoParams(BigInteger bigInteger, BigInteger bigInteger2, String str) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("The prime parameter 'N' must not be null");
        }
        this.N = bigInteger;
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("The generator parameter 'g' must not be null");
        }
        BigInteger bigInteger3 = BigInteger.ONE;
        if (bigInteger2.equals(bigInteger3)) {
            throw new IllegalArgumentException("The generator parameter 'g' must not be 1");
        }
        if (bigInteger2.equals(bigInteger.subtract(bigInteger3))) {
            throw new IllegalArgumentException("The generator parameter 'g' must not equal N - 1");
        }
        if (bigInteger2.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("The generator parameter 'g' must not be 0");
        }
        this.f7365g = bigInteger2;
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Undefined hash algorithm 'H'");
        }
        if (isSupportedHashAlgorithm(str)) {
            this.H = str;
            return;
        }
        throw new IllegalArgumentException("Unsupported hash algorithm 'H': " + str);
    }

    public static SRP6CryptoParams getInstance(int i10, String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Undefined hash algorithm 'H'");
        }
        if (i10 == 256) {
            return new SRP6CryptoParams(N_256, g_common, str);
        }
        if (i10 == 512) {
            return new SRP6CryptoParams(N_512, g_common, str);
        }
        if (i10 == 768) {
            return new SRP6CryptoParams(N_768, g_common, str);
        }
        if (i10 == 1024) {
            return new SRP6CryptoParams(N_1024, g_common, str);
        }
        if (i10 == 1536) {
            return new SRP6CryptoParams(N_1536, g_common, str);
        }
        if (i10 == 2048) {
            return new SRP6CryptoParams(N_2048, g_common, str);
        }
        return null;
    }

    public static boolean isSupportedHashAlgorithm(String str) {
        try {
            MessageDigest.getInstance(str);
            return true;
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    public MessageDigest getMessageDigestInstance() {
        try {
            return MessageDigest.getInstance(this.H);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static SRP6CryptoParams getInstance() {
        return getInstance(512, "SHA-1");
    }
}
