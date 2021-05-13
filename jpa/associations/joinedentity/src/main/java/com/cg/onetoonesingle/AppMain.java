package com.cg.onetoonesingle;

import com.cg.onetoonesingle.entities.Department;
import com.cg.onetoonesingle.entities.Employee;
import com.cg.onetoonesingle.entities.EmployeeDepartment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppMain {

    private EntityManager entityManager;

    public static void main(String args[]) {
        AppMain app = new AppMain();
        app.start();
    }

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("emp-ms");
        entityManager = emf.createEntityManager();
        Department dev = new Department("dev");
        addDepartment(dev);
        Department test = new Department("test");
        addDepartment(test);

        Employee krishna = new Employee("krishna");
        Employee farheen = new Employee("farheen");
        Employee venkat = new Employee("venkat");
        Employee raju = new Employee("raju");
        addEmployee(krishna);
        addEmployee(farheen);
        addEmployee(venkat);
        addEmployee(raju);

        addEmployeeToDepartment(krishna, dev);
        addEmployeeToDepartment(farheen,dev);
        addEmployeeToDepartment(venkat,test);
        addEmployeeToDepartment(raju,test);


        System.out.println("fetching employees in test department");
        List<Employee>devEmployees= findEmployeesInDepartmentWay2("test");
        displayEmployees(devEmployees);

        entityManager.close();
        emf.close();
    }

    public void addEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }

    public void addDepartment(Department dept) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(dept);
        transaction.commit();

    }


    public void addEmployeeToDepartment(Employee employee, Department dept) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        EmployeeDepartment emd=new EmployeeDepartment(employee,dept);
        entityManager.persist(emd);
        transaction.commit();
    }

    public List<Employee>findEmployeesInDepartmentWay1(String department){
        String qlText="from EmployeeDepartment where department.deptName=:deptNameParam";
        TypedQuery<EmployeeDepartment>query=entityManager.createQuery(qlText,EmployeeDepartment.class);
        query.setParameter("deptNameParam",department);
        List<EmployeeDepartment>eds=query.getResultList();
        List<Employee>employees=new ArrayList<>();
        for (EmployeeDepartment ed:eds){
            employees.add(ed.getEmployee());
        }
        return employees;
    }


    public List<Employee>findEmployeesInDepartmentWay2(String department){
        String qlText="select ed.employee from EmployeeDepartment ed  join ed.department dept where dept.deptName=:deptNameParam";
        TypedQuery<Employee>query=entityManager.createQuery(qlText,Employee.class);
        query.setParameter("deptNameParam",department);
        List<Employee>employees=query.getResultList();
         return employees;
    }


    void display(Department department) {
        System.out.println(department.getDeptId() + "-" + department.getDeptName());
    }

    void display(Employee employee) {
        System.out.println(employee.getId() + "-" + employee.getName());
    }

    void displayEmployees(Collection<Employee> employees){
        for(Employee emp:employees){
            display(emp);
        }
    }

}
