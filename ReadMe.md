# Rendering JSON

Related Standard: SPR0019-V1 - Manage JSON

## Objectives

By the end of this lesson you will:

- Render a JSON object in a response
- Render a list of JSON objects in a response

## Rationale

Accessing data that's passed to your application is only half of the equation.  If you are building a JSON API you also need to _serve_ JSON responses.

## Render a JSON object in a response

If you use the `@RequestMapping` annotation on your Controller class, all you need to do is return an object from your route method, and Spring will automatically serialize it to JSON for you 👍

### Example: Simple Object

NOTE: the "package" and import statements have been left out intentionally.  Use your IDE's "import" keybindings to import these, and make sure the package matches your application's package.

```java
@RestController
@RequestMapping("/json")
public class JSONController {

    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.firstName = "Dwayne";
        person.lastName = "Johnson";
        return person;
    }

    public static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

}
```

Issuing a `GET` to `/json/person` would render:

```json
{
  "firstName": "Dwayne",
  "lastName": "Johnson"
}
```

## Render a list of JSON objects in a response

To render a list, simply have your controller method return a List or Array of objects.

### Example: Lists

```java
@RestController
@RequestMapping("/json")
public class JSONController {

    @GetMapping("/people")
    public List<Person> getPeople() {
        Person person1 = new Person();
        person1.firstName = "Dwayne";
        person1.lastName = "Johnson";

        Person person2 = new Person();
        person2.firstName = "John";
        person2.lastName = "Cena";

        return Arrays.asList(person1, person2);
    }

    public static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

}
```

Issuing a `GET` to `/json/people` would render:

```json
[
  {
    "firstName": "Dwayne",
    "lastName": "Johnson"
  },
  {
    "firstName": "John",
    "lastName": "Cena"
  }
]
```
