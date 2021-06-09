## Javers Error
Javers can't correctly work with object structure like:

```
class A {
  private B b;
  private Map<String, List<C>> map;
}
```

It will throw:

```
java.lang.NullPointerException
	at org.javers.core.json.typeadapter.commit.GlobalIdTypeAdapter.parseUnboundedValueObject(GlobalIdTypeAdapter.java:49)
	at org.javers.core.json.typeadapter.commit.GlobalIdTypeAdapter.fromJson(GlobalIdTypeAdapter.java:44)
	at org.javers.core.json.typeadapter.commit.GlobalIdTypeAdapter.fromJson(GlobalIdTypeAdapter.java:19)
	.....
```

When trying to deal with Map<String, List<C>>.

## How to reproduce
Open in your chosen IDE and run AServiceTest