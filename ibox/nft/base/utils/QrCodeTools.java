package com.ibox.nft.base.utils;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ibox.libs.common.manager.ThreadManager;
import com.ibox.nft.base.utils.QrCodeTools;
import com.ibox.nft.base.utils.qrcode.QRCodeDecoder;
import java.util.Hashtable;

/* loaded from: QrCodeTools.class */
public class QrCodeTools {

    /* loaded from: QrCodeTools$OnCompleteListener.class */
    public interface OnCompleteListener {
        void onSuccess(String str);
    }

    public static Bitmap a(String str, int i) {
        return b(str, i, 0);
    }

    public static Bitmap b(String str, int i, int i2) {
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hashtable.put(EncodeHintType.MARGIN, Integer.valueOf(i2));
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i, i, hashtable);
            int[] iArr = new int[i * i];
            for (int i3 = 0; i3 < i; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    if (encode.get(i4, i3)) {
                        iArr[(i3 * i) + i4] = -16777216;
                    } else {
                        iArr[(i3 * i) + i4] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
            return createBitmap;
        } catch (WriterException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void c(final Bitmap bitmap, final OnCompleteListener onCompleteListener) {
        if (bitmap != null && onCompleteListener != null) {
            ThreadManager.c().a().a(new Runnable(bitmap, onCompleteListener) { // from class: d.c.d.d.h.s

                /* renamed from: b  reason: collision with root package name */
                public final Bitmap f1172b;
                public final QrCodeTools.OnCompleteListener c;

                {
                    this.f1172b = bitmap;
                    this.c = onCompleteListener;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    QrCodeTools.e(this.f1172b, this.c);
                }
            });
        }
    }

    public static /* synthetic */ void d(OnCompleteListener onCompleteListener, String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        onCompleteListener.onSuccess(str2);
    }

    public static /* synthetic */ void e(Bitmap bitmap, final OnCompleteListener onCompleteListener) {
        final String a = QRCodeDecoder.a(bitmap);
        ThreadManager.c().d(new Runnable(onCompleteListener, a) { // from class: d.c.d.d.h.r

            /* renamed from: b  reason: collision with root package name */
            public final QrCodeTools.OnCompleteListener f1171b;
            public final String c;

            {
                this.f1171b = onCompleteListener;
                this.c = a;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QrCodeTools.d(this.f1171b, this.c);
            }
        });
        System.gc();
    }
}
