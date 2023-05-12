import java.util.ArrayList;
import java.util.List;

// Subject (Observado)
interface Subject {
    void attach(ObserverInterface observer);
    void detach(ObserverInterface observer);
    void notifyObservers();
}

// Concrete Subject (Observado Concreto)
class ConcreteSubject implements Subject {
    private List<ObserverInterface> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(ObserverInterface observer) {
        observers.add(observer);
    }

    public void detach(ObserverInterface observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ObserverInterface observer : observers) {
            observer.update();
        }
    }
}

// Observer (Observador)
interface ObserverInterface {
    void update();
}

// Concrete Observer (Observador Concreto)
class ConcreteObserver implements ObserverInterface {
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
    }

    public void update() {
        int state = subject.getState();
        System.out.println("Estado atualizado para: " + state);
    }
}

// Exemplo de uso
public class Observer {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState(10);
        subject.setState(20);

        subject.detach(observer2);

        subject.setState(30);
    }
}