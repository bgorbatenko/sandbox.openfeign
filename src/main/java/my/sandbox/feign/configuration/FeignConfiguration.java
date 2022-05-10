package my.sandbox.feign.configuration;

import feign.Logger;
import feign.codec.Encoder;
import my.sandbox.feign.clientSide.PageableFeign;
import my.sandbox.feign.clientSide.SimpleFeign;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.PageJacksonModule;
import org.springframework.cloud.openfeign.support.PageableSpringEncoder;
import org.springframework.cloud.openfeign.support.SortJacksonModule;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.Module;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {SimpleFeign.class, PageableFeign.class})
@EnableAutoConfiguration
@RibbonClient(name = "restClient", configuration = {RibbonConfiguration.class})
public class FeignConfiguration {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public PageJacksonModule pageJacksonModule() {
        return new PageJacksonModule();
    }

    @Bean
    public Module sortJacksonModule() {
        return new SortJacksonModule();
    }

    @Bean
    public Encoder feignEncoder() {
        return new PageableSpringEncoder(new SpringEncoder(messageConverters));
    }

}
