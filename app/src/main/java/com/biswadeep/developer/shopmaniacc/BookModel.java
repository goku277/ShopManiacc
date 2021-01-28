package com.biswadeep.developer.shopmaniacc;

public class BookModel {
    private String title;
    private String page;


    public BookModel() {}

    public BookModel(String title, String page) {
        this.title= title;
        this.page= page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
