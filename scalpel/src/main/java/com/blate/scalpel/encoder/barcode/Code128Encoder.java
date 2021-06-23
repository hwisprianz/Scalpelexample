package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;

import com.blate.scalpel.throwable.EncodeException;

/**
 * code128编码器
 * 根据参数指定的不同子集调用不同的编码器进行编码
 * <p>
 * created by Blate
 * on2021/06/21
 */
public class Code128Encoder {

    /**
     * code128编码器的实现
     */
    private final ICode128Encoder mEncoder;

    public Code128Encoder() {
        this(new BarcodeEncoderParams());
    }

    public Code128Encoder(BarcodeEncoderParams params) throws Error {
        if (params.getBarcodeFormat() == BarcodeFormat.CODE128A) {
            mEncoder = new Code128AEncoder(params);
        } else if (params.getBarcodeFormat() == BarcodeFormat.CODE128B) {
            mEncoder = new Code128BEncoder(params);
        } else if (params.getBarcodeFormat() == BarcodeFormat.CODE128C) {
            mEncoder = new Code128CEncoder(params);
        } else {
            mEncoder = null;
            throw new Error(String.format("not supported format[%s]", params.getBarcodeFormat()));
        }
    }

    /**
     * 对内容进行编码
     *
     * @param context 条码内容
     * @return 编码后的Bitmap
     * @throws EncodeException 编码异常
     */
    public Bitmap encode(String context) throws EncodeException {
        return mEncoder.encode(context);
    }

}
