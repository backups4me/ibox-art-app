package com.ibox.nft.base.widgets.dialog.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.widget.PopupWindowCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.data.a;
import com.ibox.libs.common.utils.ContextTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.libs.common.utils.ScreemTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.dialog.menu.GridMenuTool;
import com.ibox.nft.base.widgets.recycle.IBoxDataType;
import com.ibox.nft.base.widgets.recycle.IBoxRecyclerView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.ref.SoftReference;
import java.util.List;

/* loaded from: GridMenuTool.class */
public final class GridMenuTool {
    public static volatile PopupWindow a;

    /* renamed from: b  reason: collision with root package name */
    public static SoftReference<GridMenuBuilder> f464b;
    public static SoftReference<IBoxRecyclerView> c;

    /* loaded from: GridMenuTool$GridMenuBuilder.class */
    public static class GridMenuBuilder {
        public static GridMenuTool a = new GridMenuTool();

        /* renamed from: b  reason: collision with root package name */
        public View f466b;
        public View c;

        /* renamed from: d  reason: collision with root package name */
        public int f467d;

        /* renamed from: e  reason: collision with root package name */
        public List<IBoxDataType> f468e;
        public OnRefreshLoadMoreListener n;
        public PopupWindow.OnDismissListener o;
        public int f = 1;
        public int g = 0;
        public int h = 0;
        public int i = 1;
        public boolean j = false;
        public boolean k = false;
        public boolean l = true;
        public boolean m = false;
        public int p = 0;
        public int q = 0;

        public static GridMenuTool a() {
            return a;
        }

        public GridMenuBuilder A(int i) {
            this.f467d = i;
            return this;
        }

        public GridMenuBuilder B(int i) {
            this.q = i;
            return this;
        }

        public GridMenuBuilder C(View view) {
            this.f466b = view;
            return this;
        }

        public GridMenuBuilder D(int i) {
            this.f = i;
            return this;
        }

        public View b() {
            return this.c;
        }

        public int c() {
            return this.i;
        }

        public List<IBoxDataType> d() {
            return this.f468e;
        }

        public int e() {
            return this.g;
        }

        public int f() {
            return this.h;
        }

        public PopupWindow.OnDismissListener g() {
            return this.o;
        }

        public OnRefreshLoadMoreListener h() {
            return this.n;
        }

        public int i() {
            return this.f467d;
        }

        public int j() {
            return this.q;
        }

        public View k() {
            return this.f466b;
        }

        public int l() {
            return this.f;
        }

        public boolean m() {
            return this.m;
        }

        public boolean n() {
            return this.k;
        }

        public boolean o() {
            return this.j;
        }

        public boolean p() {
            return this.l;
        }

        public GridMenuBuilder q(View view) {
            this.c = view;
            return this;
        }

        public GridMenuBuilder r(boolean z) {
            this.k = z;
            return this;
        }

        public GridMenuBuilder s(boolean z) {
            this.j = z;
            return this;
        }

        public GridMenuBuilder t(int i) {
            this.i = i;
            return this;
        }

        public String toString() {
            return "GridMenuBuilder{rootView=" + this.f466b + ", anchorView=" + this.c + ", popWindowHeight=" + this.f467d + ", menuList=" + this.f468e + ", spanCount=" + this.f + ", offsetX=" + this.g + ", offsetY=" + this.h + ", gravity=" + this.i + ", enableRefresh=" + this.j + ", enableLoadMore=" + this.k + ", outsideTouchable=" + this.l + ", clippingEnabled=" + this.m + ", onRefreshLoadMoreListener=" + this.n + ", onDismissListener=" + this.o + ", rootTopPadding=" + this.p + ", rootBottomPadding=" + this.q + '}';
        }

        public GridMenuBuilder u(List<IBoxDataType> list) {
            this.f468e = list;
            return this;
        }

        public GridMenuBuilder v(int i) {
            this.g = i;
            return this;
        }

        public GridMenuBuilder w(int i) {
            this.h = i;
            return this;
        }

        public GridMenuBuilder x(PopupWindow.OnDismissListener onDismissListener) {
            this.o = onDismissListener;
            return this;
        }

        public GridMenuBuilder y(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
            this.n = onRefreshLoadMoreListener;
            return this;
        }

        public GridMenuBuilder z(boolean z) {
            this.l = z;
            return this;
        }
    }

    public GridMenuTool() {
    }

    public static void a(List<IBoxDataType> list, boolean z) {
        IBoxRecyclerView d2 = d();
        if (a != null && a.isShowing() && d2 != null) {
            if (z) {
                d2.b(list);
            } else {
                d2.setData(list);
            }
        }
    }

