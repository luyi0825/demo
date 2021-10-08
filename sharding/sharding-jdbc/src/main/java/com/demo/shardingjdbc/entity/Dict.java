package com.demo.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author luyi
 * 数据字典-广播表
 */
@TableName("t_dict")
public class Dict implements Serializable {
    /**
     * 数据字典的主键
     */
    @TableId
    private int dictId;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String caption;

    public int getDictId() {
        return dictId;
    }

    public void setDictId(int dictId) {
        this.dictId = dictId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
