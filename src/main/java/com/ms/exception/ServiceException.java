package com.ms.exception;

/**
 * describe:
 *
 * @date: 2019/01/05 08:59:8:59
 * @version: V1.0
 * @review:
 */
public class ServiceException extends BaseException {
    public ServiceException() {
        super();
    }

    public ServiceException(String code) {
        super(code);
    }

    public ServiceException(String code, String message) {
        super(code, message);
    }
}
