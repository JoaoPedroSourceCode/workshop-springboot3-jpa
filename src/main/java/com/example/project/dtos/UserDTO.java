package com.example.project.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UserDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<OrderDTO> orderDTOlist;

    public UserDTO() {
    }

    public UserDTO(Long id, String password, String email, String name, String phone, List<OrderDTO> orderDTOlist) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.orderDTOlist = orderDTOlist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrderDTOList(List<OrderDTO> orderDTOlist) {
        this.orderDTOlist = orderDTOlist;
    }

    public List<OrderDTO> getOrderDTOlist() {
        return orderDTOlist;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
