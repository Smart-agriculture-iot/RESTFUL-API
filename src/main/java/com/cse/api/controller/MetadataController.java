package com.cse.api.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cse.api.Response.CommonResponse;
import  com.cse.api.helper.ExcelHelper;
import com.cse.api.model.Rain;
import com.cse.api.model.harvest;
import com.cse.api.repository.RainRepository;
// import com.cse.api.service.ExcelService;
import com.cse.api.repository.harvestRepository;

import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1")
public class MetadataController {

   
    // @Autowired
    // ExcelService excelService;
    @Autowired
    RainRepository rainRepository;
    @Autowired
    harvestRepository haRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/rain")
    public List<Rain> getAlData() {
      return rainRepository.findAll();
    }  

    @CrossOrigin(origins = "*")
    @GetMapping("/rainyear/{year}")
    public Map<String, String> getbyyear(@PathVariable(value = "year") String year) {
        Map<String, String> data = new HashMap<>();
       List<Rain>rains=rainRepository.findclientByYear(year);
       for (final Rain rain: rains) {
        data.put(rain.getMonth(),rain.getRain());
    }
      return data;
    }  
  

    @PostMapping("/rain")
    public List<Rain> createbBranch(@RequestBody List<Rain> rain) {
        
            return rainRepository.saveAll(rain);
    }

    @PostMapping("/harvest")
    public List<harvest> createHarvest(@RequestBody List<harvest> havest) {
        
            return haRepository.saveAll(havest);
    }


    @PostMapping("/delete")
    public String deleatedata() {
      rainRepository.deleteAll();
            return "Deleted all data";
    }

}




