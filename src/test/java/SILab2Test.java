import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SILab2Test {

    @Test
    public void testMultipleCondition() {
        RuntimeException ex;

        List<User> allUsers = new ArrayList<>();
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, allUsers));
        assertEquals("Mandatory information missing!", ex.getMessage());

        User user1 = new User("username", null, "kristijan@finki.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, allUsers));
        assertEquals("Mandatory information missing!", ex.getMessage());

        User user2 = new User("username", "password", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, allUsers));
        assertEquals("Mandatory information missing!", ex.getMessage());

        User user3 = new User("username", "password", "kristijan@finki.com");
        boolean expected = false;
        boolean actual = SILab2.function(user3, allUsers);
        assertEquals(expected, actual);
    }
}
