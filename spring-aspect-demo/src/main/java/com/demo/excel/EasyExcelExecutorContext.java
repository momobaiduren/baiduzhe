package com.demo.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhanglong
 * @description: context容器
 * @date 2019-08-3122:54
 */
public class EasyExcelExecutorContext {


    private DataHandler dataHandler;

    private EasyExcelExecutorContextBind easyExcelExecutorContextBind;

    public <T extends ExcelModel> EasyExcelExecutorContext(EasyExcelHandler easyExcelHandler ) {
        if(Objects.isNull(this.dataHandler)) {
            this.dataHandler = new DataHandler();
        }
        if(Objects.isNull(this.easyExcelExecutorContextBind)) {
            this.easyExcelExecutorContextBind = new EasyExcelExecutorContextBind();
        }
        easyExcelExecutorContextBind.bindingasyExcelHandler(easyExcelHandler);
    }


    public DataHandler dataHandler(){
        return dataHandler;
    }

    public EasyExcelExecutorContextBind easyExcelExecutorContextBind(){
        return easyExcelExecutorContextBind;
    }
    public class DataHandler<T extends ExcelModel> {

        private List<T> data = new ArrayList<>();

        private List<T> errorData = new ArrayList<>();

        public List<T> get(){
            return data;
        }

        public List<T> errorData(){
            return errorData;
        }

        public EasyExcelExecutorContext.DataHandler dataAdd( T model ) {
            data.add(model);
            return dataHandler;
        }

        public EasyExcelExecutorContext.DataHandler errorMsgAdd( T model, String errMsg ) {
            if (data.contains(model)) {
                data.remove(model);
            }
            model.setErrorMsg(errMsg);
            errorData.add(model);
            return dataHandler;
        }
    }

    public class EasyExcelExecutorContextBind {

        private EasyExcelHandler easyExcelHandler;

        public EasyExcelExecutorContext.EasyExcelExecutorContextBind bindingasyExcelHandler(
            final EasyExcelHandler easyExcelHandler ) {
            this.easyExcelHandler = easyExcelHandler;
            return easyExcelExecutorContextBind;
        }

        public EasyExcelHandler easyExcelHandler() {
            return easyExcelHandler;
        }

    }


}
