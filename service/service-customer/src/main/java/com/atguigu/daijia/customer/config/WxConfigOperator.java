package com.atguigu.daijia.customer.config;

import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import me.chanjar.weixin.common.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class WxConfigOperator {
    @Autowired
    private WxConfigProperties wxConfigProperties;

    @Bean
    private WxService wxService(){
        WxMaDefaultConfigImpl wxMaDefaultConfig = new WxMaDefaultConfigImpl();
        wxMaDefaultConfig.setAppid(wxConfigProperties.getAppId());
        wxMaDefaultConfig.setSecret(wxConfigProperties.getSecret());


        WxMaServiceImpl wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(wxMaDefaultConfig);
        return wxMaService;
    }
}
