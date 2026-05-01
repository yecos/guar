package com.google.android.gms.common.server.response;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.hpplay.component.common.ParamsMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {'u', 'l', 'l'};
    private static final char[] zab = {'r', 'u', 'e'};
    private static final char[] zac = {'r', 'u', 'e', '\"'};
    private static final char[] zad = {'a', 'l', 's', 'e'};
    private static final char[] zae = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zaf = {'\n'};
    private static final zai zag = new zaa();
    private static final zai zah = new zab();
    private static final zai zai = new zac();
    private static final zai zaj = new zad();
    private static final zai zak = new zae();
    private static final zai zal = new zaf();
    private static final zai zam = new zag();
    private static final zai zan = new zah();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[1024];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(1024);
    private final Stack zat = new Stack();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        throw new com.google.android.gms.common.server.response.FastParser.ParseException("Unexpected control character while reading string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String zaA(java.io.BufferedReader r8, char[] r9, java.lang.StringBuilder r10, char[] r11) {
        /*
            r0 = 0
            r10.setLength(r0)
            int r1 = r9.length
            r8.mark(r1)
            r1 = 0
            r2 = 0
        La:
            int r3 = r8.read(r9)
            r4 = -1
            if (r3 == r4) goto L68
            r4 = 0
        L12:
            if (r4 >= r3) goto L60
            char r5 = r9[r4]
            boolean r6 = java.lang.Character.isISOControl(r5)
            if (r6 == 0) goto L31
            if (r11 == 0) goto L29
            r6 = 0
        L1f:
            if (r6 > 0) goto L29
            char r7 = r11[r6]
            if (r7 != r5) goto L26
            goto L31
        L26:
            int r6 = r6 + 1
            goto L1f
        L29:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected control character while reading string"
            r8.<init>(r9)
            throw r8
        L31:
            r6 = 34
            r7 = 1
            if (r5 != r6) goto L53
            if (r2 != 0) goto L5c
            r10.append(r9, r0, r4)
            r8.reset()
            int r4 = r4 + r7
            long r2 = (long) r4
            r8.skip(r2)
            if (r1 == 0) goto L4e
            java.lang.String r8 = r10.toString()
            java.lang.String r8 = com.google.android.gms.common.util.JsonUtils.unescapeString(r8)
            return r8
        L4e:
            java.lang.String r8 = r10.toString()
            return r8
        L53:
            r6 = 92
            if (r5 != r6) goto L5c
            r1 = r2 ^ 1
            r2 = r1
            r1 = 1
            goto L5d
        L5c:
            r2 = 0
        L5d:
            int r4 = r4 + 1
            goto L12
        L60:
            r10.append(r9, r0, r3)
            int r3 = r9.length
            r8.mark(r3)
            goto La
        L68:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected EOF while parsing string"
            r8.<init>(r9)
            goto L71
        L70:
            throw r8
        L71:
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zaA(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    private final char zai(BufferedReader bufferedReader) {
        if (bufferedReader.read(this.zao) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.zao[0])) {
            if (bufferedReader.read(this.zao) == -1) {
                return (char) 0;
            }
        }
        return this.zao[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) {
        int i10;
        int i11;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 <= 0) {
            throw new ParseException("No number to parse");
        }
        char c10 = cArr[0];
        int i12 = c10 == '-' ? Integer.MIN_VALUE : ParamsMap.MirrorParams.CAPTRUESOURCE_FLAG_MIUI;
        int i13 = c10 == '-' ? 1 : 0;
        if (i13 < zam2) {
            i10 = i13 + 1;
            int digit = Character.digit(cArr[i13], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            i11 = -digit;
        } else {
            i10 = i13;
            i11 = 0;
        }
        while (i10 < zam2) {
            int i14 = i10 + 1;
            int digit2 = Character.digit(cArr[i10], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (i11 < -214748364) {
                throw new ParseException("Number too large");
            }
            int i15 = i11 * 10;
            if (i15 < i12 + digit2) {
                throw new ParseException("Number too large");
            }
            i11 = i15 - digit2;
            i10 = i14;
        }
        if (i13 == 0) {
            return -i11;
        }
        if (i10 > 1) {
            return i11;
        }
        throw new ParseException("No digits to parse");
    }

    private final int zam(BufferedReader bufferedReader, char[] cArr) {
        int i10;
        char zai2 = zai(bufferedReader);
        if (zai2 == 0) {
            throw new ParseException("Unexpected EOF");
        }
        if (zai2 == ',') {
            throw new ParseException("Missing value");
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return 0;
        }
        bufferedReader.mark(1024);
        if (zai2 == '\"') {
            i10 = 0;
            boolean z10 = false;
            while (i10 < 1024 && bufferedReader.read(cArr, i10, 1) != -1) {
                char c10 = cArr[i10];
                if (Character.isISOControl(c10)) {
                    throw new ParseException("Unexpected control character while reading string");
                }
                if (c10 == '\"') {
                    if (!z10) {
                        bufferedReader.reset();
                        bufferedReader.skip(i10 + 1);
                        return i10;
                    }
                } else if (c10 == '\\') {
                    z10 = !z10;
                    i10++;
                }
                z10 = false;
                i10++;
            }
        } else {
            cArr[0] = zai2;
            i10 = 1;
            while (i10 < 1024 && bufferedReader.read(cArr, i10, 1) != -1) {
                char c11 = cArr[i10];
                if (c11 == '}' || c11 == ',' || Character.isWhitespace(c11) || cArr[i10] == ']') {
                    bufferedReader.reset();
                    bufferedReader.skip(i10 - 1);
                    cArr[i10] = 0;
                    return i10;
                }
                i10++;
            }
        }
        if (i10 == 1024) {
            throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) {
        long j10;
        int i10;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0L;
        }
        char[] cArr = this.zaq;
        if (zam2 <= 0) {
            throw new ParseException("No number to parse");
        }
        char c10 = cArr[0];
        long j11 = c10 == '-' ? Long.MIN_VALUE : -9223372036854775807L;
        int i11 = c10 == '-' ? 1 : 0;
        if (i11 < zam2) {
            i10 = i11 + 1;
            int digit = Character.digit(cArr[i11], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            j10 = -digit;
        } else {
            j10 = 0;
            i10 = i11;
        }
        while (i10 < zam2) {
            int i12 = i10 + 1;
            int digit2 = Character.digit(cArr[i10], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (j10 < -922337203685477580L) {
                throw new ParseException("Number too large");
            }
            long j12 = j10 * 10;
            long j13 = digit2;
            if (j12 < j11 + j13) {
                throw new ParseException("Number too large");
            }
            j10 = j12 - j13;
            i10 = i12;
        }
        if (i11 == 0) {
            return -j10;
        }
        if (i10 > 1) {
            return j10;
        }
        throw new ParseException("No digits to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zao(BufferedReader bufferedReader) {
        return zap(bufferedReader, this.zap, this.zar, null);
    }

    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            return zaA(bufferedReader, cArr, sb, cArr2);
        }
        if (zai2 != 'n') {
            throw new ParseException("Expected string");
        }
        zax(bufferedReader, zaa);
        return null;
    }

    private final String zaq(BufferedReader bufferedReader) {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        }
        if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        }
        if (zai2 == '}') {
            zaw(2);
            return null;
        }
        throw new ParseException("Unexpected token: " + zai2);
    }

    private final String zar(BufferedReader bufferedReader) {
        bufferedReader.mark(1024);
        char zai2 = zai(bufferedReader);
        int i10 = 1;
        if (zai2 == '\"') {
            if (bufferedReader.read(this.zao) == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            char c10 = this.zao[0];
            boolean z10 = false;
            do {
                if (c10 == '\"') {
                    if (z10) {
                        c10 = '\"';
                        z10 = true;
                    }
                }
                z10 = c10 == '\\' ? !z10 : false;
                if (bufferedReader.read(this.zao) == -1) {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
                c10 = this.zao[0];
            } while (!Character.isISOControl(c10));
            throw new ParseException("Unexpected control character while reading string");
        }
        if (zai2 == ',') {
            throw new ParseException("Missing value");
        }
        if (zai2 == '[') {
            this.zat.push(5);
            bufferedReader.mark(32);
            if (zai(bufferedReader) != ']') {
                bufferedReader.reset();
                boolean z11 = false;
                loop1: while (true) {
                    boolean z12 = false;
                    while (i10 > 0) {
                        char zai3 = zai(bufferedReader);
                        if (zai3 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        }
                        if (Character.isISOControl(zai3)) {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                        if (zai3 == '\"') {
                            if (!z12) {
                                z11 = !z11;
                            }
                            zai3 = '\"';
                        }
                        if (zai3 == '[') {
                            if (!z11) {
                                i10++;
                            }
                            zai3 = '[';
                        }
                        if (zai3 == ']' && !z11) {
                            i10--;
                        }
                        if (zai3 == '\\' && z11) {
                            z12 = !z12;
                        }
                    }
                    zaw(5);
                    break loop1;
                }
            } else {
                zaw(5);
            }
        } else if (zai2 != '{') {
            bufferedReader.reset();
            zam(bufferedReader, this.zaq);
        } else {
            this.zat.push(1);
            bufferedReader.mark(32);
            char zai4 = zai(bufferedReader);
            if (zai4 == '}') {
                zaw(1);
            } else {
                if (zai4 != '\"') {
                    throw new ParseException("Unexpected token " + zai4);
                }
                bufferedReader.reset();
                zaq(bufferedReader);
                while (zar(bufferedReader) != null) {
                }
                zaw(1);
            }
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        }
        if (zai5 == '}') {
            zaw(2);
            return null;
        }
        throw new ParseException("Unexpected token " + zai5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigDecimal zas(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigInteger zat(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    private final ArrayList zau(BufferedReader bufferedReader, zai zaiVar) {
        char zai2 = zai(bufferedReader);
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        }
        if (zai2 != '[') {
            throw new ParseException("Expected start of array");
        }
        this.zat.push(5);
        ArrayList arrayList = new ArrayList();
        while (true) {
            bufferedReader.mark(1024);
            char zai3 = zai(bufferedReader);
            if (zai3 == 0) {
                throw new ParseException("Unexpected EOF");
            }
            if (zai3 != ',') {
                if (zai3 == ']') {
                    zaw(5);
                    return arrayList;
                }
                bufferedReader.reset();
                arrayList.add(zaiVar.zaa(this, bufferedReader));
            }
        }
    }

    private final ArrayList zav(BufferedReader bufferedReader, FastJsonResponse.Field field) {
        ArrayList arrayList = new ArrayList();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        }
        if (zai2 != '{') {
            throw new ParseException("Unexpected token: " + zai2);
        }
        this.zat.push(1);
        while (true) {
            try {
                FastJsonResponse zad2 = field.zad();
                if (!zaz(bufferedReader, zad2)) {
                    return arrayList;
                }
                arrayList.add(zad2);
                char zai3 = zai(bufferedReader);
                if (zai3 != ',') {
                    if (zai3 == ']') {
                        zaw(5);
                        return arrayList;
                    }
                    throw new ParseException("Unexpected token: " + zai3);
                }
                if (zai(bufferedReader) != '{') {
                    throw new ParseException("Expected start of next object in array");
                }
                this.zat.push(1);
            } catch (IllegalAccessException e10) {
                throw new ParseException("Error instantiating inner object", e10);
            } catch (InstantiationException e11) {
                throw new ParseException("Error instantiating inner object", e11);
            }
        }
    }

    private final void zaw(int i10) {
        if (this.zat.isEmpty()) {
            throw new ParseException("Expected state " + i10 + " but had empty stack");
        }
        int intValue = ((Integer) this.zat.pop()).intValue();
        if (intValue == i10) {
            return;
        }
        throw new ParseException("Expected state " + i10 + " but had " + intValue);
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) {
        int i10 = 0;
        while (true) {
            int length = cArr.length;
            if (i10 >= length) {
                return;
            }
            int read = bufferedReader.read(this.zap, 0, length - i10);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i11 = 0; i11 < read; i11++) {
                if (cArr[i11 + i10] != this.zap[i11]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i10 += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z10) {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            if (z10) {
                throw new ParseException("No boolean value found in string");
            }
            return zay(bufferedReader, true);
        }
        if (zai2 == 'f') {
            zax(bufferedReader, z10 ? zae : zad);
            return false;
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return false;
        }
        if (zai2 == 't') {
            zax(bufferedReader, z10 ? zac : zab);
            return true;
        }
        throw new ParseException("Unexpected token: " + zai2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zaz(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) {
        HashMap hashMap;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaq = zaq(bufferedReader);
        if (zaq == null) {
            zaw(1);
            return false;
        }
        while (zaq != null) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(zaq);
            if (field == null) {
                zaq = zar(bufferedReader);
            } else {
                this.zat.push(4);
                int i10 = field.zaa;
                switch (i10) {
                    case 0:
                        if (!field.zab) {
                            fastJsonResponse.zau(field, zal(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zav(field, zau(bufferedReader, zag));
                            break;
                        }
                    case 1:
                        if (!field.zab) {
                            fastJsonResponse.zae(field, zat(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zag(field, zau(bufferedReader, zam));
                            break;
                        }
                    case 2:
                        if (!field.zab) {
                            fastJsonResponse.zax(field, zan(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zay(field, zau(bufferedReader, zah));
                            break;
                        }
                    case 3:
                        if (!field.zab) {
                            fastJsonResponse.zaq(field, zak(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zas(field, zau(bufferedReader, zai));
                            break;
                        }
                    case 4:
                        if (!field.zab) {
                            fastJsonResponse.zam(field, zaj(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zao(field, zau(bufferedReader, zaj));
                            break;
                        }
                    case 5:
                        if (!field.zab) {
                            fastJsonResponse.zaa(field, zas(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zac(field, zau(bufferedReader, zan));
                            break;
                        }
                    case 6:
                        if (!field.zab) {
                            fastJsonResponse.zai(field, zay(bufferedReader, false));
                            break;
                        } else {
                            fastJsonResponse.zaj(field, zau(bufferedReader, zak));
                            break;
                        }
                    case 7:
                        if (!field.zab) {
                            fastJsonResponse.zaA(field, zao(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse.zaC(field, zau(bufferedReader, zal));
                            break;
                        }
                    case 8:
                        fastJsonResponse.zal(field, Base64Utils.decode(zap(bufferedReader, this.zaq, this.zas, zaf)));
                        break;
                    case 9:
                        fastJsonResponse.zal(field, Base64Utils.decodeUrlSafe(zap(bufferedReader, this.zaq, this.zas, zaf)));
                        break;
                    case 10:
                        char zai2 = zai(bufferedReader);
                        if (zai2 == 'n') {
                            zax(bufferedReader, zaa);
                            hashMap = null;
                        } else {
                            if (zai2 != '{') {
                                throw new ParseException("Expected start of a map object");
                            }
                            this.zat.push(1);
                            hashMap = new HashMap();
                            while (true) {
                                char zai3 = zai(bufferedReader);
                                if (zai3 == 0) {
                                    throw new ParseException("Unexpected EOF");
                                }
                                if (zai3 == '\"') {
                                    String zaA = zaA(bufferedReader, this.zap, this.zar, null);
                                    if (zai(bufferedReader) != ':') {
                                        throw new ParseException("No map value found for key ".concat(String.valueOf(zaA)));
                                    }
                                    if (zai(bufferedReader) != '\"') {
                                        throw new ParseException("Expected String value for key ".concat(String.valueOf(zaA)));
                                    }
                                    hashMap.put(zaA, zaA(bufferedReader, this.zap, this.zar, null));
                                    char zai4 = zai(bufferedReader);
                                    if (zai4 != ',') {
                                        if (zai4 != '}') {
                                            throw new ParseException("Unexpected character while parsing string map: " + zai4);
                                        }
                                        zaw(1);
                                    }
                                } else if (zai3 == '}') {
                                    zaw(1);
                                }
                            }
                        }
                        fastJsonResponse.zaB(field, hashMap);
                        break;
                    case 11:
                        if (field.zab) {
                            char zai5 = zai(bufferedReader);
                            if (zai5 == 'n') {
                                zax(bufferedReader, zaa);
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                                break;
                            } else {
                                this.zat.push(5);
                                if (zai5 != '[') {
                                    throw new ParseException("Expected array start");
                                }
                                fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                                break;
                            }
                        } else {
                            char zai6 = zai(bufferedReader);
                            if (zai6 == 'n') {
                                zax(bufferedReader, zaa);
                                fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                                break;
                            } else {
                                this.zat.push(1);
                                if (zai6 != '{') {
                                    throw new ParseException("Expected start of object");
                                }
                                try {
                                    FastJsonResponse zad2 = field.zad();
                                    zaz(bufferedReader, zad2);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, zad2);
                                    break;
                                } catch (IllegalAccessException e10) {
                                    throw new ParseException("Error instantiating inner object", e10);
                                } catch (InstantiationException e11) {
                                    throw new ParseException("Error instantiating inner object", e11);
                                }
                            }
                        }
                    default:
                        throw new ParseException("Invalid field type " + i10);
                }
                zaw(4);
                zaw(2);
                char zai7 = zai(bufferedReader);
                if (zai7 == ',') {
                    zaq = zaq(bufferedReader);
                } else {
                    if (zai7 != '}') {
                        throw new ParseException("Expected end of object or field separator, but found: " + zai7);
                    }
                    zaq = null;
                }
            }
        }
        zaw(1);
        return true;
    }

    @KeepForSdk
    public void parse(InputStream inputStream, T t10) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.zat.push(0);
                char zai2 = zai(bufferedReader);
                if (zai2 == 0) {
                    throw new ParseException("No data to parse");
                }
                if (zai2 == '[') {
                    this.zat.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t10.getFieldMappings();
                    if (fieldMappings.size() != 1) {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                    FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                    t10.addConcreteTypeArrayInternal(value, value.zae, zav(bufferedReader, value));
                } else {
                    if (zai2 != '{') {
                        throw new ParseException("Unexpected token: " + zai2);
                    }
                    this.zat.push(1);
                    zaz(bufferedReader, t10);
                }
                zaw(0);
            } catch (IOException e10) {
                throw new ParseException(e10);
            }
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException unused) {
            }
        }
    }
}
