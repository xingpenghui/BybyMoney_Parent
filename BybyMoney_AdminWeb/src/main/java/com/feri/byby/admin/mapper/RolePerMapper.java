package com.feri.byby.admin.mapper;
import com.feri.byby.admin.domain.RolePer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
public interface RolePerMapper {
    @Delete("delete from t_roleper where rid=#{rid}")
    int deleteByRid(Integer rid);
    @Insert("insert into t_roleper (rid, pid) values (#{rid,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER})")
    int insert(RolePer record);
}