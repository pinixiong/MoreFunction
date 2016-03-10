package com.rj.morefunction.entity;

import android.graphics.drawable.Drawable;

import java.util.List;

public class MenuItem {
    private Drawable drawable;
    private int number;
    private String title;
    private String callBack;
    private List<MenuItem> sonitems;

    public MenuItem(Drawable drawable, String title) {
        this.drawable = drawable;
        this.title = title;
    }

    public MenuItem(String title, List<MenuItem> sonitems) {
        this.title = title;
        this.sonitems = sonitems;
    }

    public MenuItem(Drawable drawable, int number, String title, String callBack, List<MenuItem> sonitems) {
        this.drawable = drawable;
        this.number = number;
        this.title = title;
        this.callBack = callBack;
        this.sonitems = sonitems;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCallBack() {
        return callBack;
    }

    public void setCallBack(String callBack) {
        this.callBack = callBack;
    }

    public List<MenuItem> getSonitems() {
        return sonitems;
    }

    public void setSonitems(List<MenuItem> sonitems) {
        this.sonitems = sonitems;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "drawable=" + drawable +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", callBack='" + callBack + '\'' +
                ", sonitems=" + sonitems +
                '}';
    }
}
