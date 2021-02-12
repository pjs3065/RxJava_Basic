package chapter2;

import io.reactivex.Observable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class ObservableFromPublisher {

    /**
     * fromPublisher() 함수를 이용하여 Observable 만들기
     * 람다식으로 표현할 때
     */
    private void basic(){
        Publisher<String> publisher = (Subscriber<? super String> s) -> {
            s.onNext("Hello Observable.fromPublisher()");
            s.onComplete();
        };
        Observable<String> source = Observable.fromPublisher(publisher);
        source.subscribe(System.out::println);
    }

    /**
     * fromPublisher() 함수를 이용하여 Observable 만들기
     * 람다식으로 표현하지 않을 때
     */
    private void withoutLambda(){
        Publisher<String> publisher = new Publisher<String>(){
            @Override
            public void subscribe(Subscriber<? super String> s) {
                s.onNext("Hello Observable.fromPublisher()");
                s.onComplete();
            }
        };
        Observable<String> source = Observable.fromPublisher(publisher);
        source.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableFromPublisher obj = new ObservableFromPublisher();
        obj.basic();
        obj.withoutLambda();
    }
}
