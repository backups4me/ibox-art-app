package com.ibox.nft.base.utils;

import androidx.appcompat.app.AppCompatDelegate;
import com.ibox.nft.base.mvp.IBoxCoreActivity;
import com.igexin.push.core.c;
import org.greenrobot.eventbus.EventBus;

/* loaded from: IBoxNightHelper.class */
public class IBoxNightHelper {
    public static IBoxNightHelper a = new IBoxNightHelper();

    /* renamed from: b  reason: collision with root package name */
    public boolean f425b;
    public long c;

    /* loaded from: IBoxNightHelper$NightEvent.class */
    public static class NightEvent {
    }

    public IBoxNightHelper() {
        int i = 1;
        boolean z = ConfigPreferences.b("ibox_user_config", "ibox_night_theme", 1) == 0;
        this.f425b = z;
        AppCompatDelegate.setDefaultNightMode(z ? 2 : i);
    }

    public static IBoxNightHelper c() {
        return a;
    }

    public void a(boolean z) {
        this.c = System.currentTimeMillis();
        this.f425b = z;
        ConfigPreferences.c("ibox_user_config", "ibox_night_theme", z ? c.f613e : "1");
        AppCompatDelegate.setDefaultNightMode(z ? 2 : 1);
        EventBus.c().l(new NightEvent());
    }

    public void b(IBoxCoreActivity iBoxCoreActivity) {
        if (((iBoxCoreActivity.getResources().getConfiguration().uiMode & 48) == 32) != d()) {
            a(d());
        }
    }

    public boolean d() {
        return this.f425b;
    }
}
