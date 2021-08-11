package com.example.demo.util;

import org.openxmlformats.schemas.drawingml.x2006.main.STSchemeColorVal;

import java.util.ArrayList;
import java.util.List;

/**
 * 官方对于颜色的解释： http://poi.apache.org/apidocs/dev/org/apache/poi/sl/draw/binding/STSchemeColorVal.html
 */
public final class STSchemeColorValTools {
    static List<STSchemeColorVal.Enum> colorEnum = new ArrayList<>();

    static {
//        colorEnum.add(STSchemeColorVal.BG_1);
//        colorEnum.add(STSchemeColorVal.BG_2);
//        colorEnum.add(STSchemeColorVal.TX_1);
//        colorEnum.add(STSchemeColorVal.TX_2);
        colorEnum.add(STSchemeColorVal.ACCENT_1);
        colorEnum.add(STSchemeColorVal.ACCENT_2);
        colorEnum.add(STSchemeColorVal.ACCENT_3);
        colorEnum.add(STSchemeColorVal.ACCENT_4);
        colorEnum.add(STSchemeColorVal.ACCENT_5);
        colorEnum.add(STSchemeColorVal.ACCENT_6);
//        colorEnum.add(STSchemeColorVal.HLINK);
//        colorEnum.add(STSchemeColorVal.FOL_HLINK);
//        colorEnum.add(STSchemeColorVal.PH_CLR);
//        colorEnum.add(STSchemeColorVal.DK_1);
//        colorEnum.add(STSchemeColorVal.DK_2);
//        colorEnum.add(STSchemeColorVal.LT_1);
//        colorEnum.add(STSchemeColorVal.LT_2);
    }

    public static STSchemeColorVal.Enum get(int i){
        return colorEnum.get(i);
    }
}






















