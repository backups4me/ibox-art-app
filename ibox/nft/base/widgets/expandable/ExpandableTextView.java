package com.ibox.nft.base.widgets.expandable;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.ibox.libs.common.utils.DisplayTool;
import com.ibox.libs.common.utils.UrlParamTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.expandable.ExpandableTextView;
import com.ibox.nft.base.widgets.expandable.FormatData;
import com.ibox.nft.base.widgets.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: ExpandableTextView.class */
public class ExpandableTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public static String f476b = "收起";
    public static String c = "展开";

    /* renamed from: d  reason: collision with root package name */
    public static String f477d = "网页链接";

    /* renamed from: e  reason: collision with root package name */
    public static final String f478e = "图" + f477d;
    public static final Pattern f = Pattern.compile("(mailto:|(news|(ht|f)tp(s?))://|((?<![\\p{L}0-9_.])(www\\.)))[-A-Za-z0-9+$&@#/%?=~_|!:,.;]*[-A-Za-z0-9+$&@#/%=~_|]");
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public CharSequence E;
    public CharSequence F;
    @ColorInt
    public int G;
    @ColorInt
    public int H;
    @ColorInt
    public int I;
    @ColorInt
    public int J;
    @ColorInt
    public int K;
    @ColorInt
    public int L;
    public String M;
    public String N;
    public String O;
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public Drawable T;
    public Drawable U;
    public int V;
    public int W;
    public int d0;
    public int e0;
    public boolean f0;
    public int g;
    public Drawable g0;
    public TextPaint h;
    public int h0;
    public Context i;
    public int i0;
    public ExpandableStatusFix j;
    public int j0;
    public DynamicLayout k;
    public OnExpandableContractChangedListener k0;
    public int l;
    public ViewTreeObserver.OnPreDrawListener l0;
    public int m;
    public OnGetLineCountListener m0;
    public int n;
    public boolean n0;
    public Drawable o;
    public String o0;
    public OnLinkClickListener p;
    public int p0;
    public boolean q;
    public float q0;
    public OnExpandOrContractClickListener r;
    public int r0;
    public boolean s;
    public int s0;
    public FormatData t;
    public Drawable t0;
    public boolean u;
    public int u0;
    public boolean v;
    public int v0;
    public boolean w;
    public int w0;
    public boolean x;
    public int x0;
    public boolean y;
    public ExpandableLabelSpan y0;
    public boolean z;

    /* loaded from: ExpandableTextView$OnExpandOrContractClickListener.class */
    public interface OnExpandOrContractClickListener {
        void a(StatusType statusType);
    }

    /* loaded from: ExpandableTextView$OnGetLineCountListener.class */
    public interface OnGetLineCountListener {
        void a(int i, boolean z);
    }

    /* loaded from: ExpandableTextView$OnLinkClickListener.class */
    public interface OnLinkClickListener {
        void a(LinkType linkType, String str, String str2);
    }

    /* loaded from: ExpandableTextView$SelfImageSpan.class */
    public class SelfImageSpan extends ImageSpan {

        /* renamed from: b  reason: collision with root package name */
        public Drawable f485b;
        public final ExpandableTextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelfImageSpan(ExpandableTextView expandableTextView, Drawable drawable, int i) {
            super(drawable, i);
            this.c = expandableTextView;
            this.f485b = drawable;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
        public Drawable getDrawable() {
            return this.f485b;
        }
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 0;
        this.l = 5;
        this.o = null;
        this.q = true;
        this.s = true;
        this.u = true;
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = true;
        this.E = "";
        this.G = Color.parseColor("#FFBE00");
        this.H = Color.parseColor("#FF9B00");
        this.I = Color.parseColor("#FF6200");
        this.J = Color.parseColor("#FF6200");
        this.K = Color.parseColor("#FFBE00");
        this.L = Color.parseColor("#1A1A1A");
        this.P = Color.parseColor("#999999");
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = null;
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = false;
        this.g0 = null;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.l0 = new ViewTreeObserver.OnPreDrawListener(this) { // from class: com.ibox.nft.base.widgets.expandable.ExpandableTextView.1

            /* renamed from: b  reason: collision with root package name */
            public final ExpandableTextView f479b;

            {
                this.f479b = this;
            }

            /* JADX WARN: Type inference failed for: r0v23, types: [com.ibox.nft.base.widgets.expandable.ExpandableTextView, android.widget.TextView] */
            /* JADX WARN: Type inference failed for: r0v7, types: [com.ibox.nft.base.widgets.expandable.ExpandableTextView, android.widget.TextView] */
            /* JADX WARN: Type inference failed for: r2v2, types: [com.ibox.nft.base.widgets.expandable.ExpandableTextView, android.widget.TextView] */
            /* JADX WARN: Type inference failed for: r2v5, types: [com.ibox.nft.base.widgets.expandable.ExpandableTextView, android.widget.TextView] */
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (this.f479b.Q) {
                    return true;
                }
                this.f479b.Q = true;
                this.f479b.getViewTreeObserver().removeOnPreDrawListener(this);
                if (this.f479b.n <= 0) {
                    ?? r0 = this.f479b;
                    r0.n = r0.getWidth() + this.f479b.getPaddingLeft() + this.f479b.getPaddingRight();
                }
                ExpandableTextView expandableTextView = this.f479b;
                expandableTextView.L(expandableTextView.F == null ? "" : this.f479b.F, false);
                return true;
            }
        };
        this.n0 = false;
        this.o0 = "";
        this.p0 = 12;
        this.q0 = DisplayTool.a(10.0f);
        this.r0 = WebView.NIGHT_MODE_COLOR;
        this.s0 = 0;
        this.t0 = null;
        this.u0 = 0;
        this.v0 = 0;
        this.w0 = 0;
        this.x0 = 0;
        E(context, attributeSet, i);
        setOnTouchListener(new FixLinkMovementTouchListener());
        getViewTreeObserver().addOnPreDrawListener(this.l0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: F */
    public /* synthetic */ void G(boolean z, StatusType statusType, ValueAnimator valueAnimator) {
        Float f2 = (Float) valueAnimator.getAnimatedValue();
        if (z) {
            int i = this.l;
            this.m = i + ((int) ((this.D - i) * f2.floatValue()));
        } else if (this.s) {
            int i2 = this.l;
            this.m = i2 + ((int) ((this.D - i2) * (1.0f - f2.floatValue())));
        }
        CharSequence charSequence = this.F;
        setText(B(charSequence, "action_" + statusType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: H */
    public /* synthetic */ void I(CharSequence charSequence, String str) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.n = width;
        if (width > 0) {
            setText(B(charSequence, str));
            this.g = 0;
        } else if (this.g > 2) {
            setText(B(charSequence, str));
            this.g = 0;
        } else {
            L(charSequence, false);
            this.g++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: J */
    public /* synthetic */ void K(CharSequence charSequence) {
        if (this.n <= 0) {
            this.n = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        y(charSequence, "setContent");
    }

    private String getExpandEndContent() {
        return TextUtils.isEmpty(this.O) ? String.format(Locale.getDefault(), "  %s", this.N) : String.format(Locale.getDefault(), "  %s  %s", this.O, this.N);
    }

    private ExpandableLabelSpan getExpandableLabelSpan() {
        ExpandableLabelSpan expandableLabelSpan = this.y0;
        return expandableLabelSpan != null ? expandableLabelSpan : new ExpandableLabelSpan(this.i, this.s0, this.u0, this.v0, this.r0, this.w0, this.x0);
    }

    private String getHideEndContent() {
        if (TextUtils.isEmpty(this.O)) {
            return String.format(Locale.getDefault(), this.B ? "  %s" : "...  %s", this.M);
        }
        return String.format(Locale.getDefault(), this.B ? "  %s  %s" : "...  %s  %s", this.O, this.M);
    }

    public final int A(String str, int i, int i2, float f2, float f3, float f4) {
        int i3 = (int) (((f2 - (f3 + f4)) * (i - i2)) / f2);
        if (i3 <= str.length()) {
            return i;
        }
        int i4 = i3 + i2;
        return this.h.measureText(this.t.a().substring(i2, i4)) <= f2 - f3 ? i4 : A(str, i, i2, f2, f3, f4 + this.h.measureText(" "));
    }

    public final SpannableStringBuilder B(CharSequence charSequence, String str) {
        String str2;
        this.g = 0;
        if (TextUtils.isEmpty(this.E)) {
            str2 = charSequence;
        } else {
            str2 = this.E.toString() + charSequence.toString();
        }
        FormatData z = z(str2);
        this.t = z;
        if (TextUtils.isEmpty(z.a())) {
            this.t.c(charSequence.toString());
            this.t.d(new ArrayList());
        }
        DynamicLayout dynamicLayout = new DynamicLayout(this.t.a(), this.h, this.n, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, true);
        this.k = dynamicLayout;
        int lineCount = dynamicLayout.getLineCount();
        this.D = lineCount;
        OnGetLineCountListener onGetLineCountListener = this.m0;
        if (onGetLineCountListener != null) {
            onGetLineCountListener.a(lineCount, lineCount > this.l);
        }
        return (!this.u || this.D <= this.l) ? x(this.t, false, str) : x(this.t, true, str);
    }

    public final int C(float f2) {
        float measureText = this.h.measureText(" ");
        return f2 % measureText == 0.0f ? (int) (f2 / measureText) : ((int) (f2 / measureText)) + 1;
    }

    public final String D(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.append(" ");
            i--;
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(Context context, AttributeSet attributeSet, int i) {
        f476b = context.getString(R.string.social_contract);
        c = context.getString(R.string.social_expend);
        f477d = context.getString(R.string.social_text_target);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView, i, 0);
            int i2 = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_ep_max_line, 5);
            this.l = i2;
            this.m = i2;
            this.u = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_expand, this.u);
            this.M = obtainStyledAttributes.getString(R.styleable.ExpandableTextView_ep_expand_text);
            this.G = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_expand_color, this.G);
            if (this.u && TextUtils.isEmpty(this.M)) {
                this.M = c;
            }
            this.s = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_contract, this.s);
            this.N = obtainStyledAttributes.getString(R.styleable.ExpandableTextView_ep_contract_text);
            this.K = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_contract_color, this.K);
            if (this.s && TextUtils.isEmpty(this.N)) {
                this.N = f476b;
            }
            this.O = obtainStyledAttributes.getString(R.styleable.ExpandableTextView_ep_end_text);
            this.P = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_end_color, this.P);
            this.A = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_title, this.A);
            this.L = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_title_color, this.L);
            this.z = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_self, this.z);
            this.J = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_self_color, this.J);
            this.w = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_mention, this.w);
            this.H = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_mention_color, this.H);
            this.x = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_link, this.x);
            this.y = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_link_res, this.y);
            this.I = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_link_color, this.I);
            this.o = getResources().getDrawable(obtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_ep_link_res, R.mipmap.ic_expandable_link));
            this.C = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_animation, this.C);
            this.B = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_always_showright, this.B);
            this.v = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_convert_url, this.v);
            this.S = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_show_arrow_icon, this.S);
            this.d0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_arrow_icon_width, this.d0);
            this.e0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_arrow_icon_height, this.e0);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_ep_expand_arrow_res, this.V);
            this.V = resourceId;
            if (resourceId != 0) {
                Drawable drawable = getResources().getDrawable(this.V);
                this.T = drawable;
                drawable.setBounds(0, 0, this.d0, this.e0);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_ep_contract_arrow_res, this.W);
            this.W = resourceId2;
            if (resourceId2 != 0) {
                Drawable drawable2 = getResources().getDrawable(this.W);
                this.U = drawable2;
                drawable2.setBounds(0, 0, this.d0, this.e0);
            }
            this.f0 = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_prefix_mark_icon, this.f0);
            this.i0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_prefix_mark_icon_width, this.i0);
            this.j0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_prefix_mark_icon_height, this.j0);
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_ep_prefix_mark_icon_res, this.h0);
            this.h0 = resourceId3;
            if (resourceId3 != 0) {
                Drawable drawable3 = getResources().getDrawable(this.h0);
                this.g0 = drawable3;
                drawable3.setBounds(0, 0, this.i0, this.j0);
            }
            obtainStyledAttributes.recycle();
        } else {
            this.o = context.getResources().getDrawable(R.mipmap.ic_expandable_link);
        }
        this.i = context;
        TextPaint paint = getPaint();
        this.h = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        if (this.y) {
            this.o.setBounds(0, 0, 30, 30);
        } else {
            this.o.setBounds(0, 0, 0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void L(final CharSequence charSequence, boolean z) {
        this.F = charSequence;
        if (TextUtils.isEmpty(charSequence)) {
            setText("");
        } else if (z) {
            post(new Runnable(this, charSequence) { // from class: d.c.d.d.i.e.b

                /* renamed from: b  reason: collision with root package name */
                public final ExpandableTextView f1185b;
                public final CharSequence c;

                {
                    this.f1185b = this;
                    this.c = charSequence;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1185b.K(this.c);
                }
            });
        } else {
            y(charSequence, "setContent");
        }
    }

    public void M(OnExpandOrContractClickListener onExpandOrContractClickListener, boolean z) {
        this.r = onExpandOrContractClickListener;
        this.q = z;
    }

    public String getContractString() {
        return this.N;
    }

    @ColorInt
    public int getContractTextColor() {
        return this.K;
    }

    public int getEndExpandTextColor() {
        return this.P;
    }

    public OnExpandOrContractClickListener getExpandOrContractClickListener() {
        return this.r;
    }

    public String getExpandString() {
        return this.M;
    }

    @ColorInt
    public int getExpandTextColor() {
        return this.G;
    }

    public int getExpandableLineCount() {
        return this.D;
    }

    @ColorInt
    public int getExpandableLinkTextColor() {
        return this.I;
    }

    public OnLinkClickListener getLinkClickListener() {
        return this.p;
    }

    public Drawable getLinkDrawable() {
        return this.o;
    }

    public OnGetLineCountListener getOnGetLineCountListener() {
        return this.m0;
    }

    public int getSelfTextColor() {
        return this.J;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        ExpandableTextView.super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.l0);
    }

    public final void r() {
        s(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(final StatusType statusType) {
        int i = this.m;
        int i2 = this.D;
        boolean z = i < i2;
        if (statusType != null) {
            this.C = false;
        }
        if (this.C) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            final boolean z2 = z;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, z2, statusType) { // from class: d.c.d.d.i.e.c

                /* renamed from: b  reason: collision with root package name */
                public final ExpandableTextView f1186b;
                public final boolean c;

                /* renamed from: d  reason: collision with root package name */
                public final StatusType f1187d;

                {
                    this.f1186b = this;
                    this.c = z2;
                    this.f1187d = statusType;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f1186b.G(this.c, this.f1187d, valueAnimator);
                }
            });
            ofFloat.setDuration(100L);
            ofFloat.start();
            return;
        }
        if (z) {
            int i3 = this.l;
            this.m = i3 + (i2 - i3);
        } else if (this.s) {
            this.m = this.l;
        }
        CharSequence charSequence = this.F;
        setText(B(charSequence, "action_" + statusType));
    }

    public void setContent(CharSequence charSequence) {
        this.F = charSequence;
        this.g = 0;
        L(charSequence, false);
    }

    public void setContractTextColor(@ColorInt int i) {
        this.K = i;
    }

    public void setCurrStatus(StatusType statusType) {
        s(statusType);
    }

    public void setEndExpendContent(String str) {
        this.O = str;
    }

    public void setExpandOrContractClickListener(OnExpandOrContractClickListener onExpandOrContractClickListener) {
        this.r = onExpandOrContractClickListener;
    }

    public void setExpandTextColor(@ColorInt int i) {
        this.G = i;
    }

    public void setExpandableLineCount(int i) {
        this.D = i;
    }

    public void setExpandableLinkTextColor(@ColorInt int i) {
        this.I = i;
    }

    public void setExpandableTextViewWidth(int i) {
        this.n = i;
    }

    public void setLinkClickListener(OnLinkClickListener onLinkClickListener) {
        this.p = onLinkClickListener;
    }

    public void setLinkDrawable(Drawable drawable) {
        this.o = drawable;
    }

    public void setNeedAnimation(boolean z) {
        this.C = z;
    }

    public void setNeedContract(boolean z) {
        this.s = z;
    }

    public void setNeedExpend(boolean z) {
        this.u = z;
    }

    public void setNeedMention(boolean z) {
        this.w = z;
    }

    public void setOnExpandableContractChangedListener(OnExpandableContractChangedListener onExpandableContractChangedListener) {
        this.k0 = onExpandableContractChangedListener;
    }

    public void setOnGetLineCountListener(OnGetLineCountListener onGetLineCountListener) {
        this.m0 = onGetLineCountListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!this.x || TextUtils.isEmpty(charSequence)) {
            ExpandableTextView.super.setText(charSequence, bufferType);
            return;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        List<UrlParamTool.UrlResult> a = UrlParamTool.a(charSequence.toString());
        if (a != null && !a.isEmpty()) {
            for (UrlParamTool.UrlResult urlResult : a) {
                TextLinkSpan textLinkSpan = new TextLinkSpan(urlResult.a);
                textLinkSpan.b(this.I);
                spannableString.setSpan(textLinkSpan, urlResult.b, urlResult.c, 33);
            }
        }
        ExpandableTextView.super.setText(spannableString, bufferType);
    }

    public final void t(SpannableStringBuilder spannableStringBuilder, FormatData.PositionData positionData, int i) {
        spannableStringBuilder.setSpan(new ClickableSpan(this, positionData) { // from class: com.ibox.nft.base.widgets.expandable.ExpandableTextView.5

            /* renamed from: b  reason: collision with root package name */
            public final FormatData.PositionData f483b;
            public final ExpandableTextView c;

            {
                this.c = this;
                this.f483b = positionData;
            }

            @Override // android.text.style.ClickableSpan
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (this.c.p != null) {
                    this.c.p.a(LinkType.MENTION_TYPE, this.f483b.f(), null);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(this.c.H);
                textPaint.setUnderlineText(false);
            }
        }, positionData.d(), i, 17);
    }

    public final void u(SpannableStringBuilder spannableStringBuilder, FormatData.PositionData positionData, int i) {
        spannableStringBuilder.setSpan(new ClickableSpan(this, positionData) { // from class: com.ibox.nft.base.widgets.expandable.ExpandableTextView.4

            /* renamed from: b  reason: collision with root package name */
            public final FormatData.PositionData f482b;
            public final ExpandableTextView c;

            {
                this.c = this;
                this.f482b = positionData;
            }

            @Override // android.text.style.ClickableSpan
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (this.c.p != null) {
                    this.c.p.a(LinkType.SELF, this.f482b.b(), this.f482b.c());
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(this.c.J);
                textPaint.setUnderlineText(false);
            }
        }, positionData.d(), i, 17);
    }

    public final void v(SpannableStringBuilder spannableStringBuilder, FormatData.PositionData positionData, int i) {
        if (this.R) {
            spannableStringBuilder.setSpan(new StyleSpan(1), positionData.d(), i, 17);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.L), positionData.d(), i, 17);
    }

    public final void w(SpannableStringBuilder spannableStringBuilder, FormatData.PositionData positionData, int i) {
        spannableStringBuilder.setSpan(new ClickableSpan(this, positionData) { // from class: com.ibox.nft.base.widgets.expandable.ExpandableTextView.6

            /* renamed from: b  reason: collision with root package name */
            public final FormatData.PositionData f484b;
            public final ExpandableTextView c;

            {
                this.c = this;
                this.f484b = positionData;
            }

            @Override // android.text.style.ClickableSpan
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (this.c.p != null) {
                    this.c.p.a(LinkType.LINK_TYPE, this.f484b.f(), null);
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse(this.f484b.f()));
                    this.c.i.startActivity(intent);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(this.c.I);
                textPaint.setUnderlineText(false);
            }
        }, positionData.d() + 1, i, 17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SpannableStringBuilder x(FormatData formatData, boolean z, String str) {
        float f2;
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ExpandableStatusFix expandableStatusFix = this.j;
        if (!(expandableStatusFix == null || expandableStatusFix.getStatus() == null)) {
            if (this.j.getStatus() != null && this.j.getStatus().equals(StatusType.STATUS_CONTRACT)) {
                int i = this.l;
                this.m = i + (this.D - i);
            } else if (this.s) {
                this.m = this.l;
            }
        }
        if (z) {
            float measureText = this.h.measureText(" ");
            if (!this.S || measureText <= 0.0f) {
                str2 = "";
                f2 = 0.0f;
            } else {
                StringBuilder sb = new StringBuilder("");
                int i2 = this.d0;
                int i3 = ((float) i2) < measureText ? 2 : ((int) ((i2 + measureText) / measureText)) + 1;
                f2 = 0.0f;
                for (int i4 = 0; i4 < i3; i4++) {
                    sb.append(" ");
                    f2 += measureText;
                }
                str2 = sb.toString();
            }
            int i5 = this.m;
            if (i5 < this.D) {
                int i6 = i5 - 1;
                int lineEnd = this.k.getLineEnd(i6);
                int lineStart = this.k.getLineStart(i6);
                float lineWidth = this.k.getLineWidth(i6);
                String hideEndContent = getHideEndContent();
                String substring = formatData.a().substring(0, A(hideEndContent + str2, lineEnd, lineStart, lineWidth, this.h.measureText(hideEndContent) + f2, 0.0f));
                String str3 = substring;
                if (substring.endsWith("\n")) {
                    str3 = substring.substring(0, substring.length() - 1);
                }
                spannableStringBuilder.append((CharSequence) str3);
                if (this.B) {
                    float f3 = 0.0f;
                    for (int i7 = 0; i7 < i6; i7++) {
                        f3 += this.k.getLineWidth(i7);
                    }
                    float measureText2 = ((f3 / i6) - lineWidth) - this.h.measureText(hideEndContent);
                    if (measureText2 > 0.0f) {
                        int i8 = 0;
                        while (i8 * measureText < measureText2) {
                            i8++;
                        }
                        for (int i9 = 0; i9 < i8 - 1; i9++) {
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                    }
                }
                SpannableString spannableString = new SpannableString(hideEndContent);
                spannableString.setSpan(new ForegroundColorSpan(this.G), spannableString.length() - this.M.length(), spannableString.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                int length = TextUtils.isEmpty(this.O) ? 0 : this.O.length() + 2;
                spannableStringBuilder.setSpan(new ClickableSpan(this) { // from class: com.ibox.nft.base.widgets.expandable.ExpandableTextView.2

                    /* renamed from: b  reason: collision with root package name */
                    public final ExpandableTextView f480b;

                    {
                        this.f480b = this;
                    }

                    @Override // android.text.style.ClickableSpan
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        if (this.f480b.q) {
                            if (this.f480b.j != null) {
                                this.f480b.j.a(StatusType.STATUS_CONTRACT);
                                ExpandableTextView expandableTextView = this.f480b;
                                expandableTextView.s(expandableTextView.j.getStatus());
                            } else {
                                this.f480b.r();
                            }
                        }
                        if (this.f480b.r != null) {
                            this.f480b.r.a(StatusType.STATUS_EXPAND);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(this.f480b.G);
                        textPaint.setUnderlineText(false);
                    }
                }, (spannableStringBuilder.length() - this.M.length()) - length, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.G), (spannableStringBuilder.length() - this.M.length()) - length, spannableStringBuilder.length(), 17);
                if (this.S) {
                    spannableStringBuilder.append((CharSequence) str2);
                    spannableStringBuilder.setSpan(new SelfImageSpan(this, this.T, 1), (spannableStringBuilder.length() - str2.length()) + 1, spannableStringBuilder.length(), 18);
                }
                OnExpandableContractChangedListener onExpandableContractChangedListener = this.k0;
                if (onExpandableContractChangedListener != null) {
                    onExpandableContractChangedListener.a(true, StatusType.STATUS_EXPAND);
                }
            } else {
                spannableStringBuilder.append((CharSequence) formatData.a());
                if (this.s) {
                    String expandEndContent = getExpandEndContent();
                    if (this.B) {
                        int lineCount = this.k.getLineCount() - 1;
                        float lineWidth2 = this.k.getLineWidth(lineCount);
                        float f4 = 0.0f;
                        for (int i10 = 0; i10 < lineCount; i10++) {
                            f4 += this.k.getLineWidth(i10);
                        }
                        float measureText3 = (((f4 / lineCount) - lineWidth2) - this.h.measureText(expandEndContent)) - f2;
                        if (measureText3 > 0.0f) {
                            int i11 = 0;
                            while (i11 * measureText < measureText3) {
                                i11++;
                            }
                            for (int i12 = 0; i12 < i11 - 1; i12++) {
                                spannableStringBuilder.append((CharSequence) " ");
                            }
                        }
                    }
                    SpannableString spannableString2 = new SpannableString(expandEndContent);
                    spannableString2.setSpan(new ForegroundColorSpan(this.K), spannableString2.length() - this.N.length(), spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    int length2 = TextUtils.isEmpty(this.O) ? 0 : this.O.length() + 2;
                    spannableStringBuilder.setSpan(new ClickableSpan(this) { // from class: com.ibox.nft.base.widgets.expandable.ExpandableTextView.3

                        /* renamed from: b  reason: collision with root package name */
                        public final ExpandableTextView f481b;

                        {
                            this.f481b = this;
                        }

                        @Override // android.text.style.ClickableSpan
                        @SensorsDataInstrumented
                        public void onClick(View view) {
                            if (this.f481b.j != null) {
                                this.f481b.j.a(StatusType.STATUS_EXPAND);
                                ExpandableTextView expandableTextView = this.f481b;
                                expandableTextView.s(expandableTextView.j.getStatus());
                            } else {
                                this.f481b.r();
                            }
                            if (this.f481b.r != null) {
                                this.f481b.r.a(StatusType.STATUS_CONTRACT);
                            }
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(this.f481b.K);
                            textPaint.setUnderlineText(false);
                        }
                    }, (spannableStringBuilder.length() - this.N.length()) - length2, spannableStringBuilder.length(), 17);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.K), (spannableStringBuilder.length() - this.N.length()) - length2, spannableStringBuilder.length(), 17);
                    if (this.S) {
                        spannableStringBuilder.append((CharSequence) str2);
                        spannableStringBuilder.setSpan(new SelfImageSpan(this, this.U, 1), (spannableStringBuilder.length() - str2.length()) + 1, spannableStringBuilder.length(), 18);
                    }
                    OnExpandableContractChangedListener onExpandableContractChangedListener2 = this.k0;
                    if (onExpandableContractChangedListener2 != null) {
                        onExpandableContractChangedListener2.a(true, StatusType.STATUS_CONTRACT);
                    }
                } else {
                    if (!TextUtils.isEmpty(this.O)) {
                        spannableStringBuilder.append((CharSequence) this.O);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.P), spannableStringBuilder.length() - this.O.length(), spannableStringBuilder.length(), 17);
                    }
                    OnExpandableContractChangedListener onExpandableContractChangedListener3 = this.k0;
                    if (onExpandableContractChangedListener3 != null) {
                        onExpandableContractChangedListener3.a(false, StatusType.STATUS_CONTRACT);
                    }
                }
            }
        } else {
            spannableStringBuilder.append((CharSequence) formatData.a());
            if (!TextUtils.isEmpty(this.O)) {
                spannableStringBuilder.append((CharSequence) this.O);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.P), spannableStringBuilder.length() - this.O.length(), spannableStringBuilder.length(), 17);
            }
            OnExpandableContractChangedListener onExpandableContractChangedListener4 = this.k0;
            if (onExpandableContractChangedListener4 != null) {
                onExpandableContractChangedListener4.a(false, StatusType.STATUS_EXPAND);
            }
        }
        for (FormatData.PositionData positionData : formatData.b()) {
            if (spannableStringBuilder.length() >= positionData.a()) {
                if (positionData.e().equals(LinkType.PREFIX_MARK)) {
                    spannableStringBuilder.setSpan(new SelfImageSpan(this, this.g0, 1), positionData.d(), positionData.a() - 1, 33);
                } else if (positionData.e().equals(LinkType.PREFIX_LABEL)) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.q0), positionData.d(), positionData.a(), 33);
                    spannableStringBuilder.setSpan(getExpandableLabelSpan(), positionData.d(), positionData.a(), 33);
                } else if (positionData.e().equals(LinkType.TITLE)) {
                    if (!this.u || !z) {
                        v(spannableStringBuilder, positionData, positionData.a());
                    } else {
                        int length3 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (positionData.d() < length3) {
                            int a = positionData.a();
                            if (this.m < this.D && length3 < positionData.a()) {
                                a = length3;
                            }
                            v(spannableStringBuilder, positionData, a);
                        }
                    }
                } else if (positionData.e().equals(LinkType.LINK_TYPE)) {
                    if (!this.u || !z) {
                        spannableStringBuilder.setSpan(new SelfImageSpan(this, this.o, 1), positionData.d(), positionData.d() + 1, 18);
                        w(spannableStringBuilder, positionData, positionData.a());
                    } else {
                        int length4 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (positionData.d() < length4) {
                            spannableStringBuilder.setSpan(new SelfImageSpan(this, this.o, 1), positionData.d(), positionData.d() + 1, 18);
                            int a2 = positionData.a();
                            int i13 = a2;
                            if (this.m < this.D) {
                                i13 = a2;
                                if (length4 > positionData.d() + 1) {
                                    i13 = a2;
                                    if (length4 < positionData.a()) {
                                        i13 = length4;
                                    }
                                }
                            }
                            if (positionData.d() + 1 < length4) {
                                w(spannableStringBuilder, positionData, i13);
                            }
                        }
                    }
                } else if (positionData.e().equals(LinkType.MENTION_TYPE)) {
                    if (!this.u || !z) {
                        t(spannableStringBuilder, positionData, positionData.a());
                    } else {
                        int length5 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (positionData.d() < length5) {
                            int a3 = positionData.a();
                            if (this.m < this.D && length5 < positionData.a()) {
                                a3 = length5;
                            }
                            t(spannableStringBuilder, positionData, a3);
                        }
                    }
                } else if (positionData.e().equals(LinkType.SELF)) {
                    if (!this.u || !z) {
                        u(spannableStringBuilder, positionData, positionData.a());
                    } else {
                        int length6 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (positionData.d() < length6) {
                            int a4 = positionData.a();
                            if (this.m < this.D && length6 < positionData.a()) {
                                a4 = length6;
                            }
                            u(spannableStringBuilder, positionData, a4);
                        }
                    }
                }
            }
        }
        setHighlightColor(0);
        return spannableStringBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(final CharSequence charSequence, final String str) {
        this.m = this.l;
        if (TextUtils.isEmpty(charSequence)) {
            setText("");
        } else if (this.n <= 0) {
            post(new Runnable(this, charSequence, str) { // from class: d.c.d.d.i.e.a

                /* renamed from: b  reason: collision with root package name */
                public final ExpandableTextView f1183b;
                public final CharSequence c;

                /* renamed from: d  reason: collision with root package name */
                public final String f1184d;

                {
                    this.f1183b = this;
                    this.c = charSequence;
                    this.f1184d = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1183b.I(this.c, this.f1184d);
                }
            });
        } else {
            setText(B(charSequence, str));
            this.g = 0;
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final FormatData z(CharSequence charSequence) {
        int i;
        int i2;
        int i3;
        int i4;
        FormatData formatData = new FormatData();
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        if (this.f0) {
            StringBuilder sb2 = new StringBuilder();
            String D = D(C(this.i0));
            sb2.append(D);
            i2 = D.length();
            arrayList.add(new FormatData.PositionData(0, i2, sb2.toString(), LinkType.PREFIX_MARK));
            stringBuffer.append(sb2.toString());
            sb.append((CharSequence) sb2);
            i = i2;
        } else {
            i = 0;
            i2 = 0;
        }
        if (this.n0) {
            StringBuilder sb3 = new StringBuilder();
            int i5 = i2;
            if (!TextUtils.isEmpty(this.o0)) {
                int length = this.o0.length();
                int i6 = this.p0;
                if (length > i6) {
                    this.o0 = this.o0.substring(0, i6);
                }
                String str = this.o0 + " ";
                this.o0 = str;
                i5 = str.length() + i2;
                arrayList.add(new FormatData.PositionData(i2, i5 - 1, this.o0, LinkType.PREFIX_LABEL));
                stringBuffer.append(this.o0);
                sb3.append(this.o0);
            }
            sb.append((CharSequence) sb3);
            i3 = i5;
            i2 = i5;
        } else {
            i3 = i;
        }
        sb.append(charSequence);
        if (this.A) {
            String charSequence2 = TextUtils.isEmpty(this.E) ? "" : this.E.toString();
            i4 = charSequence2.length() + i3;
            arrayList.add(new FormatData.PositionData(i3, i4, charSequence2, LinkType.TITLE));
            stringBuffer.append(charSequence2);
            i2 = i4;
        } else {
            i4 = 0;
        }
        Matcher matcher = Pattern.compile("\\[([^\\[]*)\\]\\(([^\\(]*)\\)", 2).matcher(sb);
        int i7 = i2;
        if (this.z) {
            ArrayList arrayList2 = new ArrayList();
            while (matcher.find()) {
                int start = matcher.start();
                i2 = matcher.end();
                stringBuffer.append(sb.toString().substring(i4, start));
                String group = matcher.group();
                if (!TextUtils.isEmpty(group)) {
                    String substring = group.substring(group.indexOf("[") + 1, group.indexOf("]"));
                    String substring2 = group.substring(group.indexOf("(") + 1, group.indexOf(")"));
                    String a = UUIDUtils.a(substring.length());
                    arrayList2.add(new FormatData.PositionData(stringBuffer.length() + 1, stringBuffer.length() + 2 + substring.length(), substring, substring2, LinkType.SELF));
                    hashMap.put(a, substring);
                    stringBuffer.append(" " + a + " ");
                    i4 = i2;
                }
            }
            arrayList.addAll(arrayList2);
            i7 = i2;
        }
        stringBuffer.append(sb.toString().substring(i7, sb.toString().length()));
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(stringBuffer2.toString().substring(0, stringBuffer2.toString().length()));
        if (this.w) {
            Matcher matcher2 = Pattern.compile("#\u0002\\S*\u0002?#", 2).matcher(stringBuffer3.toString());
            ArrayList arrayList3 = new ArrayList();
            while (matcher2.find()) {
                arrayList3.add(new FormatData.PositionData(matcher2.start(), matcher2.end(), matcher2.group(), LinkType.MENTION_TYPE));
            }
            arrayList.addAll(0, arrayList3);
        }
        StringBuffer stringBuffer4 = stringBuffer3;
        if (!hashMap.isEmpty()) {
            String stringBuffer5 = stringBuffer3.toString();
            for (Map.Entry entry : hashMap.entrySet()) {
                stringBuffer5 = stringBuffer5.replaceAll((String) entry.getKey(), (String) entry.getValue());
            }
            stringBuffer4 = new StringBuffer(stringBuffer5);
        }
        formatData.c(stringBuffer4.toString());
        formatData.d(arrayList);
        return formatData;
    }
}
