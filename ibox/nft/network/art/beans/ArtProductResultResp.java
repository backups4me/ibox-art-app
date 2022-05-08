package com.ibox.nft.network.art.beans;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: ArtProductResultResp.class */
public class ArtProductResultResp implements Serializable {
    private int currPage;
    private int hashNext;
    private ArrayList<ArtProductInfoBean> list;
    private int pageSize;
    private int totalCount;
    private int totalPage;

    public int getCurrPage() {
        return this.currPage;
    }

    public int getHashNext() {
        return this.hashNext;
    }

    public ArrayList<ArtProductInfoBean> getList() {
        return this.list;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setCurrPage(int i) {
        this.currPage = i;
    }

    public void setHashNext(int i) {
        this.hashNext = i;
    }

    public void setList(ArrayList<ArtProductInfoBean> arrayList) {
        this.list = arrayList;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }
}
