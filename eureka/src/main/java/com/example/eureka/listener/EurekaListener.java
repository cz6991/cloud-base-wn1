package com.example.eureka.listener;

import com.example.commonresource.entity.TextEmailEntity;
import com.example.eureka.feign.MessageFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EurekaListener {

    @Autowired
    MessageFeign messageFeign;


    @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        String appName = event.getAppName();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(appName.equalsIgnoreCase("user")){
            //发邮件通知管理员
            messageFeign.sendTextMail(TextEmailEntity.setToAndText("783577172@qq.com","服务下线通知"));
        }

        System.out.println("服务下线通知：服务名称"+appName+
                "实例ID："+event.getServerId()+
                "下线时间："+simpleDateFormat.format(new Date(event.getTimestamp())));
    }


    @EventListener
    public void listen2 (EurekaInstanceRegisteredEvent event){
        System.out.println("服务注册通知：服务名称"+event.getInstanceInfo().getAppName()+
                "实例ID："+event.getInstanceInfo().getId()+
                "其他参数"+event.getInstanceInfo().toString());

    }

    @EventListener
    public void listen3(EurekaInstanceRenewedEvent event){
        System.out.println("续约通知"+event.toString());
    }


    @EventListener
    public void listen4(EurekaRegistryAvailableEvent event){
        System.out.println("注册中心启动通知"+event.toString());
    }

}
