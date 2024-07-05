class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}


class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        String tempName = p1.name;
        int tempAge = p1.age;

        p1.name = p2.name;
        p1.age = p2.age;

        p2.name = tempName;
        p2.age = tempAge;
    }
  
  
  public static void main(String[] args) {
    Person person1 = new Person("Jane Doe", 30);
    Person person2 = new Person("John Doe", 25);

    System.out.println("Before swapping:");
    System.out.println("Person 1: " + person1.getName() + ", " + person1.getAge());
    System.out.println("Person 2: " + person2.getName() + ", " + person2.getAge());

    changeIdentities(person1, person2);

    System.out.println("\nAfter swapping:");
    System.out.println("Person 1: " + person1.getName() + ", " + person1.getAge());
    System.out.println("Person 2: " + person2.getName() + ", " + person2.getAge());

  }

}