package com.applets.university.common.dto;

import lombok.Setter;

import java.util.Objects;

/**
 * @auther shw
 * @date 2021/8/10
 */
@Setter
public class PageDto {

    private Integer pageNum;

    private Integer pageSize;

    public Integer getPageNum() {
        if (Objects.isNull(pageNum)) {
            return 1;
        }
        return pageNum;
    }

    public Integer getPageSize() {
        if (Objects.isNull(pageSize)) {
            return 10;
        }
        return pageSize;
    }
}
