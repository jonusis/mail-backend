package com.example.mail.Compound;

import com.example.mail.Pojo.Address;
import com.example.mail.Pojo.User;

public class UserAddress {
    private User user;
    private Address address;

    public UserAddress(User user, Address address) {
        this.user = user;
        this.address = address;
    }

    public UserAddress() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
