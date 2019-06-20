package com.pengfei.utils.empty;

import com.pengfei.framework.FrameWorkCommon;

public final class EmptyUtils {

    public static <T> boolean isEmpty(T empty){
        return FrameWorkCommon.isEmpty(empty);
    }

    public static <T> boolean isNotEmpty(T empty){
        return FrameWorkCommon.isNotEmpty(empty);
    }

    public static <T> boolean isAndEmptys(T... emptys){
        if( isEmpty(emptys) ) return true;
        for(T empty : emptys){
            if( isNotEmpty(empty) ) return false;
        }
        return true;
    }

    public static <T> boolean isAndNotEmptys(T... emptys){
        if( isEmpty(emptys) ) return false;
        for(T empty : emptys){
            if( isEmpty(empty) ) return false;
        }
        return true;
    }

    public static <T> boolean isOrEmptys(T... emptys){
        if( isEmpty(emptys) ) return true;
        for(T empty : emptys){
            if( isEmpty(empty) ) return true;
        }
        return false;
    }

    public static <T> boolean isOrNotEmptys(T... emptys){
        if( isEmpty(emptys) ) return false;
        for(T empty : emptys){
            if( isNotEmpty(empty) ) return true;
        }
        return false;
    }

}
