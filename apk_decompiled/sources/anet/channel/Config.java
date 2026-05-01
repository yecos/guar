package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.umeng.analytics.pro.bd;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Config {

    /* renamed from: b, reason: collision with root package name */
    private String f3790b;

    /* renamed from: c, reason: collision with root package name */
    private String f3791c;

    /* renamed from: d, reason: collision with root package name */
    private ENV f3792d = ENV.ONLINE;

    /* renamed from: e, reason: collision with root package name */
    private ISecurity f3793e;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Config> f3789a = new HashMap();
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f3794a;

        /* renamed from: b, reason: collision with root package name */
        private String f3795b;

        /* renamed from: c, reason: collision with root package name */
        private ENV f3796c = ENV.ONLINE;

        /* renamed from: d, reason: collision with root package name */
        private String f3797d;

        /* renamed from: e, reason: collision with root package name */
        private String f3798e;

        public Config build() {
            if (TextUtils.isEmpty(this.f3795b)) {
                throw new RuntimeException("appkey can not be null or empty!");
            }
            synchronized (Config.f3789a) {
                for (Config config : Config.f3789a.values()) {
                    if (config.f3792d == this.f3796c && config.f3791c.equals(this.f3795b)) {
                        ALog.w("awcn.Config", "duplicated config exist!", null, "appkey", this.f3795b, bd.f9974a, this.f3796c);
                        if (!TextUtils.isEmpty(this.f3794a)) {
                            Config.f3789a.put(this.f3794a, config);
                        }
                        return config;
                    }
                }
                Config config2 = new Config();
                config2.f3791c = this.f3795b;
                config2.f3792d = this.f3796c;
                if (TextUtils.isEmpty(this.f3794a)) {
                    config2.f3790b = StringUtils.concatString(this.f3795b, "$", this.f3796c.toString());
                } else {
                    config2.f3790b = this.f3794a;
                }
                if (TextUtils.isEmpty(this.f3798e)) {
                    config2.f3793e = anet.channel.security.c.a().createSecurity(this.f3797d);
                } else {
                    config2.f3793e = anet.channel.security.c.a().createNonSecurity(this.f3798e);
                }
                synchronized (Config.f3789a) {
                    Config.f3789a.put(config2.f3790b, config2);
                }
                return config2;
            }
        }

        public Builder setAppSecret(String str) {
            this.f3798e = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.f3795b = str;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.f3797d = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.f3796c = env;
            return this;
        }

        public Builder setTag(String str) {
            this.f3794a = str;
            return this;
        }
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (f3789a) {
            for (Config config : f3789a.values()) {
                if (config.f3792d == env && config.f3791c.equals(str)) {
                    return config;
                }
            }
            return null;
        }
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (f3789a) {
            config = f3789a.get(str);
        }
        return config;
    }

    public String getAppkey() {
        return this.f3791c;
    }

    public ENV getEnv() {
        return this.f3792d;
    }

    public ISecurity getSecurity() {
        return this.f3793e;
    }

    public String getTag() {
        return this.f3790b;
    }

    public String toString() {
        return this.f3790b;
    }
}
