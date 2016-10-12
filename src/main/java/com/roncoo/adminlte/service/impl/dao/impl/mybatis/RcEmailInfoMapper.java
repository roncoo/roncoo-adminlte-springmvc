package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.bean.entity.RcEmailInfoExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface RcEmailInfoMapper {
    int countByExample(RcEmailInfoExample example);

    int deleteByExample(RcEmailInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcEmailInfo record);

    int insertSelective(RcEmailInfo record);

    List<RcEmailInfo> selectByExample(RcEmailInfoExample example);

    RcEmailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcEmailInfo record, @Param("example") RcEmailInfoExample example);

    int updateByExample(@Param("record") RcEmailInfo record, @Param("example") RcEmailInfoExample example);

    int updateByPrimaryKeySelective(RcEmailInfo record);

    int updateByPrimaryKey(RcEmailInfo record);
}