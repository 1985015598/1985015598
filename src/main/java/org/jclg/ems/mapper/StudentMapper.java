package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jclg.ems.bean.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jclg.ems.bean.Users;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface StudentMapper extends BaseMapper<Student> {
    @Select("select s.*,p.name,c.`name`,e.incompany,d.expplace from student s,profession p,college c,empinfo e,drepos d \n" +
            "where s.userid=#{userid} and s.collegeid=c.id and s.dreposid=d.id and s.empinfoid =e.id and s.professionid =p.id")
    public List<Map<String,String>> getInfo(String userid);
    @Select(" select s.*,p.name as yuanxi,c.name as xueyuan,e.incompany,d.expplace from student s,profession p,college c,empinfo e,drepos d " +
            " where  s.collegeid=c.id and s.dreposid=d.id and s.empinfoid =e.id and s.professionid =p.id" +
            "  and  INSTR(s.name,#{query}) "+
            " LIMIT #{pagenum},#{pagesize} ")
    public List<Map<String,String>> getalllimts(@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("query") String query);
    @Select("select count(1) from student where " +
            "INSTR(student.name,#{query})")
    int getcount(String query);
    @Select(" select s.*,p.name as yuanxi,c.name as xueyuan,e.incompany,d.expplace from student s,profession p,college c,empinfo e,drepos d " +
            " where  s.collegeid=c.id and s.dreposid=d.id and s.empinfoid =e.id and s.professionid =p.id" +
            "  and  INSTR(c.name,#{college}) "+
            " LIMIT #{pagenum},#{pagesize} ")
    List<Map<String, String>> getalllimtbyxy(@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("college") String college);
    @Select(" select count(1) from student s,profession p,college c,empinfo e,drepos d " +
            " where  s.collegeid=c.id and s.dreposid=d.id and s.empinfoid =e.id and s.professionid =p.id" +
            "  and  INSTR(c.name,#{college}) ")
    int getcountbyxy(String college);
    @Select("select s.*,p.name as yuanxi,c.name as xueyuan from student s,profession p,college c  where s.userid=#{userid}" +
            " and s.collegeid=c.id and s.professionid =p.id")
    Map<String, String> getByuserid(String userid);
    @Select("select count(1) from student")
    int getStudentCount();
    @Select("select count(1) from company")
    int getComCount();
    @Select("select count(distinct applyinfo.studentid) from applyinfo where applyinfo.sta=5")
    int getgz();
    @Select("select count(1) from joboffer")
    int getgw();

    @Select("")
    List<Map<String, String>> getbyjy(@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("query") String query);
    @Select("select count(1) from student where sex='男'")
    int getnan();
    @Select("select count(1) from student where sex='女'")
    int getnv();
}
