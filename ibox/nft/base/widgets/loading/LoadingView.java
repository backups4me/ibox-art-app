package com.ibox.nft.base.widgets.loading;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.SafeLottieView;
import java.io.InputStream;

/* loaded from: LoadingView.class */
public class LoadingView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f493b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public int f494d;

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingView, i, 0);
        this.f494d = obtainStyledAttributes.getResourceId(R.styleable.LoadingView_loading_view_lottie_rawRes, R.raw.d_middle);
        this.c = obtainStyledAttributes.getBoolean(R.styleable.LoadingView_loading_view_lottie_loop, true);
        obtainStyledAttributes.recycle();
        a(context);
    }

    public final void a(Context context) {
        LottieAnimationView lottieAnimationView = this.f493b;
        if (lottieAnimationView != null) {
            removeView(lottieAnimationView);
        }
        this.f493b = new SafeLottieView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f493b.setLayoutParams(layoutParams);
        addView(this.f493b);
        setLottieAnimationRes(this.f494d);
        setLoop(this.c);
    }

    public void b() {
        LogTool.a("LoadingView-->start-->");
        LottieAnimationView lottieAnimationView = this.f493b;
        if (lottieAnimationView != null) {
            lottieAnimationView.playAnimation();
        }
    }

    public void c() {
        LogTool.a("LoadingView-->stop-->");
        LottieAnimationView lottieAnimationView = this.f493b;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.f493b.clearAnimation();
        }
    }

    public void setLoop(boolean z) {
        setRepeatCount(z ? -1 : 0);
    }

    public void setLottieAnimationName(String str) {
        LottieAnimationView lottieAnimationView = this.f493b;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(str);
        }
    }

    public void setLottieAnimationRes(int i) {
        if (this.f493b != null && i != 0) {
            Resources resources = getResources();
            int i2 = resources.getConfiguration().uiMode;
            InputStream openRawResource = resources.openRawResource(i);
            this.f493b.setAnimation(openRawResource, "rawRes_" + (i2 & 32) + "_" + i);
        }
    }

    public void setProgress(float f) {
        LottieAnimationView lottieAnimationView = this.f493b;
        if (lottieAnimationView != null) {
            lottieAnimationView.setProgress(f);
        }
    }

    public void setRepeatCount(int i) {
        LottieAnimationView lottieAnimationView = this.f493b;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(i);
        }
    }
}
