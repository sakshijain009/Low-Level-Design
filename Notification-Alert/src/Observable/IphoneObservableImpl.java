package Observable;

import Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable{
    private final List<NotificationAlertObserver> observerList = new ArrayList<>();
    private int stockCount = 0;


    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observerList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifyMembers() {
        for(NotificationAlertObserver notificationAlertObserver : observerList) {
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if(stockCount == 0) {
            notifyMembers();
        }
        stockCount = newStockCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

    @Override
    public String getDescription() {
        return "Iphone 17 pro max";
    }
}
