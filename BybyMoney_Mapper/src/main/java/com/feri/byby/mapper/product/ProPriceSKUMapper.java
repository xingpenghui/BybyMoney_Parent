package com.feri.byby.mapper.product;

import com.feri.byby.domain.product.ProPriceSKU;

import java.util.List;

public interface ProPriceSKUMapper {
    int insert(ProPriceSKU record);

    List<ProPriceSKU> selectByPid(Integer pid);

    ProPriceSKU selectByPsid(int psid);
}