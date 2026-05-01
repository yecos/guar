package com.taobao.accs.ut.monitor;

import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;

@Monitor(module = "accs", monitorPoint = "netperformance")
/* loaded from: classes3.dex */
public class NetPerformanceMonitor extends BaseMonitor {

    /* renamed from: a, reason: collision with root package name */
    private long f9294a;

    @Dimension
    public int accs_sdk_version;

    @Dimension
    public int accs_type;

    /* renamed from: b, reason: collision with root package name */
    private long f9295b;

    /* renamed from: c, reason: collision with root package name */
    private long f9296c;
    public long check_command_time;
    public long check_process_time;
    public long check_routing_ack_time;
    public long check_routing_msg_time;
    public long check_space_time;
    public long control_msg_time;

    /* renamed from: d, reason: collision with root package name */
    private long f9297d;
    public String data_id;
    public String device_id;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long distribute_to_service_time;

    /* renamed from: e, reason: collision with root package name */
    private long f9298e;

    @Dimension
    public int error_code;

    /* renamed from: f, reason: collision with root package name */
    private long f9299f;

    @Dimension
    public String fail_reasons;

    /* renamed from: g, reason: collision with root package name */
    private long f9300g;

    @Dimension
    public String host;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long in_queue_time;

    @Dimension
    public int msgType;
    public long real_to_bz_date;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long receive_accs_to_call_time;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long receive_agoo_to_call_time;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long receive_to_call_back_time;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long receive_to_distribute_time;

    @Dimension
    public String ret;

    @Dimension
    public int retry_times;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long send_to_receive_time;

    @Dimension
    public String service_id = "none";
    public long service_recv;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long service_to_recv_time;
    public long start_service;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long start_to_enter_queue_time;
    public long take_date;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long talk_to_send_time;
    public long thread_schedule_time;
    public long to_tnet_date;

    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long total_time;

    private long a(long j10, long j11) {
        if (j10 <= 0 || j11 <= 0) {
            return 0L;
        }
        return j11 - j10;
    }

    @Override // com.taobao.accs.utl.BaseMonitor, anet.channel.statist.StatObject
    public boolean beforeCommit() {
        if (this.real_to_bz_date == 0) {
            this.real_to_bz_date = this.f9297d;
        }
        this.accs_sdk_version = Constants.SDK_VERSION_CODE;
        this.total_time = a(this.f9294a, this.real_to_bz_date);
        this.start_to_enter_queue_time = a(this.f9294a, this.f9295b);
        this.in_queue_time = a(this.f9295b, this.take_date);
        this.talk_to_send_time = a(this.take_date, this.to_tnet_date);
        this.send_to_receive_time = a(this.to_tnet_date, this.f9296c);
        this.receive_to_distribute_time = a(this.f9296c, this.f9297d);
        this.distribute_to_service_time = a(this.f9297d, this.start_service);
        this.service_to_recv_time = a(this.start_service, this.service_recv);
        this.receive_to_call_back_time = a(this.service_recv, this.real_to_bz_date);
        this.receive_accs_to_call_time = a(this.f9298e, this.f9299f);
        this.receive_agoo_to_call_time = a(this.f9298e, this.f9300g);
        if ("accs-impaas".equals(this.service_id)) {
            ALog.e("pref", "netperf", "dataid", this.data_id, "total_time", Long.valueOf(this.total_time), "before_queue", Long.valueOf(this.start_to_enter_queue_time), "in_queue", Long.valueOf(this.in_queue_time), "send", Long.valueOf(this.talk_to_send_time), "recv", Long.valueOf(this.send_to_receive_time), "distribute", Long.valueOf(this.receive_to_distribute_time), "startservice", Long.valueOf(this.distribute_to_service_time), "servicerecv", Long.valueOf(this.service_to_recv_time), "tobiz", Long.valueOf(this.receive_to_call_back_time));
        }
        return super.beforeCommit();
    }

    public void onEnterQueueData() {
        this.f9295b = System.currentTimeMillis();
    }

    public void onRecAck() {
        this.f9296c = System.currentTimeMillis();
    }

    public void onReceiveData() {
        this.f9298e = System.currentTimeMillis();
    }

    public void onSend() {
        this.f9294a = System.currentTimeMillis();
    }

    public void onSendData() {
        this.to_tnet_date = System.currentTimeMillis();
    }

    public void onTakeFromQueue() {
        this.take_date = System.currentTimeMillis();
    }

    public void onToAccsTime() {
        this.f9299f = System.currentTimeMillis();
    }

    public void onToAgooTime() {
        this.f9300g = System.currentTimeMillis();
    }

    public void onToBizDate() {
        this.f9297d = System.currentTimeMillis();
    }

    public void setConnType(int i10) {
        this.accs_type = i10;
    }

    public void setDataId(String str) {
        this.data_id = str;
    }

    public void setDeviceId(String str) {
        this.device_id = str;
    }

    public void setFailReason(String str) {
        this.fail_reasons = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setMsgType(int i10) {
        this.msgType = i10;
    }

    public void setRet(boolean z10) {
        this.ret = z10 ? "y" : "n";
    }

    public void setServiceId(String str) {
        this.service_id = str;
    }

    public void setFailReason(int i10) {
        this.error_code = i10;
        if (i10 == -4) {
            setFailReason("msg too large");
            return;
        }
        if (i10 == -3) {
            setFailReason("service not available");
            return;
        }
        if (i10 == -2) {
            setFailReason("param error");
            return;
        }
        if (i10 == -1) {
            setFailReason("network fail");
        } else if (i10 != 200) {
            if (i10 != 300) {
                setFailReason(String.valueOf(i10));
            } else {
                setFailReason("app not bind");
            }
        }
    }
}
