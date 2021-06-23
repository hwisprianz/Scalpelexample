package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;

import com.blate.scalpel.table.Code128SymbolTable;
import com.blate.scalpel.throwable.EncodeException;

import java.util.ArrayList;
import java.util.List;

/**
 * Code128C格式的编码器
 * 将符合Code128C规范的字符串编码成位图
 * <p>
 * created by Blate
 * on2021/06/21
 */
public class Code128CEncoder
        implements ICode128Encoder {

    /**
     * 非空的条码参数
     */
    private final BarcodeEncoderParams mParams;

    /**
     * code128符号序列
     */
    private final List<Code128SymbolTable.Symbol> mSymbols = new ArrayList<>();

    public Code128CEncoder(BarcodeEncoderParams params) {
        mParams = params;
    }

    public Code128Painter mCode128Painter = new Code128Painter();

    @Override
    public Bitmap encode(String content) throws EncodeException {
        String cooked = content.trim();
        if ((cooked.length() & 0x00000001) == 1) {
            throw new EncodeException("code128c can only encode even length content");
        }
        if (!cooked.matches("[0-9]+")) {
            throw new EncodeException("code128c can only encode only contain 0-9 content");
        }

        mSymbols.clear();

        //检验值,计算方式参见code128编码规范
        int check = 0;

        Code128SymbolTable.Symbol startSymbol = Code128SymbolTable.getSymbolByCodeC(Code128SymbolTable.CODE_START_C);
        mSymbols.add(startSymbol);
        check += startSymbol.id;
        for (int i = 0; i < cooked.length() / 2; i += 1) {
            Code128SymbolTable.Symbol symbol = Code128SymbolTable.getSymbolByCodeC(cooked.substring(i * 2, i * 2 + 2));
            check += (i + 1) * symbol.id;
            mSymbols.add(symbol);
        }
        check %= Code128SymbolTable.CHECK_MOLD;
        Code128SymbolTable.Symbol checkSymbol = Code128SymbolTable.getSymbolById(check);
        mSymbols.add(checkSymbol);
        mSymbols.add(Code128SymbolTable.getSymbolByCodeC(Code128SymbolTable.CODE_END_COMMON));

        return mCode128Painter.generate(mSymbols, content, mParams);
    }

}
