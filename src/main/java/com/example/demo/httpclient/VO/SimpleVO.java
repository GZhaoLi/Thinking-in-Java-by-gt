package com.example.demo.httpclient.VO;

import lombok.Data;

@Data
public class SimpleVO {
    /**
     * 行号
     */
    private String rowNum;
    /**
     * 类型
     */
    private String type;
    /**
     * 返回的数据
     */
    private int beforeRowNum;
    /**
     * 返回的数据
     */
    private int beforeUseNum;
    /**
     * 文档类型，用来区分不同类型文档
     */
    private String documentId;

}
