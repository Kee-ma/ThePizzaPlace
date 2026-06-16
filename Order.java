public class Order extends GameObject {

    private static int nextId = 1;

    private int id;
    private PizzaInfo info;
    private boolean completed;

    public Order(PizzaInfo info) {

        id = nextId++;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public PizzaInfo getInfo() {
        return info;
    }

    public void complete() {
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void update() {
    }

    @Override
    public String toString() {

        return "-------------------\n" + "Order #" + id + " -> " + info;
    }

}
