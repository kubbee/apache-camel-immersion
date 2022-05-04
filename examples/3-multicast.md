# Message - FILTER

## Archetype
```shell
mvn archetype:generate -DgroupId="org.camel.examples"  -DartifactId="multicast" -DarchetypeGroupId="org.apache.camel.archetypes" -DarchetypeArtifactId="camel-archetype-spring-boot" -DinteractiveMode=false
```

## Example

```java
from("direct:a")
  .multicast()
    .to("direct:x")
    .to("direct:y")
    .to("direct:z");
```

```java
from("direct:a")
  .multicast().parallelProcessing()
    .to("direct:x")
    .to("direct:y")
    .to("direct:z");
```


```java
from("direct:start")
  .multicast(new MyAggregationStrategy()).parallelProcessing().timeout(500)
    .to("direct:x")
    .to("direct:y")
    .to("direct:z")
  .end()
  .to("mock:result");
```
```java
package org.apache.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.UseLatestAggregationStrategy;

/**
*/
public class MyAggregationStrategy extends UseLatestAggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        Exchange result = super.aggregate(oldExchange, newExchange);
        if (oldExchange == null) {
            result.setProperty("aggregated", 1);
        } else {
            Integer old = oldExchange.getProperty("aggregated", Integer.class);
            result.setProperty("aggregated", old + 1);
        }
        return result;
    }

}
```