package com.iotcomm.core.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity
        implements Serializable
{
    @ApiModelProperty("主键")
    @TableId(type=IdType.UUID)
    private String id;
    @ApiModelProperty("创建人")
    @TableField(value="create_by", fill=FieldFill.INSERT)
    private String createBy;
    @ApiModelProperty("创建时间")
    @TableField(value="create_time", fill=FieldFill.INSERT)
    private Date createTime;
    @ApiModelProperty("修改人")
    @TableField(value="update_by", fill=FieldFill.UPDATE)
    private String updateBy;
    @ApiModelProperty("修改时间")
    @TableField(value="update_time", fill=FieldFill.UPDATE)
    private Date updateTime;
    @ApiModelProperty("删除人")
    @TableField(value="delete_by", fill=FieldFill.UPDATE)
    private String deleteBy;
    @ApiModelProperty("删除时间")
    @TableField(value="delete_time", fill=FieldFill.UPDATE)
    private Date deleteTime;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public void setDeleteBy(String deleteBy)
    {
        this.deleteBy = deleteBy;
    }

    public void setDeleteTime(Date deleteTime)
    {
        this.deleteTime = deleteTime;
    }

    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseEntity)) {
            return false;
        }
        BaseEntity other = (BaseEntity)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = getId();Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$createBy = getCreateBy();Object other$createBy = other.getCreateBy();
        if (this$createBy == null ? other$createBy != null : !this$createBy.equals(other$createBy)) {
            return false;
        }
        Object this$createTime = getCreateTime();Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime)) {
            return false;
        }
        Object this$updateBy = getUpdateBy();Object other$updateBy = other.getUpdateBy();
        if (this$updateBy == null ? other$updateBy != null : !this$updateBy.equals(other$updateBy)) {
            return false;
        }
        Object this$updateTime = getUpdateTime();Object other$updateTime = other.getUpdateTime();
        if (this$updateTime == null ? other$updateTime != null : !this$updateTime.equals(other$updateTime)) {
            return false;
        }
        Object this$deleteBy = getDeleteBy();Object other$deleteBy = other.getDeleteBy();
        if (this$deleteBy == null ? other$deleteBy != null : !this$deleteBy.equals(other$deleteBy)) {
            return false;
        }
        Object this$deleteTime = getDeleteTime();Object other$deleteTime = other.getDeleteTime();return this$deleteTime == null ? other$deleteTime == null : this$deleteTime.equals(other$deleteTime);
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof BaseEntity;
    }

    public int hashCode()
    {
        int PRIME = 59;int result = 1;Object $id = getId();result = result * 59 + ($id == null ? 43 : $id.hashCode());Object $createBy = getCreateBy();result = result * 59 + ($createBy == null ? 43 : $createBy.hashCode());Object $createTime = getCreateTime();result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());Object $updateBy = getUpdateBy();result = result * 59 + ($updateBy == null ? 43 : $updateBy.hashCode());Object $updateTime = getUpdateTime();result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());Object $deleteBy = getDeleteBy();result = result * 59 + ($deleteBy == null ? 43 : $deleteBy.hashCode());Object $deleteTime = getDeleteTime();result = result * 59 + ($deleteTime == null ? 43 : $deleteTime.hashCode());return result;
    }

    public String toString()
    {
        return "BaseEntity(id=" + getId() + ", createBy=" + getCreateBy() + ", createTime=" + getCreateTime() + ", updateBy=" + getUpdateBy() + ", updateTime=" + getUpdateTime() + ", deleteBy=" + getDeleteBy() + ", deleteTime=" + getDeleteTime() + ")";
    }

    public String getId()
    {
        return this.id;
    }

    public String getCreateBy()
    {
        return this.createBy;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public String getUpdateBy()
    {
        return this.updateBy;
    }

    public Date getUpdateTime()
    {
        return this.updateTime;
    }

    public String getDeleteBy()
    {
        return this.deleteBy;
    }

    public Date getDeleteTime()
    {
        return this.deleteTime;
    }
}
