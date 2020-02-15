package com.tanjiu.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 叹久
 * @create 2020-02-14 20:55
 */
//国际化解析器
//写完以后要到视图解析器里面去添加bean
public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的语言参数链接
       String language= httpServletRequest.getParameter("l");
       Locale locale=Locale.getDefault();//如果没有就使用默认的
        //如果请求的链接携带了国际化的参数
        if(!StringUtils.isEmpty(language)){
            //zh_CN
           String[] split=language.split("_");//分割
            //国家、地区
            locale= new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
