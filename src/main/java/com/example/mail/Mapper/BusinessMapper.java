package com.example.mail.Mapper;
import com.example.mail.Pojo.Business;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BusinessMapper {

    List<Business> queryBusinessList();

    Business queryBusinessById(int bid);

    void addBusiness(Business Business);

    void updateBusiness(Business Business);

    void deleteBusiness(int bid);

    int selectIdMaxBusiness();

    List<Business> selectBusinessLogin(String account,String password);
}
