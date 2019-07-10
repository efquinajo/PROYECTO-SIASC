package com.comvetlp.bo.siasc.util;

/**
 * MC4
 * La Paz - Bolivia
 * EDV - JBPM
 * 04/07/2017 - 2:27 PM
 * Created by: vtorrez
 */
public class BooleanUtils {

    public static final String SI="SI";
    public static final String NO="NO";

    public static boolean fromJbpmBooleanToBoolean(String valor){
        if(StringUtil.isEmptyOrNull(valor)){
            return false;
        }
        if(valor.equals(SI)){
            return true;
        }
        return false;
    }

    public static String getLabel(boolean valor){
        if(valor){
            return SI;
        }
        else {
            return NO;
        }
    }

}
