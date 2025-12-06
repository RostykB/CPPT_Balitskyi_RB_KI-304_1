package KI304.Balitskyi.Lab6;

public class KI_304BalitskyiLab6 {
    public static void main(String[] args) {
        SingleLinkedList mixedList = new SingleLinkedList();
        
        // Тепер один метод add для всіх!
        mixedList.add(new Student("Andriy", 85));
        mixedList.add(new Book("Java Basics", 45.5));
        mixedList.add(new Student("Oleh", 73));
        mixedList.add(new Book("C# Advanced", 38.0));
        
        System.out.println("Mixed list:");
        mixedList.display();
        System.out.println("Min element: " + mixedList.findMin());
    }
}