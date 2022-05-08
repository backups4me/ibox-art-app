package com.ibox.nft.base.widgets.banner;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.ibox.nft.base.widgets.banner.RollPagerView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: LoopPagerAdapter.class */
public abstract class LoopPagerAdapter extends PagerAdapter {
    public RollPagerView a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<View> f450b = new ArrayList<>();
    public int c;

    /* loaded from: LoopPagerAdapter$LoopHintViewDelegate.class */
    public class LoopHintViewDelegate implements RollPagerView.HintViewDelegate {
        public final LoopPagerAdapter a;

        public LoopHintViewDelegate(LoopPagerAdapter loopPagerAdapter) {
            this.a = loopPagerAdapter;
        }

        @Override // com.ibox.nft.base.widgets.banner.RollPagerView.HintViewDelegate
        public void a(int i, HintView hintView) {
            if (hintView != null && this.a.b() > 0) {
                hintView.setCurrent(i % this.a.b());
            }
        }

        @Override // com.ibox.nft.base.widgets.banner.RollPagerView.HintViewDelegate
        public void b(int i, int i2, HintView hintView) {
            if (hintView != null) {
                hintView.a(this.a.b(), i2);
            }
        }
    }

    public LoopPagerAdapter(RollPagerView rollPagerView) {
        this.a = rollPagerView;
        rollPagerView.setHintViewDelegate(new LoopHintViewDelegate());
    }

    public final View a(ViewGroup viewGroup, int i) {
        Iterator<View> it = this.f450b.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (((Integer) next.getTag()).intValue() == i && next.getParent() == null) {
                return next;
            }
        }
        View c = c(viewGroup, i);
        c.setTag(Integer.valueOf(i));
        this.f450b.add(c);
        return c;
    }

    public abstract int b();

    public abstract View c(ViewGroup viewGroup, int i);

    public void d(int i) {
        this.c = i;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Deprecated
    public final int getCount() {
        return b() <= 0 ? b() : SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View a = a(viewGroup, i % b());
        viewGroup.addView(a);
        return a;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void notifyDataSetChanged() {
        this.f450b.clear();
        LoopPagerAdapter.super.notifyDataSetChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        LoopPagerAdapter.super.registerDataSetObserver(dataSetObserver);
    }
}
