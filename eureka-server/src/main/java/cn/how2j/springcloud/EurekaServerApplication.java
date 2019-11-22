package cn.how2j.springcloud;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//这是一个 EurekaServer ，它扮演的角色是注册中心，用于注册各种微服务，以便于其他微服务找到和访问
@SpringBootApplication
@EnableEurekaServer//urekaServer 本身就是个 Springboot 微服务, 所以它有 @SpringBootApplication 注解。
public class EurekaServerApplication {
    public static void main(String[] args) {
        //8761 这个端口是默认的，就不要修改了，后面的子项目，都会访问这个端口。
        int port = 8080;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(EurekaServerApplication.class).properties("server.port=" + port).run(args);
    }
}
