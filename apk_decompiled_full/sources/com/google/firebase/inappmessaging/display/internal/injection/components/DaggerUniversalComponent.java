package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.display.dagger.internal.MapBuilder;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager_Factory;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.keys.LayoutConfigKey;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesCardLandscapeConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesCardPortraitConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesDisplayMetricsFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalLandscapeConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalPortraitConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerUniversalComponent implements UniversalComponent {
    private Provider<BindingWrapperFactory> bindingWrapperFactoryProvider;
    private Provider<FiamWindowManager> fiamWindowManagerProvider;
    private final InflaterConfigModule inflaterConfigModule;
    private Provider<Application> providesApplicationProvider;
    private Provider<InAppMessageLayoutConfig> providesBannerLandscapeLayoutConfigProvider;
    private Provider<InAppMessageLayoutConfig> providesBannerPortraitLayoutConfigProvider;
    private Provider<InAppMessageLayoutConfig> providesCardLandscapeConfigProvider;
    private Provider<InAppMessageLayoutConfig> providesCardPortraitConfigProvider;
    private Provider<DisplayMetrics> providesDisplayMetricsProvider;
    private Provider<InAppMessageLayoutConfig> providesLandscapeImageLayoutConfigProvider;
    private Provider<InAppMessageLayoutConfig> providesModalLandscapeConfigProvider;
    private Provider<InAppMessageLayoutConfig> providesModalPortraitConfigProvider;
    private Provider<InAppMessageLayoutConfig> providesPortraitImageLayoutConfigProvider;

    public static final class Builder {
        private ApplicationModule applicationModule;
        private InflaterConfigModule inflaterConfigModule;

        public Builder applicationModule(ApplicationModule applicationModule) {
            this.applicationModule = (ApplicationModule) Preconditions.checkNotNull(applicationModule);
            return this;
        }

        public UniversalComponent build() {
            Preconditions.checkBuilderRequirement(this.applicationModule, ApplicationModule.class);
            if (this.inflaterConfigModule == null) {
                this.inflaterConfigModule = new InflaterConfigModule();
            }
            return new DaggerUniversalComponent(this.applicationModule, this.inflaterConfigModule);
        }

        public Builder inflaterConfigModule(InflaterConfigModule inflaterConfigModule) {
            this.inflaterConfigModule = (InflaterConfigModule) Preconditions.checkNotNull(inflaterConfigModule);
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(ApplicationModule applicationModule, InflaterConfigModule inflaterConfigModule) {
        this.providesApplicationProvider = DoubleCheck.provider(ApplicationModule_ProvidesApplicationFactory.create(applicationModule));
        this.fiamWindowManagerProvider = DoubleCheck.provider(FiamWindowManager_Factory.create());
        this.bindingWrapperFactoryProvider = DoubleCheck.provider(BindingWrapperFactory_Factory.create(this.providesApplicationProvider));
        InflaterConfigModule_ProvidesDisplayMetricsFactory create = InflaterConfigModule_ProvidesDisplayMetricsFactory.create(inflaterConfigModule, this.providesApplicationProvider);
        this.providesDisplayMetricsProvider = create;
        this.providesPortraitImageLayoutConfigProvider = InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory.create(inflaterConfigModule, create);
        this.providesLandscapeImageLayoutConfigProvider = InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory.create(inflaterConfigModule, this.providesDisplayMetricsProvider);
        this.providesModalLandscapeConfigProvider = InflaterConfigModule_ProvidesModalLandscapeConfigFactory.create(inflaterConfigModule, this.providesDisplayMetricsProvider);
        this.providesModalPortraitConfigProvider = InflaterConfigModule_ProvidesModalPortraitConfigFactory.create(inflaterConfigModule, this.providesDisplayMetricsProvider);
        this.providesCardLandscapeConfigProvider = InflaterConfigModule_ProvidesCardLandscapeConfigFactory.create(inflaterConfigModule, this.providesDisplayMetricsProvider);
        this.providesCardPortraitConfigProvider = InflaterConfigModule_ProvidesCardPortraitConfigFactory.create(inflaterConfigModule, this.providesDisplayMetricsProvider);
        this.providesBannerPortraitLayoutConfigProvider = InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory.create(inflaterConfigModule, this.providesDisplayMetricsProvider);
        this.providesBannerLandscapeLayoutConfigProvider = InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory.create(inflaterConfigModule, this.providesDisplayMetricsProvider);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public DisplayMetrics displayMetrics() {
        return InflaterConfigModule_ProvidesDisplayMetricsFactory.providesDisplayMetrics(this.inflaterConfigModule, this.providesApplicationProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public FiamWindowManager fiamWindowManager() {
        return this.fiamWindowManagerProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public BindingWrapperFactory inflaterClient() {
        return this.bindingWrapperFactoryProvider.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public Map<String, Provider<InAppMessageLayoutConfig>> myKeyStringMap() {
        return MapBuilder.newMapBuilder(8).put(LayoutConfigKey.IMAGE_ONLY_PORTRAIT, this.providesPortraitImageLayoutConfigProvider).put(LayoutConfigKey.IMAGE_ONLY_LANDSCAPE, this.providesLandscapeImageLayoutConfigProvider).put(LayoutConfigKey.MODAL_LANDSCAPE, this.providesModalLandscapeConfigProvider).put(LayoutConfigKey.MODAL_PORTRAIT, this.providesModalPortraitConfigProvider).put(LayoutConfigKey.CARD_LANDSCAPE, this.providesCardLandscapeConfigProvider).put(LayoutConfigKey.CARD_PORTRAIT, this.providesCardPortraitConfigProvider).put(LayoutConfigKey.BANNER_PORTRAIT, this.providesBannerPortraitLayoutConfigProvider).put(LayoutConfigKey.BANNER_LANDSCAPE, this.providesBannerLandscapeLayoutConfigProvider).build();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.UniversalComponent
    public Application providesApplication() {
        return this.providesApplicationProvider.get();
    }

    private DaggerUniversalComponent(ApplicationModule applicationModule, InflaterConfigModule inflaterConfigModule) {
        this.inflaterConfigModule = inflaterConfigModule;
        initialize(applicationModule, inflaterConfigModule);
    }
}
