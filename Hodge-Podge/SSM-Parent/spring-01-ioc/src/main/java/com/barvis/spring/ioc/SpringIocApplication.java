package com.barvis.spring.ioc;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.barvis.spring.ioc.bean.Person;
import com.barvis.spring.ioc.config.PersonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        // 1.1 这是一个 Spring Boot 应用程序的主类，名为 SpringIocApplication。下面是加上注释后的代码：
        ConfigurableApplicationContext ioc = SpringApplication.run(SpringIocApplication.class, args);
        System.out.println("IOC = " + ioc);
        System.out.println("====================");

        // 1.2 获取到容器中所有组件的名字；容器中装了哪些组件； Spring启动会有很多默认组件
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
        System.out.println("====================");
        // 1.4.1 通过名字和指定类型获取组件
        Person zhangsan = ioc.getBean("zhangsan", Person.class);
        System.out.println("zhangsan = " + zhangsan);
        System.out.println("====================");
        // 1.4.2 通过名字获取组件,需要强转类型
        Person zhangsan1 = (Person) ioc.getBean("zhangsan");
        System.out.println("zhangsan1 = " + zhangsan1);
        System.out.println("====================");
        // 1.4.3 通过@Bean中定义的名字获取组件
        Person lisi = ioc.getBean("haha", Person.class);
        System.out.println("lisi = " + lisi);
        System.out.println("====================");
        //1.4.4 通过类型获取所有组件
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println("beansOfType = " + beansOfType);
        System.out.println("====================");

        // Bean是单实例的
        System.out.println("zhangsan == zhangsan1 : " + (zhangsan == zhangsan1));
    }

    // 1.3 给容器中注册一个自己的组件； 容器中的每个组件都有自己的名字，方法名就是组件的名字
    @Bean
    public Person zhangsan() {
        return new Person("zhangsan", 18);
    }
    // 1.3.1 也可以通过@Bean("xxx")的方式给组件命名
    @Bean("haha")
    public Person lisi() {
        return new Person("lisi", 19);
    }




}
