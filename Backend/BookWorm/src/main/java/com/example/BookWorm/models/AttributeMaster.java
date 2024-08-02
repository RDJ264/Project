package com.example.BookWorm.models;





import jakarta.persistence.*;

@Entity
@Table(name = "attribute_master")
public class AttributeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id", length = 10, nullable = false)
    private int attributeId;

    @Column(name = "attribute_name", nullable = false)
    private String attribute_name;

    // Getters and Setters
    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeDesc() {
        return attribute_name;
    }

    public void setAttributeDesc(String attributeDesc) {
        this.attribute_name = attributeDesc;
    }
}
