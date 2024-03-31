package com.demo.elasticsearch.entity;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.io.Serializable;


@Data
public class Product implements Serializable {



    private String productName;

    private String productCode;

    /**
     * 备注
     */
    private String remark;


}
