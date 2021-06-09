package com.edison.services.yxproject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.edison.services.yxproject.common.BaseEntity;
import com.sun.javafx.PlatformUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CodeGenerator {
    /**
     * 代码生成位置
     */
    public static final String PARENT_NAME = "com.edison.services.yxproject.business" ;

    /**
     * modular 名字
     */
    public static final String MODULAR_NAME = "" ;

    /**
     * 基本路径
     */
    public static final String SRC_MAIN_JAVA = "src/main/java/" ;

    /**
     * 作者
     */
    public static final String AUTHOR = "LiuLin" ;

    /**
     * 是否是 rest 接口
     */
    private static final boolean REST_CONTROLLER_STYLE = true;

    public static final String JDBC_MYSQL_URL = "jdbc:mysql://192.168.200.181:3306/edison-yxproject" +
            "?useSSL=false&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8&allowMultiQueries=true" ;

    public static final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver" ;

    public static final String JDBC_USERNAME = "devcoder" ;

    public static final String JDBC_PASSWORD = "Devcoder@gxtY__2019!@#" ;

    public static void main(String[] args) {
        String moduleName = scanner("模块名");
//        String tableName = scanner("表名");
        String tableName = moduleName;
//        String tablePrefix = scanner("表前缀(无前缀输入#)").replaceAll("#", "");
        String tablePrefix = "" ;
        autoGenerator(moduleName, tableName, tablePrefix);
    }

    public static void autoGenerator(String moduleName, String tableName, String tablePrefix) {
        new AutoGenerator()
                .setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setPackageInfo(getPackageConfig(moduleName))
                .setStrategy(getStrategyConfig(tableName, tablePrefix))
                .setCfg(getInjectionConfig(moduleName))
                .setTemplate(getTemplateConfig())
                .execute();
    }

    private static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDate.format(formatter);
    }

    private static InjectionConfig getInjectionConfig(final String moduleName) {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map map = new HashMap();
                map.put("dateTime", getDateTime());
                map.put("myPackage", PARENT_NAME);
                setMap(map);
                final String projectPath = System.getProperty("user.dir");
                List<FileOutConfig> fileOutConfigList = new ArrayList<FileOutConfig>();
                // 自定义配置会被优先输出
                fileOutConfigList.add(new FileOutConfig("/templates/vo.java.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
                        return projectPath + "/" + SRC_MAIN_JAVA + "/" + PARENT_NAME.replace(".","/") +  "/vo"
                                 + "/" + tableInfo.getEntityName() + "VO" + StringPool.DOT_JAVA;
                    }
                });
                fileOutConfigList.add(new FileOutConfig("/templates/dto.java.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
                        return projectPath + "/"  + SRC_MAIN_JAVA + "/" + PARENT_NAME.replace(".","/") +  "/dto"
                                 + "/" + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
                    }
                });
                fileOutConfigList.add(new FileOutConfig("/templates/client.java.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
                        return projectPath + "/"  + SRC_MAIN_JAVA + "/" + PARENT_NAME.replace(".","/") +  "/client"
                                + "/" + tableInfo.getEntityName() + "Client" + StringPool.DOT_JAVA;
                    }
                });
                setFileOutConfigList(fileOutConfigList);
            }
        };
    }


    private static StrategyConfig getStrategyConfig(String tableName, String tablePrefix) {
        return new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableName.split(StringPool.COMMA))
                .setRestControllerStyle(REST_CONTROLLER_STYLE)
                .setEntityBuilderModel(true)
                .setControllerMappingHyphenStyle(true)
                .entityTableFieldAnnotationEnable(true)
                .setEntityLombokModel(true)
                .setSuperEntityClass(BaseEntity.class.getName())
                .setSuperEntityColumns("create_at","modify_at","modify_uid","create_uid")
                .setLogicDeleteFieldName("deleted")
                .setTablePrefix(tablePrefix + "_");
    }

    private static PackageConfig getPackageConfig(String moduleName) {
        return new PackageConfig()
//                .setModuleName(moduleName.replaceAll(StringPool.UNDERSCORE,""))
                .setParent(PARENT_NAME)
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller")
                .setEntity("entity");
    }

    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setUrl(JDBC_MYSQL_URL)
                .setDriverName(JDBC_DRIVER_NAME)
                .setUsername(JDBC_USERNAME)
                .setPassword(JDBC_PASSWORD);
    }

    private static GlobalConfig getGlobalConfig() {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/" + MODULAR_NAME + SRC_MAIN_JAVA;
        if (PlatformUtil.isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setDateType(DateType.ONLY_DATE)
                .setIdType(IdType.UUID)
                .setAuthor(AUTHOR)
                .setBaseColumnList(true)
                .setSwagger2(true)
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setActiveRecord(true)
                .setOpen(false);
    }

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("/templates/controller.java.vm")
                .setService("/templates/service.java.vm")
                .setServiceImpl("/templates/serviceImpl.java.vm")
                .setEntity("/templates/entity.java.vm")
                .setMapper("/templates/mapper.java.vm")
                .setXml("/templates/mapper.xml.vm");
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("please input " + tip + " : ");
        System.out.println(sb.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("please input the correct " + tip + ". ");
    }
}