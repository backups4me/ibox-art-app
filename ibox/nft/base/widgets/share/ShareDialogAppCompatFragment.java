package com.ibox.nft.base.widgets.share;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.ibox.libs.common.utils.ClipManager;
import com.ibox.libs.common.utils.IBoxViewFinder;
import com.ibox.libs.common.utils.PixelTool;
import com.ibox.libs.widgets.dialog.BaseDialogAppCompatFragment;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.animation.CubicBezierInterpolator;
import com.ibox.nft.base.widgets.recycle.IBoxRecyclerView;
import com.ibox.nft.base.widgets.share.ShareDialogAppCompatFragment;
import com.ibox.nft.base.widgets.share.ShareMenuListItem;
import com.ibox.platform.sdk.manager.MobSdkOpenManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Route(path = "/ibox_app_base/fragment/shareDialogActivity")
@SuppressLint({"ValidFragment"})
/* loaded from: ShareDialogAppCompatFragment.class */
public class ShareDialogAppCompatFragment extends BaseDialogAppCompatFragment {
    public boolean l;
    public float m;
    public View n;
    public FrameLayout o;
    public IBoxRecyclerView p;
    public ImageView q;
    public ShareType r;
    public ShareInfoBean s;
    public List<ShareMenuListItem> t;
    public ShareMenuListItem.OnMenuItemCallback u;

    /* loaded from: ShareDialogAppCompatFragment$ShareInfoBean.class */
    public static class ShareInfoBean implements Serializable {
        private String content;
        private String imagePath;
        private String imageUrl;
        private Bitmap imgBitmap;
        private String title;
        private String url;

        public String getContent() {
            return this.content;
        }

