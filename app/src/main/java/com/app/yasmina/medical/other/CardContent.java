package com.app.yasmina.medical.other;

import android.graphics.drawable.Drawable;

public class CardContent {
    private String header;
    private String[] footerTexts;
    private Drawable[] footerImages;

    public CardContent(String header, String[] footerTexts, Drawable[] footerImages) {
        this.header = header;
        this.footerTexts = footerTexts;
        this.footerImages = footerImages;
    }

    public String getHeaderTitle() {

        return header;
    }

    public Drawable getImageOne() {

        return footerImages[0];
    }

    public Drawable getImageTwo() {

        return footerImages[1];
    }

    public String getFooterTitle() {

        return footerTexts[0];
    }

    public String getImageTitleOne() {

        return footerTexts[1];
    }

    public String getImageTitleTwo() {

        return footerTexts[2];
    }

    public String getFooterTextOne() {

        return footerTexts[3];
    }

    public String getFooterTextTwo() {

        return footerTexts[4];
    }
}
