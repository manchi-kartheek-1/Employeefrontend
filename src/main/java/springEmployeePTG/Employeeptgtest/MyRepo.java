package springEmployeePTG.Employeeptgtest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository<Employee, Long>
{

}
