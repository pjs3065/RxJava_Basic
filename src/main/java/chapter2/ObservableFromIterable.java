package chapter2;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ObservableFromIterable {
    /**
     * fromIterable()함수를 이용하여 list 객체 데이터 처리하기
     */
    private void listExample(){
        List<String> names = new ArrayList<>();
        names.add("Jerry");
        names.add("William");
        names.add("Bob");

        Observable<String> source = Observable.fromIterable(names);
        source.subscribe(System.out::println);
    }

    /**
     * fromIterable()함수를 이용하여 set 객체의 데이터 처리하기
     */
    private void setExample(){
        Set<String> cities = new HashSet<>();
        cities.add("Seoul");
        cities.add("London");
        cities.add("Paris");

        Observable<String> source = Observable.fromIterable(cities);
        source.subscribe(System.out::println);
    }

    /**
     * fromIterable()함수를 이용하여 BlockingQueue 배열 데이터 처리하기
     */
    private void blockingQueueExample(){
        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
        orderQueue.add(new Order("ORD-1"));
        orderQueue.add(new Order("ORD-2"));
        orderQueue.add(new Order("ORD-3"));

        Observable<Order> source = Observable.fromIterable(orderQueue);
        source.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableFromIterable obj = new ObservableFromIterable();
        obj.listExample();
        obj.setExample();
        obj.blockingQueueExample();
    }
}
