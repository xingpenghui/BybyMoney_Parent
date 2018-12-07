package com.feri.byby.mapper.protype;

import com.feri.byby.domain.protype.ProType;

import java.util.List;

public interface ProTypeMapper {
    int insert(ProType record);
    ProType selectById(Integer id);
    List<ProType> selectAll();
    List<ProType> selectByPid(int parentid);
    //查询所有的三级类型

    List<ProType> selectByLevel(int level);
}