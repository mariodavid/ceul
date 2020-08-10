package com.company.ceul.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "CEUL_IMPORT_ENTRY")
@Entity(name = "ceul_ImportEntry")
public class ImportEntry extends StandardEntity {
    private static final long serialVersionUID = 950263861713179977L;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}