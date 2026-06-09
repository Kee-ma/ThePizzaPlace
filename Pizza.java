public class Pizza {
    private final int orderId;
    private final PizzaInfo info;
    
    private boolean inOven;
    private boolean burned;
    private boolean completed;
    
    private long ovenStart;
    private static final long bakeTime = 10000;
    
    public Pizza(int orderId, PizzaInfo info) {
        this.orderId = orderId;
        this.info = info;
    }
    
    public PizzaInfo getInfo() {
        return info;
    }
    
    public void putInOven() {
        inOven = true;
        ovenStart = System.currentTimeMillis();
    }
    
    public void updateOven() {
        if (inOven && !burned) {
            if (System.currentTimeMillis() > ovenStart + bakeTime) {
                burned = true;
            }
        }
    }
    public boolean isBurned() {
        return burned;
    }
}
