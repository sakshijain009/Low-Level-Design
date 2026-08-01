package Observer;

import Observable.StocksObservable;

public class SMSNotificationAlertObserverImpl implements NotificationAlertObserver{
    private final String phoneNumber;
    private final StocksObservable stocksObservable;

    public SMSNotificationAlertObserverImpl(String phoneNumber, StocksObservable stocksObservable) {
        this.phoneNumber = phoneNumber;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendEmail("Items are back in Stock!", stocksObservable.getDescription());
    }

    private void sendEmail(String message, String item) {
        System.out.println("SMS sent with message : " + message + " to " + phoneNumber + " for item " + item);
    }
}
