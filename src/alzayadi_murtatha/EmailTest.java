package alzayadi_murtatha;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.Session;
import java.util.Date;

import static org.junit.Assert.*;

public class EmailTest {

    private SimpleEmail email;

    @Before
    public void setUp() throws Exception {
        email = new SimpleEmail();
    }

    @After
    public void tearDown() throws Exception {
        email = null;
    }

    @Test
    public void testAddBcc() throws Exception {
        email.addBcc("bcc@example.com");
        assertEquals(1, email.getBccAddresses().size());
    }

    @Test
    public void testAddCc() throws Exception {
        email.addCc("cc@example.com");
        assertEquals(1, email.getCcAddresses().size());
    }

    @Test
    public void testAddHeader() throws Exception {
        email.addHeader("X-Test-Header", "TestValue");
        // No exception = test passed
        assertTrue(true);
    }

    @Test
    public void testAddReplyTo() throws Exception {
        email.addReplyTo("reply@example.com", "Reply Name");
        assertEquals("reply@example.com", email.getReplyToAddresses().get(0).getAddress());
    }

    @Test
    public void testBuildMimeMessage() throws Exception {
        email.setHostName("smtp.example.com");
        email.setFrom("from@example.com");
        email.addTo("to@example.com");
        email.setSubject("Test Subject");
        email.setMsg("This is a test message.");
        email.buildMimeMessage();
        assertNotNull(email.getMimeMessage());
    }

    @Test
    public void testGetHostName() {
        email.setHostName("smtp.example.com");
        assertEquals("smtp.example.com", email.getHostName());
    }

    @Test
    public void testGetMailSession() throws Exception {
        email.setHostName("smtp.example.com");
        Session session = email.getMailSession();
        assertNotNull(session);
    }

    @Test
    public void testGetSentDate() {
        Date now = new Date();
        email.setSentDate(now);
        assertEquals(now, email.getSentDate());
    }

    @Test
    public void testGetSocketConnectionTimeout() {
        email.setSocketConnectionTimeout(4000);
        assertEquals(4000, email.getSocketConnectionTimeout());
    }

    @Test
    public void testSetFrom() throws Exception {
        email.setFrom("from@example.com");
        assertEquals("from@example.com", email.getFromAddress().getAddress());
    }
}
