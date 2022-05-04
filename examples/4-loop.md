# LOOP

## Archetype
```shell
mvn archetype:generate -DgroupId="org.camel.examples"  -DartifactId="loop" -DarchetypeGroupId="org.apache.camel.archetypes" -DarchetypeArtifactId="camel-archetype-spring-boot" -DinteractiveMode=false
```

```java 
from("direct:a")
    .loop(8)
        .to("mock:result");
```

```java
from("direct:b")
    .loop(header("loop"))
        .to("mock:result");
```