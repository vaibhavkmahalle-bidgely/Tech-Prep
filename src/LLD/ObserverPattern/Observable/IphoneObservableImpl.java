package LLD.ObserverPattern.Observable;

import LLD.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer){
        observerList.add(observer);
    }

    public void remove(NotificationAlertObserver observer){
        observerList.remove(observer);
    }

    public void notifySuscribers(){
        for(NotificationAlertObserver observer : observerList){
           observer.update();
        }
    }

    public void setStockCount(int newStockAdded){
        if(stockCount == 0){
            notifySuscribers();
        }
        stockCount = stockCount + newStockAdded;
    }

    public int getStockCount(){
        return stockCount;
    }

}
