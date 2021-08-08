package com.globpay.bankmicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.globpay.bankmicroservice.repositories.BankRepository;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Branch {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String routingNumber;

    @NotEmpty
    private String swiftCode;

    @NotNull
    private boolean status;

    @ManyToOne
//    @JsonIgnoreProperties(value = {"branches"})
    @JsonIgnore
    private Bank bank;

    public Branch(){

    }

    public Branch(String id, String name, String routingNumber, String swiftCode,
                  boolean status) {

        this.id = id;
        this.name = name;
        this.routingNumber = routingNumber;
        this.swiftCode = swiftCode;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return status == branch.status && Objects.equals(id, branch.id) && Objects.equals(name, branch.name) && Objects.equals(routingNumber, branch.routingNumber) && Objects.equals(swiftCode, branch.swiftCode) && Objects.equals(bank, branch.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, routingNumber, swiftCode, status, bank);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", routingNumber='" + routingNumber + '\'' +
                ", swiftCode='" + swiftCode + '\'' +
                ", status=" + status +
                ", bank=" + bank +
                '}';
    }
}
