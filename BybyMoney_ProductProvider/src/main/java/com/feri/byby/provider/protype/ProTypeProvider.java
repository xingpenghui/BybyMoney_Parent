package com.feri.byby.provider.protype;

import com.alibaba.fastjson.JSON;
import com.feri.byby.common.constant.SystemCon;
import com.feri.byby.common.redis.JedisUtil;
import com.feri.byby.common.vo.PageBean;
import com.feri.byby.common.vo.ProTypeBean;
import com.feri.byby.common.vo.ProTypeVo;
import com.feri.byby.domain.protype.ProType;
import com.feri.byby.mapper.protype.ProTypeMapper;
import com.feri.byby.service.ProTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/12/7 09:50
 */
@Service
public class ProTypeProvider implements ProTypeService {
    @Autowired
    private ProTypeMapper mapper;
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public String queryIndex() {
        //查询Redis 有就返回
        if(jedisUtil.isKey(SystemCon.PROTYPES)){
            return jedisUtil.getStr(SystemCon.PROTYPES);
        }else{
            //如果Redis没有去Mysql中
            //查询MySql数据库 获取所有的三级类型和对应的所属的二级类型
            List<ProType> proTypes=mapper.selectByLevel(3);
            //查询所有的二级类型和对应的一级类型
            List<ProType> secondPts=mapper.selectByLevel(2);
            Map<Integer,Integer> ids=new LinkedHashMap<>();
            ProTypeBean bean=new ProTypeBean();
            bean.setCode(SystemCon.ROK);

            //获取当前系统的所有的二级类型和对应的三级类型
            List<Map<ProTypeVo,List<ProTypeVo>>> list=new ArrayList<>();

            int pid=0;//记录当前的一级类型的id
            //获取对应的一级类型和二级类型
            for(ProType pt:secondPts){
               if(pt.getParentid()!=pid){
                   list.add(new LinkedHashMap<>());
                   pid=pt.getParentid();
               }
               ProTypeVo proTypeVo=new ProTypeVo();
               proTypeVo.setId(pt.getId());
               proTypeVo.setName(pt.getTname());
               list.get(list.size()-1).put(proTypeVo,new ArrayList<>());
               ids.put(pt.getId(),list.size()-1);
            }
            //遍历所有的三级类型
            for(ProType pt :proTypes){
                ProTypeVo parentVo=new ProTypeVo();
                parentVo.setId(pt.getParentid());
                ProTypeVo vo=new ProTypeVo();
                vo.setId(pt.getId());
                vo.setName(pt.getTname());
                list.get(ids.get(pt.getParentid())).get(parentVo).add(vo);
            }
            bean.setProTypeVos(list);//设置整个类型
            //更新Redis
            String json= JSON.toJSONString(bean);
            jedisUtil.addStr(SystemCon.PROTYPES,json);
            //返回结果
            return json;
        }
    }
}
