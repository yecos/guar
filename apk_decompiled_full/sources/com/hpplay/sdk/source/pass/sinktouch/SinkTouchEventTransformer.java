package com.hpplay.sdk.source.pass.sinktouch;

import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.sdk.source.bean.SinkTouchEvent;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.SinkTouchPointerInfo;
import com.hpplay.sdk.source.utils.AppContextUtils;
import com.umeng.analytics.pro.q;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
class SinkTouchEventTransformer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "SinkTouchEventTransform";
    private static long sDownTime;
    private static final Map<Integer, PointF> sPrePointers = new HashMap();
    private static int scaleCount = 0;
    private static boolean hasDownEvent = false;

    private static int calculateAngle(double d10, double d11, double d12, double d13) {
        double d14 = d12 - d10;
        double d15 = d13 - d11;
        if (d14 == 0.0d) {
            return d15 > 0.0d ? 90 : 270;
        }
        if (d15 == 0.0d) {
            return d14 >= 0.0d ? 0 : 180;
        }
        int atan = (int) ((Math.atan(d15 / d14) * 180.0d) / 3.141592653589793d);
        if (d14 > 0.0d && d15 > 0.0d) {
            return atan;
        }
        if (d14 < 0.0d && d15 > 0.0d) {
            return atan + 180;
        }
        if (d14 < 0.0d && d15 < 0.0d) {
            return atan + 180;
        }
        if (d14 <= 0.0d || d15 >= 0.0d) {
            return 0;
        }
        return atan + 360;
    }

    private static PointF calculateCenterXY(SinkTouchPointerInfo[] sinkTouchPointerInfoArr) {
        double d10 = 0.0d;
        double d11 = 0.0d;
        for (SinkTouchPointerInfo sinkTouchPointerInfo : sinkTouchPointerInfoArr) {
            PointF calculatePoint = calculatePoint(sinkTouchPointerInfo.ratioX, sinkTouchPointerInfo.ratioY);
            double d12 = calculatePoint.x;
            Double.isNaN(d12);
            d10 += d12;
            double d13 = calculatePoint.y;
            Double.isNaN(d13);
            d11 += d13;
        }
        double length = sinkTouchPointerInfoArr.length;
        Double.isNaN(length);
        float f10 = (float) (d10 / length);
        double length2 = sinkTouchPointerInfoArr.length;
        Double.isNaN(length2);
        return new PointF(f10, (float) (d11 / length2));
    }

    private static PointF calculatePoint(double d10, double d11) {
        double d12;
        double d13;
        SinkTouchEventArea touchEventArea = SinkTouchEventMonitor.getInstance().getTouchEventArea();
        if (touchEventArea == null) {
            int[] relScreenSize = ScreenUtil.getRelScreenSize(AppContextUtils.getInstance().getAppContext());
            double d14 = relScreenSize[0];
            Double.isNaN(d14);
            d12 = d14 * d10;
            d13 = relScreenSize[1];
            Double.isNaN(d13);
        } else {
            double d15 = touchEventArea.width;
            Double.isNaN(d15);
            d12 = d15 * d10;
            d13 = touchEventArea.height;
            Double.isNaN(d13);
        }
        return new PointF((float) d12, (float) (d13 * d11));
    }

    private static boolean isScaleGesture(SinkTouchPointerInfo[] sinkTouchPointerInfoArr) {
        if (sinkTouchPointerInfoArr.length == 1) {
            return false;
        }
        int[] iArr = new int[sinkTouchPointerInfoArr.length];
        int i10 = 0;
        int i11 = 0;
        for (SinkTouchPointerInfo sinkTouchPointerInfo : sinkTouchPointerInfoArr) {
            if (sPrePointers.get(Integer.valueOf(sinkTouchPointerInfo.pointerId)) != null) {
                PointF calculatePoint = calculatePoint(r8.ratioX, r8.ratioY);
                iArr[i10] = calculateAngle(r9.x, r9.y, calculatePoint.x, calculatePoint.y);
                i11++;
                i10++;
            }
        }
        int i12 = 0;
        while (i12 < i11) {
            int i13 = i12 + 1;
            for (int i14 = i13; i14 < i11; i14++) {
                int abs = Math.abs(iArr[i12] - iArr[i14]);
                if (abs > 120 && abs < 240) {
                    return true;
                }
            }
            i12 = i13;
        }
        return false;
    }

    public static void transformEvent(SinkTouchEvent sinkTouchEvent) {
        transformPointerEvent(sinkTouchEvent.pointerInfos);
    }

    private static void transformPointerEvent(SinkTouchPointerInfo[] sinkTouchPointerInfoArr) {
        if (sinkTouchPointerInfoArr.length <= 0) {
            return;
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[sinkTouchPointerInfoArr.length];
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[sinkTouchPointerInfoArr.length];
        if (SinkTouchEventMonitor.getInstance().getTouchScaleModulus() > 1.0f && scaleCount < 2 && isScaleGesture(sinkTouchPointerInfoArr)) {
            scaleCount++;
        }
        PointF calculateCenterXY = scaleCount >= 2 ? calculateCenterXY(sinkTouchPointerInfoArr) : null;
        int i10 = sinkTouchPointerInfoArr[0].actionType;
        int i11 = 0;
        for (SinkTouchPointerInfo sinkTouchPointerInfo : sinkTouchPointerInfoArr) {
            PointF calculatePoint = calculatePoint(sinkTouchPointerInfo.ratioX, sinkTouchPointerInfo.ratioY);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            if (scaleCount >= 2) {
                float f10 = calculatePoint.x;
                pointerCoords.x = f10 + ((f10 - calculateCenterXY.x) * SinkTouchEventMonitor.getInstance().getTouchScaleModulus());
                float f11 = calculatePoint.y;
                pointerCoords.y = f11 + ((f11 - calculateCenterXY.y) * SinkTouchEventMonitor.getInstance().getTouchScaleModulus());
            } else {
                pointerCoords.x = calculatePoint.x;
                pointerCoords.y = calculatePoint.y;
            }
            pointerCoordsArr[i11] = pointerCoords;
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            int i12 = sinkTouchPointerInfo.pointerId;
            pointerProperties.id = i12;
            pointerProperties.toolType = 1;
            pointerPropertiesArr[i11] = pointerProperties;
            if (sinkTouchPointerInfo.actionType == 0 || !hasDownEvent) {
                Map<Integer, PointF> map = sPrePointers;
                map.clear();
                scaleCount = 0;
                sDownTime = SystemClock.uptimeMillis();
                hasDownEvent = true;
                map.put(Integer.valueOf(sinkTouchPointerInfo.pointerId), calculatePoint);
                i10 = 0;
                break;
            }
            sPrePointers.put(Integer.valueOf(i12), calculatePoint);
            i11++;
        }
        if (i10 == 1) {
            hasDownEvent = false;
        }
        SinkTouchEventDispatcher.getInstance().notifyTouchEvent(MotionEvent.obtain(sDownTime, SystemClock.uptimeMillis(), sinkTouchPointerInfoArr.length > 1 ? (65280 | i10) & ((sinkTouchPointerInfoArr[0].activePointerId << 8) | 255) : i10, sinkTouchPointerInfoArr.length, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 8, 0, q.a.f10522b, 2));
    }
}
