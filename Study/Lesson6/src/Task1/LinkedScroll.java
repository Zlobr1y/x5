package Task1;

public class LinkedScroll<T> implements CustomScroll<T> {
    private int size;
    private Node<T> firstElement;
    private Node<T> lastElement;

    public LinkedScroll() {
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(T item) {
        Node<T> node = new Node<T>(item, null, null);
        if (size == 0) {
            this.firstElement = node;
            this.lastElement = node;
        } else {
            this.lastElement.next = node;
            node.prev = this.lastElement;
            this.lastElement = node;
        }
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException();
        Node<T> node = getNode(index);
        if (node.next == null && this.lastElement == node) {
            node.prev.next = null;
            this.lastElement = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.drop();
        size--;
    }

    @Override
    public void remove(T item) {
        Node<T> current = this.firstElement;
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (current.item.equals(item)) {
                index = i;
                break;
            }
            current = current.next;
        }
        remove(index);
    }

    @Override
    public T get(int index) {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        T item = getNode(index).item;
        if (item == null) throw new IndexOutOfBoundsException();
        return item;
    }

    private Node<T> getNode(int index) {
        Node<T> current = this.firstElement;
        int i = 0;
        while (current != null) {
            if (i == index) {
                break;
            }
            current = current.next;
            i++;
        }
        return current;
    }

    @Override
    public void clear() {
        this.firstElement = null;
        this.lastElement = null;
        this.size = 0;
    }

    private class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;

        }

        void drop() {
            this.item = null;
            this.next = null;
            this.prev = null;
        }
    }
}
