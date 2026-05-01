package anet.channel.monitor;

/* loaded from: classes.dex */
class e {

    /* renamed from: b, reason: collision with root package name */
    private double f4031b;

    /* renamed from: c, reason: collision with root package name */
    private double f4032c;

    /* renamed from: d, reason: collision with root package name */
    private double f4033d;

    /* renamed from: e, reason: collision with root package name */
    private double f4034e;

    /* renamed from: f, reason: collision with root package name */
    private double f4035f;

    /* renamed from: g, reason: collision with root package name */
    private double f4036g;

    /* renamed from: h, reason: collision with root package name */
    private double f4037h;

    /* renamed from: a, reason: collision with root package name */
    private long f4030a = 0;

    /* renamed from: i, reason: collision with root package name */
    private double f4038i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    private double f4039j = 0.0d;

    /* renamed from: k, reason: collision with root package name */
    private double f4040k = 0.0d;

    public double a(double d10, double d11) {
        char c10;
        double d12 = d10 / d11;
        if (d12 < 8.0d) {
            if (this.f4030a != 0) {
                return this.f4040k;
            }
            this.f4040k = d12;
            return d12;
        }
        long j10 = this.f4030a;
        if (j10 == 0) {
            this.f4038i = d12;
            this.f4037h = d12;
            this.f4033d = d12 * 0.1d;
            this.f4032c = 0.02d * d12;
            this.f4034e = 0.1d * d12 * d12;
        } else if (j10 == 1) {
            this.f4039j = d12;
            this.f4037h = d12;
        } else {
            double d13 = this.f4039j;
            double d14 = d12 - d13;
            this.f4038i = d13;
            this.f4039j = d12;
            double d15 = d12 / 0.95d;
            this.f4031b = d15;
            this.f4036g = d15 - (this.f4037h * 0.95d);
            double sqrt = Math.sqrt(this.f4033d);
            double d16 = this.f4036g;
            if (d16 >= 4.0d * sqrt) {
                this.f4036g = (d16 * 0.75d) + (sqrt * 2.0d);
                c10 = 1;
            } else if (d16 <= (-4.0d) * sqrt) {
                this.f4036g = (sqrt * (-1.0d)) + (d16 * 0.75d);
                c10 = 2;
            } else {
                c10 = 0;
            }
            double d17 = this.f4033d * 1.05d;
            double d18 = this.f4036g;
            double min = Math.min(Math.max(Math.abs(d17 - ((0.0025d * d18) * d18)), this.f4033d * 0.8d), this.f4033d * 1.25d);
            this.f4033d = min;
            double d19 = this.f4034e;
            double d20 = d19 / ((0.9025d * d19) + min);
            this.f4035f = d20;
            double d21 = this.f4037h + (1.0526315789473684d * d14) + (d20 * this.f4036g);
            this.f4037h = d21;
            if (c10 == 1) {
                this.f4037h = Math.min(d21, this.f4031b);
            } else if (c10 == 2) {
                this.f4037h = Math.max(d21, this.f4031b);
            }
            this.f4034e = (1.0d - (0.95d * this.f4035f)) * (this.f4034e + this.f4032c);
        }
        double d22 = this.f4037h;
        if (d22 < 0.0d) {
            double d23 = this.f4039j * 0.7d;
            this.f4040k = d23;
            this.f4037h = d23;
        } else {
            this.f4040k = d22;
        }
        return this.f4040k;
    }

    public void a() {
        this.f4030a = 0L;
        this.f4040k = 0.0d;
    }
}
