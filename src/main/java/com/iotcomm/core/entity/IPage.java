package com.iotcomm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value="分页对象", description="分页对象")
public class IPage<T>
        implements Serializable
{
    @ApiModelProperty("列表")
    private List<T> records;
    @ApiModelProperty("总个数")
    private long total;
    @ApiModelProperty("每页个数")
    private long size;
    @ApiModelProperty("当前页码")
    private long current;
    @ApiModelProperty("总页数")
    private long pages;

    public void setRecords(List<T> records)
    {
        this.records = records;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public void setCurrent(long current)
    {
        this.current = current;
    }

    public void setPages(long pages)
    {
        this.pages = pages;
    }

    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IPage)) {
            return false;
        }
        IPage<?> other = (IPage)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$records = getRecords();Object other$records = other.getRecords();
        if (this$records == null ? other$records != null : !this$records.equals(other$records)) {
            return false;
        }
        if (getTotal() != other.getTotal()) {
            return false;
        }
        if (getSize() != other.getSize()) {
            return false;
        }
        if (getCurrent() != other.getCurrent()) {
            return false;
        }
        return getPages() == other.getPages();
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof IPage;
    }

    public int hashCode()
    {
        int PRIME = 59;int result = 1;Object $records = getRecords();result = result * 59 + ($records == null ? 43 : $records.hashCode());long $total = getTotal();result = result * 59 + (int)($total >>> 32 ^ $total);long $size = getSize();result = result * 59 + (int)($size >>> 32 ^ $size);long $current = getCurrent();result = result * 59 + (int)($current >>> 32 ^ $current);long $pages = getPages();result = result * 59 + (int)($pages >>> 32 ^ $pages);return result;
    }

    public String toString()
    {
        return "IPage(records=" + getRecords() + ", total=" + getTotal() + ", size=" + getSize() + ", current=" + getCurrent() + ", pages=" + getPages() + ")";
    }

    public List<T> getRecords()
    {
        return this.records;
    }

    public long getTotal()
    {
        return this.total;
    }

    public long getSize()
    {
        return this.size;
    }

    public long getCurrent()
    {
        return this.current;
    }

    public long getPages()
    {
        return this.pages;
    }
}
