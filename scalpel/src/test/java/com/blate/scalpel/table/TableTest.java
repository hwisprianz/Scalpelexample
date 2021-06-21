package com.blate.scalpel.table;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void testCode128Table() {
        for (Code128SymbolTable.Symbol symbol : Code128SymbolTable.getTableCodeSymbol()) {
            if (Objects.equals(symbol.code128A, Code128SymbolTable.CODE_END_COMMON)
                    || Objects.equals(symbol.code128B, Code128SymbolTable.CODE_END_COMMON)
                    || Objects.equals(symbol.code128C, Code128SymbolTable.CODE_END_COMMON)) {
                assertEquals(symbol.band.length(), 7);
                assertEquals(symbol.column.length(), 13);
            } else {
                assertEquals(symbol.band.length(), 6);
                assertEquals(symbol.column.length(), 11);
            }
        }

    }

}
