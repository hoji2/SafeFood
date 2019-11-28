package com.safefood.support;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties
public class Parser {

	public static final Logger logger = LoggerFactory.getLogger(Parser.class);
	
	@Value("${foodrestapi.key}")
	private String keyid;

	@Value("${foodrestapi.food.nutrition}")
	private String food_nutrition;

	@Value("${foodrestapi.food.material}")
	private String food_material;
	
	@Bean
	public void setParser() {
		LoadData(3, 50);
	}
	
	@Bean
	private void LoadData(int st, int end) {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(1000000);
		factory.setConnectTimeout(1000000);
		HttpClient httpClient = HttpClientBuilder.create()
				.setMaxConnTotal(100)
				.setMaxConnPerRoute(5)
				.build();
		factory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(factory);
		
		//keyid : 38f62c6a738d4f8e8165
		//service id : 식품영양 DB(I0750), 식품원재료DB(C002)
		
		String url="http://openapi.foodsafetykorea.go.kr/api/"+keyid+"/"+food_nutrition+"/xml/"+st+"/"+end;
		logger.info("완료 : "+url);
		String obj=restTemplate.getForObject(url, String.class);
		System.out.println(obj);	
	}
}
