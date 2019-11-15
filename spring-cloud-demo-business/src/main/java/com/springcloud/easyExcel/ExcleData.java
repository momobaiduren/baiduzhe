package com.springcloud.easyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangLong on 2019/10/16  5:56 下午
 * @version V1.0
 */
public class ExcleData<M extends ReadModel> {

    private List<M> data = new ArrayList<>();

    private List<M> errorData = new ArrayList<>();

    public List<M> get() {
        return data;
    }

    public List<M> errorData() {
        return errorData;
    }

    public void dataAdd(M model ) {
        data.add(model);
    }

    public void errorMsgAdd(M model, String errMsg ) {
        if (data.contains(model)) {
            data.remove(model);
        }
        model.setErrorMsg(errMsg);
        errorData.add(model);
    }
}