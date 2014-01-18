package com.todoroo.astrid.gtasks.api;

import android.text.TextUtils;

import java.io.IOException;

public class GoogleTasksException extends IOException {
    private static final long serialVersionUID = -5585448790574862510L;

    private String type;

    public GoogleTasksException(String message, String type) {
        super(message);
        this.type = type;
    }

    public String getType() {
        if (!TextUtils.isEmpty(type)) {
            return type;
        }
        return getMessage();
    }
}
