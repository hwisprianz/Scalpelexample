package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;

import com.blate.scalpel.throwable.EncodeException;
import com.blate.scalpel.throwable.SymbolInvalidException;

public interface ICode128Encoder {

    Bitmap encode(String context) throws EncodeException;

}
