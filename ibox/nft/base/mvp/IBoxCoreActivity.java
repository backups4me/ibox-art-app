package com.ibox.nft.base.mvp;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.ibox.libs.common.utils.LogTool;
import java.util.List;

/* loaded from: IBoxCoreActivity.class */
public class IBoxCoreActivity extends AppCompatActivity {

    /* renamed from: b  reason: collision with root package name */
    public boolean f419b = true;

    /* JADX WARN: Multi-variable type inference failed */
    public Fragment V0(String str, Bundle bundle, String str2) {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(str2);
        if (findFragmentByTag != null) {
            if (!(findFragmentByTag.getArguments() == null || bundle == null)) {
                findFragmentByTag.getArguments().putAll(bundle);
            }
            return findFragmentByTag;
        }
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.getClass().getName().equals(str) && str2.equals(fragment.getTag())) {
                    if (!(fragment.getArguments() == null || bundle == null)) {
                        fragment.getArguments().putAll(bundle);
                    }
                    return fragment;
                }
            }
        }
        return Fragment.instantiate(this, str, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void applyOverrideConfiguration(Configuration configuration) {
        if (configuration != null) {
            int i = configuration.uiMode;
            configuration.setTo(getBaseContext().getResources().getConfiguration());
            configuration.uiMode = i;
        }
        IBoxCoreActivity.super.applyOverrideConfiguration(configuration);
    }

    public void onConfigurationChanged(Configuration configuration) {
        IBoxCoreActivity.super.onConfigurationChanged(configuration);
        LogTool.a(getClass().getSimpleName() + "------onConfigurationChanged_enter------");
    }

    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        IBoxCoreActivity.super.onCreate(bundle);
        LogTool.a(getClass().getSimpleName() + "------onCreate_enter------");
    }

    public void onDestroy() {
        IBoxCoreActivity.super.onDestroy();
        LogTool.a(getClass().getSimpleName() + "------onDestroy_enter------");
        this.f419b = false;
    }

    public void onLowMemory() {
        IBoxCoreActivity.super.onLowMemory();
    }

    public void onPause() {
        IBoxCoreActivity.super.onPause();
        LogTool.a(getClass().getSimpleName() + "------onPause_enter------");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestart() {
        IBoxCoreActivity.super.onRestart();
        LogTool.a(getClass().getSimpleName() + "------onRestart_enter------");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestoreInstanceState(Bundle bundle) {
        IBoxCoreActivity.super.onRestoreInstanceState(bundle);
        LogTool.a(getClass().getSimpleName() + "------onRestoreInstanceState_enter------");
    }

    public void onResume() {
        IBoxCoreActivity.super.onResume();
        LogTool.a(getClass().getSimpleName() + "------onResume_enter------");
    }

    public void onSaveInstanceState(Bundle bundle) {
        IBoxCoreActivity.super.onSaveInstanceState(bundle);
        LogTool.a(getClass().getSimpleName() + "------onSaveInstanceState_enter------");
    }

    public void onStart() {
        IBoxCoreActivity.super.onStart();
        LogTool.a(getClass().getSimpleName() + "------onStart_enter------");
    }

    public void onStop() {
        IBoxCoreActivity.super.onStop();
        LogTool.a(getClass().getSimpleName() + "------onStop_enter------");
    }
}
