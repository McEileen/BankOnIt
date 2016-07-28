import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TransactionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstructorWithAmountAndType() throws Exception {
        Transaction t = new Transaction(50f, TransactionType.DEPOSIT);
        assertNotNull(t.getId());
        assertNotNull(t.getDate());
        assertEquals(50f, t.getAmount(), 0.1);
        assertEquals(TransactionType.DEPOSIT, t.getType());
    }

    @Test
    public void testToString() {
        Transaction t = new Transaction(75f, TransactionType.DEPOSIT);
        String transactionDescription = t.toString();
        assert(transactionDescription.contains("DEPOSIT"));
        assert(transactionDescription.contains("75.00"));
    }

}