package com.titan.thumbnail;

import android.net.Uri;
import android.text.TextUtils;
import ba.t;
import com.hpplay.a.a.a.d;
import com.raizlabs.android.dbflow.sql.language.Operator;
import h9.k;
import h9.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ThumbnailUtil {
    private static final String SnapShotUrl = "%1$s/snapshot/v1/%2$s?offset_in_zip=%3$d&source_url=%4$s";
    private static CombineData mCurrentCombine;
    private static int mHorizontalCount;
    private static ThumbnailResult mThumbnailResult;
    private static int mVerticalCount;
    public static final ThumbnailUtil INSTANCE = new ThumbnailUtil();
    private static final String TAG = ThumbnailUtil.class.getSimpleName();
    private static String mSnapInfoUrl = "";
    private static ArrayList<CombineData> mCombineList = new ArrayList<>();
    private static String mSnapShotHost = "";
    private static String mSourceUrl = "";

    private ThumbnailUtil() {
    }

    private final CombineData getCombine(long j10) {
        List<CombineData> combines;
        CombineData combineData = mCurrentCombine;
        if (combineData != null) {
            if (combineData == null) {
                i.q();
            }
            long startMoment = combineData.getStartMoment();
            CombineData combineData2 = mCurrentCombine;
            if (combineData2 == null) {
                i.q();
            }
            long endMoment = combineData2.getEndMoment();
            if (startMoment <= j10 && endMoment >= j10) {
                return mCurrentCombine;
            }
        }
        ThumbnailResult thumbnailResult = mThumbnailResult;
        CombineData combineData3 = null;
        if (thumbnailResult != null && (combines = thumbnailResult.getCombines()) != null) {
            for (CombineData combineData4 : combines) {
                long startMoment2 = combineData4.getStartMoment();
                long endMoment2 = combineData4.getEndMoment();
                if (startMoment2 <= j10 && endMoment2 >= j10) {
                    combineData3 = combineData4;
                }
            }
        }
        mCurrentCombine = combineData3;
        return combineData3;
    }

    private final String getHost(String str) {
        try {
            if (!TextUtils.isEmpty(str) && t.o(str, "//", false, 2, null) && t.o(str, Operator.Operation.DIVISION, false, 2, null)) {
                int x10 = t.x(str, '/', t.y(str, "//", 0, false, 6, null) + 2, false, 4, null);
                if (str == null) {
                    throw new q("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str.substring(0, x10);
                i.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private final int searchSnapshot(long j10, List<Snapshot> list) {
        int size = list.size() - 1;
        if (size <= 0) {
            return -1;
        }
        int i10 = (size + 0) / 2;
        int i11 = 0;
        while (i11 <= size) {
            i10 = (i11 + size) / 2;
            int i12 = i10 + 1;
            long moment = i12 < list.size() ? list.get(i12).getMoment() : list.get(i10).getMoment() + d.SOCKET_READ_TIMEOUT;
            if (j10 < list.get(i10).getMoment()) {
                size = i10 - 1;
            } else {
                if (j10 <= moment) {
                    return i10;
                }
                i11 = i12;
            }
        }
        return i10 >= list.size() + (-1) ? list.size() - 1 : i10;
    }

    public final ArrayList<CombineData> getCombineList() {
        return mCombineList;
    }

    public final String getCombineUrl(long j10) {
        CombineData combine = getCombine(j10);
        if (combine != null) {
            String format = String.format(SnapShotUrl, Arrays.copyOf(new Object[]{mSnapShotHost, combine.getName(), Long.valueOf(combine.getOffset()), Uri.encode(mSourceUrl)}, 4));
            i.c(format, "java.lang.String.format(this, *args)");
            if (format != null) {
                return format;
            }
        }
        return "";
    }

    public final CombineData getCurrentCombine() {
        return mCurrentCombine;
    }

    public final int getMHorizontalCount() {
        return mHorizontalCount;
    }

    public final int getMVerticalCount() {
        return mVerticalCount;
    }

    public final k getSnapshotPosition(long j10) {
        List<Snapshot> snapshots;
        int searchSnapshot;
        CombineData combine = getCombine(j10);
        if (combine == null || (snapshots = combine.getSnapshots()) == null || (searchSnapshot = INSTANCE.searchSnapshot(j10, snapshots)) == -1) {
            return new k(-1, -1);
        }
        int i10 = mHorizontalCount;
        int i11 = searchSnapshot % i10;
        double d10 = searchSnapshot / i10;
        Double.isNaN(d10);
        return new k(Integer.valueOf(i11), Integer.valueOf((int) (d10 + 0.5d)));
    }

    public final boolean hasThumbnail() {
        return mThumbnailResult != null;
    }

    public final void reset() {
        mThumbnailResult = null;
        mCombineList.clear();
        mCurrentCombine = null;
        mSnapShotHost = "";
        mSourceUrl = "";
    }

    public final void setData(ThumbnailResult thumbnailResult) {
        i.h(thumbnailResult, "thumbnailResult");
        mThumbnailResult = thumbnailResult;
        mCombineList.clear();
        ThumbnailResult thumbnailResult2 = mThumbnailResult;
        if (thumbnailResult2 == null) {
            i.q();
        }
        mHorizontalCount = thumbnailResult2.getCombine_wn();
        ThumbnailResult thumbnailResult3 = mThumbnailResult;
        if (thumbnailResult3 == null) {
            i.q();
        }
        mVerticalCount = thumbnailResult3.getCombine_hn();
        ThumbnailResult thumbnailResult4 = mThumbnailResult;
        if (thumbnailResult4 == null) {
            i.q();
        }
        String source_url = thumbnailResult4.getSource_url();
        if (source_url == null) {
            source_url = "";
        }
        mSourceUrl = source_url;
        ThumbnailResult thumbnailResult5 = mThumbnailResult;
        if (thumbnailResult5 == null) {
            i.q();
        }
        String source_url2 = thumbnailResult5.getSource_url();
        mSnapShotHost = getHost(source_url2 != null ? source_url2 : "");
        ThumbnailResult thumbnailResult6 = mThumbnailResult;
        if (thumbnailResult6 == null) {
            i.q();
        }
        List<CombineData> combines = thumbnailResult6.getCombines();
        if (combines != null) {
            for (CombineData combineData : combines) {
                if (combineData.getSnapshots() != null) {
                    if (combineData.getSnapshots() == null) {
                        i.q();
                    }
                    if (!r2.isEmpty()) {
                        List<Snapshot> snapshots = combineData.getSnapshots();
                        if (snapshots == null) {
                            i.q();
                        }
                        combineData.setStartMoment(snapshots.get(0).getMoment());
                        List<Snapshot> snapshots2 = combineData.getSnapshots();
                        if (snapshots2 == null) {
                            i.q();
                        }
                        if (combineData.getSnapshots() == null) {
                            i.q();
                        }
                        combineData.setEndMoment(snapshots2.get(r3.size() - 1).getMoment() + d.SOCKET_READ_TIMEOUT);
                    }
                }
            }
            mCombineList.addAll(combines);
        }
    }

    public final void setMHorizontalCount(int i10) {
        mHorizontalCount = i10;
    }

    public final void setMVerticalCount(int i10) {
        mVerticalCount = i10;
    }

    public final void setSnapInfoUrl(String str) {
        i.h(str, "url");
        mSnapInfoUrl = str;
        if (str.length() == 0) {
            reset();
        }
    }

    public final String getCombineUrl(CombineData combineData) {
        i.h(combineData, "combine");
        String format = String.format(SnapShotUrl, Arrays.copyOf(new Object[]{mSnapShotHost, combineData.getName(), Long.valueOf(combineData.getOffset()), Uri.encode(mSourceUrl)}, 4));
        i.c(format, "java.lang.String.format(this, *args)");
        return format;
    }
}
