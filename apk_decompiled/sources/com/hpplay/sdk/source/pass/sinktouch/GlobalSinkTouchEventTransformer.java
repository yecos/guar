package com.hpplay.sdk.source.pass.sinktouch;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.hpplay.sdk.source.api.LelinkAccessibilityService;
import com.hpplay.sdk.source.bean.PathEventInfo;
import com.hpplay.sdk.source.bean.SinkTouchEvent;
import com.hpplay.sdk.source.bean.SinkTouchPointerInfo;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class GlobalSinkTouchEventTransformer {
    private static final String TAG = "GlobalSinkTouchEventTransformer";
    static float mStartX = -1.0f;
    static float mStartY = -1.0f;
    private static long mTouchDownTime;

    public static void transformEvent(SinkTouchEvent sinkTouchEvent) {
        transformPointerEvent(sinkTouchEvent.pointerInfos[0]);
    }

    private static void transformPointerEvent(SinkTouchPointerInfo sinkTouchPointerInfo) {
        transformWrapEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), sinkTouchPointerInfo.actionType, sinkTouchPointerInfo.ratioX, sinkTouchPointerInfo.ratioY, 0));
    }

    private static void transformWrapEvent(MotionEvent motionEvent) {
        SourceLog.i(TAG, "onTouchEvent action:" + motionEvent.getAction());
        if (motionEvent.getAction() == 0) {
            mTouchDownTime = System.currentTimeMillis();
            mStartX = motionEvent.getX();
            mStartY = motionEvent.getY();
            SourceLog.i(TAG, "onTouchEvent mStartX:" + mStartX + ",mStartY:" + mStartY + ", mTouchDownTime：" + mTouchDownTime);
            return;
        }
        if (motionEvent.getAction() == 1) {
            PathEventInfo pathEventInfo = new PathEventInfo(mStartX, mStartY, motionEvent.getX(), motionEvent.getY(), (int) (System.currentTimeMillis() - mTouchDownTime));
            if (mStartX == -1.0f && mStartY == -1.0f) {
                return;
            }
            SourceLog.i(TAG, "onTouchEvent TargetRatioX:" + pathEventInfo.getTargetRatioX() + ",TargetRatioY:" + pathEventInfo.getTargetRatioY() + ",duration：" + pathEventInfo.getDuration());
            LelinkAccessibilityService lelinkAccessibilityService = LelinkAccessibilityService.lelinkAccessibilityService;
            if (lelinkAccessibilityService != null) {
                lelinkAccessibilityService.moveOnScreen(pathEventInfo, null);
            }
            mStartX = -1.0f;
            mStartY = -1.0f;
        }
    }
}
