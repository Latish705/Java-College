package Model;
import java.util.Calendar;

public class Enrolls{
    private Calendar enrollment_date;
    Customer ObjStud;
    Product objProduct;

    public void enroll_stud_course(Customer tempStud, Product tempCourse, Calendar temp_enroll_date)
    {
        ObjStud = tempStud;
        objProduct = tempCourse;
        enrollment_date = temp_enroll_date;
    }

    public void display_enrolled_Customer_course()
    {
//        System.out.println("Customer : "+this.ObjStud.getName()+" enrolled for Course : "+this.ObjCourse.getCourseName()+" on "+this.enrollment_date.getTime());
    }
}
