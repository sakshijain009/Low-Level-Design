package Observer;

import Observable.StocksObservable;

public class EmailNotificationAlertObserverImpl implements NotificationAlertObserver{
    private final String email;
    private final StocksObservable stocksObservable;

    public EmailNotificationAlertObserverImpl(String email, StocksObservable stocksObservable) {
        this.email = email;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendEmail("Items are back in Stock!", stocksObservable.getDescription());
    }

    private void sendEmail(String message, String item) {
        System.out.println("Email sent with message : " + message + " to " + email + " for item " + item);
    }
}
