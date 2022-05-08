package com.ibox.nft.base.widgets;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: SafeLottieView.class */
public class SafeLottieView extends LottieAnimationView {
    public SafeLottieView(Context context) {
        super(context);
        a(this);
    }

    public SafeLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(this);
    }

    public static void a(SafeLottieView safeLottieView) {
        if (b()) {
            try {
                Field declaredField = LottieAnimationView.class.getDeclaredField("failureListener");
                if (declaredField != null) {
                    Field declaredField2 = declaredField.getClass().getDeclaredField("accessFlags");
                    declaredField2.setAccessible(true);
                    declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(safeLottieView);
                    if (obj != null) {
                        Field declaredField3 = LottieAnimationView.class.getDeclaredField("compositionTask");
                        declaredField3.setAccessible(true);
                        Object obj2 = declaredField3.get(safeLottieView);
                        if (obj2 != null) {
                            LottieTask lottieTask = (LottieTask) obj2;
                            Method declaredMethod = lottieTask.getClass().getDeclaredMethod("removeFailureListener", LottieListener.class);
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(lottieTask, obj);
                        }
                    }
                    declaredField.set(safeLottieView, new SafeLottieListener((1) null));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean b() {
        int i = Build.VERSION.SDK_INT;
        return i >= 26 && i <= 27;
    }
}
