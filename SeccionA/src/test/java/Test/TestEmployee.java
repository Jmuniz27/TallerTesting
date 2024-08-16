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
    private static LocalDate fechaActual;

    @BeforeAll
    public static void setup() {
        fechaActual = LocalDate.now();
        
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
        assumeTrue(fechaActual.getMonthValue() % 2 == 0); 
        float expectativa = 1000;
        assertEquals(expectativa, workerUSD.cs(), 0.01);
    }

    @Test
    public void testWorkerUSDImpar() {
        assumeTrue(fechaActual.getMonthValue() % 2 != 0); 
        float expectativa = 1000 + (386.0F / 12 * 2);
        assertEquals(expectativa, workerUSD.cs(), 0.01);
    }

    @Test
    public void testWorkerCADPar() {
        assumeTrue(fechaActual.getMonthValue() % 2 == 0); 
        float expectativa = (float) (1000 * 0.95);
        assertEquals(expectativa, workerCAD.cs(), 0.01);
    }

    @Test
    public void testWorkerCADImpar() {
        assumeTrue(fechaActual.getMonthValue() % 2 != 0); 
        float expectativa = (float) (1000 * 0.95) + (386.0F / 12 * 2);
        assertEquals(expectativa, workerCAD.cs(), 0.01);
    }

    @Test
    public void testSupervisorUSDPar() {
        assumeTrue(fechaActual.getMonthValue() % 2 == 0);
        float expectativa = 2000 + (0.1F * 0.35F);
        assertEquals(expectativa, supervisorUSD.cs(), 0.01);
    }

    @Test
    public void testSupervisorUSDImpar() {
        assumeTrue(fechaActual.getMonthValue() % 2 != 0); 
        float expectativa = 2000 + (0.1F * 0.35F) + (386.0F / 12 * 2);
        assertEquals(expectativa, supervisorUSD.cs(), 0.01);
    }

    @Test
    public void testSupervisorCADPar() {
        assumeTrue(fechaActual.getMonthValue() % 2 == 0); 
        float expectativa = (float) (2000 * 0.95) + (0.1F * 0.35F);
        assertEquals(expectativa, supervisorCAD.cs(), 0.01);
    }

    @Test
    public void testSupervisorCADImpar() {
        assumeTrue(fechaActual.getMonthValue() % 2 != 0); 
        float expectativa = (float) (2000 * 0.95) + (0.1F * 0.35F) + (386.0F / 12 * 2);
        assertEquals(expectativa, supervisorCAD.cs(), 0.01);
    }

    @Test
    public void testManagerUSDPar() {
        assumeTrue(fechaActual.getMonthValue() % 2 == 0); 
        float expectativa = 3000 + (0.2F * 0.7F);
        assertEquals(expectativa, managerUSD.cs(), 0.01);
    }

    @Test
    public void testManagerUSDImpar() {
        assumeTrue(fechaActual.getMonthValue() % 2 != 0); 
        float expectativa = 3000 + (0.2F * 0.7F) + (386.0F / 12 * 2);
        assertEquals(expectativa, managerUSD.cs(), 0.01);
    }

    @Test
    public void testManagerCADPar() {
        assumeTrue(fechaActual.getMonthValue() % 2 == 0); 
        float expectativa = (float) (3000 * 0.95) + (0.2F * 0.7F);
        assertEquals(expectativa, managerCAD.cs(), 0.01);
    }

    @Test
    public void testManagerCADImpar() {
        assumeTrue(fechaActual.getMonthValue() % 2 != 0);
        float expectativa = (float) (3000 * 0.95) + (0.2F * 0.7F) + (386.0F / 12 * 2);
        assertEquals(expectativa, managerCAD.cs(), 0.01);
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
