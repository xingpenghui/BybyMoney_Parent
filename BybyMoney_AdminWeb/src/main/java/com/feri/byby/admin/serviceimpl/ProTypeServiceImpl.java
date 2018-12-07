package com.feri.byby.admin.serviceimpl;

import com.feri.byby.admin.common.RUtil;
import com.feri.byby.admin.service.ProTypeService;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import com.feri.byby.domain.protype.ProType;
import com.feri.byby.mapper.protype.ProTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *@Author feri
 *@Date Created in 2018/12/3 12:10
 */
@Service
public class ProTypeServiceImpl implements ProTypeService {
    @Autowired
    private ProTypeMapper proTypeMapper;
    @Override
    public R savePro(ProType proType) {
        return RUtil.setRes(proTypeMapper.insert(proType));
    }
    @Override
    public PageVo<ProType> queryAll() {
        List<ProType>proTypes=proTypeMapper.selectAll();
        return PageVo.createPage(proTypes,proTypes.size());
    }
}