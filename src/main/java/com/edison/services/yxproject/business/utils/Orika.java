package com.edison.services.yxproject.business.utils;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Orika
 *
 * @author zicai
 * @since 2021-01-11
 */
public class Orika {

    private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    private static final MapperFacade MAPPER_FACADE = MAPPER_FACTORY.getMapperFacade();

    private static final Map<String, MapperFacade> MAPPER_FACADE_CACHE = new ConcurrentHashMap<>();

    /**
     * 映射实体（默认字段）
     * 这种映射就是DTO字段名称和实体对象DO之间字段名称一致
     *
     * @param toClass 映射类对象 DTO对象
     * @param data    数据（对象）DO对象
     * @return 映射类对象
     */
    public static <T, E> E map(T data, Class<E> toClass) {
        return MAPPER_FACADE.map(data, toClass);
    }

    public static <T, E> Function<T, E> map(Class<E> toClass) {
        return t -> map(t, toClass);
    }

    /**
     * 映射实体（自定义配置）
     *
     * @param toClass   映射类对象 DTO对象
     * @param data      数据（对象）DO对象
     * @param configMap 自定义配置 这个自定义配置我目前就理解为，如果需要映射的字段之间存在差异，需要通过一个对象来中中转
     * @return 映射类对象
     */
    public static <T, E> E map(T data, Class<E> toClass, Map<String, String> configMap) {
        MapperFacade mapperFacade = getMapperFacade(toClass, data.getClass(), configMap);
        return mapperFacade.map(data, toClass);
    }

    public static <T, E> Function<T, E> map(Class<E> toClass, Map<String, String> configMap) {
        return data -> map(data, toClass, configMap);
    }

    /**
     * 映射集合（默认字段）
     * 映射为集合的形式
     *
     * @param toClass 映射类对象 DTO对象
     * @param data    数据（集合） DO对象
     * @return 映射类对象
     */
    public static <T, E> List<E> mapAsList(Collection<T> data, Class<E> toClass) {
        return MAPPER_FACADE.mapAsList(data, toClass);
    }

    public static <T, E> List<E> mapAsList(Collection<T> data, Class<E> toClass, Map<String, String> configMap) {
        MapperFacade mapperFacade = getMapperFacade(toClass, data.getClass(), configMap);
        return mapperFacade.mapAsList(data, toClass);
    }

    public static <T, E> Function<Collection<T>, List<E>> mapAsList(Class<E> toClass) {
        return data -> mapAsList(data, toClass);
    }

    public static <T, E> Function<Collection<T>, List<E>> mapAsList(Class<E> toClass, Map<String, String> configMap) {
        return data -> mapAsList(data, toClass, configMap);
    }

    /**
     * 获取自定义映射
     *
     * @param toClass   映射类
     * @param dataClass 数据映射类
     * @param configMap 自定义配置
     * @return 映射类对象
     */
    private static <T, E> MapperFacade getMapperFacade(Class<T> dataClass, Class<E> toClass, Map<String, String> configMap) {
        String mapKey = dataClass.getCanonicalName() + "/" + toClass.getCanonicalName();
        MapperFacade mapperFacade = MAPPER_FACADE_CACHE.get(mapKey);
        if (Objects.isNull(mapperFacade)) {
            MapperFactory factory = new DefaultMapperFactory.Builder().build();
            ClassMapBuilder<T, E> classMapBuilder = factory.classMap(dataClass, toClass);
            configMap.forEach(classMapBuilder::field);
            classMapBuilder.byDefault().register();
            mapperFacade = factory.getMapperFacade();
            MAPPER_FACADE_CACHE.put(mapKey, mapperFacade);
        }
        return mapperFacade;
    }

}
