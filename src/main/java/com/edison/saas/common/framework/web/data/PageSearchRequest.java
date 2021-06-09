package com.edison.saas.common.framework.web.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by gonghongrui on 16/10/25.
 */
@Getter
@Setter
@ApiModel(description = "分页查询请求")
public class PageSearchRequest<T>  {

//	@ApiParam(value = "")
	@ApiModelProperty(value = "请求的页码", example="0")
	private Integer page;
	@ApiModelProperty(value = "每页数据量", example = "10", allowEmptyValue = false)
	private Integer limit;
	@ApiModelProperty(value = "快速查询条件,目前没用处", example = "xxx", allowEmptyValue = true)
	private String query;
	@ApiModelProperty(value = "具体的查询条件")
	T searchCondition;
//	@ApiParam(value = "排序条件", defaultValue = "{\"property\":\"code\"}")
	@ApiModelProperty(value = "排序条件", example = "[{\"property\":\"id\"}]")
	private String sortCondition;

	public Integer getPage() {
		return page==null?0:this.page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit==null?10:limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}


}

