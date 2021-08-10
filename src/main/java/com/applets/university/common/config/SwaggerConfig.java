package com.applets.university.common.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger配置类
 *
 * @author sun
 * @date 2021/1/25 6:54 下午
 */
@Configuration
@EnableOpenApi
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfig implements InitializingBean {
    /** 各服务的名称和说明 */
    private String[] services = {"trade-二手交易","sys-系统"};

    @Autowired
    private ApplicationContext applicationContext;

    private ApiInfo apiInfo(String descr){
        return new ApiInfoBuilder()
                .title(descr)
                .description("高校小程序 - "+descr+"服务")
                .version("1.0")
                .build();
    }

    /**
     * 创建接口文档
     * @param name 服务英文名
     * @param descr 服务中文说明
     * @return
     */
    private Docket createDocket(String name, String descr){
        descr += "接口";
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo(descr))
                //分组名称
                .groupName(descr)
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.applets.university."+name+".controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 根据设置的services动态创建所有的接口bean
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // 动态注入bean
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        if(autowireCapableBeanFactory instanceof DefaultListableBeanFactory){
            DefaultListableBeanFactory capableBeanFactory = (DefaultListableBeanFactory) autowireCapableBeanFactory;
            for (String service : services) {
                String[] serviceArr = service.split("-");
                String serviceName = serviceArr[0];
                String serviceDesc = serviceArr[1];
                System.out.println(serviceName + " " + serviceDesc);
                AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().setFactoryMethodOnBean("createDocket", "swaggerConfig")
                        .addConstructorArgValue(serviceName)
                        .addConstructorArgValue(serviceDesc)
                        .getBeanDefinition();
                capableBeanFactory.registerBeanDefinition(serviceName, beanDefinition);
            }
        }
    }
}