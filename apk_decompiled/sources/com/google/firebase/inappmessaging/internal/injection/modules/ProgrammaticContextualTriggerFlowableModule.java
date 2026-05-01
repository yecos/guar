package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class ProgrammaticContextualTriggerFlowableModule {
    private ProgramaticContextualTriggers triggers;

    public ProgrammaticContextualTriggerFlowableModule(ProgramaticContextualTriggers programaticContextualTriggers) {
        this.triggers = programaticContextualTriggers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$providesProgramaticContextualTriggerStream$1(final FlowableEmitter flowableEmitter) {
        this.triggers.setListener(new ProgramaticContextualTriggers.Listener() { // from class: o4.a
            @Override // com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers.Listener
            public final void onEventTrigger(String str) {
                FlowableEmitter.this.onNext(str);
            }
        });
    }

    @Provides
    @Singleton
    @ProgrammaticTrigger
    public ConnectableFlowable<String> providesProgramaticContextualTriggerStream() {
        ConnectableFlowable<String> publish = Flowable.create(new FlowableOnSubscribe() { // from class: o4.b
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                ProgrammaticContextualTriggerFlowableModule.this.lambda$providesProgramaticContextualTriggerStream$1(flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER).publish();
        publish.connect();
        return publish;
    }

    @Provides
    @Singleton
    @ProgrammaticTrigger
    public ProgramaticContextualTriggers providesProgramaticContextualTriggers() {
        return this.triggers;
    }
}
