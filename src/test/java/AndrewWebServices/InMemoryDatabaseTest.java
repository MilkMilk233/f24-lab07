package AndrewWebServices;

public class InMemoryDatabaseTest {
    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();

        db.setPassword("Scotty", 17214);
        db.setPassword("Ex10si0n", 12345);

        System.out.println(db.getPassword("Scotty")); // 17214
        System.out.println(db.getPassword("Ex10si0n")); // 12345
        System.out.println(db.getPassword("Petter Griffin")); // 0
    }
}
