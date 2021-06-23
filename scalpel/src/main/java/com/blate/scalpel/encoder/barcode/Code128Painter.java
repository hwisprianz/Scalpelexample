package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.blate.scalpel.table.Code128SymbolTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Code128条码的绘制器
 * 把一个{@link com.blate.scalpel.table.Code128SymbolTable.Symbol}序列绘制为Bitmap
 * <p>
 * created by Blate
 * on2021/06/21
 */
public class Code128Painter {

    /**
     * 画笔
     */
    private final Paint mPaint = new Paint();

    /**
     * 矩形,用来测量文本区域
     */
    private final Rect mContentRect = new Rect();

    /**
     * constructor
     *
     * @param symbols 条码符号序列
     * @param content 条码内容
     * @param params  条码参数
     * @return 合成后的条码位图
     */
    public Bitmap generate(List<Code128SymbolTable.Symbol> symbols,
                           String content,
                           BarcodeEncoderParams params) {
        Bitmap barcode = justGenerateBarcode(symbols, params);

        int mixWidth;
        int mixHeight;
        Bitmap mix;
        if (params.isShowContent()) {
            //需要绘制文本时的条码合成位图大小计算
            mPaint.setTextSize(Math.max(params.getContentTextSizePx(), 24));
            mPaint.getTextBounds(content, 0, content.length(), mContentRect);
            int contentWidth = mContentRect.right - mContentRect.left;
            int contentHeight = mContentRect.bottom - mContentRect.top;

            mixWidth = Math.max(barcode.getWidth(), contentWidth)
                    + params.getSpaceLeft()
                    + params.getSpaceRight();
            mixHeight = barcode.getHeight()
                    + contentHeight
                    + params.getSpaceTop()
                    + params.getSpaceBottom()
                    + params.getBarcodeAndContentSpace();

            mix = Bitmap.createBitmap(mixWidth, mixHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(mix);
            canvas.drawColor(params.getBackgroundColorArgb());

            canvas.drawBitmap(
                    barcode,
                    (mixWidth - params.getSpaceLeft() - params.getSpaceRight() - barcode.getWidth()) / 2.0f + params.getSpaceLeft(),
                    params.getSpaceTop(),
                    mPaint);

            mPaint.setColor(params.getContentTextColorArgb());
            canvas.drawText(
                    content,
                    (mixWidth - params.getSpaceLeft() - params.getSpaceRight() - contentWidth) / 2.0f + params.getSpaceLeft(),
                    params.getSpaceTop() + barcode.getHeight() + params.getBarcodeAndContentSpace() + contentHeight,
                    mPaint);

        } else {
            //不需要绘制文本时的条码位图大小计算
            mixWidth = barcode.getWidth() + params.getSpaceLeft() + params.getSpaceRight();
            mixHeight = barcode.getHeight() + params.getSpaceTop() + params.getSpaceBottom();

            mix = Bitmap.createBitmap(mixWidth, mixHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(mix);
            canvas.drawColor(params.getBackgroundColorArgb());

            canvas.drawBitmap(
                    barcode,
                    params.getSpaceLeft(),
                    params.getSpaceTop(),
                    mPaint);

        }

        barcode.recycle();
        return mix;
    }

    /**
     * 生成条码位图,只是条码,不包含间距或者文本
     *
     * @param symbols 条码符号序列
     * @param params  条码参数
     * @return 条码位图
     */
    private Bitmap justGenerateBarcode(List<Code128SymbolTable.Symbol> symbols,
                                       BarcodeEncoderParams params) {

        List<Integer> bands = new ArrayList<>();    //条码原始带数据
        int columnCount = 0;                        //条码原始列数
        for (Code128SymbolTable.Symbol symbol : symbols) {
            for (char c : symbol.band.toCharArray()) {
                int band = Character.getNumericValue(c);
                bands.add(band);
                columnCount += band;
            }
        }

        //计算合适的单位宽度
        int barcodeColumnWidth = params.getBarcodeUnitWidth();
        if (barcodeColumnWidth < 1) {
            barcodeColumnWidth = params.getBarcodeTotalWidth() / columnCount;
        }
        if (barcodeColumnWidth < 1) {
            barcodeColumnWidth = 1;
        }

        int[] row = new int[barcodeColumnWidth * columnCount];  //一行的像素序列
        int rowIndex = 0;
        for (int bandIndex = 0; bandIndex < bands.size(); bandIndex += 1) {
            //填充条空的像素.条空单位可能不是1像素,所以可能需要对每一个条空数据进行循环填充
            for (int columnIndex = 0; columnIndex < bands.get(bandIndex) * barcodeColumnWidth; columnIndex += 1) {
                //从0开始对band计数,偶数绘制条,技术绘制空
                row[rowIndex++] = (bandIndex & 0x00000001) == 0 ? params.getBarcodeBandColorArgb() : params.getBarcodeSpaceColorArgb();
            }
        }

        Bitmap barcode = Bitmap.createBitmap(
                barcodeColumnWidth * columnCount,
                params.getBarcodeHeight(),
                Bitmap.Config.ARGB_4444);

        //填充位图到需要的高度
        for (int i = 0; i < Math.max(params.getBarcodeHeight(), 4); i += 1) {
            barcode.setPixels(row, 0, barcode.getWidth(), 0, i, barcode.getWidth(), 1);
        }

        return barcode;
    }

}
