package com.demo.validation;

/**
 * @author zhanglong
 * @description: 描述
 * @date 2019-08-3114:15
 */
public interface ValidationHandler{

    ValidationHandler DEFULTVALIDATIONHANDLER = new DefaultValidationHandler();

    void resultHandler(ValidationResult data);

}
