package com.example.demo.util;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

import java.util.List;

/**
 * 更新图表的标题
 */
public class PoiWordTitle {

    public void setBarTitle(CTChart ctChart, String title) {
        CTTitle ctTitle = ctChart.getTitle();
        CTTx ctTx = ctTitle.getTx();
        if (null != ctTx) {
            CTTextBody ctTextBody = ctTx.getRich();
            List<CTTextParagraph> ctTextParagraphslist = ctTextBody.getPList();
            CTTextParagraph ctTextParagraph1 = ctTextParagraphslist.get(0);
            List<CTRegularTextRun> ctRegularTextRunslist = ctTextParagraph1.getRList();
            ctRegularTextRunslist.get(0).setT(title);  // 设置标题
        }


    }
}
