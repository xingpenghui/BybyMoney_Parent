package com.feri.byby.mapper.protype;
import com.feri.byby.domain.protype.AtrSet;

import java.util.List;

public interface AtrSetMapper {
    int insert(AtrSet record);
    List<AtrSet> selectAll();
    List<AtrSet> selectBtPtid(int ptid);
}