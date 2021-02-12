package chapter2;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;

public class ConnectableObservableExample {
    public void marbleDiagram() throws InterruptedException {
        //발행할 데이터
        String[] dt = {"red","green","blue"};

        //데이터 발행자
        Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> dt[i])
                .take(dt.length);

        //객체생성
        ConnectableObservable<String> source = balls.publish();

        //구독자 추가
        source.subscribe(data -> System.out.println("Subscriber #1 => " + data ));
        source.subscribe(data -> System.out.println("Subscriber #2 => " + data ));

        //구독 시작
        source.connect();

        Thread.sleep(250L);

        //구독자 추가
        source.subscribe(data -> System.out.println("Subscriber #3 => " + data ));
        Thread.sleep(100L);
    }

    public static void main(String[] args) throws InterruptedException {
        ConnectableObservableExample obj = new ConnectableObservableExample();
        obj.marbleDiagram();
    }
}
