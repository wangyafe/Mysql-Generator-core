package com.ys.test;

/**
 * @program: Mysql-Generator-core
 * @author: Bell
 * @create: 2020-04-23 16:11
 **/
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorTest {

    public void testGenerator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指向逆向工程配置文件
        File configFile = new File(GeneratorTest.class.getResource("/generatorConfig.xml").getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {
        try {
            GeneratorTest generator = new GeneratorTest();
            generator.testGenerator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}