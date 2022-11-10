package com.cse.api.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import com.cse.api.repository.RainRepository;
import com.cse.api.service.ExcelService;

import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1")
public class MetadataController {

   
    @Autowired
    ExcelService excelService;
    @Autowired
    RainRepository rainRepository;
    
    @PostMapping("/upload")
    public ResponseEntity<CommonResponse> uploadFile(@RequestParam("file")MultipartFile file){
        if(ExcelHelper.hasExcelFormat(file)){
            try{
                excelService.save(file);
                String message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("success", message));
            } 
            
            
            catch (Exception e){
            
                String message = "Could not upload the file: " + file.getOriginalFilename() + "!";
              e.printStackTrace();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new CommonResponse("failed", message));
            }
        }
        String message = "Please Upload an Excel File";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResponse("failed", message));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/rain")
    public List<Rain> getAlData() {
      return rainRepository.findAll();
    }  

  

    @PostMapping("/rain")
    public List<Rain> createbBranch(@RequestBody List<Rain> rain) {
        
            return rainRepository.saveAll(rain);
    }

}




