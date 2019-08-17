package team.weacsoft.teacherinfo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.weacsoft.teacherinfo.bean.TeacherInfo;
import team.weacsoft.teacherinfo.service.TeacherInfoRepository;

/**
 * 数据库更新操作接口
 * @author GreenHatHG
 */

@RestController
@RequestMapping(value="/teacherinfos")
public class Update {

    @Autowired
    private TeacherInfoRepository teacherInfoRepository;

    @PutMapping("/name/{id}/{name}")
    @ApiOperation(value = "updateNameById"
                    ,nickname = "updateNameById")
    public void updateNameById( @PathVariable("id") String id,
                                @PathVariable("name") String name){
        teacherInfoRepository.updateNameById(id, name);
    }

    @PutMapping("/jobnumber/{id}/{jobnumber}")
    @ApiOperation(value = "updateJobNumberById", nickname = "updateJobNumberById")
    public void updateJobNumberById( @PathVariable("id") String id,
                                @PathVariable("jobnumber") String jobnumber){
        teacherInfoRepository.updateJobNumberById(id, jobnumber);
    }

    @PutMapping("/office/{id}/{office}")
    @ApiOperation(value = "updateOfficeById", nickname = "updateOfficeById")
    public void updateOfficeById( @PathVariable("id") String id,
                                     @PathVariable("office") String office){
        teacherInfoRepository.updateOfficeById(id, office);
    }

    @PutMapping("/phone/{id}/{phone}")
    @ApiOperation(value = "updatePhoneById", nickname = "updatePhoneById")
    public void updatePhoneById( @PathVariable("id") String id,
                                  @PathVariable("phone") String phone){
        teacherInfoRepository.updatePhoneById(id, phone);
    }

    @PutMapping("/ftppassword/{id}/{ftppassword}")
    @ApiOperation(value = "updateFtpPasswordById", nickname = "updateFtpPasswordById")
    public void updateFtpPasswordById( @PathVariable("id") String id,
                                       @PathVariable("ftppassword") String ftppassword){
        teacherInfoRepository.updateFtpPasswordById(id, ftppassword);
    }

    @PutMapping("")
    @ApiOperation(value = "update"
                    ,notes = "当所有成员值有效，增量更新里面的值"
                    ,nickname = "update")
    public void update(@RequestBody TeacherInfo t){
        teacherInfoRepository.save(t);
    }
}
