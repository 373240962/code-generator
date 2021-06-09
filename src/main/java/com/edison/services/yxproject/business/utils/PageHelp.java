package com.edison.services.yxproject.business.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edison.saas.common.framework.web.data.PageSearchRequest;

/**
 * PageHelp
 *
 * @author LiuLin
 * @since 2021-04-19
 */
public class PageHelp {

    public static <T> IPage<T> of(PageSearchRequest t) {

        Page<T> page = new Page<>(t.getPage() + 1, t.getLimit());
//        if (StrUtil.isNotBlank(t.getSortCondition())) {
//            //获取排序规则
//            List<SortCondition> conditions = JSON.parseArray(t.getSortCondition(), SortCondition.class);
//            List<String> ascs = conditions.stream()
//                    .filter(e -> e.getDirection().equals(SortCondition.SortDirection.ASC))
//                    .map(SortCondition::getProperty)
//                    .collect(Collectors.toList());
//
//            List<String> descs = conditions.stream()
//                    .filter(e -> e.getDirection().equals(SortCondition.SortDirection.DESC))
//                    .map(SortCondition::getProperty)
//                    .collect(Collectors.toList());
//
//            page.setDescs(descs);
//            page.setAscs(ascs);
//        }else {
//            page.setDesc("create_at");
//        }

        return page;
    }
}
