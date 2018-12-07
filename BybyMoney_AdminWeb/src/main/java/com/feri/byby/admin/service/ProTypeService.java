package com.feri.byby.admin.service;

import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.domain.product.Product;
import com.feri.byby.domain.protype.ProType;

/**
 *@Author feri
 *@Date Created in 2018/12/3 12:05
 */
public interface ProTypeService {
    R savePro(ProType proType);
    PageVo<ProType> queryAll();

}
