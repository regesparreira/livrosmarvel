package com.api.livrosmarvel.restservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "RestService", url = "http://gateway.marvel.com")
public interface RestService {

	@RequestMapping("/v1/public/comics/{comicId}?ts=1&apikey=9d6d212bcc1fad9dd156765dccd88963&hash=6ee777977e63d6b53f74d852956dd1e1")
	String BuscarComicsApiMarvel(@PathVariable("comicId") int comicId);		
}
