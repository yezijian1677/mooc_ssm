package com.blogs.dao;

import com.blogs.pojo.SystemMessage;

public interface SystemMessageMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(SystemMessage record);

    int insertSelective(SystemMessage record);

    SystemMessage selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(SystemMessage record);

    int updateByPrimaryKeyWithBLOBs(SystemMessage record);

    int updateByPrimaryKey(SystemMessage record);
}