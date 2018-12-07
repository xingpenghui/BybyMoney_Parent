package com.feri.byby.mapper.product;

import com.feri.byby.domain.product.RepSKU;

import java.util.List;

public interface RepSKUMapper {

    int insert(RepSKU record);

    List<RepSKU> selectByPsid(Integer psid);

}