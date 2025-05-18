package com.barvis.mybatis.mapper;

import com.barvis.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
    Emp getEmpById(Integer id);

    void insertEmp(Emp emp);
}
