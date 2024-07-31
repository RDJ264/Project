package com.example.BookWorm.Controller;



import com.example.BookWorm.models.AttributeMaster;
import com.example.BookWorm.service.AttributeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributes")
public class AttributeMasterController {

    @Autowired
    private AttributeMasterService attributeMasterService;

    @GetMapping
    public List<AttributeMaster> getAllAttributes() {
        return attributeMasterService.getAllAttributes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeMaster> getAttributeById(@PathVariable int id) {
        Optional<AttributeMaster> attribute = attributeMasterService.getAttributeById(id);
        return attribute.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AttributeMaster createAttribute(@RequestBody AttributeMaster attribute) {
        return attributeMasterService.saveAttribute(attribute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeMaster> updateAttribute(@PathVariable int id, @RequestBody AttributeMaster attributeDetails) {
        return ResponseEntity.ok(attributeMasterService.updateAttribute(id, attributeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable int id) {
        attributeMasterService.deleteAttribute(id);
        return ResponseEntity.noContent().build();
    }
}
