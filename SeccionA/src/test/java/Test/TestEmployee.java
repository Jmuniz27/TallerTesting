package Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import espol.Employee;
import espol.EmployeeType;

class TestEmployee {
	private static Employee workerUSD;
    private static Employee workerCAD;
    private static Employee supervisorUSD;
    private static Employee supervisorCAD;
    private static Employee managerUSD;
    private static Employee managerCAD;
    private static LocalDate currentDate;

    @BeforeAll
    public static void setup() {
        currentDate = LocalDate.now();
        
        workerUSD = new Employee(1000, "USD", 0, EmployeeType.Worker);
        workerCAD = new Employee(1000, "CAD", 0, EmployeeType.Worker);

        supervisorUSD = new Employee(2000, "USD", 0.1F, EmployeeType.Supervisor);
        supervisorCAD = new Employee(2000, "CAD", 0.1F, EmployeeType.Supervisor);

        managerUSD = new Employee(3000, "USD", 0.2F, EmployeeType.Manager);
        managerCAD = new Employee(3000, "CAD", 0.2F, EmployeeType.Manager);
    }
    
    // Casos de prueba para cs()
    @Test
    public void testWorkerUSDPar() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expectedSalary = 1000;
        assertEquals(expectedSalary, workerUSD.cs(), 0.01);
    }

    @Test
    public void testWorkerUSDImpar() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expectedSalary = 1000 + (386.0F / 12 * 2);
        assertEquals(expectedSalary, workerUSD.cs(), 0.01);
    }

    @Test
    public void testWorkerCADPar() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expectedSalary = (float) (1000 * 0.95);
        assertEquals(expectedSalary, workerCAD.cs(), 0.01);
    }

    @Test
    public void testWorkerCADImpar() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expectedSalary = (float) (1000 * 0.95) + (386.0F / 12 * 2);
        assertEquals(expectedSalary, workerCAD.cs(), 0.01);
    }

    @Test
    public void testSupervisorUSDPar() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0);
        float expectedSalary = 2000 + (0.1F * 0.35F);
        assertEquals(expectedSalary, supervisorUSD.cs(), 0.01);
    }

    @Test
    public void testSupervisorUSDImpar() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expectedSalary = 2000 + (0.1F * 0.35F) + (386.0F / 12 * 2);
        assertEquals(expectedSalary, supervisorUSD.cs(), 0.01);
    }

    @Test
    public void testSupervisorCADPar() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expectedSalary = (float) (2000 * 0.95) + (0.1F * 0.35F);
        assertEquals(expectedSalary, supervisorCAD.cs(), 0.01);
    }

    @Test
    public void testSupervisorCADImpar() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expectedSalary = (float) (2000 * 0.95) + (0.1F * 0.35F) + (386.0F / 12 * 2);
        assertEquals(expectedSalary, supervisorCAD.cs(), 0.01);
    }

    @Test
    public void testManagerUSDPar() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expectedSalary = 3000 + (0.2F * 0.7F);
        assertEquals(expectedSalary, managerUSD.cs(), 0.01);
    }

    @Test
    public void testManagerUSDImpar() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0); 
        float expectedSalary = 3000 + (0.2F * 0.7F) + (386.0F / 12 * 2);
        assertEquals(expectedSalary, managerUSD.cs(), 0.01);
    }

    @Test
    public void testManagerCADPar() {
        assumeTrue(currentDate.getMonthValue() % 2 == 0); 
        float expectedSalary = (float) (3000 * 0.95) + (0.2F * 0.7F);
        assertEquals(expectedSalary, managerCAD.cs(), 0.01);
    }

    @Test
    public void testManagerCADImpar() {
        assumeTrue(currentDate.getMonthValue() % 2 != 0);
        float expectedSalary = (float) (3000 * 0.95) + (0.2F * 0.7F) + (386.0F / 12 * 2);
        assertEquals(expectedSalary, managerCAD.cs(), 0.01);
    }

    // Casos de prueba para CalculateYearBonus()

    @Test
    public void testCalculateYearBonusWorkerUSD() {
        float expectedBonus = 386.0F;
        assertEquals(expectedBonus, workerUSD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusWorkerCAD() {
        float expectedBonus = 386.0F;
        assertEquals(expectedBonus, workerCAD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusSupervisorUSD() {
        float expectedBonus = 2000 + 386.0F * 0.5F;
        assertEquals(expectedBonus, supervisorUSD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusSupervisorCAD() {
        float expectedBonus = (float) (2000 * 0.95) + 386.0F * 0.5F;
        assertEquals(expectedBonus, supervisorCAD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusManagerUSD() {
        float expectedBonus = 3000 + 386.0F;
        assertEquals(expectedBonus, managerUSD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusManagerCAD() {
        float expectedBonus = (float) (3000 * 0.95) + 386.0F;
        assertEquals(expectedBonus, managerCAD.CalculateYearBonus(), 0.01);
    }
}
