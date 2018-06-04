package dao;

import java.util.List;
import vo.Tripcourse;

public interface CourseDAO {
   public void insertcourse(Tripcourse course) throws Exception;
   public List<Tripcourse> listcourse() throws Exception;
   public List<Tripcourse> detailcourse() throws Exception;
}