package base.singleton.static_inner_class;

public class Singleton {

    private Singleton() {}

    private static Singleton getInstance() {
        return SingletonHandler.SINGLETON;
    }

    private static class SingletonHandler {
        private final static Singleton SINGLETON = new Singleton();
    }

}
