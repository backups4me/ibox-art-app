package com.ibox.nft.base.widgets.recycle;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.ibox.nft.base.widgets.recycle.IBoxDataType;
import java.util.List;

/* loaded from: IBoxRecyclerView.class */
public class IBoxRecyclerView<T extends IBoxDataType> extends RecyclerView {

    /* renamed from: b  reason: collision with root package name */
    public String f502b = "";
    public IBoxRecycleAdapter<T> c;

    /* renamed from: d  reason: collision with root package name */
    public Callback f503d;

    /* loaded from: IBoxRecyclerView$Callback.class */
    public interface Callback {
        void onScrollChanged();
    }

    public IBoxRecyclerView(Context context) {
        super(context);
        d(context);
    }

    public IBoxRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    public void a(String str, List<T> list) {
        IBoxRecycleAdapter<T> iBoxRecycleAdapter = this.c;
        if (iBoxRecycleAdapter == null) {
            IBoxRecycleAdapter<T> iBoxRecycleAdapter2 = new IBoxRecycleAdapter<>(str, list);
            this.c = iBoxRecycleAdapter2;
            setAdapter(iBoxRecycleAdapter2);
            return;
        }
        iBoxRecycleAdapter.a(list);
        this.c.notifyDataSetChanged();
    }

    public void b(List<T> list) {
        a(this.f502b, list);
    }

    public int c(T t) {
        IBoxRecycleAdapter<T> iBoxRecycleAdapter = this.c;
        if (iBoxRecycleAdapter != null) {
            return iBoxRecycleAdapter.d(t);
        }
        return -1;
    }

    public final void d(Context context) {
    }

    public void e() {
        IBoxRecycleAdapter<T> iBoxRecycleAdapter = this.c;
        if (iBoxRecycleAdapter != null) {
            iBoxRecycleAdapter.notifyDataSetChanged();
            return;
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void f(T t) {
        IBoxRecycleAdapter<T> iBoxRecycleAdapter = this.c;
        if (iBoxRecycleAdapter != null) {
            List<T> b2 = iBoxRecycleAdapter.b();
            int c = c(t);
            if (c >= 0 && c < b2.size()) {
                b2.set(c, t);
                this.c.notifyItemChanged(c);
            }
        }
    }

    public void g() {
        IBoxRecycleAdapter<T> iBoxRecycleAdapter = this.c;
        if (iBoxRecycleAdapter != null) {
            iBoxRecycleAdapter.i();
        }
    }

    public int getItemCount() {
        IBoxRecycleAdapter<T> iBoxRecycleAdapter = this.c;
        if (iBoxRecycleAdapter != null) {
            return iBoxRecycleAdapter.getItemCount();
        }
        return 0;
    }

    public T getLastItem() {
        IBoxRecycleAdapter<T> iBoxRecycleAdapter = this.c;
        if (iBoxRecycleAdapter != null) {
            return iBoxRecycleAdapter.e();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h(String str, List<T> list) {
        if (getLayoutManager() == null) {
            setLayoutManager(new StableLinearLayoutManager(getContext()));
        }
        IBoxRecycleAdapter<T> iBoxRecycleAdapter = this.c;
        if (iBoxRecycleAdapter == null) {
            IBoxRecycleAdapter<T> iBoxRecycleAdapter2 = new IBoxRecycleAdapter<>(str, list);
            this.c = iBoxRecycleAdapter2;
            setAdapter(iBoxRecycleAdapter2);
            return;
        }
        iBoxRecycleAdapter.j(list);
        this.c.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IBoxRecyclerView.super.onScrollChanged(i, i2, i3, i4);
    }

    public void onScrollStateChanged(int i) {
        Callback callback;
        IBoxRecyclerView.super.onScrollStateChanged(i);
        if (i == 1 && (callback = this.f503d) != null) {
            callback.onScrollChanged();
        }
    }

    public void setCallback(Callback callback) {
        this.f503d = callback;
    }

    public void setData(List<T> list) {
        h(this.f502b, list);
    }

    public void setViewCacheName(String str) {
        this.f502b = str;
    }
}
