package com.ibox.nft.base.widgets.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.ibox.libs.common.utils.PixelTool;

/* loaded from: ColorPointHintView.class */
public class ColorPointHintView extends ShapeHintView {
    public int g;
    public int h;

    public ColorPointHintView(Context context, int i, int i2) {
        super(context);
        this.g = i;
        this.h = i2;
    }

    @Override // com.ibox.nft.base.widgets.banner.ShapeHintView
    public Drawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.g);
        gradientDrawable.setCornerRadius(PixelTool.a(4.0f));
        gradientDrawable.setSize(PixelTool.a(8.0f), PixelTool.a(8.0f));
        return gradientDrawable;
    }

    @Override // com.ibox.nft.base.widgets.banner.ShapeHintView
    public Drawable d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.h);
        gradientDrawable.setCornerRadius(PixelTool.a(4.0f));
        gradientDrawable.setSize(PixelTool.a(8.0f), PixelTool.a(8.0f));
        return gradientDrawable;
    }
}
