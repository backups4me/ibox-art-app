package com.ibox.nft.base.widgets.banner;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.ibox.libs.common.utils.PixelTool;
import com.ibox.nft.base.R;

/* loaded from: AnimHintView.class */
public class AnimHintView extends LinearLayout implements VerticalHintPagerView$IVerticalHintView {

    /* renamed from: b  reason: collision with root package name */
    public ImageView[] f442b;

    /* renamed from: e  reason: collision with root package name */
    public int f444e;
    public int f;
    public int g;
    public FrameLayout i;
    public ImageView j;
    public Callback k;
    public int n;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f443d = 0;
    public boolean h = true;
    public int l = R.drawable.index_banner_focus_indicator;
    public int m = R.drawable.index_banner_normal_indicator;

    /* loaded from: AnimHintView$Callback.class */
    public interface Callback {
        void a(int i);
    }

    public AnimHintView(Context context) {
        super(context);
        d();
    }

    @Override // com.ibox.nft.base.widgets.banner.HintView
    public void a(int i, int i2) {
        b(i, i2, 0);
    }

    @Override // com.ibox.nft.base.widgets.banner.VerticalHintPagerView$IVerticalHintView
    public void b(int i, int i2, int i3) {
        if (this.c == i) {
            setCurrent(i3);
            return;
        }
        removeAllViews();
        this.c = i;
        this.f442b = new ImageView[i];
        if (i2 == 0) {
            setGravity(19);
        } else if (i2 == 1) {
            setGravity(17);
        } else if (i2 == 2) {
            setGravity(21);
        }
        setOrientation(0);
        this.i = new FrameLayout(getContext());
        this.i.setLayoutParams(new LinearLayout.LayoutParams(-2, this.f));
        addView(this.i);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, this.f));
        this.i.addView(linearLayout);
        for (int i4 = 0; i4 < i; i4++) {
            this.f442b[i4] = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f444e, this.f);
            if (i4 > 0) {
                layoutParams.setMargins(this.g, 0, 0, 0);
            }
            this.f442b[i4].setLayoutParams(layoutParams);
            this.f442b[i4].setImageResource(this.m);
            linearLayout.addView(this.f442b[i4]);
        }
        this.j = new ImageView(getContext());
        this.j.setLayoutParams(new LinearLayout.LayoutParams(this.f444e, this.f));
        this.j.setImageResource(this.l);
        this.i.addView(this.j);
        int i5 = this.n;
        if (i5 != 0) {
            this.i.setBackgroundResource(i5);
        }
        setCurrent(0);
    }

    public void c(View view, int i) {
        view.animate().translationX(i);
    }

    public final void d() {
        this.f444e = PixelTool.a(20.0f);
        this.f = PixelTool.a(2.0f);
    }

    public void setBgResId(int i) {
        this.n = i;
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(i);
        }
    }

    public void setCallback(Callback callback) {
        this.k = callback;
    }

    @Override // com.ibox.nft.base.widgets.banner.HintView
    public void setCurrent(int i) {
        if (i >= 0 && i <= this.c - 1 && this.f443d != i) {
            this.f443d = i;
            int i2 = (this.f444e + this.g) * i;
            if (this.h) {
                c(this.j, i2);
            } else {
                this.j.setTranslationX(i2);
            }
            Callback callback = this.k;
            if (callback != null) {
                callback.a(i);
            }
        }
    }

    public void setDotHeight(int i) {
        this.f = i;
    }

    public void setDotPadding(int i) {
        this.g = i;
    }

    public void setDotWidth(int i) {
        this.f444e = i;
    }

    public void setFocusResId(int i) {
        this.l = i;
    }

    public void setNormalResId(int i) {
        this.m = i;
    }

    public void setUseAnim(boolean z) {
        this.h = z;
    }
}
