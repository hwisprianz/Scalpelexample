package com.blate.scalpel.throwable;

import androidx.annotation.Nullable;

/**
 * 编码异常
 * 尝试编码时出现异常
 * 可能是尝试编码不支持的字符,或者某个子集中不存在的字符
 * <p>
 * created by Blate
 * on2021/06/21
 */
public class EncodeException
        extends Throwable {

    public EncodeException(@Nullable String message) {
        super(message);
    }

}
