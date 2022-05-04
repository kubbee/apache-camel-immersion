# WIRETAP

## Archetype
```shell
mvn archetype:generate -DgroupId="org.camel.examples"  -DartifactId="wiretap" -DarchetypeGroupId="org.apache.camel.archetypes" -DarchetypeArtifactId="camel-archetype-spring-boot" -DinteractiveMode=false
```

```java
from("direct:start").routeId(ROUTE_ID)
        .wireTap("direct:logBody")
        .split().body()
        .choice()
        .when(body().isEqualTo("Camel"))
            .log("${body} is awesome")
        .otherwise()
            .log("${body} kinda sucks")
        .end()
        .wireTap("direct:logBody");

from("direct:logBody")
        .log(LoggingLevel.DEBUG, ROUTE_ID + ".inoutBody", "INOUT: ${body}");
```