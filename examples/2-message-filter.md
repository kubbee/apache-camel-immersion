# Message - FILTER

## Archetype
```shell
mvn archetype:generate -DgroupId="org.camel.examples"  -DartifactId="message-filter" -DarchetypeGroupId="org.apache.camel.archetypes" -DarchetypeArtifactId="camel-archetype-spring-boot" -DinteractiveMode=false
```

## Example

```java
from("direct:a")
    .filter(simple("${header.foo} == 'bar'"))
        .to("direct:bar")
    .end()
    .to("direct:b")
```