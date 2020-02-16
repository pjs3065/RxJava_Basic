package Chapter2;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ObservableNotification {
     Observable<String> source = Observable.just("RED", "GREEN", "YELLOW");
     Disposable d = source.subscribe(
            v -> System.out.println("onNext() : value : " + v),
            err -> System.out.println("onError() : err : " + err.getMessage()),
            () -> System.out.println("onComplete()")
    );
     
    public static void main(String[] args) {
        ObservableNotification on = new ObservableNotification();
        System.out.println("isDisposed() : " + on.d.isDisposed());
    }
}




