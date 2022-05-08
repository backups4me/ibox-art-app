package com.ibox.nft.base.widgets.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.ibox.libs.common.utils.PixelTool;
import com.ibox.nft.base.R;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: RollPagerView.class */
public class RollPagerView extends RelativeLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f451b;
    public PagerAdapter c;

    /* renamed from: d  reason: collision with root package name */
    public OnItemClickListener f452d;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f453e;
    public long f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public View q;
    public Timer r;
    public FrameLayout s;
    public boolean t;
    public HintViewDelegate u;
    public TimeTaskHandler v;
    public ViewPager.OnPageChangeListener w;

    /* loaded from: RollPagerView$HintViewDelegate.class */
    public interface HintViewDelegate {
        void a(int i, HintView hintView);

        void b(int i, int i2, HintView hintView);
    }

    /* loaded from: RollPagerView$JPagerObserver.class */
    public class JPagerObserver extends DataSetObserver {
        public final RollPagerView a;

        public JPagerObserver(RollPagerView rollPagerView) {
            this.a = rollPagerView;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.a.l();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.a.l();
        }
    }

    /* loaded from: RollPagerView$TimeTaskHandler.class */
    public static final class TimeTaskHandler extends Handler {
        public WeakReference<RollPagerView> a;

        public TimeTaskHandler(RollPagerView rollPagerView) {
            this.a = new WeakReference<>(rollPagerView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int count;
            WeakReference<RollPagerView> weakReference = this.a;
            RollPagerView rollPagerView = weakReference == null ? null : weakReference.get();
            if (rollPagerView != null && rollPagerView.c != null && (count = rollPagerView.c.getCount()) > 0) {
                int currentItem = (rollPagerView.getViewPager().getCurrentItem() + 1) % count;
                rollPagerView.getViewPager().setCurrentItem(currentItem);
                rollPagerView.u.a(currentItem, (HintView) rollPagerView.q);
                if (count <= 1) {
                    rollPagerView.u();
                }
            }
        }
    }

    /* loaded from: RollPagerView$WeakTimerTask.class */
    public static class WeakTimerTask extends TimerTask {

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<RollPagerView> f455b;

        public WeakTimerTask(RollPagerView rollPagerView) {
            this.f455b = new WeakReference<>(rollPagerView);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            WeakReference<RollPagerView> weakReference = this.f455b;
            RollPagerView rollPagerView = weakReference == null ? null : weakReference.get();
            if (rollPagerView == null) {
                cancel();
            } else if (rollPagerView.isShown() && System.currentTimeMillis() - rollPagerView.f > rollPagerView.g && rollPagerView.o()) {
                rollPagerView.v.sendEmptyMessage(0);
            }
        }
    }

    public RollPagerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RollPagerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = false;
        this.t = true;
        this.u = new HintViewDelegate(this) { // from class: com.ibox.nft.base.widgets.banner.RollPagerView.1
            public final RollPagerView a;

            {
                this.a = this;
            }

            @Override // com.ibox.nft.base.widgets.banner.RollPagerView.HintViewDelegate
            public void a(int i2, HintView hintView) {
                if (hintView != null) {
                    hintView.setCurrent(i2);
                }
            }

            @Override // com.ibox.nft.base.widgets.banner.RollPagerView.HintViewDelegate
            public void b(int i2, int i3, HintView hintView) {
                if (hintView != null) {
                    hintView.a(i2, i3);
                }
            }
        };
        this.v = new TimeTaskHandler(this);
        n(attributeSet);
        setAnimationDurtion(400);
    }

    private int getRealPosition() {
        PagerAdapter pagerAdapter = this.c;
        if (pagerAdapter == null) {
            return 0;
        }
        return pagerAdapter instanceof LoopPagerAdapter ? this.f451b.getCurrentItem() % this.c.b() : this.f451b.getCurrentItem();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            this.f = System.currentTimeMillis();
            this.f453e.onTouchEvent(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public ViewPager getViewPager() {
        return this.f451b;
    }

    public void k(View view, FrameLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.s;
        if (frameLayout != null) {
            frameLayout.addView(view, layoutParams);
        }
    }

    public final void l() {
        if (this.q != null) {
            this.u.b(this.c.getCount(), this.h, (HintView) this.q);
            this.u.a(this.f451b.getCurrentItem(), (HintView) this.q);
        }
        t();
    }

    public final void m(HintView hintView) {
        View view = this.q;
        if (view != null) {
            removeView(view);
        }
        if (hintView != null) {
            this.q = (View) hintView;
            p();
        }
    }

    public final void n(AttributeSet attributeSet) {
        ViewPager viewPager = this.f451b;
        if (viewPager != null) {
            removeView(viewPager);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RollViewPager);
        this.h = obtainStyledAttributes.getInteger(R.styleable.RollViewPager_rvp_hint_gravity, 1);
        this.g = obtainStyledAttributes.getInt(R.styleable.RollViewPager_rvp_play_delay, 0);
        this.i = obtainStyledAttributes.getColor(R.styleable.RollViewPager_rvp_hint_color, WebView.NIGHT_MODE_COLOR);
        this.j = obtainStyledAttributes.getInt(R.styleable.RollViewPager_rvp_hint_alpha, 0);
        this.l = obtainStyledAttributes.getInt(R.styleable.RollViewPager_rvp_page_num, 1);
        this.p = obtainStyledAttributes.getBoolean(R.styleable.RollViewPager_rvp_show_bottom_panel, false);
        this.k = (int) obtainStyledAttributes.getDimension(R.styleable.RollViewPager_rvp_hint_paddingLeft, 0.0f);
        this.n = (int) obtainStyledAttributes.getDimension(R.styleable.RollViewPager_rvp_hint_paddingRight, 0.0f);
        this.m = (int) obtainStyledAttributes.getDimension(R.styleable.RollViewPager_rvp_hint_paddingTop, 0.0f);
        this.o = (int) obtainStyledAttributes.getDimension(R.styleable.RollViewPager_rvp_hint_paddingBottom, PixelTool.a(4.0f));
        ViewPager viewPager2 = new ViewPager(getContext());
        this.f451b = viewPager2;
        viewPager2.setOffscreenPageLimit(this.l);
        this.f451b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f451b);
        obtainStyledAttributes.recycle();
        q();
        m(new ColorPointHintView(getContext(), Color.parseColor("#E3AC42"), Color.parseColor("#88ffffff")));
        this.f453e = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(this) { // from class: com.ibox.nft.base.widgets.banner.RollPagerView.2
            public final RollPagerView a;

            {
                this.a = this;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (this.a.f452d == null) {
                    return super.onSingleTapUp(motionEvent);
                }
                int currentItem = this.a.f451b.getCurrentItem();
                int i = currentItem;
                if (this.a.c instanceof LoopPagerAdapter) {
                    i = currentItem % this.a.c.b();
                }
                this.a.f452d.a(i);
                return super.onSingleTapUp(motionEvent);
            }
        });
    }

    public boolean o() {
        return this.t;
    }

    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.w;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(getRealPosition());
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.w;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(getRealPosition(), f, i2);
        }
    }

    public void onPageSelected(int i) {
        this.u.a(i, (HintView) this.q);
        ViewPager.OnPageChangeListener onPageChangeListener = this.w;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(getRealPosition());
        }
    }

    public final void p() {
        addView(this.q);
        this.q.setPadding(this.k, this.m, this.n, this.o);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.q.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.i);
        gradientDrawable.setAlpha(this.j);
        this.q.setBackgroundDrawable(gradientDrawable);
        HintViewDelegate hintViewDelegate = this.u;
        PagerAdapter pagerAdapter = this.c;
        hintViewDelegate.b(pagerAdapter == null ? 0 : pagerAdapter.getCount(), this.h, (HintView) this.q);
    }

    public final void q() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.s = frameLayout;
        addView(frameLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.s.setLayoutParams(layoutParams);
    }

    public void r() {
        u();
    }

    public void s() {
        t();
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        pagerAdapter.registerDataSetObserver(new JPagerObserver());
        this.f451b.setAdapter(pagerAdapter);
        this.f451b.addOnPageChangeListener(this);
        this.c = pagerAdapter;
        l();
    }

    public void setAnimationDurtion(int i) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.f451b, new Scroller(this, getContext(), new DecelerateInterpolator(), i) { // from class: com.ibox.nft.base.widgets.banner.RollPagerView.3
                public final int a;

                /* renamed from: b  reason: collision with root package name */
                public final RollPagerView f454b;

                {
                    this.f454b = this;
                    this.a = i;
                }

                @Override // android.widget.Scroller
                public void startScroll(int i2, int i3, int i4, int i5) {
                    super.startScroll(i2, i3, i4, i5, this.a);
                }

                @Override // android.widget.Scroller
                public void startScroll(int i2, int i3, int i4, int i5, int i6) {
                    super.startScroll(i2, i3, i4, i5, System.currentTimeMillis() - this.f454b.f > ((long) this.f454b.g) ? this.a : i6 / 2);
                }
            });
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }

    public void setAutoPlay(boolean z) {
        this.t = z;
    }

    public void setHintAlpha(int i) {
        this.j = i;
        m((HintView) this.q);
    }

    public void setHintView(HintView hintView) {
        View view = this.q;
        if (view != null) {
            removeView(view);
        }
        this.q = (View) hintView;
        if (hintView != null && (hintView instanceof View)) {
            m(hintView);
        }
    }

    public void setHintViewDelegate(HintViewDelegate hintViewDelegate) {
        this.u = hintViewDelegate;
    }

    public void setOnBannerChangedListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.w = onPageChangeListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f452d = onItemClickListener;
    }

    public void setPlayDelay(int i) {
        this.g = i;
        t();
    }

    public final void t() {
        PagerAdapter pagerAdapter = this.c;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 1) {
            u();
        } else if (this.g > 0) {
            Timer timer = this.r;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = new Timer();
            this.r = timer2;
            WeakTimerTask weakTimerTask = new WeakTimerTask(this);
            int i = this.g;
            timer2.schedule(weakTimerTask, i, i);
        }
    }

    public final void u() {
        Timer timer = this.r;
        if (timer != null) {
            timer.cancel();
            this.r = null;
        }
    }
}
