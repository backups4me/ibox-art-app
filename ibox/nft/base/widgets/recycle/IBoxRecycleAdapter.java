package com.ibox.nft.base.widgets.recycle;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ibox.nft.base.widgets.recycle.IBoxDataType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: IBoxRecycleAdapter.class */
public class IBoxRecycleAdapter<T extends IBoxDataType> extends RecyclerView.Adapter<IBoxViewHolder> {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<T> f501b;
    public Map<Integer, Integer> c = new HashMap();

    public IBoxRecycleAdapter(String str, List<T> list) {
        this.a = str;
        j(list);
    }

    public IBoxRecycleAdapter(List<T> list) {
        j(list);
    }

    public void a(List<T> list) {
        if (this.f501b == null) {
            this.f501b = new ArrayList();
        }
        this.f501b.addAll(list);
    }

    public List<T> b() {
        return this.f501b;
    }

    public T c(int i) {
        return this.f501b.get(i);
    }

    public int d(T t) {
        int i;
        List<T> list = this.f501b;
        if (list != null && list.contains(t)) {
            try {
                i = this.f501b.indexOf(t);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i;
        }
        i = -1;
        return i;
    }

    public T e() {
        List<T> list = this.f501b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<T> list2 = this.f501b;
        return list2.get(list2.size() - 1);
    }

    /* renamed from: f */
    public void onBindViewHolder(IBoxViewHolder iBoxViewHolder, int i) {
        IBoxViewHandler a;
        T c = c(i);
        if (c != null) {
            String viewHandlerName = c.getViewHandlerName();
            if (!TextUtils.isEmpty(viewHandlerName) && (a = IBoxViewHandlerFactory.a(viewHandlerName)) != null) {
                a.a(iBoxViewHolder, i, c(i), (ViewGroup) ((RecyclerView.ViewHolder) iBoxViewHolder).itemView.getParent());
            }
        }
    }

    /* renamed from: g */
    public void onBindViewHolder(@NonNull IBoxViewHolder iBoxViewHolder, int i, @NonNull List<Object> list) {
        IBoxViewHandler a;
        IBoxRecycleAdapter.super.onBindViewHolder(iBoxViewHolder, i, list);
        if (list == null || list.isEmpty()) {
            onBindViewHolder(iBoxViewHolder, i);
            return;
        }
        T c = c(i);
        if (c != null) {
            String viewHandlerName = c.getViewHandlerName();
            if (TextUtils.isEmpty(viewHandlerName) || (a = IBoxViewHandlerFactory.a(viewHandlerName)) == null) {
                return;
            }
            if (a instanceof IBoxSupportPartialRefreshViewHandler) {
                ((IBoxSupportPartialRefreshViewHandler) a).c(iBoxViewHolder, i, c(i), (ViewGroup) ((RecyclerView.ViewHolder) iBoxViewHolder).itemView.getParent(), list);
            } else {
                a.a(iBoxViewHolder, i, c(i), (ViewGroup) ((RecyclerView.ViewHolder) iBoxViewHolder).itemView.getParent());
            }
        }
    }

    public int getItemCount() {
        List<T> list = this.f501b;
        return list == null ? 0 : list.size();
    }

    public int getItemViewType(int i) {
        T c = c(i);
        if (c == null) {
            return 0;
        }
        IBoxViewHandler a = IBoxViewHandlerFactory.a(c.getViewHandlerName());
        this.c.put(Integer.valueOf(a.getClass().hashCode()), Integer.valueOf(a.b()));
        return a.getClass().hashCode();
    }

    /* renamed from: h */
    public IBoxViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return IBoxViewHolder.a(viewGroup, this.c.get(Integer.valueOf(i)).intValue());
    }

    public void i() {
    }

    public void j(List<T> list) {
        this.f501b = list;
    }
}