        public String getImagePath() {
            return this.imagePath;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public Bitmap getImgBitmap() {
            return this.imgBitmap;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        public ShareInfoBean setContent(String str) {
            this.content = str;
            return this;
        }

        public ShareInfoBean setImagePath(String str) {
            this.imagePath = str;
            return this;
        }

        public ShareInfoBean setImageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        public ShareInfoBean setImgBitmap(Bitmap bitmap) {
            this.imgBitmap = bitmap;
            return this;
        }

        public ShareInfoBean setTitle(String str) {
            this.title = str;
            return this;
        }

        public ShareInfoBean setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public ShareDialogAppCompatFragment() {
        this.l = false;
        this.m = PixelTool.a(165.0f);
        this.r = ShareType.URL;
    }

    public ShareDialogAppCompatFragment(ShareType shareType) {
        this.l = false;
        this.m = PixelTool.a(165.0f);
        this.r = ShareType.URL;
        this.r = shareType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: b2 */
    public /* synthetic */ void c2(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int C1() {
        return R.layout.fragment_share_dialog;
    }

    public int F1() {
        return 80;
    }

    public void I1(IBoxViewFinder iBoxViewFinder) {
        this.n = iBoxViewFinder.a(R.id.cl_share_root_container);
        this.o = (FrameLayout) iBoxViewFinder.a(R.id.fl_share_content_contaienr);
        this.p = (IBoxRecyclerView) iBoxViewFinder.a(R.id.rlv_share_menu_list);
        this.q = (ImageView) iBoxViewFinder.a(R.id.tv_cancel_btn);
    }

    public boolean M1() {
        return this.l;
    }

    public boolean V1() {
        return false;
    }

    public void X1(String str) {
        ClipManager.a(str);
    }

    public void Y1() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, View.TRANSLATION_Y, 0.0f, this.m);
        ofFloat.setInterpolator(new CubicBezierInterpolator(0.0d, 0.0d, 0.58d, 1.0d));
        ofFloat.addListener(new AnimatorListenerAdapter(this) { // from class: com.ibox.nft.base.widgets.share.ShareDialogAppCompatFragment.1

            /* renamed from: b  reason: collision with root package name */
            public final ShareDialogAppCompatFragment f505b;

            {
                this.f505b = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ShareDialogAppCompatFragment.super.y1();
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.o, View.ALPHA, 1.0f, 0.0f);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(260L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    public void Z1() {
        this.o.setAlpha(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, View.TRANSLATION_Y, this.m, 0.0f);
        ofFloat.setDuration(270L);
        ofFloat.setInterpolator(new CubicBezierInterpolator(0.0d, 0.0d, 0.58d, 1.0d));
        ofFloat.start();
    }

    public final void a2() {
        Bundle arguments = getArguments();
        if (arguments != null && !arguments.isEmpty() && arguments.containsKey("SHARE_TYPE")) {
            this.r = ShareType.getType(arguments.getInt("SHARE_TYPE", ShareType.URL.type));
        }
    }

    public ShareDialogAppCompatFragment d2(List<ShareMenuListItem> list) {
        this.t = list;
        this.p.setLayoutManager(new GridLayoutManager(getContext(), list.size()));
        this.p.setData(list);
        return this;
    }

    public ShareDialogAppCompatFragment e2(ShareInfoBean shareInfoBean) {
        this.s = shareInfoBean;
        return this;
    }

    public void f2(ShareInfoBean shareInfoBean, PlatformActionListener platformActionListener) {
        if (shareInfoBean != null) {
            MobSdkOpenManager.a().g(getActivity(), shareInfoBean.getTitle(), shareInfoBean.getContent(), shareInfoBean.getImagePath(), shareInfoBean.getImageUrl(), shareInfoBean.getImgBitmap(), shareInfoBean.getUrl(), platformActionListener);
        }
    }

    public void g2(ShareInfoBean shareInfoBean, PlatformActionListener platformActionListener) {
        if (shareInfoBean != null) {
            MobSdkOpenManager.a().f(getActivity(), shareInfoBean.getTitle(), shareInfoBean.getContent(), shareInfoBean.getImagePath(), shareInfoBean.getImageUrl(), shareInfoBean.getImgBitmap(), shareInfoBean.getUrl(), platformActionListener);
        }
    }

    public void o1(IBoxViewFinder iBoxViewFinder) {
        this.q.setOnClickListener(new View.OnClickListener(this) { // from class: d.c.d.d.i.i.a

            /* renamed from: b  reason: collision with root package name */
            public final ShareDialogAppCompatFragment f1194b;

            {
                this.f1194b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1194b.c2(view);
            }
        });
        Z1();
    }

    public void p1() {
        a2();
        List<ShareMenuListItem> list = this.t;
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.t = arrayList;
            arrayList.add(new ShareMenuListItem(Wechat.NAME, "微信", R.drawable.ic_share_wechat, this.u));
            this.t.add(new ShareMenuListItem(WechatMoments.NAME, "朋友圈", R.drawable.ic_share_friend_circle, this.u));
            ShareType shareType = ShareType.IMAGE;
            ShareType shareType2 = this.r;
            if (shareType == shareType2) {
                this.t.add(new ShareMenuListItem("SAVE", "保存图片", R.drawable.ic_share_save_img, this.u));
            } else if (ShareType.TEXT == shareType2) {
                this.t.add(new ShareMenuListItem("COPY", "复制", R.drawable.ic_share_copy_link, this.u));
            } else {
                this.t.add(new ShareMenuListItem("COPY", "复制链接", R.drawable.ic_share_copy_link, this.u));
            }
        }
        d2(this.t);
    }

    public void s1(View view) {
        if (L1()) {
            Y1();
        } else {
            y1();
        }
    }

    public int show(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        return ShareDialogAppCompatFragment.super.show(fragmentTransaction, str);
    }

    public void show(FragmentManager fragmentManager, String str) {
        ShareDialogAppCompatFragment.super.show(fragmentManager, str);
    }

    public void y1() {
        if (getFragmentManager() != null) {
            ShareDialogAppCompatFragment.super.y1();
        }
    }
}
