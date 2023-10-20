public abstract class Actor implements ActorBehavoir {
    protected final String name;


    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    protected Actor(String name) {
        this.name = name;
    }

    abstract String getName();

}
