package com.levelupcorp.emenube.util.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("dozerMapper")
@Log4j2
public class BeanMapper implements InitializingBean {
	
	private Mapper mapper;

	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			mapper = DozerBeanMapperBuilder.create().build();
		} catch (Exception e) {
			log.error("BeanMapper afterPropertiesSet Error" + e);
		}
	}

	/**
	 * Constructs new instance of destinationClass and performs mapping between
	 * from source
	 *
	 * @param source
	 * @param targetClass
	 * @param <T>
	 * @return
	 */
	public <T> T map(Object source, Class<T> targetClass) {
		return mapper.map(source, targetClass);
	}

	/**
	 * Performs mapping between source and destination objects
	 *
	 * @param source
	 * @param target
	 */
	public void map(Object source, Object target) {
		mapper.map(source, target);
	}

	/**
	 * Performs mapping between source and destination objects according to
	 * mapId
	 *
	 * @param source
	 * @param target
	 * @param mapId
	 */
	public void map(Object source, Object target, String mapId) {
		mapper.map(source, target, mapId);
	}

	/**
	 * Constructs new instance of destinationClass and performs mapping between
	 * from source
	 *
	 * @param source
	 * @param targetClass
	 * @param mapId
	 * @param <T>
	 * @return
	 */
	public <T> T map(Object source, Class<T> targetClass, String mapId) {
		return mapper.map(source, targetClass, mapId);
	}

	/**
	 *
	 * @param sourceCollection
	 * @param targetClass
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> List<T> map(Collection sourceCollection, Class<T> targetClass) {

		List<T> targetList = new LinkedList<>();
		for (Object source : sourceCollection) {
			T target = map(source, targetClass);
			targetList.add(target);
		}

		return targetList;
	}

	/**
	 *
	 * @param sourceCollection
	 * @param targetClass
	 * @param mapId
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> List<T> map(Collection sourceCollection, Class<T> targetClass, String mapId) {

		List<T> targetList = new LinkedList<>();
		for (Object source : sourceCollection) {
			T target = map(source, targetClass, mapId);
			targetList.add(target);
		}

		return targetList;
	}
	
	public <T,K> List<K> mapList(List<T> sourceList,Class<K> targetClass) {
		
		List<K> mappedList = new ArrayList<>();
		for(T item : sourceList){
			K convertedItem = map(item, targetClass);
			mappedList.add(convertedItem);
		}
		
		return mappedList;
	}
	
	public <T,K> Set<K> mapSet(Set<T> sourceList,Class<K> targetClass) {
		
		Set<K> mappedSet = new HashSet<>();
		for(T item : sourceList){
			K convertedItem = map(item, targetClass);
			mappedSet.add(convertedItem);
		}
		
		return mappedSet;
	}
	
}
