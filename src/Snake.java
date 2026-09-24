public class Snake {
    private Position[] data;
    private int tail;
    private int size;
    private int capacity;

    public Snake(Position tailPos, Position headPos) {
        size = 2;
        capacity = 2;
        data = new Position[capacity];
        tail = 0;
        data[tail] = tailPos;
        data[(tail + size - 1) % capacity] = headPos;
    }

    public void addHead(Position p) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        data[(tail + size) % capacity] = p;
        size++;
    }

    public Position removeTail() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("No hay cola a eliminar");
        }
        Position removed = data[tail];
        data[tail] = null;
        tail = (tail + 1) % capacity;
        size--;
        return removed;
    }

    public Position get(int logicalIndex) {
        if (logicalIndex < 0) {
            throw new IndexOutOfBoundsException("Indice negativo no valido");
        }
        if (logicalIndex >= size) {
            throw new IndexOutOfBoundsException(
                "Indice " + logicalIndex + " es mayor o igual al tamaño " + size);
        }
        return data[(tail + logicalIndex) % capacity];
    }

    private void resize(int newCapacity) {
        if (newCapacity < size) {
            throw new IllegalArgumentException("Capacidad nueva no valida");
        }

        Position[] newData = new Position[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(tail + i) % capacity];
        }
        data = newData;
        capacity = newCapacity;
        tail = 0;
    }

    // ---- Solo para inspeccion desde Main (no forman parte del diseño) ----

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int tail() {
        return tail;
    }

    /** Indice fisico de la cabeza, derivado (no se almacena). */
    public int headIndex() {
        return (tail + size - 1) % capacity;
    }

    /** Contenido fisico completo de data, con "." en las celdas vacias. */
    public String physicalString(String[] names) {
        String s = "[";
        for (int i = 0; i < capacity; i++) {
            if (i > 0) {
                s += " ";
            }
            s += (data[i] == null) ? "." : nameOf(data[i], names);
        }
        return s + "]";
    }

    /** Orden logico (cola -> cabeza). */
    public String logicalString(String[] names) {
        String s = "";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                s += " ";
            }
            s += nameOf(get(i), names);
        }
        return s;
    }

    private String nameOf(Position p, String[] names) {
        int id = p.row();
        return (id >= 0 && id < names.length) ? names[id] : p.toString();
    }
}