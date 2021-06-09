package com.edison.services.yxproject.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author gonghongrui on 2018/4/17.
 */
@Data
public abstract class BaseEntity<T extends Model> extends Model<T> {

    public static final String PROPERTY_CREATE_AT = "createAt";
    public static final String PROPERTY_CREATE_UID = "createUid";
    public static final String PROPERTY_MODIFY_AT = "modifyAt";
    public static final String PROPERTY_MODIFY_UID = "modifyUid";

    @ApiModelProperty(value = "创建者", hidden = true, example = "1")
    protected Long createUid;

    @TableField(value = "create_at",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", hidden = true, example = "1556161331067")
    protected Date createAt;

    @ApiModelProperty(value = "更新者", hidden = true, example = "1")
    protected Long modifyUid;

    @TableField(value = "modify_at", update = "now()")
    @ApiModelProperty(value = "更新时间", hidden = true, example = "1556161331067")
    protected Date modifyAt;

}
