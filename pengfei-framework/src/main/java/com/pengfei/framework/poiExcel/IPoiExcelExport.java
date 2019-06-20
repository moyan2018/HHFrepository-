package com.pengfei.framework.poiExcel;

public interface IPoiExcelExport<T> {

    String getCellValue(int sheetIndex, int rowIndex, int cellIndex, T tData) throws Exception;

}
