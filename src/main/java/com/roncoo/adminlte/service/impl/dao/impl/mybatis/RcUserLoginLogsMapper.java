package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.RcUserLoginLogs;
import com.roncoo.adminlte.bean.entity.RcUserLoginLogsExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface RcUserLoginLogsMapper {
    int countByExample(RcUserLoginLogsExample example);

    int deleteByExample(RcUserLoginLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcUserLoginLogs record);

    int insertSelective(RcUserLoginLogs record);

    List<RcUserLoginLogs> selectByExample(RcUserLoginLogsExample example);

    RcUserLoginLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcUserLoginLogs record, @Param("example") RcUserLoginLogsExample example);

    int updateByExample(@Param("record") RcUserLoginLogs record, @Param("example") RcUserLoginLogsExample example);

    int updateByPrimaryKeySelective(RcUserLoginLogs record);

    int updateByPrimaryKey(RcUserLoginLogs record);
}