package com.blate.scalpel.encoder.barcode;

import java.util.List;

/**
 * 条码的参数
 * 一般来说默认值就够用了
 * <p>
 *  * created by Blate
 *  * on2021/06/21
 */
public class BarcodeEncoderParams {

    /**
     * 条码格式
     */
    private BarcodeFormat mBarcodeFormat = BarcodeFormat.CODE128A;


    /*--------------------------------条码尺寸--------------------------------*/
    /**
     * 条码高度
     * 只是条码,不包含间距或者文本的尺寸
     */
    private int barcodeHeight = 128;

    /**
     * 条码单位宽度,正值有效
     * 条码的条空最小的尺寸.
     * 这个设置和{@link #barcodeTotalWidth}互斥,设置逻辑为这两者只能有一个为正.
     * 如果通过其他方式设置两者都为正,那么会优先使用该值
     * 具体逻辑参见{@link Code128Painter#justGenerateBarcode(List, BarcodeEncoderParams)}
     */
    private int barcodeUnitWidth = 4;

    /**
     * 条码的总宽度,正值有效
     * 不一定会使用该值.如果计算条空单位尺寸小于1,那么使用1px条宽单位尺寸
     * 如果按照最大值分配了条空的总尺寸,还有剩余,会舍弃这部分值
     * 这个设置和{@link #barcodeUnitWidth}互斥
     */
    private int barcodeTotalWidth = -1;


    /*--------------------------------边距--------------------------------*/
    /**
     * 内容区域(包含条码和可能存在的文本的最小平行于条码的矩形)左边距
     */
    private int spaceLeft = 16;

    /**
     * 内容区域(包含条码和可能存在的文本的最小平行于条码的矩形)上边距
     */
    private int spaceTop = 16;

    /**
     * 内容区域(包含条码和可能存在的文本的最小平行于条码的矩形)右边距
     */
    private int spaceRight = 16;

    /**
     * 内容区域(包含条码和可能存在的文本的最小平行于条码的矩形)底边距
     */
    private int spaceBottom = 16;


    /*--------------------------------颜色--------------------------------*/

    /**
     * 背景
     */
    private int backgroundColorArgb = 0xFFFFFFFF;

    /**
     * 条码部分的条颜色
     */
    private int barcodeBandColorArgb = 0xFF000000;

    /**
     * 条码部分的空颜色
     */
    private int barcodeSpaceColorArgb = 0xFFFFFFFF;

    /**
     * 文本颜色
     */
    private int contentTextColorArgb = 0xFF000000;


    /*--------------------------------文本--------------------------------*/
    /**
     * 是否显示条码值在底部(是的只能显示在底部,没有非主流的骚操作)
     */
    private boolean showContent = true;

    /**
     * 文本和条码的间距
     */
    private int barcodeAndContentSpace = 16;

    /**
     * 文本的大小
     */
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
