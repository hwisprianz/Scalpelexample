package com.blate.scalpel.encoder.barcode;

public class BarcodeEncoderParams {

    private BarcodeFormat mBarcodeFormat = BarcodeFormat.CODE128AUTO;

    private int barcodeHeight = 128;
    private int barcodeUnitWidth = 4;
    private int barcodeTotalWidth = -1;

    private int spaceLeft = 16;
    private int spaceTop = 16;
    private int spaceRight = 16;
    private int spaceBottom = 16;

    private int backgroundColorArgb = 0xFFFFFFFF;
    private int barcodeBandColorArgb = 0xFF000000;
    private int barcodeSpaceColorArgb = 0xFFFFFFFF;
    private int contentTextColorArgb = 0xFF000000;

    private boolean showContent = true;
    private int barcodeAndContentSpace = 16;
    private int contentTextSizePx = 24;

    public BarcodeFormat getBarcodeFormat() {
        return mBarcodeFormat;
    }

    public int getBarcodeHeight() {
        return barcodeHeight;
    }

    public int getBarcodeUnitWidth() {
        return barcodeUnitWidth;
    }

    public int getBarcodeTotalWidth() {
        return barcodeTotalWidth;
    }

    public int getSpaceLeft() {
        return spaceLeft;
    }

    public int getSpaceTop() {
        return spaceTop;
    }

    public int getSpaceRight() {
        return spaceRight;
    }

    public int getSpaceBottom() {
        return spaceBottom;
    }

    public int getBackgroundColorArgb() {
        return backgroundColorArgb;
    }

    public int getBarcodeBandColorArgb() {
        return barcodeBandColorArgb;
    }

    public int getBarcodeSpaceColorArgb() {
        return barcodeSpaceColorArgb;
    }

    public int getContentTextColorArgb() {
        return contentTextColorArgb;
    }

    public boolean isShowContent() {
        return showContent;
    }

    public int getBarcodeAndContentSpace() {
        return barcodeAndContentSpace;
    }

    public int getContentTextSizePx() {
        return contentTextSizePx;
    }

    public BarcodeEncoderParams setBarcodeFormat(BarcodeFormat barcodeFormat) {
        mBarcodeFormat = barcodeFormat;
        return this;
    }

    public BarcodeEncoderParams setBarcodeHeight(int barcodeHeight) {
        this.barcodeHeight = barcodeHeight;
        return this;
    }

    public BarcodeEncoderParams setBarcodeUnitWidth(int barcodeUnitWidth) {
        this.barcodeUnitWidth = barcodeUnitWidth;
        this.barcodeTotalWidth = -1;
        return this;
    }

    public BarcodeEncoderParams setBarcodeTotalWidth(int barcodeTotalWidth) {
        this.barcodeTotalWidth = barcodeTotalWidth;
        this.barcodeUnitWidth = -1;
        return this;
    }

    public BarcodeEncoderParams setSpaceLeft(int spaceLeft) {
        this.spaceLeft = spaceLeft;
        return this;
    }

    public BarcodeEncoderParams setSpaceTop(int spaceTop) {
        this.spaceTop = spaceTop;
        return this;
    }

    public BarcodeEncoderParams setSpaceRight(int spaceRight) {
        this.spaceRight = spaceRight;
        return this;
    }

    public BarcodeEncoderParams setSpaceBottom(int spaceBottom) {
        this.spaceBottom = spaceBottom;
        return this;
    }

    public BarcodeEncoderParams setBackgroundColorArgb(int backgroundColorArgb) {
        this.backgroundColorArgb = backgroundColorArgb;
        return this;
    }

    public BarcodeEncoderParams setBarcodeBandColorArgb(int barcodeBandColorArgb) {
        this.barcodeBandColorArgb = barcodeBandColorArgb;
        return this;
    }

    public BarcodeEncoderParams setBarcodeSpaceColorArgb(int barcodeSpaceColorArgb) {
        this.barcodeSpaceColorArgb = barcodeSpaceColorArgb;
        return this;
    }

    public BarcodeEncoderParams setContentTextColorArgb(int contentTextColorArgb) {
        this.contentTextColorArgb = contentTextColorArgb;
        return this;
    }

    public BarcodeEncoderParams setShowContent(boolean showContent) {
        this.showContent = showContent;
        return this;
    }

    public BarcodeEncoderParams setBarcodeAndContentSpace(int barcodeAndContentSpace) {
        this.barcodeAndContentSpace = barcodeAndContentSpace;
        return this;
    }

    public BarcodeEncoderParams setContentTextSizePx(int contentTextSizePx) {
        this.contentTextSizePx = contentTextSizePx;
        return this;
    }

}
