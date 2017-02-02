package cz.etn.etnshop.dao;

import cz.etn.etnshop.utils.ValidatorResult;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = -2739622030641073946L;

    private int id;

    private String name;

    private Integer serialNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "serial_number", nullable = true)
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }

    public ValidatorResult validate() {
        ValidatorResult result = new ValidatorResult();

        if (name == null || name.isEmpty()) {
            result.setValid(false);
            result.addErrorMessage("Name is empty");
        }
        if (name != null && name.length() > 50) {
            result.setValid(false);
            result.addErrorMessage("Name is too long");
        }
        if (serialNumber == null) {
            result.setValid(false);
            result.addErrorMessage("Serial number is empty");
        }
        if (serialNumber <= 0) {
            result.setValid(false);
            result.addErrorMessage("Serial number cannot be less than zero");
        }

        return result;
    }
}
