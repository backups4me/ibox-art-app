package com.ibox.nft.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.ibox.libs.common.utils.LogTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.List;

/* loaded from: IBoxCoreFragment.class */
public abstract class IBoxCoreFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public View f420b;

    public IBoxCoreFragment() {
        setArguments(new Bundle());
    }

    public abstract View o1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void onActivityCreated(Bundle bundle) {
        IBoxCoreFragment.super.onActivityCreated(bundle);
        LogTool.a(getClass().getSimpleName() + "------onActivityCreated_enter------");
    }

    public void onAttach(Context context) {
        IBoxCoreFragment.super.onAttach(context);
        LogTool.a(getClass().getSimpleName() + "------onAttach_enter------");
    }

    public void onCreate(Bundle bundle) {
        IBoxCoreFragment.super.onCreate(bundle);
        LogTool.a(getClass().getSimpleName() + "------onCreate_enter------");
        setRetainInstance(true);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogTool.a(getClass().getSimpleName() + "------onCreateView_enter------");
        if (this.f420b == null) {
            r1(o1(layoutInflater, viewGroup, bundle));
            p1();
        }
        if (this.f420b.getParent() != null) {
            ((ViewGroup) this.f420b.getParent()).removeView(this.f420b);
        }
        return this.f420b;
    }

    public void onDestroy() {
        IBoxCoreFragment.super.onDestroy();
        LogTool.a(getClass().getSimpleName() + "------onDestroy_enter------");
    }

    public void onDestroyView() {
        IBoxCoreFragment.super.onDestroyView();
        LogTool.a(getClass().getSimpleName() + "------onDestroyView_enter------");
    }

    public void onDetach() {
        IBoxCoreFragment.super.onDetach();
        LogTool.a(getClass().getSimpleName() + "------onDetach_enter------");
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        IBoxCoreFragment.super.onHiddenChanged(z);
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.isAdded()) {
                    fragment.onHiddenChanged(z || fragment.isHidden());
                }
            }
        }
        LogTool.a(getClass().getSimpleName() + "------onHiddenChanged_enter------ hidden:" + z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @SensorsDataInstrumented
    public void onPause() {
        IBoxCoreFragment.super.onPause();
        LogTool.a(getClass().getSimpleName() + "------onPause_enter------");
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        IBoxCoreFragment.super.onResume();
        LogTool.a(getClass().getSimpleName() + "------onResume_enter------");
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        IBoxCoreFragment.super.onStart();
        LogTool.a(getClass().getSimpleName() + "------onStart_enter------");
    }

    public void onStop() {
        IBoxCoreFragment.super.onStop();
        LogTool.a(getClass().getSimpleName() + "------onStop_enter------");
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        IBoxCoreFragment.super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public abstract void p1();

    public View q1() {
        return this.f420b;
    }

    public void r1(View view) {
        this.f420b = view;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        IBoxCoreFragment.super.setUserVisibleHint(z);
        LogTool.a(getClass().getSimpleName() + "------setUserVisibleHint_enter------ userVisible:" + z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
