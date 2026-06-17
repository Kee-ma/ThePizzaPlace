public class Pizza extends GameObject {

    private PizzaInfo info;

    private long ovenStartTime;
    private long totalCookTime;

    private boolean inOven;
    private boolean removed;

    public Pizza(PizzaInfo info) {
        this.info = info;
    }

    //Code segment: OOP where each pizza object stores its own oven start time.
    public void putInOven() {
        if (!inOven && !removed) {
            inOven = true;
            ovenStartTime = System.currentTimeMillis();
        }
    }

    public void removeFromOven() {
        if (inOven) {
            totalCookTime =
                    (System.currentTimeMillis() - ovenStartTime) / 1000;

            inOven = false;
            removed = true;
        }
    }

    public long getTimeInOven() {
        if (inOven) {
            return (System.currentTimeMillis() - ovenStartTime) / 1000;
        }

        return totalCookTime;
    }

    public boolean isReady() {
        return getTimeInOven() >= 60;
    }

    public boolean isBurned() {
        return getTimeInOven() >= 70;
    }

    public boolean isInOven() {
        return inOven;
    }

    public boolean isRemoved() {
        return removed;
    }

    public PizzaInfo getInfo() {
        return info;
    }

    @Override
    public void update() {
    }
}
