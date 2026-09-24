public class Main{
    public static void main(String[] args) {
        DynamicArray<Integer> a = new DynamicArray<>(1);
         a.removeLast();for (int i = 1; i <= 5; i++) {
            a.append(i);
            System.out.println("size=" + a.size() + " capacity=" + a.capacity());
        }
      
    }
}

