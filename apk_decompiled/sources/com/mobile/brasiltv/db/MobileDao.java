package com.mobile.brasiltv.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import ba.t;
import com.umeng.analytics.pro.f;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.List;
import ra.a;
import t9.i;

/* loaded from: classes.dex */
public final class MobileDao implements a.b {
    private final String DATABASE_NAME;
    private final int DB_VERSION;
    private final boolean DUBUG_MODEL;
    private final String TAG;
    private Context context;
    private final g db$delegate;

    public MobileDao(Context context) {
        i.g(context, f.X);
        this.context = context;
        this.TAG = "MobileDao";
        this.DB_VERSION = 1;
        this.DATABASE_NAME = "CloudSteam.db";
        this.DUBUG_MODEL = true;
        this.db$delegate = h.b(new MobileDao$db$2(this));
    }

    public final void addAccount(SwitchAccountBean switchAccountBean) {
        i.g(switchAccountBean, "accountBean");
        try {
            if (switchAccountBean.getPassword().length() > 32) {
                String substring = switchAccountBean.getPassword().substring(0, 32);
                i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                switchAccountBean.setPassword(substring);
            }
            List m10 = getDb().m(SwitchAccountBean.class, "userId='" + switchAccountBean.getUserId() + '\'');
            List k10 = getDb().k(SwitchAccountBean.class);
            if (m10 != null && m10.size() != 0) {
                getDb().e(m10.get(0));
            } else if (k10 != null && k10.size() >= 5) {
                getDb().e(k10.get(0));
            }
            getDb().r(switchAccountBean);
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return;
                }
            }
            throw e10;
        }
    }

    public final void addAudioSetting(AudioSettingBean audioSettingBean) {
        i.g(audioSettingBean, "audioSetting");
        k7.f.e("增加一个局部音轨设置", new Object[0]);
        if (getDb().k(AudioSettingBean.class).size() == 100) {
            getDb().g(AudioSettingBean.class, 0);
        }
        List m10 = getDb().m(AudioSettingBean.class, "contentId='" + audioSettingBean.getContentId() + '\'');
        if (m10.size() != 0) {
            getDb().e(m10.get(0));
        }
        getDb().r(audioSettingBean);
    }

    public final void addSearchHistory(SearchHistory searchHistory) {
        i.g(searchHistory, "searchHistory");
        try {
            if (getDb().k(SearchHistory.class).size() == 10) {
                getDb().g(SearchHistory.class, 0);
            }
            List m10 = getDb().m(SearchHistory.class, "contentId='" + searchHistory.getContentId() + '\'');
            if (m10.size() != 0) {
                getDb().e(m10.get(0));
            }
            getDb().r(searchHistory);
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return;
                }
            }
            throw e10;
        }
    }

    public final void addSearchLiveHistory(SearchLiveHistory searchLiveHistory) {
        i.g(searchLiveHistory, "searchHistory");
        try {
            if (getDb().k(SearchLiveHistory.class).size() == 10) {
                getDb().g(SearchLiveHistory.class, 0);
            }
            List m10 = getDb().m(SearchLiveHistory.class, "channelCode='" + searchLiveHistory.getChannelCode() + '\'');
            if (m10.size() != 0) {
                getDb().e(m10.get(0));
            }
            getDb().r(searchLiveHistory);
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return;
                }
            }
            throw e10;
        }
    }

    public final void addSubtitleSetting(SubtitleSettingBean subtitleSettingBean) {
        i.g(subtitleSettingBean, "subtitleSetting");
        k7.f.e("增加一个局部字幕设置", new Object[0]);
        if (getDb().k(SubtitleSettingBean.class).size() == 100) {
            getDb().g(SubtitleSettingBean.class, 0);
        }
        List m10 = getDb().m(SubtitleSettingBean.class, "contentId='" + subtitleSettingBean.getContentId() + '\'');
        if (m10.size() != 0) {
            getDb().e(m10.get(0));
        }
        getDb().r(subtitleSettingBean);
    }

    public final void deleteAccount(SwitchAccountBean switchAccountBean) {
        i.g(switchAccountBean, "accountBean");
        try {
            List m10 = getDb().m(SwitchAccountBean.class, "userId='" + switchAccountBean.getUserId() + '\'');
            if (m10 == null || m10.size() == 0) {
                return;
            }
            getDb().e(m10.get(0));
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return;
                }
            }
            throw e10;
        }
    }

    public final void deleteAllAccount() {
        getDb().f(SwitchAccountBean.class);
    }

    public final void deleteAllSearchHistory() {
        getDb().f(SearchHistory.class);
    }

    public final void deleteAllSearchLiveHistory() {
        getDb().f(SearchLiveHistory.class);
    }

    public final a getDb() {
        Object value = this.db$delegate.getValue();
        i.f(value, "<get-db>(...)");
        return (a) value;
    }

    @Override // ra.a.b
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // ra.a.b
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public final SwitchAccountBean queryAccount(String str) {
        i.g(str, "userId");
        try {
            List m10 = getDb().m(SwitchAccountBean.class, "userId='" + str + '\'');
            if (m10 == null || m10.size() <= 0) {
                return null;
            }
            return (SwitchAccountBean) m10.get(0);
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return null;
                }
            }
            throw e10;
        }
    }

    public final List<SwitchAccountBean> queryAllAccount() {
        try {
            List<SwitchAccountBean> k10 = getDb().k(SwitchAccountBean.class);
            return k10 == null ? new ArrayList() : k10;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return new ArrayList();
                }
            }
            throw e10;
        }
    }

    public final List<AudioSettingBean> queryAllAudioSetting() {
        List<AudioSettingBean> k10 = getDb().k(AudioSettingBean.class);
        i.f(k10, "db.findAll(AudioSettingBean::class.java)");
        return k10;
    }

    public final List<SearchHistory> queryAllSearchHistory() {
        try {
            List<SearchHistory> k10 = getDb().k(SearchHistory.class);
            i.f(k10, "db.findAll(SearchHistory::class.java)");
            return k10;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return new ArrayList();
                }
            }
            throw e10;
        }
    }

    public final List<SearchLiveHistory> queryAllSearchLiveHistory() {
        try {
            List<SearchLiveHistory> k10 = getDb().k(SearchLiveHistory.class);
            i.f(k10, "db.findAll(SearchLiveHistory::class.java)");
            return k10;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return new ArrayList();
                }
            }
            throw e10;
        }
    }

    public final List<SubtitleSettingBean> queryAllSubtitleSetting() {
        List<SubtitleSettingBean> k10 = getDb().k(SubtitleSettingBean.class);
        i.f(k10, "db.findAll(SubtitleSettingBean::class.java)");
        return k10;
    }

    public final AudioSettingBean queryAudioSetting(String str) {
        i.g(str, "contentId");
        List m10 = getDb().m(AudioSettingBean.class, "contentId='" + str + '\'');
        if (m10 == null || m10.size() <= 0) {
            return null;
        }
        return (AudioSettingBean) m10.get(0);
    }

    public final SubtitleSettingBean querySubtitleSetting(String str) {
        i.g(str, "contentId");
        List m10 = getDb().m(SubtitleSettingBean.class, "contentId='" + str + '\'');
        if (m10 == null || m10.size() <= 0) {
            return null;
        }
        return (SubtitleSettingBean) m10.get(0);
    }

    public final boolean updateAccountEmail(String str, String str2, String str3) {
        SwitchAccountBean queryAccount;
        i.g(str, "userId");
        i.g(str2, "oldEmail");
        i.g(str3, "changedEmail");
        if (TextUtils.isEmpty(str) || (queryAccount = queryAccount(str)) == null || !TextUtils.equals(queryAccount.getUserName(), str2)) {
            return false;
        }
        queryAccount.setUserName(str3);
        getDb().t(queryAccount);
        return true;
    }
}
