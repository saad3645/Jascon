package org.saadahmed.jascon

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import scala.util.Random
import scala.collection.mutable

/**
 * @author Saad Ahmed
 */
class JSONObjectTest extends AssertionsForJUnit {


	val testMap_Simple = Map("one" -> 1, "two" -> 2, "three" -> 3, "four" -> 4, "five" -> 5)
	val testLinkedHashMap_Simple = mutable.LinkedHashMap("one" -> 1, "two" -> 2, "three" -> 3, "four" -> 4, "five" -> 5)

	val testMap_Boolean = Map("one" -> true, "two" -> false)
	val testLinkedHashMap_Boolean = mutable.LinkedHashMap("one" -> true, "two" -> false)

	val testMap_RandomInt = Map("one" -> Random.nextInt(), "two" -> Random.nextInt(), "three" -> Random.nextInt(), "four" -> Random.nextInt(), "five" -> Random.nextInt())
	val testLinkedHashMap_RandomInt = mutable.LinkedHashMap("one" -> Random.nextInt(), "two" -> Random.nextInt(), "three" -> Random.nextInt(), "four" -> Random.nextInt(), "five" -> Random.nextInt())

	val testMap_RandomLong = Map("one" -> Random.nextLong(), "two" -> Random.nextLong(), "three" -> Random.nextLong(), "four" -> Random.nextLong(), "five" -> Random.nextLong())
	val testLinkedHashMap_RandomLong = mutable.LinkedHashMap("one" -> Random.nextLong(), "two" -> Random.nextLong(), "three" -> Random.nextLong(), "four" -> Random.nextLong(), "five" -> Random.nextLong())

	val testMap_RandomFloat = Map("one" -> Random.nextFloat(), "two" -> Random.nextFloat(), "three" -> Random.nextFloat(), "four" -> Random.nextFloat(), "five" -> Random.nextFloat())
	val testLinkedHashMap_RandomFloat = mutable.LinkedHashMap("one" -> Random.nextFloat(), "two" -> Random.nextFloat(), "three" -> Random.nextFloat(), "four" -> Random.nextFloat(), "five" -> Random.nextFloat())

	val testMap_RandomDouble = Map("one" -> Random.nextDouble(), "two" -> Random.nextDouble(), "three" -> Random.nextDouble(), "four" -> Random.nextDouble(), "five" -> Random.nextDouble())
	val testLinkedHashMap_RandomDouble = mutable.LinkedHashMap("one" -> Random.nextDouble(), "two" -> Random.nextDouble(), "three" -> Random.nextDouble(), "four" -> Random.nextDouble(), "five" -> Random.nextDouble())

	val testMap_SimpleString = Map("one" -> "Hydrogen", "two" -> "Helium", "three" -> "Lithium", "four" -> "Beryllium", "five" -> "Boron", "six" -> "Carbon", "seven" -> "Nitrogen", "eight" -> "Oxygen", "nine" -> "Fluorine", "ten" -> "Neon")
	val testLinkedHashMap_SimpleString = mutable.LinkedHashMap("one" -> "Hydrogen", "two" -> "Helium", "three" -> "Lithium", "four" -> "Beryllium", "five" -> "Boron", "six" -> "Carbon", "seven" -> "Nitrogen", "eight" -> "Oxygen", "nine" -> "Fluorine", "ten" -> "Neon")

	val testMap_RandomString = Map("one" -> Random.nextString(10), "two" -> Random.nextString(10), "three" -> Random.nextString(10), "four" -> Random.nextString(10), "five" -> Random.nextString(10))
	val testLinkedHashMap_RandomString = mutable.LinkedHashMap("one" -> Random.nextString(10), "two" -> Random.nextString(10), "three" -> Random.nextString(10), "four" -> Random.nextString(10), "five" -> Random.nextString(10))

	val testMap_Null = Map("nullKey" -> null, "noneKey" -> None)
	val testLinkedHashMap_Null = mutable.LinkedHashMap("nullKey" -> null, "noneKey" -> None)

	val testMap_SimpleMixed = Map("one" -> 1, "two" -> 2L, "three" -> 3.0F, "four" -> 4.45D, "five" -> "I am a string", "six" -> true, "seven" -> false, "eight" -> null)
	val testLinkedHashMap_SimpleMixed = mutable.LinkedHashMap("one" -> 1, "two" -> 2L, "three" -> 3.0F, "four" -> 4.45D, "five" -> "I am a string", "six" -> true, "seven" -> false, "eight" -> null)

