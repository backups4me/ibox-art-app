package com.ibox.nft.base.widgets.animation;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: CubicBezierInterpolator.class */
public class CubicBezierInterpolator implements Interpolator {
    public PointF a;

    /* renamed from: b  reason: collision with root package name */
    public PointF f439b;
    public PointF c;

    /* renamed from: d  reason: collision with root package name */
    public PointF f440d;

    /* renamed from: e  reason: collision with root package name */
    public PointF f441e;

    public CubicBezierInterpolator(double d2, double d3, double d4, double d5) {
        this((float) d2, (float) d3, (float) d4, (float) d5);
    }

    public CubicBezierInterpolator(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    public CubicBezierInterpolator(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.c = new PointF();
        this.f440d = new PointF();
        this.f441e = new PointF();
        float f = pointF.x;
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f2 = pointF2.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.a = pointF;
        this.f439b = pointF2;
    }

    public final float a(float f) {
        PointF pointF = this.f441e;
        PointF pointF2 = this.a;
        float f2 = pointF2.x * 3.0f;
        pointF.x = f2;
        PointF pointF3 = this.f440d;
        float f3 = ((this.f439b.x - pointF2.x) * 3.0f) - f2;
        pointF3.x = f3;
        PointF pointF4 = this.c;
        float f4 = (1.0f - pointF.x) - f3;
        pointF4.x = f4;
        return f * (pointF.x + ((pointF3.x + (f4 * f)) * f));
    }

    public float b(float f) {
        PointF pointF = this.f441e;
        PointF pointF2 = this.a;
        float f2 = pointF2.y * 3.0f;
        pointF.y = f2;
        PointF pointF3 = this.f440d;
        float f3 = ((this.f439b.y - pointF2.y) * 3.0f) - f2;
        pointF3.y = f3;
        PointF pointF4 = this.c;
        float f4 = (1.0f - pointF.y) - f3;
        pointF4.y = f4;
        return f * (pointF.y + ((pointF3.y + (f4 * f)) * f));
    }

    public final float c(float f) {
        return this.f441e.x + (f * ((this.f440d.x * 2.0f) + (this.c.x * 3.0f * f)));
    }

    public float d(float f) {
        float f2 = f;
        for (int i = 1; i < 14; i++) {
            float a = a(f2) - f;
            if (Math.abs(a) < 0.001d) {
                break;
            }
            f2 -= a / c(f2);
        }
        return f2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return b(d(f));
    }
}
