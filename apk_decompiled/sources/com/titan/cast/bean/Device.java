package com.titan.cast.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class Device {
    private boolean alive;
    private String control_url;
    private String friendly_name;
    private String model_name;
    private String model_number;
    private String server_product;
    private String udn;

    public Device(String str, String str2, String str3, String str4, String str5, String str6, boolean z10) {
        i.g(str, "friendly_name");
        i.g(str2, "model_name");
        i.g(str3, "model_number");
        i.g(str4, "udn");
        i.g(str5, "control_url");
        i.g(str6, "server_product");
        this.friendly_name = str;
        this.model_name = str2;
        this.model_number = str3;
        this.udn = str4;
        this.control_url = str5;
        this.server_product = str6;
        this.alive = z10;
    }

    public static /* synthetic */ Device copy$default(Device device, String str, String str2, String str3, String str4, String str5, String str6, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = device.friendly_name;
        }
        if ((i10 & 2) != 0) {
            str2 = device.model_name;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = device.model_number;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = device.udn;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = device.control_url;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = device.server_product;
        }
        String str11 = str6;
        if ((i10 & 64) != 0) {
            z10 = device.alive;
        }
        return device.copy(str, str7, str8, str9, str10, str11, z10);
    }

    public final String component1() {
        return this.friendly_name;
    }

    public final String component2() {
        return this.model_name;
    }

    public final String component3() {
        return this.model_number;
    }

    public final String component4() {
        return this.udn;
    }

    public final String component5() {
        return this.control_url;
    }

    public final String component6() {
        return this.server_product;
    }

    public final boolean component7() {
        return this.alive;
    }

    public final Device copy(String str, String str2, String str3, String str4, String str5, String str6, boolean z10) {
        i.g(str, "friendly_name");
        i.g(str2, "model_name");
        i.g(str3, "model_number");
        i.g(str4, "udn");
        i.g(str5, "control_url");
        i.g(str6, "server_product");
        return new Device(str, str2, str3, str4, str5, str6, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return i.b(this.friendly_name, device.friendly_name) && i.b(this.model_name, device.model_name) && i.b(this.model_number, device.model_number) && i.b(this.udn, device.udn) && i.b(this.control_url, device.control_url) && i.b(this.server_product, device.server_product) && this.alive == device.alive;
    }

    public final boolean getAlive() {
        return this.alive;
    }

    public final String getControl_url() {
        return this.control_url;
    }

    public final String getFriendly_name() {
        return this.friendly_name;
    }

    public final String getModel_name() {
        return this.model_name;
    }

    public final String getModel_number() {
        return this.model_number;
    }

    public final String getServer_product() {
        return this.server_product;
    }

    public final String getUdn() {
        return this.udn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.friendly_name.hashCode() * 31) + this.model_name.hashCode()) * 31) + this.model_number.hashCode()) * 31) + this.udn.hashCode()) * 31) + this.control_url.hashCode()) * 31) + this.server_product.hashCode()) * 31;
        boolean z10 = this.alive;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setAlive(boolean z10) {
        this.alive = z10;
    }

    public final void setControl_url(String str) {
        i.g(str, "<set-?>");
        this.control_url = str;
    }

    public final void setFriendly_name(String str) {
        i.g(str, "<set-?>");
        this.friendly_name = str;
    }

    public final void setModel_name(String str) {
        i.g(str, "<set-?>");
        this.model_name = str;
    }

    public final void setModel_number(String str) {
        i.g(str, "<set-?>");
        this.model_number = str;
    }

    public final void setServer_product(String str) {
        i.g(str, "<set-?>");
        this.server_product = str;
    }

    public final void setUdn(String str) {
        i.g(str, "<set-?>");
        this.udn = str;
    }

    public String toString() {
        return "Device(friendly_name=" + this.friendly_name + ", model_name=" + this.model_name + ", model_number=" + this.model_number + ", udn=" + this.udn + ", control_url=" + this.control_url + ", server_product=" + this.server_product + ", alive=" + this.alive + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
