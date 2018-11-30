package com.feri.byby.admin.mapper;

import com.feri.byby.admin.domain.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface AdminMapper {

    @Insert("insert into t_admin (phone, username, password, createtime, flag) values ( #{phone}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, now(), 1)")
    int insert(Admin record);

    @Select("select * from t_admin where phone=#{name} or username =#{name} and flag=1")
    @ResultType(Admin.class)
    Admin selectByName(String name);

    @Update("update t_admin set password=#{newpass} where id=#{uid} and password=#{oldpass}")
    int updatePass(@Param("aid") int aid, @Param("oldpass") String oldpass, @Param("newpass") String newPass);

    //查询数量
    @Select("select COUNT(*) from t_admin where flag=#{flag}")
    @ResultType(long.class)
    long selectCount(int flag);

    //分页查询
    @Select("select * from t_admin where flag=#{flag} order by createtime desc limit #{index},#{count}")
    @ResultType(Admin.class)
    List<Admin> selectByPage(@Param("index") int index, @Param("count") int count, @Param("flag") int flag);
}