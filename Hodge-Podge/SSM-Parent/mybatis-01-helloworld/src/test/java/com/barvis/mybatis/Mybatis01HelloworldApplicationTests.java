package com.barvis.mybatis;

import com.barvis.mybatis.bean.Emp;
import com.barvis.mybatis.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mybatis01HelloworldApplicationTests {

    @Autowired
    EmpMapper mapper;
    @Test
    void test01() {
        System.out.println("Emp = " + mapper.getEmpById(1));
    }

    @Test
    void testInsert(){
        Emp emp = new Emp();
        emp.setEmpName("张三00");
        emp.setAge(22);
        emp.setEmpSalary(9998.9);
        mapper.insertEmp(emp);

        System.out.println("emp = " + emp);
    }

}
