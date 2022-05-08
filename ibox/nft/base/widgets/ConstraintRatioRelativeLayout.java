package com.ibox.nft.base.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.fastjson.util.AntiCollisionHashMap;
import com.ibox.nft.base.R;

/* loaded from: ConstraintRatioRelativeLayout.class */
public class ConstraintRatioRelativeLayout extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f432b;
    public float c;

    public ConstraintRatioRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConstraintRatioRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintRatioRelativeLayout));
    }

    public final void a(TypedArray typedArray) {
        if (typedArray != null) {
            this.f432b = typedArray.getInt(R.styleable.ConstraintRatioRelativeLayout_constraint_type, 0);
            this.c = typedArray.getFloat(R.styleable.ConstraintRatioRelativeLayout_constraint_ratio, 1.0f);
            typedArray.recycle();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (isInEditMode()) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.f432b == 0) {
            i3 = View.MeasureSpec.getSize(i);
            i4 = (int) (i3 * this.c);
        } else {
            i4 = View.MeasureSpec.getSize(i2);
            i3 = (int) (i4 * this.c);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, AntiCollisionHashMap.MAXIMUM_CAPACITY), View.MeasureSpec.makeMeasureSpec(i4, AntiCollisionHashMap.MAXIMUM_CAPACITY));
    }

    public void setRatio(float f) {
        this.c = f;
        postInvalidate();
    }
}
