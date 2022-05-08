package com.ibox.nft.base.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ibox.libs.common.utils.DisplayTool;
import com.ibox.nft.base.R;

/* loaded from: TopTitleBarView.class */
public class TopTitleBarView extends RelativeLayout {
    public int A;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f436b;
    public LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f437d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f438e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public String i;
    public String j;
    public String k;
    public float l;
    public float m;
    public float n;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;
    public int o = Color.parseColor("#333333");
    public ColorStateList p = null;
    public int q = Color.parseColor("#333333");
    public ColorStateList r = null;
    public int s = Color.parseColor("#333333");
    public ColorStateList t = null;
    public int B = Color.parseColor("#333333");
    public ColorStateList C = null;
    public int D = Color.parseColor("#333333");
    public ColorStateList E = null;
    public int F = -1;
    public ColorStateList G = null;

    public TopTitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    @SuppressLint({"ResourceType"})
    public final void a(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        int i3;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TopTitleBarView);
            try {
                int i4 = R.styleable.TopTitleBarView_title;
                this.i = obtainStyledAttributes.getString(i4);
                i2 = obtainStyledAttributes.getResourceId(i4, 0);
                int i5 = R.styleable.TopTitleBarView_leftText;
                this.j = obtainStyledAttributes.getString(i5);
                i3 = obtainStyledAttributes.getResourceId(i5, 0);
                int i6 = R.styleable.TopTitleBarView_rightText;
                this.k = obtainStyledAttributes.getString(i6);
                i = obtainStyledAttributes.getResourceId(i6, 0);
                this.v = obtainStyledAttributes.getInt(R.styleable.TopTitleBarView_leftIconVisible, 0);
                this.w = obtainStyledAttributes.getInt(R.styleable.TopTitleBarView_rightIconVisible, 8);
                this.x = obtainStyledAttributes.getInt(R.styleable.TopTitleBarView_leftTextVisible, 8);
                this.y = obtainStyledAttributes.getInt(R.styleable.TopTitleBarView_rightTextVisible, 8);
                this.u = obtainStyledAttributes.getInt(R.styleable.TopTitleBarView_titleVisible, 0);
                this.o = obtainStyledAttributes.getColor(R.styleable.TopTitleBarView_titleColor, this.o);
                this.q = obtainStyledAttributes.getColor(R.styleable.TopTitleBarView_leftTextColor, this.q);
                this.s = obtainStyledAttributes.getColor(R.styleable.TopTitleBarView_rightTextColor, this.s);
                this.B = obtainStyledAttributes.getColor(R.styleable.TopTitleBarView_leftIconFilterColor, this.B);
                this.D = obtainStyledAttributes.getColor(R.styleable.TopTitleBarView_rightIconFilterColor, this.D);
                this.F = obtainStyledAttributes.getColor(R.styleable.TopTitleBarView_backgroundColor, this.F);
                this.z = obtainStyledAttributes.getResourceId(R.styleable.TopTitleBarView_leftIcon, -1);
                this.A = obtainStyledAttributes.getResourceId(R.styleable.TopTitleBarView_rightIcon, -1);
                this.m = obtainStyledAttributes.getDimension(R.styleable.TopTitleBarView_leftTextSize, DisplayTool.b(getContext(), 17.0f));
                this.l = obtainStyledAttributes.getDimension(R.styleable.TopTitleBarView_titleSize, DisplayTool.b(getContext(), 17.0f));
                this.n = obtainStyledAttributes.getDimension(R.styleable.TopTitleBarView_rightTextSize, DisplayTool.b(getContext(), 17.0f));
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
                throw th;
            }
        } else {
            i2 = 0;
            i3 = 0;
            i = 0;
        }
        View inflate = View.inflate(context, R.layout.view_top_title_bar, this);
        this.f436b = (LinearLayout) inflate.findViewById(R.id.ll_left);
        this.c = (LinearLayout) inflate.findViewById(R.id.ll_right);
        this.f437d = (TextView) inflate.findViewById(R.id.tv_title);
        this.f438e = (ImageView) inflate.findViewById(R.id.iv_left_icon);
        this.f = (ImageView) inflate.findViewById(R.id.iv_right_icon);
        this.g = (TextView) inflate.findViewById(R.id.tv_left_text);
        this.h = (TextView) inflate.findViewById(R.id.tv_right_text);
        if (i2 == 0) {
            this.f437d.setText(this.i);
        } else {
            this.f437d.setText(i2);
        }
        this.f437d.setTextColor(this.o);
        this.f437d.setVisibility(this.u);
        this.f437d.setTextSize(0, this.l);
        if (i3 == 0) {
            this.g.setText(this.j);
        } else {
            this.g.setText(i3);
        }
        this.g.setTextColor(this.q);
        this.g.setVisibility(this.x);
        this.g.setTextSize(0, this.m);
        if (i == 0) {
            this.h.setText(this.k);
        } else {
            this.h.setText(i);
        }
        this.h.setTextColor(this.s);
        this.h.setVisibility(this.y);
        this.h.setTextSize(0, this.n);
        int i7 = this.z;
        if (i7 != -1) {
            this.f438e.setImageResource(i7);
        }
        this.f438e.setVisibility(this.v);
        this.f438e.setColorFilter(this.B);
        int i8 = this.A;
        if (i8 != -1) {
            this.f.setImageResource(i8);
        }
        this.f.setVisibility(this.w);
        this.f.setColorFilter(this.D);
    }

    public ImageView getIvLeftIcon() {
        return this.f438e;
    }

    public ImageView getIvRightIcon() {
        return this.f;
    }

    public TextView getTvLeftText() {
        return this.g;
    }

    public TextView getTvRightText() {
        return this.h;
    }

    public TextView getTvTitle() {
        return this.f437d;
    }

    public void setLeftClick(View.OnClickListener onClickListener) {
        this.f436b.setOnClickListener(onClickListener);
    }

    public void setLeftIcon(int i) {
        this.f438e.setImageResource(i);
    }

    public void setLeftIconFilterColor(int i) {
        this.B = i;
        this.f438e.setColorFilter(i);
    }

    public void setLeftLayoutVisible(int i) {
        this.f436b.setVisibility(i);
    }

    public void setLeftVisible(int i) {
        this.f436b.setVisibility(i);
    }

    public void setRightClick(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    public void setRightEnable(boolean z) {
        this.c.setEnabled(z);
    }

    public void setRightIcon(int i) {
        this.f.setImageResource(i);
    }

    public void setRightIconFilterColor(int i) {
        this.D = i;
        this.f.setColorFilter(i);
    }

    public void setRightVisible(int i) {
        this.c.setVisibility(i);
    }

    public void setTitle(String str) {
        this.f437d.setText(str);
    }
}
