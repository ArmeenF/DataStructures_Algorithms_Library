import java.util.*;

public class MyLinkedList<T> {
    Node<T> first;
    Node<T> last;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Iterator<T> iterator() {
        return new MyIterator<>(this);
    }

    public void add(T item) {
        if (isEmpty()) {
            first = new Node<>(item);
            last = first;
            size++;
        } else {
            MyIterator<T> itr = (MyIterator<T>) iterator();
            while (itr.hasNext()) {
                itr.next();
            }
            itr.curr.next = new Node<>(item);
            last = itr.curr.next;
            size++;
        }
    }

    public void add(int index, T item) {
        MyIterator<T> itr = (MyIterator<T>) iterator();
        if (isEmpty()) {
            add(item);
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            if (itr.hasNext()) {
                itr.next();
            }
        }
        Node<T> temp = itr.curr.next;
        itr.curr.next = new Node<T>(item);
        itr.curr.next.next = temp;
        size++;
        itr.next();
        if (!itr.hasNext()) {
            last = itr.curr;
        }

    }

    public T remove(int index) {
        MyIterator<T> itr = (MyIterator<T>) iterator();
        MyIterator<T> itr2 = (MyIterator<T>) iterator();
        itr2.next();
        if (isEmpty())
            return null;
        if (index >= size || index < 0) {
            return null;
        }
        if (index == 0) {
            T temp = first.item;
            first = first.next;
            size--;
            return temp;
        }
        for (int i = 0; i < index - 1; i++) {
            if (itr.hasNext()) {
                itr.next();
                itr2.next();
            }
        }
        if (itr2.curr != null) {
            itr.curr.next = itr2.curr.next;
            size--;
            return itr2.curr.item;
        } else {
            itr.curr.next = null;
            last = itr.curr;
            size--;
            return null;
        }
    }

    public T get(int index) {
        MyIterator<T> itr = (MyIterator<T>) iterator();
        if (isEmpty()) {
            return null;
        }
        if (index >= size || index < 0) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            if (itr.hasNext()) {
                itr.next();
            }
        }
        return (T) itr.curr.item;
    }

    public void set(int index, T item) {
        MyIterator<T> itr = (MyIterator<T>) iterator();
        if (isEmpty()) {
            return;
        }
        if (index >= size || index < 0) {
            return;
        }
        for (int i = 0; i < index; i++) {
            if (itr.hasNext()) {
                itr.next();
            }
        }
        itr.curr.item = item;
    }

    public String toString() {
        String str = "";
        MyIterator<T> itr = (MyIterator<T>) iterator();
        while (itr.hasNext()) {
            str += itr.curr.item.toString();
            itr.next();
        }
        str += itr.curr.item.toString();
        return str;
    }
}

class Node<t> {
    T item;
    Node<T> next;

    public Node(t i) {
        item = i;
    }

    public String toString() {
        return item.toString();
    }
}

class MyIterator<T> implements Iterator<T> {
    Node<t> curr;

    public MyIterator(MyLinkedList<t> list) {
        curr = list.first;
    }

    @Override
    public boolean hasNext() {
        return curr != null && curr.next != null;
    }

    @Override
    public T next() {
        curr = curr.next;
        return curr.item;
    }
}
