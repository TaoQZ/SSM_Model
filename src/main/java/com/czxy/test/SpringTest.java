package com.czxy.test;

import com.czxy.config.MyBatisConfig;
import com.czxy.config.SpringConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author :almostTao
 * @date :Created in 2019/6/24 15:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, MyBatisConfig.class})
public class SpringTest {


}
