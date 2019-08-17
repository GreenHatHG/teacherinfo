package team.weacsoft.teacherinfo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import team.weacsoft.teacherinfo.bean.TeacherInfo;

import java.util.List;

/**
 * 数据库操作接口
 * @author GreenHatHG
 */

public interface TeacherInfoRepository extends JpaRepository<TeacherInfo, String>
        , JpaSpecificationExecutor<TeacherInfo> {


    List<TeacherInfo> findByName(String name);

    TeacherInfo findByJobNumber(String jobnumber);

    List<TeacherInfo> findByOffice(String office);

    List<TeacherInfo> findByPhone(String phone);

    TeacherInfo findByFtpNumber(String ftpnumber);

    List<TeacherInfo> findByFtpPassword(String ftppassword);

    @Query(value = "select * from teacherinfo where job_number is null", nativeQuery=true)
    List<TeacherInfo> findJobnumberNull();

    @Query(value = "select * from teacherinfo where phone is null", nativeQuery=true)
    List<TeacherInfo> findPhoneNull();

    @Transactional
    @Modifying
    @Query(value = "update teacherinfo t set t.name=?2 where t.ftp_number=?1", nativeQuery=true)
    void updateNameById(String id, String name);

    @Transactional
    @Modifying
    @Query(value = "update teacherinfo t set t.job_number=?2 where t.ftp_number=?1", nativeQuery=true)
    void updateJobNumberById(String id, String jobNumber);

    @Transactional
    @Modifying
    @Query(value = "update teacherinfo t set t.office=?2 where t.ftp_number=?1", nativeQuery=true)
    void updateOfficeById(String id, String office);

    @Transactional
    @Modifying
    @Query(value = "update teacherinfo t set t.phone=?2 where t.ftp_number=?1", nativeQuery=true)
    void updatePhoneById(String id, String phone);

    @Transactional
    @Modifying
    @Query(value = "update teacherinfo t set t.ftp_password=?2 where t.ftp_number=?1", nativeQuery=true)
    void updateFtpPasswordById(String id, String ftpPassword);

}