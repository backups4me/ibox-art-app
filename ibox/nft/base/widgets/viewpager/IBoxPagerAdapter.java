package com.ibox.nft.base.widgets.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.ibox.libs.common.utils.StringTool;
import java.util.ArrayList;
import java.util.List;

/* loaded from: IBoxPagerAdapter.class */
public class IBoxPagerAdapter<K, T extends Fragment> extends FragmentStateAdapter {
    public List<K> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<T> f508b = new ArrayList();

    public IBoxPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public IBoxPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public T a(int i) {
        int size = this.f508b.size();
        if (i < 0 || i >= size) {
            return null;
        }
        return this.f508b.get(i);
    }

    public K b(int i) {
        int size = this.a.size();
        if (i < 0 || i >= size) {
            return null;
        }
        return this.a.get(i);
    }

    public void c(List<K> list, List<T> list2) {
        this.f508b.clear();
        if (list2 != null && !list2.isEmpty()) {
            this.f508b.addAll(list2);
        }
        this.a.clear();
        if (list != null && !list.isEmpty()) {
            this.a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public T createFragment(int i) {
        int size = this.f508b.size();
        if (this.f508b.isEmpty() || i < 0 || i >= size) {
            return null;
        }
        return this.f508b.get(i);
    }

    public int getItemCount() {
        return this.f508b.size();
    }

    public long getItemId(int i) {
        return StringTool.i(String.valueOf(createFragment(i).hashCode()), 0L);
    }
}
