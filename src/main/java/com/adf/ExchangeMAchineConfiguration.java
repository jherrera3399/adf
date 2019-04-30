package com.adf;

import java.util.logging.Logger;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.adf.util.CoinsDispenser;

@Configuration
public class ExchangeMAchineConfiguration {

	@Bean
	public CoinsDispenser getCoinsDispenser() {
		return new CoinsDispenser();
	}


	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger("logger");
	}




}
