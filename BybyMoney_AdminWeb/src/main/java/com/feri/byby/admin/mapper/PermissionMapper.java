package com.feri.byby.admin.mapper;

import com.feri.byby.admin.domain.Permission;
import com.feri.byby.admin.domain.Admin;
import org.apache.ibatis.annotations.*;
import java.util.List;
public interface PermissionMapper {
    @Insert("insert into t_permission (name, pers, parentid, icon, type,  createdate) values (#{name,jdbcType=VARCHAR}, #{pers},  #{parentid,jdbcType=INTEGER}, #{icon,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, now())")
    @Options(useGeneratedKeys = true)
    int insert(Permission record);

    @Select("select * from t_permission where id=#{id}")
    Permission selectById(Integer id);

    //查询用户的权限
    @Select("select p.pers from t_permission p left join t_roleper rp on p.id=rp.pid left join t_adminrole ar on rp.rid=ar.rid where ar.aid=#{id}")
    @ResultType(String.class)
    List<String> selectByAid(int id);

    @Select("select * from t_permission limit #{index},#{count}")
    @ResultType(Permission.class)
    List<Permission> selectByPage(@Param("index") int index, @Param("count") int count);

    @Select("select COUNT(*) from t_permission")
    @ResultType(long.class)
    long selectCount();

    @Select("select p.* from  t_permission p left join  t_roleper rp on p.id=rp.pid left join  t_adminrole ar on ar.rid=rp.rid  left join  t_admin a on ar.aid=a.id where p.type=1 and a.id=#{id} order by p.parentid,p.id")
    @ResultType(Permission.class)
    List<Permission> selectByMenuAid(int id);

    @Select(" select * from t_permission where type=1 and parentid=-1 order by id")
    @ResultType(Permission.class)
    List<Permission> selectByPid();


}