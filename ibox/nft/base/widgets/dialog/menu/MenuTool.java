package com.ibox.nft.base.widgets.dialog.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import com.ibox.libs.common.utils.ToastTool;
import com.ibox.nft.base.R;
import com.ibox.nft.base.widgets.dialog.menu.MenuTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

/* loaded from: MenuTool.class */
public final class MenuTool {
    public static volatile MenuPopupWindow a;
    @SuppressLint({"RestrictedApi"})

    /* renamed from: b  reason: collision with root package name */
    public static MenuItemHoverListener f469b = new MenuItemHoverListener() { // from class: com.ibox.nft.base.widgets.dialog.menu.MenuTool.1
        public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ToastTool.f("### MenuTool ------- onItemHoverEnter");
        }

        public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ToastTool.f("### MenuTool ------- onItemHoverExit");
        }
    };

    /* loaded from: MenuTool$OnMenuItemClickLinstener.class */
    public interface OnMenuItemClickLinstener {
        void a(AdapterView<?> adapterView, View view, int i, long j, MenuItemImpl menuItemImpl);
    }

    @SuppressLint({"RestrictedApi"})
    public static MenuPopupWindow a(Context context, View view, int i, MenuItemHoverListener menuItemHoverListener, AdapterView.OnItemClickListener onItemClickListener, PopupWindow.OnDismissListener onDismissListener) {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(context, (AttributeSet) null, 16843520, 0);
        menuPopupWindow.setHoverListener(menuItemHoverListener);
        menuPopupWindow.setOnItemClickListener(onItemClickListener);
        menuPopupWindow.setOnDismissListener(onDismissListener);
        menuPopupWindow.setAnchorView(view);
        menuPopupWindow.setDropDownGravity(i);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    public static void b() {
        if (a != null && a.isShowing()) {
            a.dismiss();
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void c(OnMenuItemClickLinstener onMenuItemClickLinstener, MenuBuilder menuBuilder, AdapterView adapterView, View view, int i, long j) {
        if (onMenuItemClickLinstener != null) {
            onMenuItemClickLinstener.a(adapterView, view, i, j, (MenuItemImpl) menuBuilder.getVisibleItems().get(i));
        }
        SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
    }

    public static /* synthetic */ void d(PopupWindow.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @SuppressLint({"RestrictedApi"})
    public static void e(@NonNull Context context, @NonNull View view, int i, boolean z, boolean z2, @NonNull final MenuBuilder menuBuilder, final OnMenuItemClickLinstener onMenuItemClickLinstener, final PopupWindow.OnDismissListener onDismissListener) {
        if (a != null && a.isShowing()) {
            a.dismiss();
        }
        int i2 = R.layout.item_menu_popup_window_list;
        if (z2) {
            i2 = R.layout.item_menu_popup_window_simple;
        }
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, LayoutInflater.from(context), true, i2);
        menuAdapter.setForceShowIcon(z);
        a = a(context, view, 0, f469b, new AdapterView.OnItemClickListener(onMenuItemClickLinstener, menuBuilder) { // from class: d.c.d.d.i.d.c.d

            /* renamed from: b  reason: collision with root package name */
            public final MenuTool.OnMenuItemClickLinstener f1182b;
            public final MenuBuilder c;

            {
                this.f1182b = onMenuItemClickLinstener;
                this.c = menuBuilder;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i3, long j) {
                MenuTool.c(this.f1182b, this.c, adapterView, view2, i3, j);
            }
        }, new PopupWindow.OnDismissListener(onDismissListener) { // from class: d.c.d.d.i.d.c.c

            /* renamed from: b  reason: collision with root package name */
            public final PopupWindow.OnDismissListener f1181b;

            {
                this.f1181b = onDismissListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                MenuTool.d(this.f1181b);
            }
        });
        a.setAdapter(menuAdapter);
        a.setContentWidth(i);
        a.setTouchModal(false);
        a.setEnterTransition((Object) null);
        a.show();
    }

    @SuppressLint({"RestrictedApi"})
    public static void f(@NonNull Context context, @NonNull View view, int i, @NonNull MenuBuilder menuBuilder, OnMenuItemClickLinstener onMenuItemClickLinstener) {
        g(context, view, i, menuBuilder, onMenuItemClickLinstener, null);
    }

    @SuppressLint({"RestrictedApi"})
    public static void g(@NonNull Context context, @NonNull View view, int i, @NonNull MenuBuilder menuBuilder, OnMenuItemClickLinstener onMenuItemClickLinstener, PopupWindow.OnDismissListener onDismissListener) {
        e(context, view, i, false, true, menuBuilder, onMenuItemClickLinstener, onDismissListener);
    }
}
