package com.cse.api.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.cse.api.helper.ExcelHelper;
import com.cse.api.model.Rain;
import com.cse.api.repository.RainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelService {
    @Autowired
    RainRepository rainRepository;
    public void save(MultipartFile file){
        try{
            List<Rain> providerRegistries = ExcelHelper.excelToProviderRegistry(file.getInputStream());
            rainRepository.saveAll(providerRegistries);
        } catch (IOException ioe){
            throw new RuntimeException("Fail to store data: " + ioe.getMessage());
        }
    }
}
