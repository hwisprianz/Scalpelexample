package com.blate.scalpel.throwable;

/**
 * 符号无效异常
 * 尝试获取一个不存在的符号
 * <p>
 * created by Blate
 * on2021/06/21
 */
public class SymbolInvalidException
        extends EncodeException {

    public SymbolInvalidException(String message) {
        super(message);
    }

}
