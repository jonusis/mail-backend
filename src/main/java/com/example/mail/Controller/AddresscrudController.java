package com.example.mail.Controller;

import com.example.mail.Pojo.Address;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "address增删查改")
@RequestMapping(value = "/v1/address")
@CrossOrigin(origins = "*")
public class AddresscrudController {
    @Autowired
    private com.example.mail.Service.AddresscrudService AddresscrudService;

    @RequestMapping(value = "/queryAddressList", method = RequestMethod.GET)
    public PagehelpResult<List<Address>> queryAddressList(@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return AddresscrudService.queryAddressList(pagenum,pagesize);
    }

    @RequestMapping(value = "/queryAddressByAid", method = RequestMethod.GET)
    public Result<Address> queryAddressByAid(@RequestParam String aid){
        int id = Integer.parseInt(aid);
        return AddresscrudService.queryAddressByAid(id);
    }

    @RequestMapping(value = "/queryAddressByUid", method = RequestMethod.GET)
    public PagehelpResult<List<Address>> queryAddressByBid(@RequestParam String uid, @RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        int id = Integer.parseInt(uid);
        return AddresscrudService.queryAddressByUid(id,pagenum,pagesize);
    }
    
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public Result<String> addAddress(@RequestBody Address address){
        int uid = address.getUid();
        String province = address.getProvince();
        String city = address.getCity();
        String detailedAddress = address.getDetailedAddress();
        String telephone = address.getTelephone();
        String receivierName = address.getReceivierName();
        return AddresscrudService.addAddress(uid, province, city, detailedAddress, telephone, receivierName);
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.PUT)
    public Result<String> updateAddress(@RequestBody Address address){
        int aid = address.getAid();
        int uid = address.getUid();
        String province = address.getProvince();
        String city = address.getCity();
        String detailedAddress = address.getDetailedAddress();
        String telephone = address.getTelephone();
        String receivierName = address.getReceivierName();
        return AddresscrudService.updateAddress(aid,uid, province, city, detailedAddress, telephone, receivierName);
    }

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.DELETE)
    public Result<String> deleteAddress(@RequestParam String aid){
        int id = Integer.parseInt(aid);
        return AddresscrudService.deleteAddress(id);
    }
}
