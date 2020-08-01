package com.trustin.docgeneration.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustin.docgeneration.services.DocGenerationService;


@RestController 
@RequestMapping(value = "/docgeneration")

public class DocGeneration {
	@Autowired
	DocGenerationService docGenerationService;
	
	@PostMapping("/generate")
	public String generate(@RequestBody Map<String, String> params){
	      try {
			docGenerationService.generate(params.get("data"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return "Done";
	}
}
