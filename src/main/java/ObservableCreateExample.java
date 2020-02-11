import io.reactivex.Observable;

public class ObservableCreateExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(
                emitter ->{
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                });

        source.subscribe(System.out::println);
    }
}
