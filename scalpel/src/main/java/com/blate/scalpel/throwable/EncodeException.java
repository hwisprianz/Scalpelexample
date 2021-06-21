package com.blate.scalpel.throwable;

import androidx.annotation.Nullable;

public class EncodeException
        extends Throwable {

    public EncodeException(@Nullable String message) {
        super(message);
    }
}
