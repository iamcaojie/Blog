package com.imcaojie.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author caojie
 * @className PagedGrid
 * @description
 **/
@Data
public class PagedGrid  {

    private int page;

    private int pageSize;

    private int total;

    private long records;

    private List<?> rows;

}
