package com.ibox.nft.base.widgets.expandable;

import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* loaded from: FixLinkMovementTouchListener.class */
public final class FixLinkMovementTouchListener implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public long f486b = 0;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TextView textView = (TextView) view;
        Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
        int action = motionEvent.getAction();
        if (action != 1 && action != 0) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = textView.getTotalPaddingLeft();
        int totalPaddingTop = textView.getTotalPaddingTop();
        int scrollX = textView.getScrollX();
        int scrollY = textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - totalPaddingTop) + scrollY), (x - totalPaddingLeft) + scrollX);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpanArr.length == 0) {
            return false;
        }
        if (action == 1) {
            if (System.currentTimeMillis() - this.f486b >= 500) {
                return false;
            }
            clickableSpanArr[0].onClick(textView);
            return true;
        } else if (action != 0) {
            return false;
        } else {
            this.f486b = System.currentTimeMillis();
            return false;
        }
    }
}
