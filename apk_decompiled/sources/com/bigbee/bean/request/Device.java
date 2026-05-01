package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import t9.i;

/* loaded from: classes.dex */
public final class Device {
    private boolean alive;
    private String casting_product;
    private String discovery_product;
    private String model;
    private String model_number;
    private String name;
    private String udn;

    public Device(String str, String str2, String str3, String str4, String str5, String str6, boolean z10) {
        i.g(str, "name");
        i.g(str2, "udn");
        i.g(str3, Constants.KEY_MODEL);
        i.g(str4, "model_number");
        i.g(str5, "casting_product");
        i.g(str6, "discovery_product");
        this.name = str;
        this.udn = str2;
        this.model = str3;
        this.model_number = str4;
        this.casting_product = str5;
        this.discovery_product = str6;
        this.alive = z10;
    }

    public static /* synthetic */ Device copy$default(Device device, String str, String str2, String str3, String str4, String str5, String str6, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = device.name;
        }
        if ((i10 & 2) != 0) {
            str2 = device.udn;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = device.model;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = device.model_number;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = device.casting_product;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = device.discovery_product;
        }
        String str11 = str6;
        if ((i10 & 64) != 0) {
            z10 = device.alive;
        }
        return device.copy(str, str7, str8, str9, str10, str11, z10);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.udn;
    }

    public final String component3() {
        return this.model;
    }

    public final String component4() {
        return this.model_number;
    }

    public final String component5() {
        return this.casting_product;
    }

    public final String component6() {
        return this.discovery_product;
    }

    public final boolean component7() {
        return this.alive;
    }

    public final Device copy(String str, String str2, String str3, String str4, String str5, String str6, boolean z10) {
        i.g(str, "name");
        i.g(str2, "udn");
        i.g(str3, Constants.KEY_MODEL);
        i.g(str4, "model_number");
        i.g(str5, "casting_product");
        i.g(str6, "discovery_product");
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
        return i.b(this.name, device.name) && i.b(this.udn, device.udn) && i.b(this.model, device.model) && i.b(this.model_number, device.model_number) && i.b(this.casting_product, device.casting_product) && i.b(this.discovery_product, device.discovery_product) && this.alive == device.alive;
    }

    public final boolean getAlive() {
        return this.alive;
    }

    public final String getCasting_product() {
        return this.casting_product;
    }

    public final String getDiscovery_product() {
        return this.discovery_product;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getModel_number() {
        return this.model_number;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUdn() {
        return this.udn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.name.hashCode() * 31) + this.udn.hashCode()) * 31) + this.model.hashCode()) * 31) + this.model_number.hashCode()) * 31) + this.casting_product.hashCode()) * 31) + this.discovery_product.hashCode()) * 31;
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

    public final void setCasting_product(String str) {
        i.g(str, "<set-?>");
        this.casting_product = str;
    }

    public final void setDiscovery_product(String str) {
        i.g(str, "<set-?>");
        this.discovery_product = str;
    }

    public final void setModel(String str) {
        i.g(str, "<set-?>");
        this.model = str;
    }

    public final void setModel_number(String str) {
        i.g(str, "<set-?>");
        this.model_number = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setUdn(String str) {
        i.g(str, "<set-?>");
        this.udn = str;
    }

    public String toString() {
        return "Device(name=" + this.name + ", udn=" + this.udn + ", model=" + this.model + ", model_number=" + this.model_number + ", casting_product=" + this.casting_product + ", discovery_product=" + this.discovery_product + ", alive=" + this.alive + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
