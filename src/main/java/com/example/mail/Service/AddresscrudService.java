package com.example.mail.Service;

import com.example.mail.Mapper.AddressMapper;
import com.example.mail.Mapper.OrderMapper;
import com.example.mail.Mapper.Pay_goodsMapper;
import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.Pojo.Address;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddresscrudService {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    Pay_goodsMapper pay_goodsMapper;

    public Result<List<Address>> getAddressByUid(int uid) {
        List<Address> address = null;   //不分页
        try {
            address = addressMapper.queryAddressByUid(uid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(address);
    }

    public PagehelpResult<List<Address>> queryAddressList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Address> address = addressMapper.queryAddressList();
        PageInfo<Address> pageInfo = new PageInfo<>(address);
        List<Address> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public Address queryAddressByAid(int aid) {
        Address address = null;
        try {
            address = addressMapper.queryAddressByAid(aid);
        } catch (Exception e) {
            return null;
        }
        return address;
    }

    public PagehelpResult<List<Address>> queryAddressByUid(int uid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize); //分页
        List<Address> address = addressMapper.queryAddressByUid(uid);
        PageInfo<Address> pageInfo = new PageInfo<>(address);
        List<Address> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }


    public Result<String> addAddress(int uid, String province, String city, String detailedAddress, String telephone, String receivierName){
        try{
            int id = addressMapper.selectIdMaxAddress() + 1;
            addressMapper.addAddress(new Address(id, uid, province, city, detailedAddress, telephone, receivierName));
        }catch (Exception e){
            return Result.error(new CodeMsg(0,e.toString()));
        }
        return Result.success("success addAddress");
    }

    public Result<String> updateAddress(int aid, int uid, String province, String city, String detailedAddress, String telephone, String receivierName) {
        try {
            addressMapper.updateAddress(new Address(aid, uid, province, city, detailedAddress, telephone, receivierName));
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success updateAddress");
    }

    public Result<String> deleteAddress(int aid) {
        try {
            addressMapper.deleteAddress(aid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success deleteAddress");
    }
}
