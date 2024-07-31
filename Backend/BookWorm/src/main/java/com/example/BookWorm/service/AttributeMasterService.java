package com.example.BookWorm.service;


import com.example.BookWorm.models.AttributeMaster;
import com.example.BookWorm.repository.AttributeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeMasterService {

    @Autowired
    private AttributeMasterRepository attributeMasterRepository;

    public List<AttributeMaster> getAllAttributes() {
        return attributeMasterRepository.findAll();
    }

    public Optional<AttributeMaster> getAttributeById(int id) {
        return attributeMasterRepository.findById(id);
    }

    public AttributeMaster saveAttribute(AttributeMaster attribute) {
        return attributeMasterRepository.save(attribute);
    }

    public void deleteAttribute(int id) {
        attributeMasterRepository.deleteById(id);
    }

    public AttributeMaster updateAttribute(int id, AttributeMaster attributeDetails) {
        return attributeMasterRepository.findById(id).map(attribute -> {
            attribute.setName(attributeDetails.getName());
            return attributeMasterRepository.save(attribute);
        }).orElseGet(() -> {
            attributeDetails.setId(id);
            return attributeMasterRepository.save(attributeDetails);
        });
    }
}

