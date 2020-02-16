package Chapter2;

import io.reactivex.Observable;

import java.util.concurrent.Callable;

public class ObservableFromCallable {

    /**
     * fromCallable() 함수를 이용하여 Observable 만들기
     * 람다 표현식을 사용할때
     */
    private void basic(){
        Callable<String> callable = () -> {
          Thread.sleep(1000);
          return "Hello Callable";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }

    /**
     * fromCallable() 함수를 이용하여 Observable 만들기
     * 람다 표현식을 사용하지 않을때
     */
    private void withoutLambda(){
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Hello Callable";
            }
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableFromCallable obj = new ObservableFromCallable();
        obj.basic();
        obj.withoutLambda();
    }
}
