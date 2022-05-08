package com.ibox.nft.base.event;

/* loaded from: EventBusCenter.class */
public class EventBusCenter<T> {
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public int f392b;
    public long c = -1;

    public EventBusCenter(int i) {
        this.f392b = -1;
        this.f392b = i;
    }

    public EventBusCenter(int i, T t) {
        this.f392b = -1;
        this.f392b = i;
        this.a = t;
    }

    public T a() {
        return this.a;
    }

    public int b() {
        return this.f392b;
    }
}
