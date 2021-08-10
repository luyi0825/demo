package com.example.mybaitsfluent.code.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import cn.org.atool.fluent.mybatis.functions.TableSupplier;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * TAuthUserEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@FluentMybatis(
    table = "t_auth_user"
)
public class TAuthUserEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @TableId(
      value = "id",
      auto = false
  )
  private Long id;

  /**
   * 错误次数
   */
  @TableField("error_count")
  private Integer errorCount;

  /**
   * 最后登录IP
   */
  @TableField("last_login_ip")
  private String lastLoginIp;

  /**
   * 最后登录时间
   */
  @TableField("last_login_time")
  private Date lastLoginTime;

  /**
   * 邮件
   */
  @TableField("mail")
  private String mail;

  /**
   * 密码
   */
  @TableField("password")
  private String password;

  /**
   * 用户名
   */
  @TableField("username")
  private String username;

  @Override
  public Serializable findPk() {
    return this.id;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return TAuthUserEntity.class;
  }

  @Override
  public final TAuthUserEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final TAuthUserEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
