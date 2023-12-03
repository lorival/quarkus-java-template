package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.InterfaceToImplementationMapService;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class ApplicationServicesBeanRegistration implements BeanFactoryPostProcessor {

  private static final String PACKAGE_NAME =
      "br.com.lorival.reactivejavatemplate.app.applicationservices";
  private static final String INTERFACE_SUFFIX = "ApplicationService";

  @Override
  public void postProcessBeanFactory(@NonNull ConfigurableListableBeanFactory beanFactory)
      throws BeansException {

    for (Map.Entry<Class<?>, Class<?>> entry :
        InterfaceToImplementationMapService.getMap(PACKAGE_NAME, INTERFACE_SUFFIX).entrySet()) {
      Class<?> serviceInterface = entry.getKey();
      Class<?> implementation = entry.getValue();

      BeanDefinitionBuilder beanDefinitionBuilder =
          BeanDefinitionBuilder.genericBeanDefinition(implementation);
      ((BeanDefinitionRegistry) beanFactory)
          .registerBeanDefinition(
              serviceInterface.getSimpleName(), beanDefinitionBuilder.getBeanDefinition());
    }
  }
}
