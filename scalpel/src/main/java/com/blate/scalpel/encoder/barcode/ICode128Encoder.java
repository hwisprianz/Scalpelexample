package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;

import com.blate.scalpel.throwable.EncodeException;
import com.blate.scalpel.throwable.SymbolInvalidException;

/**
 * code128解码器
 * 不同的子集(code128A, code128B, code128C, code128Auto)不同实现
 * <p>
 * created by Blate
 * on2021/06/21
 */
public interface ICode128Encoder {

    /**
     * 生成文本对于的条码
     *
     * @param content 条码内容
     * @return 条码位图
     * @throws EncodeException 编码异常
     */
    Bitmap encode(String content) throws EncodeException;

}
