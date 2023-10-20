import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {

    private final List<Actor> queue;

    public Market() {

        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        takeInQueue(actor);
    }





    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " занял очереь");
        this.queue.add(actor);

    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " оформил заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> actorsList = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder) {
                actorsList.add(actor);
                System.out.println(actor.getName() + " готов выходить");
            }

        }
        releaseFromMarket(actorsList);
    }
    @Override
    public void releaseFromMarket(List<Actor> actorsList) {
        for (Actor actor : queue) {
            System.out.println(actor.getName() + " Вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();


    }
}
