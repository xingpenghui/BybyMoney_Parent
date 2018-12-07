package com.feri.byby.mapper.product;

import com.feri.byby.domain.product.ProLog;

import java.util.List;

public interface ProLogMapper {

    int insert(ProLog record);

    List<ProLog> selectByPid(Integer pid);
}