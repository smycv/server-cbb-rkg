package com.greatech.server.common.global;

import lombok.Data;

@Data
public class GlobalResponseError {
    int code;
    String message;
}
