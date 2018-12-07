package com.feri.byby.mapper.product;

import com.feri.byby.domain.product.ProSKU;

import java.util.List;

public interface ProSKUMapper {

    int insert(ProSKU record);

    List<ProSKU> selectByPid(Integer id);

}