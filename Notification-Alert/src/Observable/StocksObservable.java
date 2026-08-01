package Observable;

import Observer.NotificationAlertObserver;

public interface StocksObservable {

    void add(NotificationAlertObserver notificationAlertObserver);

    void remove(NotificationAlertObserver notificationAlertObserver);

    void notifyMembers();

    void setStockCount(int stockCount);

    int getStockCount();

    String getDescription();
}
