/**
 * packageName :  com.nhnacademy.account.exception
 * fileName : InvalidInputException
 * author :  ichunghui
 * date : 2023/06/10 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/10                ichunghui             최초 생성
 */

package com.nhnacademy.account.exception;

import org.springframework.validation.BindingResult;

public class InvalidInputException extends RuntimeException {

    private final BindingResult bindingResult;

    public InvalidInputException(BindingResult bindingResult) {
        super("Invalid input.");
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
