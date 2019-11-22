/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.loadbalancer.cache;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Spring Cloud LoadBalancer cache properties.
 *
 * @author Olga Maciaszek-Sharma
 * @since 2.2.0
 */
@ConfigurationProperties("spring.cloud.loadbalancer.cache")
public class LoadBalancerCacheProperties {

	private Caffeine caffeine = new Caffeine();

	/**
	 * Time To Live - time counted from writing of the record, after which cache entries
	 * are expired, expressed as a {@link Duration}. The property {@link String} has to be
	 * in keeping with the appropriate syntax as specified in
	 * {@link Duration#parse(CharSequence)}.
	 */
	private Duration ttl = Duration.ofSeconds(30);

	public Caffeine getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(Caffeine caffeine) {
		this.caffeine = caffeine;
	}

	public Duration getTtl() {
		return ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = Duration.parse(ttl);
	}

	/**
	 * Caffeine-specific LoadBalancer cache properties.
	 * NOTE: Passing your own Caffeine specification will override any other LoadBalancerCache settings,
	 * including TTL.
	 */
	public static class Caffeine {

		/**
		 * The spec to use to create caches. See CaffeineSpec for more details on the spec
		 * format.
		 */
		private String spec = "";

		public String getSpec() {
			return spec;
		}

		public void setSpec(String spec) {
			this.spec = spec;
		}

	}

}
