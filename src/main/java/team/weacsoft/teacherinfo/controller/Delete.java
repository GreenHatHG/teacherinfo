package team.weacsoft.teacherinfo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.weacsoft.teacherinfo.bean.TeacherInfo;
import team.weacsoft.teacherinfo.service.TeacherInfoRepository;

/**
 * 数据库删除操作接口
 * @author GreenHatHG
 */

@RequestMapping(value="/teacherinfos")
@RestController
public class Delete{

     @Autowired
     private TeacherInfoRepository teacherInfoRepository;

     @Transactional
     @DeleteMapping("")
     @ApiOperation(value = "deleteAll"
                    ,notes = "删除表中所有数据，保留表结构"
                    ,nickname = "deleteAll")
     public void deleteAll(){
         teacherInfoRepository.deleteAll();
     }

     @Transactional
     @DeleteMapping("/{id}")
     @ApiOperation(value = "deleteById"
                    ,notes = "根据id删除表中的记录"
                    ,nickname = "deleteById")
     public void deleteOne(@PathVariable("id") String id){
         TeacherInfo t = teacherInfoRepository.findByFtpNumber(id);
         teacherInfoRepository.delete(t);
     }
 }