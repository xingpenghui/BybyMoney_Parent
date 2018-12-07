package com.feri.byby.mapper.protype;

import com.feri.byby.domain.protype.ProTypeSKU;

import java.util.List;

public interface ProTypeSKUMapper {
    int insert(ProTypeSKU record);

    List<ProTypeSKU> selectByPtid(Integer ptid);

}