	val testMap_SimpleArray = Map("one" -> Array(1,2,3,4,5), "two" -> List(6,7,8,9,10))
	val testLinkedHashMap_SimpleArray = mutable.LinkedHashMap("one" -> Array(1,2,3,4,5), "two" -> List(6,7,8,9,10))

	val testMap_MixedArray = Map("one" -> Array(1, 2L, 3.0F, 4.45D, "I am a string", true, null), "two" -> List(100, 200L, 0.3F, 0.45D, "I am also a string", false, None))
	val testLinkedHashMap_MixedArray = mutable.LinkedHashMap("one" -> Array(1, 2L, 3.0F, 4.45D, "I am a string", true, null), "two" -> List(100, 200L, 0.3F, 0.45D, "I am also a string", false, None))

	val testMap_SimpleObject = Map(
			"one" -> Map("key1" -> 1, "key2" -> 2, "key3" -> 3, "key4" -> 4, "key5" -> 5),
			"two" -> Map("key6" -> "six", "key7" -> "seven", "key8" -> "eight", "key9" -> "nine", "key10" -> "ten"))
	val testLinkedHashMap_SimpleObject = mutable.LinkedHashMap(
			"one" -> mutable.LinkedHashMap("key1" -> 1, "key2" -> 2, "key3" -> 3, "key4" -> 4, "key5" -> 5),
			"two" -> mutable.LinkedHashMap("key6" -> "six", "key7" -> "seven", "key8" -> "eight", "key9" -> "nine", "key10" -> "ten"))

	val testMap_MixedObject = Map(
			"widget1" -> Map("name" -> "widget1", "width" -> 300, "height" -> 250, "debug" -> true, "opacity" -> 0.85),
			"widget2" -> Map("name" -> "widget2", "x-pos" -> 500, "y-pos" -> 500, "debug" -> false, "opacity" -> 0.90))
	val testLinkedHashMap_MixedObject = mutable.LinkedHashMap(
			"widget1" -> mutable.LinkedHashMap("name" -> "widget1", "width" -> 300, "height" -> 250, "debug" -> true, "opacity" -> 0.85),
			"widget2" -> mutable.LinkedHashMap("name" -> "widget2", "x-pos" -> 500, "y-pos" -> 500, "debug" -> false, "opacity" -> 0.90))

	val testMap_Mixed = Map(
			"one" -> 1, "two" -> 2L, "three" -> 3.0F, "four" -> 4.45D, "five" -> "I am a string", "six" -> true, "seven" -> false, "eight" -> null,
			"nine" -> Array(1,2,3,4,5), "ten" -> List(6,7,8,9,10),
			"eleven" -> Map("name" -> "widget1", "width" -> 300, "height" -> 250, "debug" -> true, "opacity" -> 0.85),
			"twelve" -> mutable.LinkedHashMap("name" -> "widget2", "x-pos" -> 500, "y-pos" -> 500, "debug" -> false, "opacity" -> 0.90))

	val testLinkedHashMap_Mixed = mutable.LinkedHashMap(
			"one" -> 1, "two" -> 2L, "three" -> 3.0F, "four" -> 4.45D, "five" -> "I am a string", "six" -> true, "seven" -> false, "eight" -> null,
			"nine" -> Array(1,2,3,4,5), "ten" -> List(6,7,8,9,10),
			"eleven" -> mutable.LinkedHashMap("name" -> "widget1", "width" -> 300, "height" -> 250, "debug" -> true, "opacity" -> 0.85),
			"twelve" -> mutable.LinkedHashMap("name" -> "widget2", "x-pos" -> 500, "y-pos" -> 500, "debug" -> false, "opacity" -> 0.90))


