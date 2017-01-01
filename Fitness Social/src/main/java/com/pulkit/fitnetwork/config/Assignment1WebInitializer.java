package com.pulkit.fitnetwork.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class Assignment1WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }


  /**
   * Spring web configuration class
   * @return
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  /**
   * For mapping dispatcher servlet
   * @return
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }
}