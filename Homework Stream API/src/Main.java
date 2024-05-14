import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
//        list.stream()
//                .filter(number -> number >= 0)
//                .filter(number -> number % 2 == 0)
//                .sorted(Comparator.naturalOrder())
//                .forEach(System.out::println);

//        List<Integer> result = list.stream()
//                .filter(number -> number >= 0)
//                .filter(number -> number % 2 == 0)
//                .sorted(Comparator.naturalOrder())
//                .collect(Collectors.toList());
//        System.out.println(result);

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long numberMinors = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(numberMinors);

        List<String> conscripts = persons.stream()
                .filter(x -> x.getAge() > 17)
                .filter(x -> x.getAge() < 28)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(conscripts);

        List<Person> manCanWork = persons.stream()
                .filter(x -> x.getAge() > 17)
                .filter(x -> x.getAge() < 66)
                .filter(x -> x.getSex().equals(Sex.MAN))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(manCanWork);

        List<Person> womenCanWork = persons.stream()
                .filter(x -> x.getAge() > 17)
                .filter(x -> x.getAge() < 61)
                .filter(x -> x.getSex().equals(Sex.WOMAN))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(womenCanWork);
    }
}

class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}