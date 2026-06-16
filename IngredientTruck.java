import java.util.Random;

public class IngredientTruck {

    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    private boolean present;

    private long nextSpawnTime;
    private long leaveTime;

    private Random random;

    public IngredientTruck() {

        random = new Random();

        scheduleNext();
    }

    public void update() {

        //now and.currentTimeMillis() logic suggested by ai, implemented by me
        long now = System.currentTimeMillis();

        // spawn truck
        if (!present && now >= nextSpawnTime) {

            present = true;
            leaveTime = now + 10000; // the time it stays for = 10s

            System.out.println(BLUE + "\nTruck has arrived!" + RESET);
        }

        // Make the truck leave
        if (present && now >= leaveTime) {

            present = false;

            System.out.println(RED + "\n Truck has left." + RESET);

            scheduleNext();
        }
    }

    private void scheduleNext() {

        // make next truck come 20-40 seconds after the last one has left
        nextSpawnTime = System.currentTimeMillis() + (20000 + random.nextInt(20000));
    }

    public boolean isPresent() {
        return present;
    }

    public void unload(Inventory inventory) {

        if (present) {
            inventory.restock();
            present = false;
            scheduleNext();
        }
    }
}
