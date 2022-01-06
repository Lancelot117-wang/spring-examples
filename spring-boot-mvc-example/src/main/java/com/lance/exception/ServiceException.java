package com.lance.exception;

import com.lance.constants.ServiceExceptionEnum;

public final class ServiceException extends RuntimeException {

    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        super(serviceExceptionEnum.getMessage());
        this.code = serviceExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
