package com.feri.byby.admin.mapper;
import com.feri.byby.admin.domain.AdminRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
public interface AdminRoleMapper {
    @Insert("insert into t_userrole(aid, rid) values ( #{aid,jdbcType=INTEGER}, #{rid,jdbcType=INTEGER})")
    int insert(AdminRole record);
    @Delete("delete from t_userrole where aid=#{aid}")
    int deleteByAid(int aid);
}