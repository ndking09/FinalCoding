/**
 * 
 */
/**
 * @author Dad
 *
 */
package pkgEmpty;
import org.junit.Test;
import pkgCore.Retirement;
import static org.junit.Assert.assertEquals;

public class RTEST {
	
@Test
public void RTST() {
	Retirement RT = new Retirement();
	RT.setdAnnualReturnRetired(.02);
	RT.setdAnnualReturnWorking(.07);
	RT.setdMonthlySSI(2642.00);
	RT.setdRequiredIncome(10000);
	RT.setiYearsRetired(20);
	RT.setiYearsToWork(40);
	assertEquals(554.13, RT.AmountToSave(),.01);
	assertEquals(-1454485.55, RT.TotalAmountSaved(),.01);
}
	

	
	
}