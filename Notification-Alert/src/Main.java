import Observable.IphoneObservableImpl;
import Observable.StocksObservable;
import Observer.EmailNotificationAlertObserverImpl;
import Observer.NotificationAlertObserver;
import Observer.SMSNotificationAlertObserverImpl;

public class Main {
    public static void main(String[] args) {
        StocksObservable iphoneStocksObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailNotificationAlertObserverImpl("user1@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer2 = new SMSNotificationAlertObserverImpl("9800789899", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new EmailNotificationAlertObserverImpl("user2@gmail.com", iphoneStocksObservable);

        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);

        System.out.println("Current Stock : " + iphoneStocksObservable.getStockCount());

        iphoneStocksObservable.setStockCount(10);

        System.out.println("Current Stock : " + iphoneStocksObservable.getStockCount());
    }
}