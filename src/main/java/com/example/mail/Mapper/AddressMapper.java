package com.example.mail.Mapper;

import com.example.mail.Pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {
    List<Address> queryAddressList();

    Address queryAddressByAid(int aid);

    List<Address> queryAddressByUid(int uid);


    void addAddress(Address address);

    void updateAddress(Address address);

    void deleteAddress(int aid);

    int selectIdMaxAddress();
}
