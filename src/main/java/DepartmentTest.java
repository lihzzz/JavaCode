import java.util.*;

public class DepartmentTest {
    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");

        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);


        List<Department> subDepartments = DepartmentTest.getSub(1, allDepartment);
        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }
    }
    /**
     * 根据id，获取所有子部门列表(包括隔代子部门，一直到叶子节点)
     * 要求：不能新增参数，不能增加static变量
     * @param id
     * @return
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {
        List<Department> res = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        if(allDepartment.isEmpty()){
            return res;
        }

        s.add(id);
        for(Department department:allDepartment){
            if(s.contains(department.getPid())) {
                s.add(department.getId());
            }
        }

        for(Department department : allDepartment){
            if(s.contains(department.getPid())){
                res.add(department);
            }
        }
        return res;
    }
}
