package com.feri.byby.admin.service;

import com.feri.byby.admin.vo.R;
import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.domain.product.ProPriceSKU;
import com.feri.byby.domain.product.ProSKU;
import com.feri.byby.domain.product.RepSKU;

/**
 *@Author feri
 *@Date Created in 2018/12/3 12:06
 */
public interface SKUService {
    R savePriSKU(ProPriceSKU sku);
    R saveRepSKU(RepSKU sku);
    R saveProSKU(ProSKU sku);
}
