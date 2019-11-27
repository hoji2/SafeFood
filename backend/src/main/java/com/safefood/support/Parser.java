package com.safefood.support;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Parser {

	@Value("${FoodRestAPI_Keyid}")
	private String keyid;

	@Value("${FoodRestAPI_Food_Nutrition}")
	private String food_nutrition;

	@Value("${FoodRestAPI_Food_Material}")
	private String food_material;
	
	@Bean
	public void Parser() {
//		System.out.println("parser()");
		LoadData(1,10);
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
		//service id : 식품 영양DB(I0750), 식품 원재료DB(C002)
		
		String url="http://openapi.foodsafetykorea.go.kr/api/38f62c6a738d4f8e8165/I0750/xml/"+st+"/"+end;
//		String url="http://openapi.foodsafetykorea.go.kr/api/"+keyid+"/"+food_nutrition+"/xml/"+st+"/"+end;
//		System.out.println("완료 : "+url);
		String obj=restTemplate.getForObject(url, String.class);
		System.out.println(obj);	
	}
}
