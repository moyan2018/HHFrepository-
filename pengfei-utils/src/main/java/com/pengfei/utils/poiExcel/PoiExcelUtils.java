package com.pengfei.utils.poiExcel;

import com.pengfei.framework.poiExcel.IPoiExcelExport;
import com.pengfei.framework.poiExcel.IPoiExcelStyle;
import com.pengfei.framework.poiExcel.PoiExcelManager;
import com.pengfei.utils.empty.EmptyUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class PoiExcelUtils {

    private PoiExcelUtils() {

    }

    public static List<List<Object>> importExcel(File file, List<String> types, Long size) throws Exception {
        return PoiExcelManager.importExcel(file, types, size);
    }

    public static <T> HSSFWorkbook exportExcel(List<List<String>> titleLists, List<String> sheets, List<List<T>> dataLists, IPoiExcelExport<T> poiExcelExport, IPoiExcelStyle poiExcelStyle) throws Exception {
        return PoiExcelManager.exportExcel(titleLists, sheets, dataLists, poiExcelExport, poiExcelStyle);
    }

    public static <T> HSSFWorkbook exportExcel(List<String> titleList, String sheetName, List<T> dataList, IPoiExcelExport<T> poiExcelExport, IPoiExcelStyle poiExcelStyle) throws Exception {
        List<List<String>> titleLists = new ArrayList<>();
        titleLists.add( titleList );
        List<String> sheets = new ArrayList<>();
        sheets.add( sheetName );
        List<List<T>> dataLists = new ArrayList<>();
        dataLists.add( dataList );
        return PoiExcelManager.exportExcel(titleLists, sheets, dataLists, poiExcelExport, poiExcelStyle);
    }

    public static <T> HSSFWorkbook exportExcel(String[] titles, List<String> sheets, List<List<T>> dataLists, IPoiExcelExport<T> poiExcelExport, IPoiExcelStyle poiExcelStyle) throws Exception {
        List<List<String>> titleLists = new ArrayList<>();
        List<String> titleList = null;
        if(EmptyUtils.isNotEmpty(titles)){
            titleList = new ArrayList<>();
            for(String title : titles){
                titleList.add( title );
            }
        }
        titleLists.add( titleList );
        return PoiExcelManager.exportExcel(titleLists, sheets, dataLists, poiExcelExport, poiExcelStyle);
    }

    public static <T> HSSFWorkbook exportExcel(String[] titles, String[] sheetNames, List<List<T>> dataLists, IPoiExcelExport<T> poiExcelExport, IPoiExcelStyle poiExcelStyle) throws Exception {
        List<List<String>> titleLists = new ArrayList<>();
        List<String> titleList = null;
        if(EmptyUtils.isNotEmpty(titles)){
            titleList = new ArrayList<>();
            for(String title : titles){
                titleList.add( title );
            }
        }
        titleLists.add( titleList );
        List<String> sheets = new ArrayList<>();
        if ( EmptyUtils.isNotEmpty(sheetNames) ){
            for(String sheetName : sheetNames){
                sheets.add(sheetName);
            }
        }
        return PoiExcelManager.exportExcel(titleLists, sheets, dataLists, poiExcelExport, poiExcelStyle);
    }

    public static <T> HSSFWorkbook exportExcel(String[] titles, String sheetName, List<T> dataList, IPoiExcelExport<T> poiExcelExport, IPoiExcelStyle poiExcelStyle) throws Exception {
        List<List<String>> titleLists = new ArrayList<>();
        List<String> titleList = null;
        if(EmptyUtils.isNotEmpty(titles)){
            titleList = new ArrayList<>();
            for(String title : titles){
                titleList.add( title );
            }
        }
        titleLists.add( titleList );
        List<String> sheets = new ArrayList<>();
        sheets.add( sheetName );
        List<List<T>> dataLists = new ArrayList<>();
        dataLists.add( dataList );
        return PoiExcelManager.exportExcel(titleLists, sheets, dataLists, poiExcelExport, poiExcelStyle);
    }
}
