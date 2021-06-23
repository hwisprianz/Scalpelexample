package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;

import com.blate.scalpel.table.Code128SymbolTable;
import com.blate.scalpel.throwable.EncodeException;

import java.util.ArrayList;
import java.util.List;

public class Code128BEncoder
        implements ICode128Encoder {

    /**
     * 非空的条码参数
     */
    private final BarcodeEncoderParams mParams;

    /**
     * code128符号序列
     */
    private final List<Code128SymbolTable.Symbol> mSymbols = new ArrayList<>();

    public Code128BEncoder(BarcodeEncoderParams params) {
        mParams = params;
    }

    public Code128Painter mCode128Painter = new Code128Painter();

    @Override
    public Bitmap encode(String content) throws EncodeException {
        String cooked = content.trim();
        if (!cooked.matches("[0-9a-zA-Z!\"#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_`{|}~]+")) {
            throw new EncodeException("code128a can only encode only contain 01234567899abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ content");
        }

        mSymbols.clear();

        //检验值,计算方式参见code128编码规范
        int check = 0;

        Code128SymbolTable.Symbol startSymbol = Code128SymbolTable.getSymbolByCodeB(Code128SymbolTable.CODE_START_B);
        mSymbols.add(startSymbol);
        check += startSymbol.id;
        for (int i = 0; i < cooked.length(); i += 1) {
            Code128SymbolTable.Symbol symbol = Code128SymbolTable.getSymbolByCodeB(cooked.substring(i, i + 1));
            check += (i + 1) * symbol.id;
            mSymbols.add(symbol);
        }
        check %= Code128SymbolTable.CHECK_MOLD;
        Code128SymbolTable.Symbol checkSymbol = Code128SymbolTable.getSymbolById(check);
        mSymbols.add(checkSymbol);
        mSymbols.add(Code128SymbolTable.getSymbolByCodeB(Code128SymbolTable.CODE_END_COMMON));

        return mCode128Painter.generate(mSymbols, content, mParams);
    }

}
