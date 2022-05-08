package com.ibox.nft.base.widgets.notice;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: NoticeWeakHandler.class */
public class NoticeWeakHandler extends Handler {
    public WeakReference<NoticeHandleCallback> a;

    public NoticeWeakHandler(NoticeHandleCallback noticeHandleCallback) {
        this.a = new WeakReference<>(noticeHandleCallback);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        NoticeHandleCallback noticeHandleCallback;
        WeakReference<NoticeHandleCallback> weakReference = this.a;
        if (weakReference != null && (noticeHandleCallback = weakReference.get()) != null) {
            noticeHandleCallback.handleMessage(message);
        }
    }
}
