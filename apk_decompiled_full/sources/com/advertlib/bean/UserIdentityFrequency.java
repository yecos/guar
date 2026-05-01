package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes.dex */
public final class UserIdentityFrequency {
    private Integer identity_1;
    private Integer identity_2;
    private Integer identity_3;
    private Integer identity_4;
    private Integer identity_5;

    public UserIdentityFrequency(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.identity_1 = num;
        this.identity_2 = num2;
        this.identity_3 = num3;
        this.identity_4 = num4;
        this.identity_5 = num5;
    }

    public static /* synthetic */ UserIdentityFrequency copy$default(UserIdentityFrequency userIdentityFrequency, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = userIdentityFrequency.identity_1;
        }
        if ((i10 & 2) != 0) {
            num2 = userIdentityFrequency.identity_2;
        }
        Integer num6 = num2;
        if ((i10 & 4) != 0) {
            num3 = userIdentityFrequency.identity_3;
        }
        Integer num7 = num3;
        if ((i10 & 8) != 0) {
            num4 = userIdentityFrequency.identity_4;
        }
        Integer num8 = num4;
        if ((i10 & 16) != 0) {
            num5 = userIdentityFrequency.identity_5;
        }
        return userIdentityFrequency.copy(num, num6, num7, num8, num5);
    }

    public final Integer component1() {
        return this.identity_1;
    }

    public final Integer component2() {
        return this.identity_2;
    }

    public final Integer component3() {
        return this.identity_3;
    }

    public final Integer component4() {
        return this.identity_4;
    }

    public final Integer component5() {
        return this.identity_5;
    }

    public final UserIdentityFrequency copy(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        return new UserIdentityFrequency(num, num2, num3, num4, num5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserIdentityFrequency)) {
            return false;
        }
        UserIdentityFrequency userIdentityFrequency = (UserIdentityFrequency) obj;
        return i.b(this.identity_1, userIdentityFrequency.identity_1) && i.b(this.identity_2, userIdentityFrequency.identity_2) && i.b(this.identity_3, userIdentityFrequency.identity_3) && i.b(this.identity_4, userIdentityFrequency.identity_4) && i.b(this.identity_5, userIdentityFrequency.identity_5);
    }

    public final Integer getIdentity_1() {
        return this.identity_1;
    }

    public final Integer getIdentity_2() {
        return this.identity_2;
    }

    public final Integer getIdentity_3() {
        return this.identity_3;
    }

    public final Integer getIdentity_4() {
        return this.identity_4;
    }

    public final Integer getIdentity_5() {
        return this.identity_5;
    }

    public int hashCode() {
        Integer num = this.identity_1;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.identity_2;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.identity_3;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.identity_4;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.identity_5;
        return hashCode4 + (num5 != null ? num5.hashCode() : 0);
    }

    public final void setIdentity_1(Integer num) {
        this.identity_1 = num;
    }

    public final void setIdentity_2(Integer num) {
        this.identity_2 = num;
    }

    public final void setIdentity_3(Integer num) {
        this.identity_3 = num;
    }

    public final void setIdentity_4(Integer num) {
        this.identity_4 = num;
    }

    public final void setIdentity_5(Integer num) {
        this.identity_5 = num;
    }

    public String toString() {
        return "UserIdentityFrequency(identity_1=" + this.identity_1 + ", identity_2=" + this.identity_2 + ", identity_3=" + this.identity_3 + ", identity_4=" + this.identity_4 + ", identity_5=" + this.identity_5 + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
