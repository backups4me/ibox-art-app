package com.ibox.nft.base.widgets.banner;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ibox.nft.base.widgets.recycle.IBoxDataType;
import com.ibox.nft.base.widgets.recycle.IBoxViewHandler;
import com.ibox.nft.base.widgets.recycle.IBoxViewHandlerFactory;
import com.ibox.nft.base.widgets.recycle.IBoxViewHolder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: IBoxBannerAdapter.class */
public class IBoxBannerAdapter<T extends IBoxDataType> extends LoopPagerAdapter {

    /* renamed from: d  reason: collision with root package name */
    public List<T> f448d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, Integer> f449e = new HashMap();

    public IBoxBannerAdapter(RollPagerView rollPagerView) {
        super(rollPagerView);
    }

    @Override // com.ibox.nft.base.widgets.banner.LoopPagerAdapter
    public int b() {
        List<T> list = this.f448d;
        return list == null ? 0 : list.size();
    }

    @Override // com.ibox.nft.base.widgets.banner.LoopPagerAdapter
    public View c(ViewGroup viewGroup, int i) {
        IBoxViewHandler a;
        T f = f(i);
        if (f == null) {
            return null;
        }
        String viewHandlerName = f.getViewHandlerName();
        if (TextUtils.isEmpty(viewHandlerName) || (a = IBoxViewHandlerFactory.a(viewHandlerName)) == null) {
            return null;
        }
        this.f449e.put(Integer.valueOf(a.getClass().hashCode()), Integer.valueOf(a.b()));
        IBoxViewHolder a2 = IBoxViewHolder.a(viewGroup, a.b());
        if (a2 == null) {
            return null;
        }
        a.a(a2, i, f, viewGroup);
        return ((RecyclerView.ViewHolder) a2).itemView;
    }

    public List<T> e() {
        return this.f448d;
    }

    public T f(int i) {
        return this.f448d.get(i);
    }

    public void g(List<T> list) {
        this.f448d = list;
    }
}
