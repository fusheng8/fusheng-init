package com.fusheng.init.model.common;

import lombok.Builder;
import lombok.Data;

/**
 * 分页查询DTO
 */
@Data
public class PageQueryDTO {
    /**
     * 第几页
     */
    private Integer currentPage;
    /**
     * 每页多少条
     */
    private Integer pageSize;

}
