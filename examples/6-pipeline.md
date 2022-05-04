# PIPELINE

## Archetype
```shell
mvn archetype:generate -DgroupId="org.camel.examples"  -DartifactId="pipeline" -DarchetypeGroupId="org.apache.camel.archetypes" -DarchetypeArtifactId="camel-archetype-spring-boot" -DinteractiveMode=false
```

```java
from("activemq:cheese")
    .pipeline()
        .to("bean:foo")
        .to("bean:bar")
        .to("direct:logBody");

from("direct:logBody")
        .log(LoggingLevel.DEBUG, ROUTE_ID + ".inoutBody", "INOUT: ${body}");
```