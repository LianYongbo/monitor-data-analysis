package com.bdilab.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.dao",
        "com.bdilab.monitor.business.authorityManagement.roleInfoManagement.dao",
        "com.bdilab.monitor.business.userManagement.userInfoManagement.dao",
        "com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.dao",})
public class MonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }

}
