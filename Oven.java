public class Oven {
    private final int orderId;
    private final PizzaInfo info;
    
    private boolean inOven = false;
    private boolean burned = false;
    private boolean completed = false;
    
    private long ovenStart;
    private static final long bakeTime = 10000;
    
    public Pizza(int orderId, PizzaInfo info) {
        this.orderId = orderId;
        this.info = info;
    }

    @Override
    public void updateOven() {
        if (inOven && !burned) {
            if (System.currentTimeMillis() > ovenStart + bakeTime) {
                burned = true;
            }
        }
    }
    public void putInOven() {
        inOven = true;
        ovenStart = System.currentTimeMillis();
    }
    public boolean isBurned() {
        return burned;
    }

    public PizzaInfo getInfo() {
        return info;
    }

    public int getOrderId() {
        return orderId;
    }
}
