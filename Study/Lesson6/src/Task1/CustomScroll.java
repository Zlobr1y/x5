package Task1;

public interface CustomScroll<T> {

        int size();

        void add(T item);

        void remove(int index);

        void remove(T item);

        T get(int index);

        void clear();
    }

