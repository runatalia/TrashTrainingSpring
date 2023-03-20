/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsontrainspringboot.controller.dto;

/**
 *
 * @author BNA
 */
public class AccountResponseDTO {
    private long id;
    private String name;
    private String email;
    private Integer bill;
    

    public AccountResponseDTO(long id,String name, String email, Integer bill) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bill = bill;
    }

    public AccountResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
