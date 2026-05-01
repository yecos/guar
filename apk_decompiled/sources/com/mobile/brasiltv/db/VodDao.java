package com.mobile.brasiltv.db;

import a7.d;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import ba.t;
import com.mobile.brasiltv.utils.b0;
import com.umeng.analytics.AnalyticsConfig;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import ra.a;
import t9.i;

/* loaded from: classes.dex */
public final class VodDao implements a.b {
    private final String DATABASE_NAME;
    private final int DB_VERSION;
    private final boolean DUBUG_MODEL;
    private String TAG;
    private Context ctx;
    private final g db$delegate;

    public VodDao(Context context) {
        i.g(context, "ctx");
        this.ctx = context;
        this.TAG = "VodDao";
        this.DB_VERSION = 1;
        this.DATABASE_NAME = "KoocanPortCodeMobile.db";
        this.DUBUG_MODEL = true;
        this.db$delegate = h.b(new VodDao$db$2(this));
    }

    private final void addAlbumNewColumn(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("alter table albums add column " + str + " varchar(50)");
        } catch (SQLiteException e10) {
            e10.printStackTrace();
        }
    }

    private final void addLiveChannelColumn(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("alter table live_channel add column " + str + " int(6)");
        } catch (SQLiteException e10) {
            e10.printStackTrace();
        }
    }

    private final void addLiveOrderColumn(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("alter table live_order add column " + str + " varchar(50)");
        } catch (SQLiteException e10) {
            e10.printStackTrace();
        }
    }

    private final String getPoster(List<? extends PosterList> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (i.b(d.f279a.g(), ((PosterList) obj).getFileType())) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return "";
        }
        String fileUrl = ((PosterList) it.next()).getFileUrl();
        i.f(fileUrl, "it.fileUrl");
        return fileUrl;
    }

    private final String[] getTimeRange(int i10) {
        String[] strArr = new String[2];
        if (i10 == 0) {
            strArr[0] = y6.a.a(new Date());
        } else if (i10 == 1) {
            strArr[0] = y6.a.a(y6.a.g(new Date(), 7));
            strArr[1] = y6.a.a(new Date());
        } else if (i10 == 2) {
            strArr[0] = y6.a.a(y6.a.g(new Date(), 7));
        }
        return strArr;
    }

    public static /* synthetic */ Links queryRecordByContentId$default(VodDao vodDao, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        return vodDao.queryRecordByContentId(str, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[Catch: RuntimeException -> 0x004f, TryCatch #0 {RuntimeException -> 0x004f, blocks: (B:3:0x0006, B:5:0x0033, B:10:0x003f, B:13:0x0047), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[Catch: RuntimeException -> 0x004f, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x004f, blocks: (B:3:0x0006, B:5:0x0033, B:10:0x003f, B:13:0x0047), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void addLinks(com.mobile.brasiltv.db.Links r6) {
        /*
            r5 = this;
            java.lang.String r0 = "link"
            t9.i.g(r6, r0)
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.RuntimeException -> L4f
            r1.<init>()     // Catch: java.lang.RuntimeException -> L4f
            java.lang.String r2 = "contentId='"
            r1.append(r2)     // Catch: java.lang.RuntimeException -> L4f
            java.lang.String r2 = r6.getContentId()     // Catch: java.lang.RuntimeException -> L4f
            r1.append(r2)     // Catch: java.lang.RuntimeException -> L4f
            java.lang.String r2 = "' and position="
            r1.append(r2)     // Catch: java.lang.RuntimeException -> L4f
            int r2 = r6.getPosition()     // Catch: java.lang.RuntimeException -> L4f
            r1.append(r2)     // Catch: java.lang.RuntimeException -> L4f
            java.lang.String r1 = r1.toString()     // Catch: java.lang.RuntimeException -> L4f
            ra.a r2 = r5.getDb()     // Catch: java.lang.RuntimeException -> L4f
            java.lang.Class<com.mobile.brasiltv.db.Links> r3 = com.mobile.brasiltv.db.Links.class
            java.util.List r2 = r2.m(r3, r1)     // Catch: java.lang.RuntimeException -> L4f
            if (r2 == 0) goto L3c
            boolean r2 = r2.isEmpty()     // Catch: java.lang.RuntimeException -> L4f
            if (r2 == 0) goto L3a
            goto L3c
        L3a:
            r2 = 0
            goto L3d
        L3c:
            r2 = 1
        L3d:
            if (r2 == 0) goto L47
            ra.a r1 = r5.getDb()     // Catch: java.lang.RuntimeException -> L4f
            r1.r(r6)     // Catch: java.lang.RuntimeException -> L4f
            goto L4e
        L47:
            ra.a r2 = r5.getDb()     // Catch: java.lang.RuntimeException -> L4f
            r2.u(r6, r1)     // Catch: java.lang.RuntimeException -> L4f
        L4e:
            return
        L4f:
            r6 = move-exception
            r6.printStackTrace()
            java.lang.String r1 = r6.getMessage()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L6b
            t9.i.d(r1)
            r2 = 2
            r3 = 0
            java.lang.String r4 = "Could not allocate CursorWindow"
            boolean r0 = ba.t.o(r1, r4, r0, r2, r3)
            if (r0 == 0) goto L6b
            return
        L6b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.db.VodDao.addLinks(com.mobile.brasiltv.db.Links):void");
    }

    public final void addLiveSub(LiveSubProgram liveSubProgram) {
        i.g(liveSubProgram, "data");
        try {
            if (getDb().m(LiveSubProgram.class, "_pid = '" + liveSubProgram.get_pid() + '\'').size() == 0) {
                getDb().r(liveSubProgram);
            } else {
                getDb().t(liveSubProgram);
            }
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

    public final void addRecord(AssetData assetData, SimpleProgramList simpleProgramList, long j10, int i10, String str, long j11) {
        i.g(str, "type");
        if (assetData == null || simpleProgramList == null) {
            return;
        }
        boolean z10 = false;
        if (i10 >= 0 && i10 < assetData.getSimpleProgramList().size()) {
            z10 = true;
        }
        if (z10) {
            Album album = new Album();
            album.setContentId(assetData.getContentId());
            album.setType(str);
            album.setName(assetData.getName());
            album.setTypeId(Album.Companion.getDB_RECORD_TYPE());
            album.setProgramType(assetData.getProgramType());
            album.setVolumnCount(assetData.getVolumnCount());
            album.setUpdateCount(assetData.getUpdateCount());
            album.setSize("");
            album.setSaveTime(y6.a.e());
            album.setAlias(assetData.getAlias());
            album.setDirector(assetData.getDirector());
            album.setScore(assetData.getScore());
            album.setTags(assetData.getTags());
            album.setDescription(assetData.getDescription());
            album.setPosterUrl(getPoster(assetData.getPosterList()));
            album.setSeriesNumber(simpleProgramList.getSeriesNumber());
            album.setReleaseTime(assetData.getReleaseTime());
            album.setPlayIndex(i10);
            album.setPlayTime(j10);
            album.setPlayName(simpleProgramList.getName());
            album.setPlayContentId(simpleProgramList.getContentId());
            addRecord(album);
            Links links = new Links();
            links.setContentId(assetData.getContentId());
            links.setPosition(i10);
            links.setRecordTime(j10);
            links.setDuration(j11);
            links.setTitle(assetData.getName());
            addLinks(links);
        }
    }

    public final void delLiveSub(String str) {
        i.g(str, "pid");
        getDb().h(LiveSubProgram.class, "_pid = '" + str + '\'');
    }

    public final void deleteAllByAlbum(int i10) {
        getDb().h(Album.class, "typeId=" + i10);
    }

    public final void deleteAllLinks() {
        getDb().f(Links.class);
    }

    public final void deleteByAlbum(String str, int i10) {
        i.g(str, "contentId");
        getDb().h(Album.class, "contentId='" + str + "' and typeId=" + i10);
    }

    public final void deleteLinksByAlbumCode(String str) {
        i.g(str, "contentId");
        getDb().h(Links.class, "contentId='" + str + '\'');
    }

    public final void deleteLiveOrderByCodeAndTime(String str, String str2) {
        getDb().h(LiveOrder.class, "channelCode='" + str + "' and startTime='" + str2 + '\'');
    }

    public final void deleteUmengPushByMsgId(String str) {
        i.g(str, "msgId");
        getDb().h(UmengPush.class, "msgId='" + str + '\'');
    }

    public final a getDb() {
        Object value = this.db$delegate.getValue();
        i.f(value, "<get-db>(...)");
        return (a) value;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // ra.a.b
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        i.g(sQLiteDatabase, "db");
    }

    @Override // ra.a.b
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        i.g(sQLiteDatabase, "db");
    }

    public final List<Album> queryAlbumByTimeArea(int i10, int i11, String str, String str2) {
        i.g(str, "flied");
        i.g(str2, "sort");
        try {
            String str3 = getTimeRange(i10, i11, getTimeRange(i11)) + " order by " + str + ' ' + str2;
            b0.U(this, "where = " + str3);
            List<Album> m10 = getDb().m(Album.class, str3);
            i.f(m10, "db.findAllByWhere(Album::class.java, where)");
            return m10;
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

    public final List<Album> queryAllAlbumByType(int i10, String str, String str2) {
        i.g(str, "flied");
        i.g(str2, "sort");
        try {
            List<Album> m10 = getDb().m(Album.class, "typeId=" + i10 + " order by " + str + ' ' + str2);
            i.f(m10, "list");
            return m10;
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

    public final List<LiveOrder> queryAllLiveOrder() {
        try {
            List<LiveOrder> k10 = getDb().k(LiveOrder.class);
            i.f(k10, "db.findAll(LiveOrder::class.java)");
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

    public final List<LiveSubProgram> queryAllLiveSub() {
        try {
            List<LiveSubProgram> k10 = getDb().k(LiveSubProgram.class);
            i.f(k10, "db.findAll(LiveSubProgram::class.java)");
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

    public final List<Album> queryAllRecord() {
        try {
            List<Album> k10 = getDb().k(Album.class);
            i.f(k10, "db.findAll(Album::class.java)");
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

    public final List<Links> queryLinkByContentID(String str, int i10) {
        i.g(str, "contentId");
        try {
            List<Links> m10 = getDb().m(Links.class, "contentId='" + str + "' and position=" + i10);
            i.f(m10, "db.findAllByWhere(Links::class.java, where)");
            return m10;
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

    public final int queryLiveOrderByCodeAndTime(String str, String str2) {
        i.g(str, "channelCode");
        i.g(str2, AnalyticsConfig.RTD_START_TIME);
        try {
            List m10 = getDb().m(LiveOrder.class, "channelCode='" + str + "'and startTime='" + str2 + '\'');
            if (m10 == null || m10.size() <= 0) {
                return 0;
            }
            return m10.size();
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return 0;
                }
            }
            throw e10;
        }
    }

    public final List<LiveOrder> queryLiveOrderDataByCode(String str, String str2, String str3) {
        i.g(str, "channelCode");
        i.g(str2, "flied");
        i.g(str3, "sort");
        try {
            List<LiveOrder> m10 = getDb().m(LiveOrder.class, "channelCode='" + str + "' order by " + str2 + ' ' + str3);
            i.f(m10, "liveOrders");
            return m10;
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

    public final List<LiveSubProgram> queryLiveSubByDate(String str) {
        i.g(str, "startDate");
        try {
            List<LiveSubProgram> m10 = getDb().m(LiveSubProgram.class, "startTime LIKE '%" + str + "%'");
            i.f(m10, "db.findAllByWhere(LiveSu…m::class.java, whereArgs)");
            return m10;
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

    public final boolean queryLiveSubByPid(String str) {
        i.g(str, "pid");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_pid = '");
            sb.append(str);
            sb.append('\'');
            return getDb().m(LiveSubProgram.class, sb.toString()).size() != 0;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return false;
                }
            }
            throw e10;
        }
    }

    public final Links queryRecordByContentId(String str, int i10) {
        i.g(str, "contentId");
        try {
            List m10 = getDb().m(Album.class, "contentId='" + str + '\'');
            i.f(m10, "db.findAllByWhere(Album::class.java, where)");
            if (m10.isEmpty()) {
                return null;
            }
            if (i10 == -1) {
                i10 = ((Album) m10.get(0)).getPlayIndex();
            }
            List<Links> queryLinkByContentID = queryLinkByContentID(str, i10);
            if (queryLinkByContentID.isEmpty()) {
                return null;
            }
            return queryLinkByContentID.get(0);
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

    public final Album queryRecordInfo(String str) {
        i.g(str, "contentId");
        try {
            List m10 = getDb().m(Album.class, "contentId='" + str + '\'');
            i.f(m10, "db.findAllByWhere(Album::class.java, where)");
            if (m10.isEmpty()) {
                return null;
            }
            return (Album) m10.get(0);
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

    public final boolean queryZJByAlbumCode(String str, int i10) {
        i.g(str, "contentId");
        try {
            List m10 = getDb().m(Album.class, "contentId='" + str + "' and typeId=" + i10);
            if (m10 != null) {
                if (m10.size() > 0) {
                    return true;
                }
            }
            return false;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return false;
                }
            }
            throw e10;
        }
    }

    public final void setTAG(String str) {
        i.g(str, "<set-?>");
        this.TAG = str;
    }

    public final void updateAlbums(Album album) {
        i.g(album, "album");
        getDb().u(album, "contentId='" + album.getContentId() + "' and typeId=" + album.getTypeId());
    }

    public final boolean updateAlbumsIfexist(Album album) {
        i.g(album, "album");
        try {
            String str = "contentId='" + album.getContentId() + "' and typeId=" + album.getTypeId();
            if (getDb().m(Album.class, str).size() <= 0) {
                return false;
            }
            getDb().u(album, str);
            return true;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return false;
                }
            }
            throw e10;
        }
    }

    public final boolean updateUmengPushIfExist(UmengPush umengPush) {
        i.g(umengPush, "umengPush");
        try {
            String str = "msgId='" + umengPush.getMsgId() + '\'';
            b0.U(this, "where=" + str);
            if (getDb().m(UmengPush.class, str).size() <= 0) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("修改= ");
            String msgId = umengPush.getMsgId();
            i.d(msgId);
            sb.append(msgId);
            b0.U(this, sb.toString());
            getDb().u(umengPush, str);
            return true;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return false;
                }
            }
            throw e10;
        }
    }

    private final String getTimeRange(int i10, int i11, String[] strArr) {
        if (!(!(strArr.length == 0))) {
            return "";
        }
        if (i11 == 0) {
            return "typeId=" + i10 + " and saveTime>='" + strArr[0] + '\'';
        }
        if (i11 != 1) {
            if (i11 != 2) {
                return "";
            }
            return "typeId=" + i10 + " and (saveTime<'" + strArr[0] + "' and saveTime>='0') or saveTime is null";
        }
        return "typeId=" + i10 + " and saveTime>='" + strArr[0] + "' and saveTime<'" + strArr[1] + '\'';
    }

    public final void addRecord(Album album) {
        i.g(album, "album");
        try {
            String str = "contentId='" + album.getContentId() + "' and typeId=" + album.getTypeId();
            List m10 = getDb().m(Album.class, str);
            if (m10 != null && m10.size() != 0) {
                getDb().u(album, str);
                return;
            }
            getDb().r(album);
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
}
