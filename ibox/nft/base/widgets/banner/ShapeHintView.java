package com.ibox.nft.base.widgets.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* loaded from: ShapeHintView.class */
public abstract class ShapeHintView extends LinearLayout implements HintView {

    /* renamed from: b  reason: collision with root package name */
    public ImageView[] f456b;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f457d = 0;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f458e;
    public Drawable f;

    public ShapeHintView(Context context) {
        super(context);
    }

    @Override // com.ibox.nft.base.widgets.banner.HintView
    public void a(int i, int i2) {
        removeAllViews();
        this.f457d = 0;
        setOrientation(0);
        if (i2 == 0) {
            setGravity(19);
        } else if (i2 == 1) {
            setGravity(17);
        } else if (i2 == 2) {
            setGravity(21);
        }
        this.c = i;
        this.f456b = new ImageView[i];
        this.f = c();
        this.f458e = d();
        for (int i3 = 0; i3 < i; i3++) {
            this.f456b[i3] = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(10, 0, 10, 0);
            this.f456b[i3].setLayoutParams(layoutParams);
            this.f456b[i3].setBackgroundDrawable(this.f458e);
            addView(this.f456b[i3]);
        }
        setCurrent(0);
    }

    public abstract Drawable c();

    public abstract Drawable d();

    @Override // com.ibox.nft.base.widgets.banner.HintView
    public void setCurrent(int i) {
        if (i >= 0 && i <= this.c - 1) {
            this.f456b[this.f457d].setBackgroundDrawable(this.f458e);
            this.f456b[i].setBackgroundDrawable(this.f);
            this.f457d = i;
        }
    }
}
