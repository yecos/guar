package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import anet.channel.util.HttpConstant;
import com.google.common.primitives.Ints;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import k.a;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {
    static final long DISMISS_THRESHOLD_MILLIS = 20000;
    static final long IMPRESSION_THRESHOLD_MILLIS = 5000;
    static final long INTERVAL_MILLIS = 1000;
    private final FiamAnimator animator;
    private final Application application;
    private final RenewableTimer autoDismissTimer;
    private final BindingWrapperFactory bindingWrapperFactory;
    private FirebaseInAppMessagingDisplayCallbacks callbacks;
    String currentlyBoundActivityName;
    private FiamListener fiamListener;
    private final FirebaseInAppMessaging headlessInAppMessaging;
    private final FiamImageLoader imageLoader;
    private final RenewableTimer impressionTimer;
    private InAppMessage inAppMessage;
    private final Map<String, Provider<InAppMessageLayoutConfig>> layoutConfigs;
    private final FiamWindowManager windowManager;

    /* renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = iArr;
            try {
                iArr[MessageType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Inject
    public FirebaseInAppMessagingDisplay(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application, BindingWrapperFactory bindingWrapperFactory, FiamAnimator fiamAnimator) {
        this.headlessInAppMessaging = firebaseInAppMessaging;
        this.layoutConfigs = map;
        this.imageLoader = fiamImageLoader;
        this.impressionTimer = renewableTimer;
        this.autoDismissTimer = renewableTimer2;
        this.windowManager = fiamWindowManager;
        this.application = application;
        this.bindingWrapperFactory = bindingWrapperFactory;
        this.animator = fiamAnimator;
    }

    private void bindFiamToActivity(final Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            Logging.logi("Binding to activity: " + activity.getLocalClassName());
            this.headlessInAppMessaging.setMessageDisplayComponent(new com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay() { // from class: com.google.firebase.inappmessaging.display.a
                @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
                public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
                    FirebaseInAppMessagingDisplay.this.lambda$bindFiamToActivity$0(activity, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
                }
            });
            this.currentlyBoundActivityName = activity.getLocalClassName();
        }
        if (this.inAppMessage != null) {
            showActiveFiam(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTimers() {
        this.impressionTimer.cancel();
        this.autoDismissTimer.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissFiam(Activity activity) {
        Logging.logd("Dismissing fiam");
        notifyFiamDismiss();
        removeDisplayedFiam(activity);
        this.inAppMessage = null;
        this.callbacks = null;
    }

    private List<Action> extractActions(InAppMessage inAppMessage) {
        ArrayList arrayList = new ArrayList();
        int i10 = AnonymousClass5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        if (i10 == 1) {
            arrayList.add(((BannerMessage) inAppMessage).getAction());
        } else if (i10 == 2) {
            arrayList.add(((ModalMessage) inAppMessage).getAction());
        } else if (i10 == 3) {
            arrayList.add(((ImageOnlyMessage) inAppMessage).getAction());
        } else if (i10 != 4) {
            arrayList.add(Action.builder().build());
        } else {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            arrayList.add(cardMessage.getPrimaryAction());
            arrayList.add(cardMessage.getSecondaryAction());
        }
        return arrayList;
    }

    private ImageData extractImageData(InAppMessage inAppMessage) {
        if (inAppMessage.getMessageType() != MessageType.CARD) {
            return inAppMessage.getImageData();
        }
        CardMessage cardMessage = (CardMessage) inAppMessage;
        ImageData portraitImageData = cardMessage.getPortraitImageData();
        ImageData landscapeImageData = cardMessage.getLandscapeImageData();
        return getScreenOrientation(this.application) == 1 ? isValidImageData(portraitImageData) ? portraitImageData : landscapeImageData : isValidImageData(landscapeImageData) ? landscapeImageData : portraitImageData;
    }

    public static FirebaseInAppMessagingDisplay getInstance() {
        return (FirebaseInAppMessagingDisplay) FirebaseApp.getInstance().get(FirebaseInAppMessagingDisplay.class);
    }

    private static int getScreenOrientation(Application application) {
        return application.getResources().getConfiguration().orientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inflateBinding(final Activity activity, final BindingWrapper bindingWrapper) {
        View.OnClickListener onClickListener;
        if (this.inAppMessage == null) {
            return;
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
                }
                FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
            }
        };
        HashMap hashMap = new HashMap();
        for (final Action action : extractActions(this.inAppMessage)) {
            if (action == null || TextUtils.isEmpty(action.getActionUrl())) {
                Logging.logi("No action url found for action. Treating as dismiss.");
                onClickListener = onClickListener2;
            } else {
                onClickListener = new View.OnClickListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                            Logging.logi("Calling callback for click action");
                            FirebaseInAppMessagingDisplay.this.callbacks.messageClicked(action);
                        }
                        FirebaseInAppMessagingDisplay.this.launchUriIntent(activity, Uri.parse(action.getActionUrl()));
                        FirebaseInAppMessagingDisplay.this.notifyFiamClick();
                        FirebaseInAppMessagingDisplay.this.removeDisplayedFiam(activity);
                        FirebaseInAppMessagingDisplay.this.inAppMessage = null;
                        FirebaseInAppMessagingDisplay.this.callbacks = null;
                    }
                };
            }
            hashMap.put(action, onClickListener);
        }
        final ViewTreeObserver.OnGlobalLayoutListener inflate = bindingWrapper.inflate(hashMap, onClickListener2);
        if (inflate != null) {
            bindingWrapper.getImageView().getViewTreeObserver().addOnGlobalLayoutListener(inflate);
        }
        loadNullableImage(activity, bindingWrapper, extractImageData(this.inAppMessage), new FiamImageLoader.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4
            @Override // com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback
            public void onError(Exception exc) {
                Logging.loge("Image download failure ");
                if (inflate != null) {
                    bindingWrapper.getImageView().getViewTreeObserver().removeGlobalOnLayoutListener(inflate);
                }
                FirebaseInAppMessagingDisplay.this.cancelTimers();
                FirebaseInAppMessagingDisplay.this.inAppMessage = null;
                FirebaseInAppMessagingDisplay.this.callbacks = null;
            }

            @Override // com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback
            public void onSuccess() {
                if (!bindingWrapper.getConfig().backgroundEnabled().booleanValue()) {
                    bindingWrapper.getRootView().setOnTouchListener(new View.OnTouchListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 4) {
                                return false;
                            }
                            if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                            return true;
                        }
                    });
                }
                FirebaseInAppMessagingDisplay.this.impressionTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.2
                    @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                    public void onFinish() {
                        if (FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null) {
                            return;
                        }
                        Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                        FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                    }
                }, FirebaseInAppMessagingDisplay.IMPRESSION_THRESHOLD_MILLIS, 1000L);
                if (bindingWrapper.getConfig().autoDismiss().booleanValue()) {
                    FirebaseInAppMessagingDisplay.this.autoDismissTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.3
                        @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                        public void onFinish() {
                            if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                        }
                    }, FirebaseInAppMessagingDisplay.DISMISS_THRESHOLD_MILLIS, 1000L);
                }
                activity.runOnUiThread(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FiamWindowManager fiamWindowManager = FirebaseInAppMessagingDisplay.this.windowManager;
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        fiamWindowManager.show(bindingWrapper, activity);
                        if (bindingWrapper.getConfig().animate().booleanValue()) {
                            FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, bindingWrapper.getRootView(), FiamAnimator.Position.TOP);
                        }
                    }
                });
            }
        });
    }

    private boolean isValidImageData(ImageData imageData) {
        return (imageData == null || TextUtils.isEmpty(imageData.getImageUrl())) ? false : true;
    }

    private boolean ishttpOrHttpsUri(Uri uri) {
        String scheme;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return scheme.equalsIgnoreCase(HttpConstant.HTTP) || scheme.equalsIgnoreCase("https");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindFiamToActivity$0(Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        if (this.inAppMessage != null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.logd("Active FIAM exists. Skipping trigger");
            return;
        }
        this.inAppMessage = inAppMessage;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
        showActiveFiam(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchUriIntent(Activity activity, Uri uri) {
        if (ishttpOrHttpsUri(uri) && supportsCustomTabs(activity)) {
            k.a a10 = new a.C0242a().a();
            Intent intent = a10.f14719a;
            intent.addFlags(Ints.MAX_POWER_OF_TWO);
            intent.addFlags(268435456);
            a10.a(activity, uri);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", uri);
        ResolveInfo resolveActivity = activity.getPackageManager().resolveActivity(intent2, 0);
        intent2.addFlags(Ints.MAX_POWER_OF_TWO);
        intent2.addFlags(268435456);
        if (resolveActivity != null) {
            activity.startActivity(intent2);
        } else {
            Logging.loge("Device cannot resolve intent for: android.intent.action.VIEW");
        }
    }

    private void loadNullableImage(Activity activity, BindingWrapper bindingWrapper, ImageData imageData, FiamImageLoader.Callback callback) {
        if (isValidImageData(imageData)) {
            this.imageLoader.load(imageData.getImageUrl()).tag(activity.getClass()).placeholder(R.drawable.image_placeholder).into(bindingWrapper.getImageView(), callback);
        } else {
            callback.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFiamClick() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamClick();
        }
    }

    private void notifyFiamDismiss() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamDismiss();
        }
    }

    private void notifyFiamTrigger() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamTrigger();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDisplayedFiam(Activity activity) {
        if (this.windowManager.isFiamDisplayed()) {
            this.imageLoader.cancelTag(activity.getClass());
            this.windowManager.destroy(activity);
            cancelTimers();
        }
    }

    private void showActiveFiam(final Activity activity) {
        final BindingWrapper createBannerBindingWrapper;
        if (this.inAppMessage == null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.loge("No active message found to render");
            return;
        }
        if (this.inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED)) {
            Logging.loge("The message being triggered is not supported by this version of the sdk.");
            return;
        }
        notifyFiamTrigger();
        InAppMessageLayoutConfig inAppMessageLayoutConfig = this.layoutConfigs.get(InflaterConfigModule.configFor(this.inAppMessage.getMessageType(), getScreenOrientation(this.application))).get();
        int i10 = AnonymousClass5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[this.inAppMessage.getMessageType().ordinal()];
        if (i10 == 1) {
            createBannerBindingWrapper = this.bindingWrapperFactory.createBannerBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i10 == 2) {
            createBannerBindingWrapper = this.bindingWrapperFactory.createModalBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i10 == 3) {
            createBannerBindingWrapper = this.bindingWrapperFactory.createImageBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else {
            if (i10 != 4) {
                Logging.loge("No bindings found for this message type");
                return;
            }
            createBannerBindingWrapper = this.bindingWrapperFactory.createCardBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        }
        activity.findViewById(android.R.id.content).post(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.1
            @Override // java.lang.Runnable
            public void run() {
                FirebaseInAppMessagingDisplay.this.inflateBinding(activity, createBannerBindingWrapper);
            }
        });
    }

    private boolean supportsCustomTabs(Activity activity) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        intent.setPackage("com.android.chrome");
        List<ResolveInfo> queryIntentServices = activity.getPackageManager().queryIntentServices(intent, 0);
        return (queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true;
    }

    private void unbindFiamFromActivity(Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            return;
        }
        Logging.logi("Unbinding from activity: " + activity.getLocalClassName());
        this.headlessInAppMessaging.clearDisplayListener();
        removeDisplayedFiam(activity);
        this.currentlyBoundActivityName = null;
    }

    public void clearFiamListener() {
        this.fiamListener = null;
    }

    public InAppMessage getCurrentInAppMessage() {
        return this.inAppMessage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        unbindFiamFromActivity(activity);
        this.headlessInAppMessaging.removeAllListeners();
        super.onActivityPaused(activity);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        bindFiamToActivity(activity);
    }

    public void setFiamListener(FiamListener fiamListener) {
        this.fiamListener = fiamListener;
    }

    public void testMessage(Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
        showActiveFiam(activity);
    }
}
