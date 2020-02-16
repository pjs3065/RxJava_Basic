package Chapter2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class ObservableCreateExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(
                emitter -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                });

        //메소드 레퍼런스로 축약 사용
//        source.subscribe(System.out::println);

        //람다로 사용
//        source.subscribe(data -> System.out.println(data));

        //익명객체로 사용
        source.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer data) throws Exception {
                System.out.println(data);
            }
        });
    }
}
