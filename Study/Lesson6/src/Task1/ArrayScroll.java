package Task1;


public class ArrayScroll<T> implements CustomScroll<T> {
    private final int START_CAPACITY = 10;
    private int capacity;
    private final int MAX_SIZE = 2000;
    private int size;
    private Object[] array;

    public ArrayScroll() {
        this.capacity = START_CAPACITY;
        this.size = 0;
        this.array = new Object[START_CAPACITY];
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(T item) {
        if (this.size >= this.array.length) increaseArray();
        this.array[size] = item;
        this.size++;
    }

    @Override
    public void remove(int index) {
        Object[] newArray = new Object[this.array.length];
        for (int i = 0; i <= this.size; i++) {
            if (i < index) {
                newArray[i] = this.array[i];
            } else if (i > index) {
                newArray[i - 1] = this.array[i];
            }
        }
        this.array = newArray;
        size--;
    }

    @Override
    public void remove(T item) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(item)) remove(i);
        }
    }

    @Override
    public T get(int index) {
        T item = null;
        for (int i = 0; i <= this.size; i++) {
            if (i == index) {
                item = (T) this.array[i];
            }
        }
        if(item==null) throw new IndexOutOfBoundsException();
        return item;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.array[i] = null;
        }
        this.size = 0;
    }

    private void increaseArray() {
        this.capacity *= 2;
        Object[] newArray = new Object[this.capacity];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }
}