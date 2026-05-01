package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;

@InAppMessageScope
@Component(modules = {InflaterModule.class})
/* loaded from: classes2.dex */
public interface InAppMessageComponent {
    @InAppMessageScope
    BannerBindingWrapper bannerBindingWrapper();

    @InAppMessageScope
    CardBindingWrapper cardBindingWrapper();

    @InAppMessageScope
    ImageBindingWrapper imageBindingWrapper();

    @InAppMessageScope
    ModalBindingWrapper modalBindingWrapper();
}
