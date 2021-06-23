package com.blate.scalpel.table;

import com.blate.scalpel.throwable.SymbolInvalidException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * code128 编码符号表
 * <p>
 * created by Blate
 * on2021/06/21
 */
public final class Code128SymbolTable {

    /**
     * code128校验位计算模
     */
    public static final int CHECK_MOLD = 103;

    /**
     * 子集code128A开始位
     */
    public static final String CODE_START_A = "StartA";

    /**
     * 子集code128B开始位
     */
    public static final String CODE_START_B = "StartB";

    /**
     * 子集code128C开始位
     */
    public static final String CODE_START_C = "StartC";

    /**
     * code128结束位,所有子集共用结束位
     */
    public static final String CODE_END_COMMON = "Stop";

    /**
     * 编码表
     */
    private static final Set<Symbol> TABLE_CODE_SYMBOL = new HashSet<>();

    static {
        TABLE_CODE_SYMBOL.add(new Symbol(0, "SP", "SP", "00", "212222", "bbsbbssbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(1, "!", "!", "01", "222122", "bbssbbsbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(2, "\"", "\"", "02", "222221", "bbssbbssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(3, "#", "#", "03", "121223", "bssbssbbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(4, "$", "$", "04", "121322", "bssbsssbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(5, "%", "%", "05", "131222", "bsssbssbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(6, "&", "&", "06", "122213", "bssbbssbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(7, "'", "'", "07", "122312", "bssbbsssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(8, "(", "(", "08", "132212", "bsssbbssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(9, ")", ")", "09", "221213", "bbssbssbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(10, "*", "*", "10", "221312", "bbssbsssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(11, "+", "+", "11", "231212", "bbsssbssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(12, ",", ",", "12", "112232", "bsbbssbbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(13, "-", "-", "13", "122132", "bssbbsbbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(14, ".", ".", "14", "122231", "bssbbssbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(15, "/", "/", "15", "113222", "bsbbbssbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(16, "0", "0", "16", "123122", "bssbbbsbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(17, "1", "1", "17", "123221", "bssbbbssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(18, "2", "2", "18", "223211", "bbssbbbssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(19, "3", "3", "19", "221132", "bbssbsbbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(20, "4", "4", "20", "221231", "bbssbssbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(21, "5", "5", "21", "213212", "bbsbbbssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(22, "6", "6", "22", "223112", "bbssbbbsbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(23, "7", "7", "23", "312131", "bbbsbbsbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(24, "8", "8", "24", "311222", "bbbsbssbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(25, "9", "9", "25", "321122", "bbbssbsbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(26, ":", ":", "26", "321221", "bbbssbssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(27, ";", ";", "27", "312212", "bbbsbbssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(28, "<", "<", "28", "322112", "bbbssbbsbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(29, "=", "=", "29", "322211", "bbbssbbssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(30, ">", ">", "30", "212123", "bbsbbsbbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(31, "?", "?", "31", "212321", "bbsbbsssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(32, "@", "@", "32", "232121", "bbsssbbsbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(33, "A", "A", "33", "111323", "bsbsssbbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(34, "B", "B", "34", "131123", "bsssbsbbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(35, "C", "C", "35", "131321", "bsssbsssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(36, "D", "D", "36", "112313", "bsbbsssbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(37, "E", "E", "37", "132113", "bsssbbsbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(38, "F", "F", "38", "132311", "bsssbbsssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(39, "G", "G", "39", "211313", "bbsbsssbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(40, "H", "H", "40", "231113", "bbsssbsbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(41, "I", "I", "41", "231311", "bbsssbsssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(42, "J", "J", "42", "112133", "bsbbsbbbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(43, "K", "K", "43", "112331", "bsbbsssbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(44, "L", "L", "44", "132131", "bsssbbsbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(45, "M", "M", "45", "113123", "bsbbbsbbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(46, "N", "N", "46", "113321", "bsbbbsssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(47, "O", "O", "47", "133121", "bsssbbbsbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(48, "P", "P", "48", "313121", "bbbsbbbsbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(49, "Q", "Q", "49", "211331", "bbsbsssbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(50, "R", "R", "50", "231131", "bbsssbsbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(51, "S", "S", "51", "213113", "bbsbbbsbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(52, "T", "T", "52", "213311", "bbsbbbsssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(53, "U", "U", "53", "213131", "bbsbbbsbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(54, "V", "V", "54", "311123", "bbbsbsbbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(55, "W", "W", "55", "311321", "bbbsbsssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(56, "X", "X", "56", "331121", "bbbsssbsbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(57, "Y", "Y", "57", "312113", "bbbsbbsbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(58, "Z", "Z", "58", "312311", "bbbsbbsssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(59, "[", "[", "59", "332111", "bbbsssbbsbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(60, "\\", "\\", "60", "314111", "bbbsbbbbsbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(61, "]", "]", "61", "221411", "bbssbssssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(62, "^", "^", "62", "431111", "bbbbsssbsbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(63, "_", "_", "63", "111224", "bsbssbbssss"));
        TABLE_CODE_SYMBOL.add(new Symbol(64, "NUL", "`", "64", "111422", "bsbssssbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(65, "SOH", "a", "65", "121124", "bssbsbbssss"));
        TABLE_CODE_SYMBOL.add(new Symbol(66, "STX", "b", "66", "121421", "bssbssssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(67, "ETX", "c", "67", "141122", "bssssbsbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(68, "EOT", "d", "68", "141221", "bssssbssbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(69, "ENQ", "e", "69", "112214", "bsbbssbssss"));
        TABLE_CODE_SYMBOL.add(new Symbol(70, "ACK", "f", "70", "112412", "bsbbssssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(71, "BEL", "g", "71", "122114", "bssbbsbssss"));
        TABLE_CODE_SYMBOL.add(new Symbol(72, "BS", "h", "72", "122411", "bssbbssssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(73, "HT", "i", "73", "142112", "bssssbbsbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(74, "LF", "j", "74", "142211", "bssssbbssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(75, "VT", "k", "75", "241211", "bbssssbssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(76, "FF", "l", "76", "221114", "bbssbsbssss"));
        TABLE_CODE_SYMBOL.add(new Symbol(77, "CR", "m", "77", "413111", "bbbbsbbbsbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(78, "SO", "n", "78", "241112", "bbssssbsbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(79, "SI", "o", "79", "134111", "bsssbbbbsbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(80, "DLE", "p", "80", "111242", "bsbssbbbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(81, "DC1", "q", "81", "121142", "bssbsbbbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(82, "DC2", "r", "82", "121241", "bssbssbbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(83, "DC3", "s", "83", "114212", "bsbbbbssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(84, "DC4", "t", "84", "124112", "bssbbbbsbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(85, "NAK", "u", "85", "124211", "bssbbbbssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(86, "SYN", "v", "86", "411212", "bbbbsbssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(87, "ETB", "w", "87", "421112", "bbbbssbsbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(88, "CAN", "x", "88", "421211", "bbbbssbssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(89, "EM", "y", "89", "212141", "bbsbbsbbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(90, "SUB", "z", "90", "214121", "bbsbbbbsbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(91, "ESC", "{", "91", "412121", "bbbbsbbsbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(92, "FS", "|", "92", "111143", "bsbsbbbbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(93, "GS", "}", "93", "111341", "bsbsssbbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(94, "RS", "~", "94", "131141", "bsssbsbbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(95, "US", "DEL", "95", "114113", "bsbbbbsbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(96, "FNC3", "FNC3", "96", "114311", "bsbbbbsssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(97, "FNC2", "FNC2", "97", "411113", "bbbbsbsbsss"));
        TABLE_CODE_SYMBOL.add(new Symbol(98, "SHIFT", "SHIFT", "98", "411311", "bbbbsbsssbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(99, "CODEC", "CODEC", "99", "113141", "bsbbbsbbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(100, "CODEB", "FNC4", "CODEB", "114131", "bsbbbbsbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(101, "FNC4", "CODEA", "CODEA", "311141", "bbbsbsbbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(102, "FNC1", "FNC1", "FNC1", "411131", "bbbbsbsbbbs"));
        TABLE_CODE_SYMBOL.add(new Symbol(103, "StartA", "StartA", "StartA", "211412", "bbsbssssbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(104, "StartB", "StartB", "StartB", "211214", "bbsbssbssss"));
        TABLE_CODE_SYMBOL.add(new Symbol(105, "StartC", "StartC", "StartC", "211232", "bbsbssbbbss"));
        TABLE_CODE_SYMBOL.add(new Symbol(106, "Stop", "Stop", "Stop", "2331112", "bbsssbbbsbsbb"));
    }

    /**
     * 获取code128符号编码表
     *
     * @return 编码表
     */
    public static Set<Symbol> getTableCodeSymbol() {
        return new HashSet<>(TABLE_CODE_SYMBOL);
    }

    /**
     * 通过id获取符号
     *
     * @param id id
     * @return 符号
     * @throws SymbolInvalidException 尝试获取一个不存在的符号时抛出异常
     */
    public static Symbol getSymbolById(int id)
            throws SymbolInvalidException {
        Symbol result = null;
        for (Symbol symbol : TABLE_CODE_SYMBOL) {
            if (id == symbol.id) {
                result = symbol;
                break;
            }
        }
        if (result == null) {
            throw new SymbolInvalidException(String.format("id [%s] does not exist in the table", id));
        } else {
            return result;
        }
    }

    /**
     * 根据code128A编码值获取符号
     *
     * @param codeA code128A子集编码值
     * @return 符号
     * @throws SymbolInvalidException 尝试获取不存在的code128A编码值符号抛出异常
     */
    public static Symbol getSymbolByCodeA(String codeA)
            throws SymbolInvalidException {
        Symbol result = null;
        for (Symbol symbol : TABLE_CODE_SYMBOL) {
            if (Objects.equals(codeA, symbol.code128A)) {
                result = symbol;
                break;
            }
        }
        if (result == null) {
            throw new SymbolInvalidException(String.format("code %s does not exist in the code128A", codeA));
        } else {
            return result;
        }
    }

    /**
     * 根据code128B编码值获取符号
     *
     * @param codeB code128B子集编码值
     * @return 符号
     * @throws SymbolInvalidException 尝试获取不存在的code128B编码值符号抛出异常
     */
    public static Symbol getSymbolByCodeB(String codeB)
            throws SymbolInvalidException {
        Symbol result = null;
        for (Symbol symbol : TABLE_CODE_SYMBOL) {
            if (Objects.equals(codeB, symbol.code128B)) {
                result = symbol;
                break;
            }
        }
        if (result == null) {
            throw new SymbolInvalidException(String.format("code %s does not exist in the code128B", codeB));
        } else {
            return result;
        }
    }

    /**
     * 根据code128C编码值获取符号
     *
     * @param codeC code128C子集编码值
     * @return 符号
     * @throws SymbolInvalidException 尝试获取不存在的code128C编码值符号抛出异常
     */
    public static Symbol getSymbolByCodeC(String codeC)
            throws SymbolInvalidException {
        Symbol result = null;
        for (Symbol symbol : TABLE_CODE_SYMBOL) {
            if (Objects.equals(codeC, symbol.code128C)) {
                result = symbol;
                break;
            }
        }
        if (result == null) {
            throw new SymbolInvalidException(String.format("code %s does not exist in the code128C", codeC));
        } else {
            return result;
        }
    }

    /**
     * 编码符号
     */
    public static final class Symbol {

        public Symbol(int id, String code128A, String code128B, String code128C, String band, String column) {
            this.id = id;
            this.code128A = code128A;
            this.code128B = code128B;
            this.code128C = code128C;
            this.band = band;
            this.column = column;
        }

        /**
         * id值
         */
        public final int id;

        /**
         * code128A编码值
         */
        public final String code128A;

        /**
         * code128B编码值
         */
        public final String code128B;

        /**
         * code128c编码值
         */
        public final String code128C;

        /**
         * 条,空宽度.
         * 除了结束符,其余共6列.按照[条空条空条空]排列,字符串长度6,结束符长度7
         * 纯数字字符串,数字是相对宽度
         */
        public final String band;

        /**
         * 条,空排列.
         * 除了结束符号,其余共11列,字符串长度 11,结束符长度13
         * b : 条
         * s : 空
         */
        public final String column;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Symbol symbol = (Symbol) o;
            return id == symbol.id &&
                    Objects.equals(code128A, symbol.code128A) &&
                    Objects.equals(code128B, symbol.code128B) &&
                    Objects.equals(code128C, symbol.code128C) &&
                    Objects.equals(band, symbol.band) &&
                    Objects.equals(column, symbol.column);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, code128A, code128B, code128C, band, column);
        }

    }

}
