public class EmpUtil {
    //(10)
    public static String q(String msg) {
        return "(" + msg + ")";
    }

    //Administration(10)
    public static String tname(DepartmentDto ee) {
        return ee.getDepartment_name() + q(ee.getDepartment_id() + "");
    }

    //Administration(10)
    public static String tname(DepCountDto ee) {
        return ee.getDepartment_name() + q(ee.getDepartment_id() + "");
    }
    //예제 183에서 사용하지 않는 메서드 숨김
}
