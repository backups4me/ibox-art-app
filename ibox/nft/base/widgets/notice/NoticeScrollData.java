package com.ibox.nft.base.widgets.notice;

import android.text.TextUtils;
import com.ibox.nft.base.R;
import java.io.Serializable;

/* loaded from: NoticeScrollData.class */
public class NoticeScrollData implements Serializable {
    public static final String TAG_TYPE = "New_Coin";
    public static final String TAG_TYPE1 = "Announcement";
    public static final String TAG_TYPE2 = "Promotions";
    private int index;
    private String notice1;
    private String notice2;
    private long proclaId;
    private String tag;
    private String url;

    public NoticeScrollData() {
    }

    public NoticeScrollData(int i, String str, long j, String str2, String str3, String str4) {
        this.index = i;
        this.tag = str;
        this.proclaId = j;
        this.notice1 = str2;
        this.notice2 = str3;
        this.url = str4;
    }

    public NoticeScrollData(String str, String str2) {
        this.notice1 = str;
        this.url = str2;
    }

    public int getIndex() {
        return this.index;
    }

    public String getNotice1() {
        return this.notice1;
    }

    public String getNotice2() {
        return this.notice2;
    }

    public long getProclaId() {
        return this.proclaId;
    }

    public String getTag() {
        return this.tag;
    }

    public int getTagToIcon() {
        int i;
        if (TextUtils.isEmpty(this.tag)) {
            return R.drawable.home_notice_icon;
        }
        String str = this.tag;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1307282352:
                if (str.equals(TAG_TYPE2)) {
                    c = 0;
                    break;
                }
                break;
            case 321102183:
                if (str.equals(TAG_TYPE1)) {
                    c = 1;
                    break;
                }
                break;
            case 1440520720:
                if (str.equals(TAG_TYPE)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i = R.drawable.home_news_image_active;
                break;
            case 1:
                i = R.drawable.home_news_image;
                break;
            case 2:
                i = R.drawable.home_news_image_new_coin;
                break;
            default:
                i = R.drawable.home_notice_icon;
                break;
        }
        return i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setNotice1(String str) {
        this.notice1 = str;
    }

    public void setNotice2(String str) {
        this.notice2 = str;
    }

    public void setProclaId(long j) {
        this.proclaId = j;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "[" + this.notice1 + " " + this.notice2 + "]";
    }
}
