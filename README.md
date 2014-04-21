Overview
========

Jascon is a Json library for Scala. Although Scala provides a native JSON package for parsing and printing json data, I feel like we need a more powerful set of classes similar to Java's Jackson to be able to work with JSON data, and at the same time take advantage of some of Scala's syntax (operator overloading, for instance). Jascon is an attempt to provide the same functionality and features to Scala developers that Jackson provide to Java developers.


<br/>
This project is under development and incomplete. Please submit pull requests if you want to see a feature included.


Usage
=====

Parsing
-------

Parsing a JSON Object
```scala
val sourceStr = "{\"firstName\": \"John\", \"lastName\": \"Smith\", \"isAlive\": true, \"age\": 25, \"height_cm\": 167.64}"

val obj: JsonObject = JsonObject(sourceStr)
```

Parsing a JSON Array
```scala
val sourceStr = "[100, 500, 300, 200, 400]"

val arr: JsonArray = JsonArray(sourceStr)
```

<br/>
If you are unsure whether the source string is a JSONObject or a JSONArray, use the parse method in Json object:
```scala
val js: JsonType = Json.parse(sourceStr)
if (js.isArray) {
    val arr: JsonArray = js.asArray
    ...
}
else if (js.isObject) {
    val obj: JsonObject = js.asObject
    ...
}
```

Addition
--------

JsonObject
----------

```scala
val obj: JsonObject = JsonObject("red" -> "#ff0000")
obj += ("green", "#00ff00")
obj += ("blue", "#0000ff")

// resulting JSON:
// {"red": "#ff0000", "green": ""#00ff00", "blue": "#0000ff"}
```

JsonArray
--------

```scala
val arr: JsonArray = JsonArray(Seq("red"))
arr += "green"
arr += "blue"

// resulting JSON:
// ["red", "green", "blue"]
```


<br/>
This guide is under development and more example usages will be provided later.



License
-------

Unless otherwise mentioned this project and its individual files are licensed under the Apache 2.0 license. See the LICENSE file for a full description.
