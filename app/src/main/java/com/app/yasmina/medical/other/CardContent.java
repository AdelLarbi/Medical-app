package com.app.yasmina.medical.other;

import android.graphics.drawable.Drawable;

public class CardContent {
    private String header;
    private String[] contents;
    private Drawable[] images;

    public CardContent(String header, String[] contents, Drawable[] images) {
        this.header = header;
        this.contents = contents;
        this.images = images;
    }

    public String getHeaderTitle() {

        return header;
    }

    public Drawable getImageOne() {

        return images[0];
    }

    public Drawable getImageTwo() {

        return images[1];
    }

    public String getFooterTitle() {

        return contents[0];
    }

    public String getImageTitleOne() {

        return contents[1];
    }

    public String getImageTitleTwo() {

        return contents[2];
    }

    public String getFooterTextOne() {

        return contents[3];
    }

    public String getFooterTextTwo() {

        return contents[4];
    }
}
