# java14-demo

This repo is a collection of some 
java features released since JDK 8

Reference article: https://advancedweb.hu/a-categorized-list-of-all-java-and-jvm-features-since-jdk-8-to-14/

### Switch Expressions
Preview in JDK 12 & JDK 13


```
int numLetters = switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY                -> 7;
    default      -> {
      String s = day.toString();
      int result = s.length();
      yield result;
    }
};
```

### Records
Preview in JDK 14

### Text Blocks
Preview in JDK 13 & JDK 14

### instanceof keyword
JDK 14

### Helpful NullPointerException messages
JDK 14

Must add `-XX:+ShowCodeDetailsInExceptionMessages` to VMOptions of configuration

### var keyword
JDK 11

### Collectors.teeing
JDK 12

### String enhancements: indent, transform, isBlank, lines, repeat, and strip
Added in JDK 11 & JDK 12

### HTTP Client
Added in JDK 11

```
HttpClient httpClient = HttpClient.newBuilder().build();

HttpRequest request =
  HttpRequest.newBuilder()
    .uri(URI.create("https://advancedweb.hu/"))
    .GET()
    .build();

HttpResponse<String> response =
  httpClient.send(request, BodyHandlers.ofString());
```

### Collection instantiation methods
Added in JDK 9

```
Set.of()
List.of()
Map.of()
```

### Launch Single-File Source-Code Programs
JDK 11

### Stream enhancements
JDK 9

- takeWhile, dropWhile
- Iterate
- ofNullable