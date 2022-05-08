package com.ibox.nft.base.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ibox.libs.common.manager.ImageLoaderManager;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.EmptyErrorView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

/* loaded from: EmptyErrorView.class */
public class EmptyErrorView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f433b;
    public TextView c;

    /* renamed from: d  reason: collision with root package name */
    public Button f434d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f435e;
    @ColorInt
    public int f;
    @ColorInt
    public int g;
    @DrawableRes
    public int h;
    @ColorInt
    public int i;
    public String j;
    public String k;
    @DrawableRes
    public int l;
    @DrawableRes
    public int m;
    public View.OnClickListener n;

    public EmptyErrorView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: c */
    public /* synthetic */ void d(View view) {
        View.OnClickListener onClickListener = this.n;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmptyErrorView);
            try {
                this.f435e = obtainStyledAttributes.getColor(R.styleable.EmptyErrorView_eev_tipsTextColor, context.getResources().getColor(R.color.color_80808c));
                int i = R.styleable.EmptyErrorView_eev_btnTextColor;
                Resources resources = context.getResources();
                int i2 = R.color.color_ffffff;
                this.f = obtainStyledAttributes.getColor(i, resources.getColor(i2));
                this.g = obtainStyledAttributes.getColor(R.styleable.EmptyErrorView_eev_btnBackgroundColor, 0);
                this.h = obtainStyledAttributes.getResourceId(R.styleable.EmptyErrorView_eev_btnBackground, 0);
                this.i = obtainStyledAttributes.getColor(R.styleable.EmptyErrorView_eev_background, context.getResources().getColor(i2));
                this.j = obtainStyledAttributes.getString(R.styleable.EmptyErrorView_eev_tipsText);
                this.k = obtainStyledAttributes.getString(R.styleable.EmptyErrorView_eev_btnText);
                this.l = obtainStyledAttributes.getResourceId(R.styleable.EmptyErrorView_eev_emptyDataIcon, 0);
                this.m = obtainStyledAttributes.getResourceId(R.styleable.EmptyErrorView_eev_errorNetworkIcon, 0);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
                throw th;
            }
        }
        b(context);
    }

    @SuppressLint({"ResourceType"})
    public final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.empty_error_page, (ViewGroup) null);
        inflate.setBackgroundColor(this.i);
        this.f433b = (ImageView) inflate.findViewById(R.id.iv_error_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_error_tips);
        this.c = textView;
        textView.setText(this.k);
        this.c.setTextColor(this.f435e);
        Button button = (Button) inflate.findViewById(R.id.btn_error_operate);
        this.f434d = button;
        button.setText(this.k);
        this.f434d.setTextColor(this.f);
        if (this.h != 0) {
            this.f434d.setBackground(getResources().getDrawable(this.h));
        } else if (this.g != 0) {
            this.f434d.setBackgroundColor(getResources().getColor(this.g));
        }
        this.f434d.setOnClickListener(new View.OnClickListener(this) { // from class: d.c.d.d.i.a

            /* renamed from: b  reason: collision with root package name */
            public final EmptyErrorView f1177b;

            {
                this.f1177b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1177b.d(view);
            }
        });
        removeAllViews();
        removeAllViewsInLayout();
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
    }

    public EmptyErrorView e(int i) {
        if (i != 0) {
            ImageLoaderManager.n().a(getContext(), i, this.f433b);
        }
        return this;
    }

    public EmptyErrorView f(String str) {
        this.c.setText(str);
        return this;
    }

    public EmptyErrorView g(View.OnClickListener onClickListener) {
        this.n = onClickListener;
        return this;
    }

    public EmptyErrorView h(String str) {
        this.f434d.setText(str);
        return this;
    }

    public EmptyErrorView i(int i) {
        this.f434d.setVisibility(i);
        return this;
    }
}
