package ru.luboshnikov.springMVC_Hibernate.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


import javax.servlet.*;
import java.util.EnumSet;


public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                AppConfig.class
        };
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }


    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    @Override
    public void onStartup (ServletContext aSrvletContext) throws ServletException {
        super.onStartup(aSrvletContext);
        registerCharacterEncodingFilter(aSrvletContext);
        registerHiddenFieldFilter(aSrvletContext);
    }

    private void registerCharacterEncodingFilter(ServletContext aSrvletContext) {
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic characterEncoding = aSrvletContext.addFilter("characterEncoding", characterEncodingFilter);
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
    }
    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null,true,"/*");
    }
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        return new Filter[]{characterEncodingFilter};
    }
    
}