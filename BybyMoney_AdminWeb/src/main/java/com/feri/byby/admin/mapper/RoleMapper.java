package com.feri.byby.admin.mapper;
import com.feri.byby.admin.domain.Permission;
import com.feri.byby.admin.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Insert(" insert into t_role (rname, rinfo) values ( #{rname,jdbcType=VARCHAR}, #{rinfo,jdbcType=VARCHAR})")
    int insert(Role record);
    @Select("select * from t_role limit #{index},#{count}")
    @ResultType(Role.class)
    List<Role> selectByPage(@Param("index") int index, @Param("count") int count);

    @Select("select COUNT(*) from t_role")
    @ResultType(long.class)
    long selectCount();

    @Select("select * from t_role")
    @ResultType(long.class)
    List<Role> selectAll();
    @Select("select rid from t_adminrole where aid=#{aid}")
    @ResultType(Integer.class)
    List<Integer> selectByAid(int aid);
}