package com.pengfei.framework.poiExcel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface IPoiExcelStyle {

    HSSFCellStyle getStyle(int sheetIndex, int rowIndex, int cellIndex, HSSFWorkbook workbook) throws Exception;

    void setColumnWith(int sheetIndex, int rowIndex, int cellIndex, HSSFSheet sheet) throws Exception;
}
