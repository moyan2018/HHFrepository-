package com.pengfei.framework.poiExcel;

import com.pengfei.framework.FrameWorkCommon;
import com.pengfei.framework.list.ListManager;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class PoiExcelManager {

    private PoiExcelManager(){

    }

    /**
     * 导入excel解析
     * @param file
     * @param types
     * @param size
     * @return
     * @throws Exception
     */
    public static List<List<Object>> importExcel(File file, List<String> types, Long size) throws Exception{
        return null;
    }

    /**
     * 导出excel
     * @param titleLists
     * @param sheets
     * @param dataLists
     * @return
     * @throws Exception
     */
    public static <T> HSSFWorkbook exportExcel(List<List<String>> titleLists, List<String> sheets, List<List<T>> dataLists, IPoiExcelExport<T> poiExcelExport, IPoiExcelStyle poiExcelStyle) throws Exception{
        if( FrameWorkCommon.isEmpty(poiExcelExport) ){
            throw new Exception("poiExcelExport不能为空");
        }
        HSSFWorkbook workbook = new HSSFWorkbook();
        if( FrameWorkCommon.isEmpty(sheets) ){
            if( sheets == null ) sheets = new ArrayList<>();
            sheets.add(0, "Sheet1");
        }
        ListManager.polishing(titleLists, sheets, dataLists);
        HSSFSheet sheet;
        HSSFRow row;
        HSSFCell cell;
        HSSFCellStyle cellStyle;
        int rowIndex, cellIndex;
        String sheetName, cellValue;
        for(int sheetIndex = 0; sheetIndex < sheets.size(); sheetIndex++){
            sheetName = sheets.get(sheetIndex);
            sheet = workbook.createSheet(sheetName);
            rowIndex = 0;
            /**
             * 获取头部信息
             */
            if( FrameWorkCommon.isNotEmpty(titleLists) ){
                List<String> titleList;
                if( titleLists.size() > sheetIndex ){
                    titleList = titleLists.get(sheetIndex);
                    if( FrameWorkCommon.isNotEmpty(titleList) ){
                        row = sheet.createRow(rowIndex);
                        cellIndex = 0;
                        for( String title: titleList ){
                            cell = row.createCell(cellIndex);
                            setColumnWith(poiExcelStyle, sheetIndex, rowIndex, cellIndex, sheet);
                            cellStyle = getCellStyle(poiExcelStyle, sheetIndex, rowIndex, cellIndex, workbook);
                            cell.setCellStyle(cellStyle);
                            cell.setCellValue( title );
                            cellIndex++;
                        }
                        rowIndex++;
                        /**
                         * 获取数据
                         */
                        if( FrameWorkCommon.isNotEmpty(dataLists) ){
                            List<T> tList;
                            if( dataLists.size() > sheetIndex ){
                                tList = dataLists.get(sheetIndex);
                                if( FrameWorkCommon.isNotEmpty(tList) ){
                                    for(T t : tList){
                                        row = sheet.createRow(rowIndex);
                                        cellIndex = 0;
                                        for(int i = 0; i < titleList.size(); i++){
                                            cell = row.createCell(cellIndex);
                                            cellStyle = getCellStyle(poiExcelStyle, sheetIndex, rowIndex, cellIndex, workbook);
                                            cellValue = getCellValue(poiExcelExport, sheetIndex, rowIndex, cellIndex, t);
                                            cell.setCellStyle(cellStyle);
                                            cell.setCellValue(cellValue);
                                            cellIndex++;
                                        }
                                        rowIndex++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return workbook;
    }

    private static HSSFCellStyle getCellStyle(IPoiExcelStyle poiExcelStyle, int sheetIndex, int rowIndex, int cellIndex, HSSFWorkbook workbook) throws Exception{
        if( poiExcelStyle == null ) return null;
        return poiExcelStyle.getStyle(sheetIndex, rowIndex, cellIndex, workbook);
    }

    private static <T> String getCellValue(IPoiExcelExport<T> poiExcelExport, int sheetIndex, int rowIndex, int cellIndex, T tData) throws Exception{
        String cellValue = poiExcelExport.getCellValue(sheetIndex, rowIndex, cellIndex, tData);
        if( cellValue == null ){
            cellValue = "";
        }
        return cellValue;
    }

    private static void setColumnWith(IPoiExcelStyle poiExcelStyle, int sheetIndex, int rowIndex, int cellIndex, HSSFSheet sheet) throws Exception{
        if( poiExcelStyle == null ) return;
        poiExcelStyle.setColumnWith(sheetIndex, rowIndex, cellIndex, sheet);
    }

}
