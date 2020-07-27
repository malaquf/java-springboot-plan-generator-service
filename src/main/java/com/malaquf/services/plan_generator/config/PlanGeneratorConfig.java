package com.malaquf.services.plan_generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
/**
 * Configuration class for Plan Generator Service
 *
 */
public class PlanGeneratorConfig {

	@Bean
	/**
	 * Default sampler strategy.
	 * @return default sampler strategy (ALWAYS_SAMPLE).
	 */
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
