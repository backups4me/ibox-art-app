package com.ibox.nft.base.widgets.notice;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.notice.NoticeScrollData;
import com.ibox.nft.base.widgets.notice.NoticeScrollItemView;
import com.ibox.nft.base.widgets.notice.NoticeScrollView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;

/* loaded from: NoticeScrollView.class */
public class NoticeScrollView extends FrameLayout implements View.OnClickListener, NoticeHandleCallback {

    /* renamed from: b  reason: collision with root package name */
    public NoticeScrollItemView f498b;
    public NoticeScrollItemView c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f499d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f500e;
    public View f;
    public Handler g;
    public Callback h;
    public int i;
    public boolean j;
    public int k;
    public List<NoticeScrollData> l;
    public boolean m;
    public boolean n;

    /* loaded from: NoticeScrollView$Callback.class */
    public interface Callback {
        void a(NoticeScrollData noticeScrollData);

        void b(NoticeScrollData noticeScrollData);

        void c();
    }

    public NoticeScrollView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoticeScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = true;
        b(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(NoticeScrollData noticeScrollData) {
        setLeftIcon(noticeScrollData.getTagToIcon());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ boolean g(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.f499d.setImageResource(R.drawable.home_notice_more);
        view.performClick();
        return true;
    }

    public final NoticeScrollData a(int i) {
        List<NoticeScrollData> list = this.l;
        if (list == null || list.isEmpty() || i >= this.l.size()) {
            return null;
        }
        return this.l.get(i);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.g = new NoticeWeakHandler(this);
        c(context);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.NoticeScrollView);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(R.styleable.NoticeScrollView_more_visibility, 0);
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.NoticeScrollView_text_style_bold, true);
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.NoticeScrollView_left_visibility, 0);
            int integer3 = obtainStyledAttributes.getInteger(R.styleable.NoticeScrollView_cover_visibility, 0);
            int i = R.styleable.NoticeScrollView_first_text_color;
            Context context2 = getContext();
            int i2 = R.color.baseColorPrimaryText;
            int color = obtainStyledAttributes.getColor(i, ContextCompat.getColor(context2, i2));
            int color2 = obtainStyledAttributes.getColor(R.styleable.NoticeScrollView_second_text_color, ContextCompat.getColor(getContext(), i2));
            int integer4 = obtainStyledAttributes.getInteger(R.styleable.NoticeScrollView_item_gravity, 0);
            if (integer == 0) {
                this.f499d.setVisibility(0);
            } else if (integer == 1) {
                this.f499d.setVisibility(4);
            } else if (integer != 2) {
                this.f499d.setVisibility(0);
            } else {
                this.f499d.setVisibility(8);
            }
            this.f498b.setTextBold(z);
            this.c.setTextBold(z);
            if (integer2 == 0) {
                this.f500e.setVisibility(0);
            } else if (integer2 == 1) {
                this.f500e.setVisibility(4);
            } else if (integer2 != 2) {
                this.f500e.setVisibility(0);
            } else {
                this.f500e.setVisibility(8);
            }
            if (integer3 == 0) {
                this.f.setVisibility(0);
            } else if (integer3 == 1) {
                this.f.setVisibility(4);
            } else if (integer3 != 2) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            this.f498b.setFirstTextColor(color);
            this.c.setFirstTextColor(color);
            this.f498b.setSecondTextColor(color2);
            this.c.setSecondTextColor(color2);
            if (integer4 == 0) {
                this.f498b.setGravity(19);
                this.c.setGravity(19);
            } else if (integer4 == 1) {
                this.f498b.setGravity(21);
                this.c.setGravity(21);
            }
            obtainStyledAttributes.recycle();
        }
        setOnClickListener(this);
        this.f498b.setCallback(new NoticeScrollItemView.Callback(this) { // from class: d.c.d.d.i.g.d
            public final NoticeScrollView a;

            {
                this.a = this;
            }

            @Override // com.ibox.nft.base.widgets.notice.NoticeScrollItemView.Callback
            public final void a(NoticeScrollData noticeScrollData) {
                this.a.e(noticeScrollData);
            }
        });
        this.f499d.setOnClickListener(this);
        this.f499d.setOnTouchListener(new View.OnTouchListener(this) { // from class: d.c.d.d.i.g.c

            /* renamed from: b  reason: collision with root package name */
            public final NoticeScrollView f1193b;

            {
                this.f1193b = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f1193b.g(view, motionEvent);
            }
        });
    }

    public final void c(Context context) {
        FrameLayout.inflate(context, R.layout.layout_notice_scroll_view, this);
        this.f498b = (NoticeScrollItemView) findViewById(R.id.top_scroll_item_view1);
        this.c = (NoticeScrollItemView) findViewById(R.id.top_scroll_item_view2);
        this.f499d = (ImageView) findViewById(R.id.index_notice_more);
        this.f500e = (ImageView) findViewById(R.id.left_icon_iv);
        this.f = findViewById(R.id.cover_view);
    }

    public void h(List<NoticeScrollData> list, boolean z) {
        LogTool.a("NoticeScrollView-->setDatas-->" + list + " reset:" + z);
        this.l = list;
        if (z) {
            this.m = false;
            this.f498b.h();
            this.c.h();
        }
        if (!this.m) {
            this.m = true;
            this.k = 0;
            this.j = true;
            k();
        }
    }

    @Override // com.ibox.nft.base.widgets.notice.NoticeHandleCallback
    public void handleMessage(Message message) {
        if (message.what == 1) {
            int i = this.k + 1;
            this.k = i;
            List<NoticeScrollData> list = this.l;
            if (list == null || i >= list.size()) {
                this.k = 0;
            }
            k();
            if (this.n) {
                this.g.sendEmptyMessageDelayed(1, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            }
        }
    }

    public void i() {
        this.n = true;
        Handler handler = this.g;
        if (handler != null) {
            handler.removeMessages(1);
            this.g.sendEmptyMessageDelayed(1, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        }
    }

    public void j() {
        this.n = false;
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void k() {
        NoticeScrollData a = a(this.k);
        Callback callback = this.h;
        if (callback != null) {
            callback.a(a);
        }
        if (this.j) {
            this.f498b.i(a);
            this.c.a();
        } else {
            this.c.i(a);
            this.f498b.a();
        }
        this.j = !this.j;
    }

    @Override // android.view.View.OnClickListener
    @SensorsDataInstrumented
    public void onClick(View view) {
        Callback callback;
        if (view.getId() != R.id.index_notice_more || (callback = this.h) == null) {
            if (this.h != null) {
                NoticeScrollData a = a(this.k);
                if (a == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                this.h.b(a);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        callback.c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.i = getHeight();
    }

    public void setCallback(Callback callback) {
        this.h = callback;
    }

    public void setDatas(List<NoticeScrollData> list) {
        h(list, false);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        NoticeScrollItemView noticeScrollItemView = this.f498b;
        if (noticeScrollItemView != null) {
            noticeScrollItemView.setEllipsize(truncateAt);
        }
        NoticeScrollItemView noticeScrollItemView2 = this.c;
        if (noticeScrollItemView2 != null) {
            noticeScrollItemView2.setEllipsize(truncateAt);
        }
    }

    public void setLeftIcon(@DrawableRes int i) {
        ImageView imageView = this.f500e;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }
}
