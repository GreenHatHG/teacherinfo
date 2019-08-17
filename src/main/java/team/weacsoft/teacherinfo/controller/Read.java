package team.weacsoft.teacherinfo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import team.weacsoft.teacherinfo.bean.TeacherInfo;
import team.weacsoft.teacherinfo.service.TeacherInfoRepository;

import java.util.List;

/**
 * 数据库查询操作接口
 * @author GreenHatHG
 */

 @RestController
 @RequestMapping(value="/teacherinfos")
 public class Read{

     @Autowired
     private TeacherInfoRepository teacherInfoRepository;

     @GetMapping("/name/{name}")
     @ApiOperation(value = "findByName", nickname = "findByName")
     public List<TeacherInfo> findByName(@PathVariable("name") String name){
         return teacherInfoRepository.findByName(name);
     }

     @GetMapping("/jobnumber/{jobnumber}")
     @ApiOperation(value = "findByJobNumber", nickname = "findByJobNumber")
     public TeacherInfo findByJobNumber(@PathVariable("jobnumber") String jobnumber){
            return teacherInfoRepository.findByJobNumber(jobnumber);
     }

     @GetMapping("/office/{office}")
     @ApiOperation(value = "findByOffice", nickname = "findByOffice")
     public List<TeacherInfo> findByOffice(@PathVariable("office") String office){
         return teacherInfoRepository.findByOffice(office);
     }

     @GetMapping("/phone/{phone}")
     @ApiOperation(value = "findByPhone", nickname = "findByPhone")
     public List<TeacherInfo> findByPhone(@PathVariable("phone") String phone){
         return teacherInfoRepository.findByPhone(phone);
     }

     @GetMapping("/ftpnumber/{ftpnumber}")
     @ApiOperation(value = "findByFtpNumber", nickname = "findByFtpNumber")
     public TeacherInfo findByFtpNumber(@PathVariable("ftpnumber") String ftpnumber){
         return teacherInfoRepository.findByFtpNumber(ftpnumber);
     }

     @GetMapping("/ftppassword/{ftppassword}")
     @ApiOperation(value = "findByFtpPassword", nickname = "findByFtpPassword")
     public List<TeacherInfo> findByFtpPassword(@PathVariable("ftppassword") String ftppassword){
         return teacherInfoRepository.findByFtpPassword(ftppassword);
     }

     @GetMapping("/count")
     @ApiOperation(notes = "返回表中数据的总行数", value = "count", nickname = "count")
     public Long Count(){
         return teacherInfoRepository.count();
     }

     @GetMapping("/null/jobnumber")
     @ApiOperation(value = "findJobnumberNull"
                    ,notes = "查询所有工号为空的数据"
                    ,nickname = "findJobnumberNull")
     public List<TeacherInfo> findJobnumberNull(){
         return teacherInfoRepository.findJobnumberNull();
     }

     @GetMapping("/null/phone")
     @ApiOperation(value = "findPhoneNull"
                    ,notes = "查询所有电话号码为空的数据"
                    ,nickname = "findPhoneNull")
     public List<TeacherInfo> findPhoneNull(){
         return teacherInfoRepository.findPhoneNull();
     }

     @GetMapping("")
     @ApiOperation(value = "findAll", nickname = "findAll")
     public List<TeacherInfo> findAll(){
         return teacherInfoRepository.findAll();
     }

     @GetMapping("/page")
     @ApiOperation(value = "findAllPage"
                    ,notes = "分页查询所有数据，size默认为6，可选对{item}排序(ASC--升序，DESC--降序)"
                    , nickname = "findAllPage")
     public Page<TeacherInfo> findAllPage(
             @RequestParam(value = "page") Integer page,
             @RequestParam(value = "size", required = false, defaultValue = "6") Integer size,
             @RequestParam(value = "item", required = false, defaultValue = "no") String item,
             @RequestParam(value = "sort", required = false, defaultValue = "false") String sort) {
         Pageable pageable = null;
         if("false".equals(sort)){
             pageable = PageRequest.of(page - 1, size);
         }else{
             if("ASC".equals(sort)){
                 pageable = PageRequest.of(page - 1, size, new Sort(Sort.Direction.ASC, item));
             }else{
                 pageable = PageRequest.of(page - 1, size, new Sort(Sort.Direction.DESC, item));
             }
         }
         return teacherInfoRepository.findAll(pageable);
     }

     @GetMapping("/{item}/{sort}")
     @ApiOperation(value = "findAllSort"
                    ,notes = "对{item}排序查询所有数据( {sort}可选ASC--升序，DESC--降序 )"
                    ,nickname = "findAllSort")
     public List<TeacherInfo> findAllSort(@PathVariable("item") String item,
                                          @PathVariable("sort") String sort){
         if("DESC".equals(sort)){
             return teacherInfoRepository.findAll(new Sort(Sort.Direction.DESC, item));
         } else{
             return teacherInfoRepository.findAll(new Sort(Sort.Direction.ASC, item));
         }
     }
 }