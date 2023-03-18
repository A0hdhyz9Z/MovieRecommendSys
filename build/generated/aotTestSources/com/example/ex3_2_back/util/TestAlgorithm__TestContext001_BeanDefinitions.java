package com.example.ex3_2_back.util;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TestAlgorithm}
 */
public class TestAlgorithm__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'testAlgorithm'
   */
  public static BeanDefinition getTestAlgorithmBeanDefinition() {
    Class<?> beanType = TestAlgorithm.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(TestAlgorithm::new);
    return beanDefinition;
  }
}
