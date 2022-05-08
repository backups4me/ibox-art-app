package com.ibox.nft.base.widgets.notice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.alipay.sdk.widget.d;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.notice.NoticeScrollData;
import com.ibox.nft.base.widgets.notice.NoticeScrollItemView;

/* loaded from: NoticeScrollItemView.class */
public class NoticeScrollItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public Callback f495b;
    public TextView c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f496d;

    /* renamed from: e  reason: collision with root package name */
    public NoticeScrollData f497e;
    public int f;
    public int g;
    public TextUtils.TruncateAt h;
    public ObjectAnimator i;
    public final Interpolator j;

    /* loaded from: NoticeScrollItemView$Callback.class */
    public interface Callback {
        void a(NoticeScrollData noticeScrollData);
    }

    public NoticeScrollItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoticeScrollItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 0;
        this.h = null;
        this.j = new DecelerateInterpolator();
        setOrientation(0);
        setGravity(16);
        c(context);
        if (isInEditMode()) {
            this.c.setText(d.v);
            this.f496d.setText("desc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e() {
        if (this.g == 1) {
            this.g = 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, 0.0f, -getHeight());
            this.i = ofFloat;
            ofFloat.setInterpolator(this.j);
            this.i.setDuration(500L);
            this.i.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g(NoticeScrollData noticeScrollData) {
        this.g = 1;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, getHeight(), 0.0f);
        this.i = ofFloat;
        ofFloat.setInterpolator(this.j);
        this.i.setDuration(500L);
        this.i.start();
        Callback callback = this.f495b;
        if (callback != null) {
            callback.a(noticeScrollData);
        }
    }

    public void a() {
        post(new Runnable(this) { // from class: d.c.d.d.i.g.b

            /* renamed from: b  reason: collision with root package name */
            public final NoticeScrollItemView f1192b;

            {
                this.f1192b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1192b.e();
            }
        });
    }

    public final String b(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        return str2;
    }

    public final void c(Context context) {
        this.c = (TextView) LayoutInflater.from(context).inflate(R.layout.notice_scroll_item_view, (ViewGroup) null);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.c.setSingleLine();
        this.c.setEllipsize(this.h);
        this.c.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
        this.c.setTextSize(1, 12.0f);
        addView(this.c);
        this.f496d = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.dp_5);
        this.f496d.setLayoutParams(layoutParams);
        this.f496d.setSingleLine();
        this.f496d.setEllipsize(this.h);
        this.f496d.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
        this.f496d.setTextSize(1, 12.0f);
        addView(this.f496d);
    }

    public void h() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.i.cancel();
        }
        this.c.setText("");
        this.f496d.setText("");
        this.g = 0;
    }

    public void i(final NoticeScrollData noticeScrollData) {
        this.f497e = noticeScrollData;
        if (noticeScrollData == null) {
            h();
            return;
        }
        this.c.setText(b(noticeScrollData.getNotice1()));
        this.f496d.setText(b(noticeScrollData.getNotice2()));
        post(new Runnable(this, noticeScrollData) { // from class: d.c.d.d.i.g.a

            /* renamed from: b  reason: collision with root package name */
            public final NoticeScrollItemView f1191b;
            public final NoticeScrollData c;

            {
                this.f1191b = this;
                this.c = noticeScrollData;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1191b.g(this.c);
            }
        });
    }

    public void setCallback(Callback callback) {
        this.f495b = callback;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.h = truncateAt;
        TextView textView = this.c;
        if (textView != null) {
            textView.setEllipsize(truncateAt);
        }
        TextView textView2 = this.f496d;
        if (textView2 != null) {
            textView2.setEllipsize(truncateAt);
        }
    }

    public void setFirstTextColor(int i) {
        this.c.setTextColor(i);
    }

    public void setIndex(int i) {
        this.f = i;
    }

    public void setSecondTextColor(int i) {
        this.f496d.setTextColor(i);
    }

    public void setText(NoticeScrollData noticeScrollData) {
        this.c.setText(b(noticeScrollData.getNotice1()));
        this.f496d.setText(b(noticeScrollData.getNotice2()));
    }

    public void setTextBold(boolean z) {
        Typeface font = ResourcesCompat.getFont(getContext(), R.font.dinpro_regular);
        this.c.getPaint().setTypeface(font);
        this.f496d.getPaint().setTypeface(font);
    }
}
