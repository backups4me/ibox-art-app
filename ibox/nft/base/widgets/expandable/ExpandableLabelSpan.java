package com.ibox.nft.base.widgets.expandable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.ibox.libs.common.utils.DisplayTool;
import com.ibox.libs.common.utils.ImageTool;
import java.lang.ref.SoftReference;

/* loaded from: ExpandableLabelSpan.class */
public class ExpandableLabelSpan extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public SoftReference<Context> f473b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f474d;

    /* renamed from: e  reason: collision with root package name */
    public int f475e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j = DisplayTool.a(8.0f);
    public int k = DisplayTool.a(4.0f);
    public int l = DisplayTool.a(5.0f);

    public ExpandableLabelSpan(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f473b = new SoftReference<>(context);
        this.f474d = i;
        this.f475e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = i4;
        double descent = ((paint.descent() - paint.ascent()) + f2) - paint.descent();
        Double.isNaN(descent);
        float f3 = (float) (descent * 0.5d);
        int i6 = this.h;
        if (i6 != 0) {
            paint.setColor(i6);
            paint.setAntiAlias(true);
            RectF rectF = new RectF(f, 1.0f, this.c + f, f2 + paint.descent());
            int i7 = this.i;
            canvas.drawRoundRect(rectF, i7, i7, paint);
        }
        Context context = this.f473b.get();
        if (context != null) {
            Bitmap h = ImageTool.h(BitmapFactory.decodeResource(context.getResources(), this.f474d), this.f475e, this.f);
            canvas.drawBitmap(h, this.j + f, this.k + 1, (Paint) null);
            if (!h.isRecycled()) {
                h.recycle();
            }
        }
        paint.setColor(this.g);
        canvas.drawText(charSequence, i, i2, f + this.j + this.l + this.f475e, f3, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) (paint.measureText(charSequence, i, i2) + (this.j * 2) + this.l + this.f475e);
        this.c = measureText;
        return measureText;
    }
}
