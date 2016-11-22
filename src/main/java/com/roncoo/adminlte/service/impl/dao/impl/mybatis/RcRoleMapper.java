package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcRoleExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface RcRoleMapper {
    int countByExample(RcRoleExample example);

    int deleteByExample(RcRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcRole record);

    int insertSelective(RcRole record);

    List<RcRole> selectByExample(RcRoleExample example);

    RcRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcRole record, @Param("example") RcRoleExample example);

    int updateByExample(@Param("record") RcRole record, @Param("example") RcRoleExample example);

    int updateByPrimaryKeySelective(RcRole record);

    int updateByPrimaryKey(RcRole record);
}