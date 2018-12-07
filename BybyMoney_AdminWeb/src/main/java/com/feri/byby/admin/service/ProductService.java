package com.feri.byby.admin.service;

import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.domain.product.Product;

/**
 *@Author feri
 *@Date Created in 2018/12/3 12:07
 */
public interface ProductService {
    R savePro(Product product);
    PageVo<Product> queryByPage(int page,int limit);
}
