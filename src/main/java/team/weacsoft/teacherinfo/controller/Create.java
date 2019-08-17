package team.weacsoft.teacherinfo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.weacsoft.teacherinfo.bean.TeacherInfo;
import team.weacsoft.teacherinfo.service.TeacherInfoRepository;

import java.util.List;

/**
 * 数据库插入操作接口
 * @author GreenHatHG
 */

@RestController
public class Create {

    @Autowired
    private TeacherInfoRepository teacherInfoRepository;

    @PostMapping("/teacherinfos")
    @ApiOperation(value = "Save"
                    ,notes = "批量插入"
                    ,nickname = "Save")
    public void Save( @RequestBody List<TeacherInfo> list){
        teacherInfoRepository.saveAll(list);
    }
}
