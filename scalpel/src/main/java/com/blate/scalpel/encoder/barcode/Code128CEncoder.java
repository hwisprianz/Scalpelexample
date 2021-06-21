package com.blate.scalpel.encoder.barcode;

import android.graphics.Bitmap;

import com.blate.scalpel.table.Code128SymbolTable;
import com.blate.scalpel.throwable.EncodeException;

import java.util.ArrayList;
import java.util.List;

public class Code128CEncoder
        implements ICode128Encoder {

    private final BarcodeEncoderParams mParams;

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
