package com.ibox.nft.base.widgets.dialog.loading;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.loading.LoadingView;

/* loaded from: LoadingDialog.class */
public class LoadingDialog extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    public Context f461b;
    public LoadingView c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f462d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f463e;

    public LoadingDialog(@NonNull Context context) {
        this(context, R.style.BaseDialogFragmentStyle);
    }

    public LoadingDialog(@NonNull Context context, int i) {
        super(context, i);
        this.f461b = context;
    }

    public final void a() {
        ImageView imageView;
        if (this.f463e != null && (imageView = this.f462d) != null) {
            imageView.clearAnimation();
        }
    }

    public final void b() {
        LoadingView loadingView = this.c;
        if (loadingView != null) {
            loadingView.c();
        }
        a();
    }

    public final void c(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_progress_bar);
        this.f462d = imageView;
        imageView.setColorFilter(-1);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.loading_anim);
        this.f463e = loadAnimation;
        loadAnimation.setInterpolator(new LinearInterpolator());
    }

    public final void d() {
        ImageView imageView;
        Animation animation = this.f463e;
        if (animation != null && (imageView = this.f462d) != null) {
            imageView.startAnimation(animation);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f461b != null) {
            b();
            super.dismiss();
        }
    }

    public final void e() {
        LoadingView loadingView = this.c;
        if (loadingView != null) {
            loadingView.b();
        }
        d();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ContextTool.c(getContext())) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_fragment_loading, (ViewGroup) null);
            setContentView(inflate);
            c(inflate);
            setCanceledOnTouchOutside(false);
            setCancelable(false);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        e();
    }
}
