package com.mkyong.util;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class ServiceLocator {

	private static final Logger logger = Logger.getLogger(ServiceLocator.class);
	
	private static ServiceLocator instance;
	
	private InitialContext context;
	private Map<String, Object> cache;
	
	private ServiceLocator() throws NamingException, IOException {
		initiateContext();
	}
	
	private void initiateContext() throws NamingException, IOException {
		logger.debug("Inicializando contexto local");
		Map<String, Object> cRef = new HashMap<String, Object>();
		cache = Collections.synchronizedMap(cRef);
		this.context = new InitialContext();
	}
	
	public static ServiceLocator getInstance() {
		try {
			if (instance == null) {
				instance = new ServiceLocator();
			}
			return instance;
		} catch (NamingException ne) {
			throw new RuntimeException("Could not instantiate ServiceLocator.", ne);
		} catch (IOException e) {
			throw new RuntimeException("Could not instantiate ServiceLocator.", e);
		}
	}

	
	@SuppressWarnings("unchecked")
	public <T> T lookup(String name) {
		if (logger.isDebugEnabled()) {
			logger.debug("Fazendo lookup em: " + name);
		}
		
		Object result = cache.get(name);
		if (result == null) {
			if (logger.isDebugEnabled()) {
				logger.debug(name + " nao estava em cache, ira fazer lookup e adicionar");
			}
			try {
				result = context.lookup(name);
				cache.put(name, result);
			} catch (NamingException ne) {
				throw new RuntimeException("Nao conseguiu fazer lookup em: " + name, ne);
			}
		}
		
		return (T) result;
	}
	
}