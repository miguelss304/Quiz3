public class DynamicArray<T> {
    private T[] data;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public DynamicArray(int initialCapacity) { 
        if (initialCapacity < 1){
            throw new IllegalArgumentException("Capacidad inicial no valida");
        }
        
        data = (T[]) new Object[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity; 

    }

    private void checkIndex(int index) {
        if(index < 0){
            throw new IndexOutOfBoundsException("Indice negativo no valido");
        }
        if(index >= size){
            throw new IndexOutOfBoundsException("Indice " + index + " es mayor o igual al tamaño " + size);
        }
    }   

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, T value) { 
        checkIndex(index);
        data[index] = value;
    }

    public void append(T value) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        data[size] = value;
        size += 1;
    }

    public T removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("No hay elementos para eliminar");
        }
        T removed = data[size - 1];
        data[size - 1] = null;
        size -= 1;
        return removed;
    }
    
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        if (newCapacity < 1) {
            throw new IllegalArgumentException("Capacidad nueva no valida");
        }

        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
    }
}