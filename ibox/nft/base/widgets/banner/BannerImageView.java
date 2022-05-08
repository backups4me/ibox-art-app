package com.ibox.nft.base.widgets.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import androidx.appcompat.widget.AppCompatImageView;
import com.ibox.libs.common.utils.PixelTool;
import com.ibox.nft.base.R;

/* loaded from: BannerImageView.class */
public class BannerImageView extends AppCompatImageView {

    /* renamed from: b  reason: collision with root package name */
    public float f445b;
    public Paint c;

    /* renamed from: d  reason: collision with root package name */
    public float f446d;

    /* renamed from: e  reason: collision with root package name */
    public float f447e;

    public BannerImageView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setColor(context.getResources().getColor(R.color.app_bg));
        this.f445b = PixelTool.a(10.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        BannerImageView.super.onDraw(canvas);
        if (getDrawable() != null) {
            RectF rectF = new RectF(0.0f, 0.0f, this.f446d, this.f447e);
            Path path = new Path();
            Path path2 = new Path();
            path2.addRect(rectF, Path.Direction.CCW);
            float f = this.f445b;
            path.addRoundRect(rectF, f, f, Path.Direction.CCW);
            if (Build.VERSION.SDK_INT >= 19) {
                path.op(path2, path, Path.Op.DIFFERENCE);
            }
            canvas.drawPath(path, this.c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int i, int i2) {
        BannerImageView.super.onMeasure(i, i2);
        this.f446d = getMeasuredWidth();
        this.f447e = getMeasuredHeight();
    }
}
