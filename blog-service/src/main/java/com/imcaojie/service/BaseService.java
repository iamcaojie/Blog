package com.imcaojie.service;

import com.github.pagehelper.PageInfo;
import com.imcaojie.utils.PagedGrid;

import java.util.List;

/**
 * @author caojie
 * @className BaseService
 * @description
 **/
public class BaseService {

    public PagedGrid setPagedGrid(List<?> dataList, Integer page, Integer pageSize) {
        PageInfo<?> pageList = new PageInfo<>(dataList);
        PagedGrid grid = new PagedGrid();
        grid.setPage(page);
        grid.setPageSize(pageSize);
        grid.setRows(dataList);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }

}
