import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAccountConstructor() {
        Account acct = new Account(Type.CHECKING);
        assertNotNull(acct.getId());
        assertEquals(0f, acct.getBalance(), 0.01);
        int numTransactions = acct.getTransactions().size();
        assertEquals(numTransactions, 0);
    }

    @Test
    public void testCanDeposit() {
        Account acct = new Account(Type.CHECKING);
        int numTransactions = acct.getTransactions().size();
        assertEquals(0f, acct.getBalance(), 0.01);
        assertEquals(numTransactions, 0);
        acct.deposit(133.00f);
        assertEquals(133.00f, acct.getBalance(), 0.01);
        numTransactions = acct.getTransactions().size();
        assertEquals(numTransactions, 1);
    }

    @Test
    public void testCanWithdrawWithSufficientFunds() {
        Account acct = new Account(Type.CHECKING);
        acct.deposit(200.00f);
        acct.withdraw(150.00f);
        assertEquals(50.00f, acct.getBalance(), 0.01);
        int numTransactions = acct.getTransactions().size();
        assertEquals(numTransactions, 2);
    }

    @Test
    public void testCannotWithdrawMoreThanBalance() {
        Account acct = new Account(Type.SAVINGS);
        acct.deposit(200.00f);
        acct.withdraw(290.00f);
        assertEquals(150.00f, acct.getBalance(), 0.01);
        int numTransactions = acct.getTransactions().size();
        assertEquals(numTransactions, 1);
        assertEquals(1, acct.getNumOverDrafts);
    }

}