    public static IBoxRecyclerView d() {
        SoftReference<IBoxRecyclerView> softReference = c;
        return softReference == null ? null : softReference.get();
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e(View view) {
        a.dismiss();
        SoftReference<IBoxRecyclerView> softReference = c;
        if (softReference != null) {
            softReference.clear();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void f(GridMenuBuilder gridMenuBuilder) {
        SoftReference<IBoxRecyclerView> softReference = c;
        if (softReference != null) {
            softReference.clear();
        }
        if (gridMenuBuilder != null && gridMenuBuilder.g() != null) {
            gridMenuBuilder.g().onDismiss();
        }
    }

    public static void g() {
        if (a != null && a.isShowing()) {
            a.dismiss();
        }
        SoftReference<IBoxRecyclerView> softReference = c;
        if (softReference != null) {
            softReference.clear();
        }
    }

    public static GridMenuTool h(GridMenuBuilder gridMenuBuilder) {
        f464b = new SoftReference<>(gridMenuBuilder);
        return GridMenuBuilder.a();
    }

    public final PopupWindow b(Context context, View view, int i) {
        if (!ContextTool.c(context) || view == null) {
            return null;
        }
        PopupWindow popupWindow = new PopupWindow(view, -1, i, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.color_66141519)));
        View contentView = popupWindow.getContentView();
        if (contentView != null) {
            contentView.measure(0, 0);
        }
        return popupWindow;
    }

    public final GridMenuBuilder c() {
        SoftReference<GridMenuBuilder> softReference = f464b;
        return softReference == null ? null : softReference.get();
    }

    public void i(Context context) {
        j(context, true);
    }

    public void j(Context context, boolean z) {
        if (ContextTool.c(context)) {
            if (z) {
                g();
            }
            final GridMenuBuilder c2 = c();
            if (c2 == null) {
                LogTool.c("##### [GridMenuDialog] GridMenuBuilder is null!");
                return;
            }
            List<IBoxDataType> d2 = c2.d();
            IBoxRecyclerView d3 = d();
            if (z || a == null || !a.isShowing() || d3 == null) {
                View b2 = c2.b();
                if (b2 != null) {
                    int e2 = c2.e();
                    int f = c2.f();
                    int c3 = c2.c();
                    int i = -2;
                    View k = c2.k();
                    if (c2.i() > 0) {
                        i = c2.i();
                    } else if (k != null) {
                        i = k.getHeight();
                    }
                    LogTool.a("###### GridMenuTool_popWindHeight: " + i + ", screenHeight: " + ScreemTool.a(context));
                    View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_grid_simple_menu, (ViewGroup) null);
                    inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, i));
                    FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.fl_menu_root_container);
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.srl_refresh_layout);
                    smartRefreshLayout.setEnableRefresh(c2.o());
                    smartRefreshLayout.setEnableLoadMore(c2.n());
                    smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener(this, c2.h()) { // from class: com.ibox.nft.base.widgets.dialog.menu.GridMenuTool.1

                        /* renamed from: b  reason: collision with root package name */
                        public final OnRefreshLoadMoreListener f465b;
                        public final GridMenuTool c;

                        {
                            this.c = this;
                            this.f465b = r5;
                        }

                        @Override // com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
                        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                            refreshLayout.finishLoadMore(a.w);
                            OnRefreshLoadMoreListener onRefreshLoadMoreListener = this.f465b;
                            if (onRefreshLoadMoreListener != null) {
                                onRefreshLoadMoreListener.onLoadMore(refreshLayout);
                            }
                        }

                        @Override // com.scwang.smart.refresh.layout.listener.OnRefreshListener
                        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                            refreshLayout.finishRefresh(a.w);
                            OnRefreshLoadMoreListener onRefreshLoadMoreListener = this.f465b;
                            if (onRefreshLoadMoreListener != null) {
                                onRefreshLoadMoreListener.onRefresh(refreshLayout);
                            }
                        }
                    });
                    RecyclerView recyclerView = (IBoxRecyclerView) inflate.findViewById(R.id.rlv_menu_grid_list);
                    recyclerView.setLayoutManager(new GridLayoutManager(context, c2.l()));
                    recyclerView.setVerticalScrollBarEnabled(true);
                    recyclerView.setData(d2);
                    c = new SoftReference<>(recyclerView);
                    frameLayout.setPadding(0, 0, 0, c2.j());
                    a = b(context, b2, i);
                    if (a != null) {
                        a.setOutsideTouchable(c2.p());
                        a.setClippingEnabled(c2.m());
                        inflate.setOnClickListener(d.c.d.d.i.d.c.a.f1179b);
                        a.setContentView(inflate);
                        a.setOnDismissListener(new PopupWindow.OnDismissListener(c2) { // from class: d.c.d.d.i.d.c.b

                            /* renamed from: b  reason: collision with root package name */
                            public final GridMenuTool.GridMenuBuilder f1180b;

                            {
                                this.f1180b = c2;
                            }

                            @Override // android.widget.PopupWindow.OnDismissListener
                            public final void onDismiss() {
                                GridMenuTool.f(this.f1180b);
                            }
                        });
                        try {
                            PopupWindowCompat.showAsDropDown(a, b2, e2, f, c3);
                        } catch (Exception e3) {
                            LogTool.e(e3);
                            e3.printStackTrace();
                        }
                    }
                }
            } else {
                d3.setData(d2);
            }
        }
    }
}
