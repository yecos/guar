package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;
import java.util.Deque;

@GwtCompatible
/* loaded from: classes2.dex */
final class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.on("");

    private static int doParseTrieToBuilder(Deque<CharSequence> deque, CharSequence charSequence, int i10, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        int length = charSequence.length();
        char c10 = 0;
        int i11 = i10;
        while (i11 < length && (c10 = charSequence.charAt(i11)) != '&' && c10 != '?' && c10 != '!' && c10 != ':' && c10 != ',') {
            i11++;
        }
        deque.push(reverse(charSequence.subSequence(i10, i11)));
        if (c10 == '!' || c10 == '?' || c10 == ':' || c10 == ',') {
            String join = PREFIX_JOINER.join(deque);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c10));
            }
        }
        int i12 = i11 + 1;
        if (c10 != '?' && c10 != ',') {
            while (i12 < length) {
                i12 += doParseTrieToBuilder(deque, charSequence, i12, builder);
                if (charSequence.charAt(i12) == '?' || charSequence.charAt(i12) == ',') {
                    i12++;
                    break;
                }
            }
        }
        deque.pop();
        return i12 - i10;
    }

    public static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            i10 += doParseTrieToBuilder(Queues.newArrayDeque(), charSequence, i10, builder);
        }
        return builder.buildOrThrow();
    }

    private static CharSequence reverse(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
