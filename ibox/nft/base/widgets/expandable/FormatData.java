package com.ibox.nft.base.widgets.expandable;

import java.util.List;

/* loaded from: FormatData.class */
public class FormatData {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<PositionData> f487b;

    /* loaded from: FormatData$PositionData.class */
    public static class PositionData {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f488b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public LinkType f489d;

        /* renamed from: e  reason: collision with root package name */
        public String f490e;
        public String f;

        public PositionData(int i, int i2, String str, LinkType linkType) {
            this.a = i;
            this.f488b = i2;
            this.c = str;
            this.f489d = linkType;
        }

        public PositionData(int i, int i2, String str, String str2, LinkType linkType) {
            this.a = i;
            this.f488b = i2;
            this.f490e = str;
            this.f = str2;
            this.f489d = linkType;
        }

        public int a() {
            return this.f488b;
        }

        public String b() {
            return this.f490e;
        }

        public String c() {
            return this.f;
        }

        public int d() {
            return this.a;
        }

        public LinkType e() {
            return this.f489d;
        }

        public String f() {
            return this.c;
        }
    }

    public String a() {
        return this.a;
    }

    public List<PositionData> b() {
        return this.f487b;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(List<PositionData> list) {
        this.f487b = list;
    }
}
