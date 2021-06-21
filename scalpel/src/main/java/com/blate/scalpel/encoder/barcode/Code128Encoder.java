package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;

import com.blate.scalpel.throwable.EncodeException;


public class Code128Encoder {

    private final ICode128Encoder mEncoder;

    public Code128Encoder() {
        this(new BarcodeEncoderParams());
    }

    public Code128Encoder(BarcodeEncoderParams params) throws Error {
        if (params.getBarcodeFormat() == BarcodeFormat.CODE128A) {
            mEncoder = null;
            throw new Error(String.format("not currently supported format[%s]", params.getBarcodeFormat()));
        } else if (params.getBarcodeFormat() == BarcodeFormat.CODE128B) {
            mEncoder = null;
            throw new Error(String.format("not currently supported format[%s]", params.getBarcodeFormat()));
        } else if (params.getBarcodeFormat() == BarcodeFormat.CODE128C) {
            mEncoder = new Code128CEncoder(params);
        } else if (params.getBarcodeFormat() == BarcodeFormat.CODE128AUTO) {
            mEncoder = null;
            throw new Error(String.format("not currently supported format[%s]", params.getBarcodeFormat()));
        } else {
            mEncoder = null;
            throw new Error(String.format("not supported format[%s]", params.getBarcodeFormat()));
        }
    }

    public Bitmap encode(String context) throws EncodeException {
        return mEncoder.encode(context);
    }

}
