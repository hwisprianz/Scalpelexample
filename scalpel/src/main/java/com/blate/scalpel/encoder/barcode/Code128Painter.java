package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.blate.scalpel.table.Code128SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class Code128Painter {

    private final Paint mPaint = new Paint();
    private final Rect mContentRect = new Rect();

    public Bitmap generate(List<Code128SymbolTable.Symbol> symbols,
                           String content,
                           BarcodeEncoderParams params) {
        Bitmap barcode = justGenerateBarcode(symbols, params);

        int mixWidth;
        int mixHeight;
        Bitmap mix;
        if (params.isShowContent()) {
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

        int barcodeColumnWidth = params.getBarcodeUnitWidth();
        if (barcodeColumnWidth < 1) {
            barcodeColumnWidth = params.getBarcodeTotalWidth() / columnCount;
        }
        if (barcodeColumnWidth < 1) {
            barcodeColumnWidth = 1;
        }

        int[] row = new int[barcodeColumnWidth * columnCount];
        int rowIndex = 0;
        for (int bandIndex = 0; bandIndex < bands.size(); bandIndex += 1) {
            for (int columnIndex = 0; columnIndex < bands.get(bandIndex) * barcodeColumnWidth; columnIndex += 1) {
                row[rowIndex++] = (bandIndex & 0x00000001) == 0 ? params.getBarcodeBandColorArgb() : params.getBarcodeSpaceColorArgb();
            }
        }

        Bitmap barcode = Bitmap.createBitmap(
                barcodeColumnWidth * columnCount,
                params.getBarcodeHeight(),
                Bitmap.Config.ARGB_4444);

        for (int i = 0; i < Math.max(params.getBarcodeHeight(), 4); i += 1) {
            barcode.setPixels(row, 0, barcode.getWidth(), 0, i, barcode.getWidth(), 1);
        }

        return barcode;
    }

}
