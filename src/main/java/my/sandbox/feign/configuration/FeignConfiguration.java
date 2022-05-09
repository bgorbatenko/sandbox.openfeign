package my.sandbox.feign.configuration;

import my.sandbox.feign.clientSide.SimpleFeign;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {SimpleFeign.class})
@EnableAutoConfiguration
@RibbonClient(name = "restClient", configuration = {RibbonConfiguration.class})
public class FeignConfiguration {
}
