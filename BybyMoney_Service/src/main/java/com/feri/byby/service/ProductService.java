package com.feri.byby.service;

import com.feri.byby.common.vo.ProductVo;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/12/7 15:05
 */
public interface ProductService {
    //查询
    List<ProductVo> queryNew();
    List<ProductVo> queryCx();
    List<ProductVo> queryRx();


}
