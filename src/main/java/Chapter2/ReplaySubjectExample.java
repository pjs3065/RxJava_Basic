package Chapter2;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample {

    public void marbleDiagram(){
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data ));
        subject.onNext("red");
        subject.onNext("green");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data ));
        subject.onNext("blue");
        subject.onComplete();
    }

    public static void main(String[] args) {
        ReplaySubjectExample obj = new ReplaySubjectExample();
        obj.marbleDiagram();
    }
}
