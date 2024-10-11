package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
//        database = new Database(); // We probably don't want to access our real database...
//        recommender = new RecSys();
//        promoService = new PromoService();


        database = mock(Database.class);
        when(database.getPassword("Scotty")).thenReturn(17214);

        recommender = mock(RecSys.class);
        when(recommender.getRecommendation("Scotty")).thenReturn("Animal House");

        promoService = mock(PromoService.class);

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        // Using fake to test login
        boolean loggedIn = andrewWebService.logIn("Scotty", 17214);
        assertTrue(loggedIn);
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        // Using stub to test recommendation
        String recommendation = andrewWebService.getRecommendation("Scotty");
        assertEquals("Animal House", recommendation);
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        // Using mock to test sendEmail
        andrewWebService.sendPromoEmail("zhixin@cmu.edu");
        verify(promoService).mailTo("zhixin@cmu.edu");
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        andrewWebService.logIn("Scotty", 17214);
        verifyNoInteractions(promoService);
    }
}