	@Test
	def testConstructor_Empty() = {
		val value = Map.empty[String, Any]
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertTrue(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Simple() = {
		val value = testMap_Simple
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Boolean() = {
		val value = testMap_Boolean
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Int() = {
		val value = testMap_RandomInt
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Long() = {
		val value = testMap_RandomLong
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Float() = {
		val value = testMap_RandomFloat
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Double() = {
		val value = testMap_RandomDouble
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_SimpleString() = {
		val value = testMap_SimpleString
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_RandomString() = {
		val value = testMap_RandomString
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Null() = {
		val value = testMap_Null
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Mixed1() = {
		val value = testMap_SimpleMixed
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_SimpleArray() = {
		val value = testMap_SimpleArray
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_MixedArray() = {
		val value = testMap_MixedArray
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_SimpleObject() = {
		val value = testMap_SimpleObject
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_MixedObject() = {
		val value = testMap_MixedObject
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_Mixed2() = {
		val value = testMap_Mixed
		val obj = JsonObject(value)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(value.size, obj.value.size)
		assertEquals(value.size, obj.size)
	}

	@Test
	def testConstructor_KVPairs_Boolean() = {
		val obj = JsonObject("one" -> true, "two" -> false)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(2, obj.value.size)
		assertEquals(2, obj.size)
	}

	@Test
	def testConstructor_KVPairs_Int() = {
		val obj = JsonObject("one" -> 1, "two" -> 2, "three" -> 3, "four" -> 4, "five" -> 5)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(5, obj.value.size)
		assertEquals(5, obj.size)
	}

	@Test
	def testConstructor_KVPairs_Long() = {
		val obj = JsonObject("one" -> 1L, "two" -> 2L, "three" -> 3L, "four" -> 4L, "five" -> 5L)

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(5, obj.value.size)
		assertEquals(5, obj.size)
	}

	@Test
	def testConstructor_KVPairs_String() = {
		val obj = JsonObject("H" -> "Hydrogen", "He" -> "Helium", "Li" -> "Lithium", "Be" -> "Beryllium", "B" -> "Boron", "C" -> "Carbon", "N" -> "Nitrogen", "O" -> "Oxygen", "F" -> "Fluorine", "Ne" -> "Neon")

		assertNotNull(obj)
		assertNotNull(obj.value)
		assertTrue(obj.isInstanceOf[JsonCollection[_]])
		assertTrue(obj.isInstanceOf[JsonObject])
		assertTrue(obj.isNonNull)
		assertTrue(obj.isCollection)
		assertTrue(obj.isObject)
		assertFalse(obj.isEmpty)
		assertEquals(10, obj.value.size)
		assertEquals(10, obj.size)
	}

	@Test(expected = classOf[IllegalArgumentException])
	def testNullKey_AddOperator(): Unit = {
		val value = testMap_Simple
		val obj = JsonObject(value)

		obj += (null, 6)
		return Unit
	}

	@Test(expected = classOf[IllegalArgumentException])
	def testNullKey_Apply(): Unit = {
		val value = testMap_Simple
		val obj = JsonObject(value)

		obj(null)
		return Unit
	}

	@Test(expected = classOf[IllegalArgumentException])
	def testNullKey_Get(): Unit = {
		val value = testMap_Simple
		val obj = JsonObject(value)

		obj.get[Int](null)
		return Unit
	}

	@Test(expected = classOf[IllegalArgumentException])
	def testNullKey_Offer(): Unit = {
		val value = testMap_Simple
		val obj = JsonObject(value)

		obj.offer(null, 6)
		return Unit
	}

	@Test(expected = classOf[IllegalArgumentException])
	def testNullKey_Put(): Unit = {
		val value = testMap_Simple
		val obj = JsonObject(value)

		obj.put(null, 6)
		return Unit
	}

	@Test(expected = classOf[IllegalArgumentException])
	def testNullKey_Update(): Unit = {
		val value = testMap_Simple
		val obj = JsonObject(value)

		obj(null) = 6
		return Unit
	}

	@Test
	def testApplyOperator_Simple() = {
		val value = testMap_Simple
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testApplyOperator_Boolean() = {
		val value = testMap_Boolean
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testApplyOperator_Int() = {
		val value = testMap_RandomInt
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testApplyOperator_Long() = {
		val value = testMap_RandomLong
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testApplyOperator_Float() = {
		val value = testMap_RandomFloat
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testApplyOperator_Double() = {
		val value = testMap_RandomDouble
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testApplyOperator_String() = {
		val value = testMap_RandomString
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testApplyOperator_Null() = {
		val value = testMap_Null
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNull)
			assertEquals(None, obj(key).value)
		}
	}

	@Test
	def testApplyOperator_Mixed1() = {
		val value = testMap_SimpleMixed
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			if (value != null && value != None) {
				assertTrue(obj(key).isNonNull)
				assertEquals(value, obj(key).value)
			}
			else {
				assertTrue(obj(key).isNull)
				assertEquals(None, obj(key).value)
			}
		}
	}

	@Test
	def testApplyOperator_SimpleArray() = {
		val value = testMap_SimpleArray
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertTrue(obj(key).isInstanceOf[JsonArray])
			if (value.isInstanceOf[Array[_]]) {
				assertEquals(value.asInstanceOf[Array[_]].length, obj(key).asInstanceOf[JsonArray].length)
			}
			else {
				assertEquals(value.asInstanceOf[Seq[_]].length, obj(key).asInstanceOf[JsonArray].length)
			}
		}
	}

	@Test
	def testApplyOperator_MixedArray() = {
		val value = testMap_MixedArray
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertTrue(obj(key).isInstanceOf[JsonArray])
			if (value.isInstanceOf[Array[_]]) {
				assertEquals(value.asInstanceOf[Array[_]].length, obj(key).asInstanceOf[JsonArray].length)
			}
			else {
				assertEquals(value.asInstanceOf[Seq[_]].length, obj(key).asInstanceOf[JsonArray].length)
			}
		}
	}

	@Test
	def testApplyOperator_SimpleObject() = {
		val value = testMap_SimpleObject
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertTrue(obj(key).isInstanceOf[JsonObject])
			assertEquals(value.size, obj(key).asInstanceOf[JsonObject].size)
		}
	}

	@Test
	def testApplyOperator_MixedObject() = {
		val value = testMap_MixedObject
		val obj = JsonObject(value)

		for ((key, value) <- value) {
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertTrue(obj(key).isInstanceOf[JsonObject])
			assertEquals(value.size, obj(key).asInstanceOf[JsonObject].size)
		}
	}

	@Test
	def testAddOperator_Simple() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_Simple
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_Boolean() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_Boolean
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_Int() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_RandomInt
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_Long() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_RandomLong
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_Float() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_RandomFloat
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_Double() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_RandomDouble
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_SimpleString() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_SimpleString
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_RandomString() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_RandomString
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertEquals(value, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_Null() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_Null
		var i = 0
		for((key, value) <- value) {
			obj += (key, value)
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNull)
			assertEquals(None, obj(key).value)
		}
	}

	@Test
	def testAddOperator_Empty_SimpleMixed() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_SimpleMixed
		var i = 0
		for((key, value) <- value) {
			obj += (key, JsonType(value))
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			if (value != null) {
				assertTrue(obj(key).isNonNull)
				assertEquals(value, obj(key).value)
			}
			else {
				assertTrue(obj(key).isNull)
				assertEquals(None, obj(key).value)
			}
		}
	}

	@Test
	def testAddOperator_Empty_SimpleArray() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_SimpleArray
		var i = 0
		for((key, value) <- value) {
			obj += (key, JsonType(value))
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertTrue(obj(key).isCollection)
			assertTrue(obj(key).isArray)
		}
	}

	@Test
	def testAddOperator_Empty_SimpleObject() = {
		val initial = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(initial)
		val size = obj.size

		val value = testMap_SimpleObject
		var i = 0
		for((key, value) <- value) {
			obj += (key, JsonType(value))
			i = i + 1

			assertEquals(size + i, obj.size)
			assertNotNull(obj(key))
			assertTrue(obj(key).isNonNull)
			assertTrue(obj(key).isCollection)
			assertTrue(obj(key).isObject)
		}
	}

	@Test
	def testToString_Empty() = {
		val value = mutable.LinkedHashMap.empty[String, Any]
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{}", str)
	}

	@Test
	def testToString_Simple() = {
		val value = testLinkedHashMap_Simple
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":1,\"two\":2,\"three\":3,\"four\":4,\"five\":5}", str)
	}

	@Test
	def testToString_Boolean() = {
		val value = testLinkedHashMap_Boolean
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":true,\"two\":false}", str)
	}

	@Test
	def testToString_Int() = {
		val value = testLinkedHashMap_RandomInt
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":" + value("one") + ",\"two\":" + value("two") + ",\"three\":" + value("three") + ",\"four\":" + value("four") + ",\"five\":" + value("five") + "}", str)
	}

	@Test
	def testToString_Long() = {
		val value = testLinkedHashMap_RandomLong
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":" + value("one") + ",\"two\":" + value("two") + ",\"three\":" + value("three") + ",\"four\":" + value("four") + ",\"five\":" + value("five") + "}", str)
	}

	@Test
	def testToString_Float() = {
		val value = testLinkedHashMap_RandomFloat
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":" + value("one") + ",\"two\":" + value("two") + ",\"three\":" + value("three") + ",\"four\":" + value("four") + ",\"five\":" + value("five") + "}", str)
	}

	@Test
	def testToString_Double() = {
		val value = testLinkedHashMap_RandomDouble
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":" + value("one") + ",\"two\":" + value("two") + ",\"three\":" + value("three") + ",\"four\":" + value("four") + ",\"five\":" + value("five") + "}", str)
	}

	@Test
	def testToString_SimpleString() = {
		val value = testLinkedHashMap_SimpleString
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":\"Hydrogen\",\"two\":\"Helium\",\"three\":\"Lithium\",\"four\":\"Beryllium\",\"five\":\"Boron\",\"six\":\"Carbon\",\"seven\":\"Nitrogen\",\"eight\":\"Oxygen\",\"nine\":\"Fluorine\",\"ten\":\"Neon\"}", str)
	}

	@Test
	def testToString_RandomString() = {
		val value = testLinkedHashMap_RandomString
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":\"" + value("one") + "\",\"two\":\"" + value("two") + "\",\"three\":\"" + value("three") + "\",\"four\":\"" + value("four") + "\",\"five\":\"" + value("five") + "\"}", str)
	}

	@Test
	def testToString_String_DoubleQuotes() = {
		val value = mutable.LinkedHashMap("one" -> "I am a string", "two" -> "I am a string with \'single quote\'", "three" -> "I am a string with \"double quote\"")
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":\"I am a string\",\"two\":\"I am a string with \'single quote\'\",\"three\":\"I am a string with \\\"double quote\\\"\"}", str)
	}

	@Test
	def testToString_Null() = {
		val value = testLinkedHashMap_Null
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"nullKey\":null,\"noneKey\":null}", str)
	}

	@Test
	def testToString_Mixed1() = {
		val value = testLinkedHashMap_SimpleMixed
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":" + value("one") + ",\"two\":" + value("two") + ",\"three\":" + value("three") + ",\"four\":" + value("four") + ",\"five\":" + "\"" + value("five") + "\"" + ",\"six\":" + value("six") + ",\"seven\":" + value("seven") + ",\"eight\":" + value("eight") + "}", str)
	}

	@Test
	def testToString_SimpleArray() = {
		val value = testLinkedHashMap_SimpleArray
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":[1,2,3,4,5],\"two\":[6,7,8,9,10]}", str)
	}

	@Test
	def testToString_MixedArray() = {
		val value = testLinkedHashMap_MixedArray
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":[1,2,3.0,4.45,\"I am a string\",true,null],\"two\":[100,200,0.3,0.45,\"I am also a string\",false,null]}", str)
	}

	@Test
	def testToString_SimpleObject() = {
		val value = testLinkedHashMap_SimpleObject
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":{\"key1\":1,\"key2\":2,\"key3\":3,\"key4\":4,\"key5\":5},\"two\":{\"key6\":\"six\",\"key7\":\"seven\",\"key8\":\"eight\",\"key9\":\"nine\",\"key10\":\"ten\"}}", str)
	}

	@Test
	def testToString_MixedObject() = {
		val value = testLinkedHashMap_MixedObject
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"widget1\":{\"name\":\"widget1\",\"width\":300,\"height\":250,\"debug\":true,\"opacity\":0.85},\"widget2\":{\"name\":\"widget2\",\"x-pos\":500,\"y-pos\":500,\"debug\":false,\"opacity\":0.9}}", str)
	}

	@Test
	def testToString_Mixed2() = {
		val value = testLinkedHashMap_Mixed
		val obj = JsonObject(value)
		val str = obj.toString

		println(str)
		assertEquals("{\"one\":1,\"two\":2,\"three\":3.0,\"four\":4.45,\"five\":\"I am a string\",\"six\":true,\"seven\":false,\"eight\":null,\"nine\":[1,2,3,4,5],\"ten\":[6,7,8,9,10],\"eleven\":{\"name\":\"widget1\",\"width\":300,\"height\":250,\"debug\":true,\"opacity\":0.85},\"twelve\":{\"name\":\"widget2\",\"x-pos\":500,\"y-pos\":500,\"debug\":false,\"opacity\":0.9}}", str)
	}
}
