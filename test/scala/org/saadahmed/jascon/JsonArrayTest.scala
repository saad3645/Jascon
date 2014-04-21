package org.saadahmed.jascon

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import scala.util.Random


/**
 * @author Saad Ahmed
 */
class JsonArrayTest extends AssertionsForJUnit {

	@Test
	def testConstructor_EmptyArray() = {
		val value = Array.empty
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertTrue(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_EmptyList() = {
		val value = List.empty
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertTrue(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_BooleanArray() = {
		val value = Array(true, false)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_BooleanList() = {
		val value = List(true, false)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_IntArray() = {
		val value = Array(1,2,3,4,5)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_IntList() = {
		val value = List(1,2,3,4,5)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_LongArray() = {
		val value = Array(1L,2L,3L,4L,5L)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_LongList() = {
		val value = Array(1L,2L,3L,4L,5L)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_FloatArray() = {
		val value = Array(1.0F, 2.0F, 3.0F, 4.0F, 5.0F)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_FloatList() = {
		val value = List(1.0F, 2.0F, 3.0F, 4.0F, 5.0F)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_DoubleArray() = {
		val value = Array(1.0D, 2.0D, 3.0D, 4.0D, 5.0D)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_DoubleList() = {
		val value = List(1.0D, 2.0D, 3.0D, 4.0D, 5.0D)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_StringArray() = {
		val value = Array("one", "two", "three", "four", "five")
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_StringList() = {
		val value = List("one", "two", "three", "four", "five")
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_ArrayOfNulls() = {
		val value = Array(null, None)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_ListOfNulls() = {
		val value = List(null, None)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_ArrayOfArrays() = {
		val value = Array(Array(1,2,3,4,5), Array("one", "two", "three", "four", "five"))
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_ListOfArrays() = {
		val value = List(Array(1,2,3,4,5), Array("one", "two", "three", "four", "five"))
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_ArrayOfLists() = {
		val value = Array(List(1,2,3,4,5), List("one", "two", "three", "four", "five"))
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_ListOfLists() = {
		val value = List(List(1,2,3,4,5), List("one", "two", "three", "four", "five"))
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_MixedArray1() = {
		val value = Array(1, 2L, 3.0, "four", true, false, null)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_MixedList1() = {
		val value = List(1, 2L, 3.0, "four", true, false, null)
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_MixedArray2() = {
		val value = Array(1, 2L, 3.0, "four", true, false, null, Array(100, 150, 200, 250, 300), List("H", "He", "Li", "Be", "B", "C", "N", "O"))
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testConstructor_MixedList2() = {
		val value = List(1, 2L, 3.0, "four", true, false, null, Array(100, 150, 200, 250, 300), List("H", "He", "Li", "Be", "B", "C", "N", "O"))
		val jsArray = JsonArray(value)

		assertNotNull(jsArray)
		assertNotNull(jsArray.value)
		assertTrue(jsArray.isInstanceOf[JsonCollection[_]])
		assertTrue(jsArray.isInstanceOf[JsonArray])
		assertTrue(jsArray.isNonNull)
		assertTrue(jsArray.isCollection)
		assertTrue(jsArray.isArray)
		assertFalse(jsArray.isEmpty)
		assertEquals(value.length, jsArray.value.length)
		assertEquals(value.length, jsArray.length)
	}

	@Test
	def testApplyOperator_Boolean() = {
		val value = List(true, false)
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			assertEquals(e, jsArray(i).value)
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_Int() = {
		val value = List(1,2,3,4,5)
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			assertEquals(e, jsArray(i).value)
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_Long() = {
		val value = List(1L,2L,3L,4L,5L)
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			assertEquals(e, jsArray(i).value)
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_Float() = {
		val value = List(1.0F, 2.0F, 3.0F, 4.0F, 5.0F)
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			assertEquals(e, jsArray(i).value)
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_Double() = {
		val value = List(1.0D, 2.0D, 3.0D, 4.0D, 5.0D)
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			assertEquals(e, jsArray(i).value)
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_String() = {
		val value = List("one", "two", "three", "four", "five")
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			if (e != null) {
				assertEquals(e, jsArray(i).value)
			}
			else {
				assertEquals(None, jsArray(i).value)
			}
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_Null() = {
		val value = List(null, None)
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			if (e != null) {
				assertEquals(e, jsArray(i).value)
			}
			else {
				assertEquals(None, jsArray(i).value)
			}
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_Array() = {
		val value = List(Array(1,2,3,4,5))
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			assertEquals(e.length, jsArray(i).asInstanceOf[JsonArray].length)
			if (e != null) {
				for (pair <- e.zip(jsArray(i).asInstanceOf[JsonArray].list)) {
					assertEquals(pair._1, pair._2)
				}
			}
			else {
				assertEquals(None, jsArray(i).value)
			}
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_List() = {
		val value = List(List(1,2,3,4,5))
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			assertEquals(e.length, jsArray(i).asInstanceOf[JsonArray].length)
			if (e != null && jsArray(i).isCollection) {
				for (pair <- e.zip(jsArray(i).asInstanceOf[JsonArray].list)) {
					assertEquals(pair._1, pair._2)
				}
			}
			else {
				assertEquals(None, jsArray(i).value)
			}
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_Mixed1() = {
		val value = List(1, 2L, 3.0, "four", true, false, null)
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			if (e != null) {
				assertEquals(e, jsArray(i).value)
			}
			else {
				assertEquals(None, jsArray(i).value)
			}
			i = i + 1
		}
	}

	@Test
	def testApplyOperator_Mixed2() = {
		val value = List(1, 2L, 3.0, "four", true, false, null, List("H", "He", "Li", "Be", "B", "C", "N", "O"))
		val jsArray = JsonArray(value)

		var i = 0
		for (e <- value) {
			assertNotNull(jsArray(i))
			if (e != null && jsArray(i).isValue) {
				assertEquals(e, jsArray(i).value)
			}
			else if (e != null && jsArray(i).isCollection) {
				for (pair <- e.asInstanceOf[Seq[_]].zip(jsArray(i).asInstanceOf[JsonArray].list)) {
					assertEquals(pair._1, pair._2)
				}
			}
			else {
				assertEquals(None, jsArray(i).value)
			}
			i = i + 1
		}
	}

	@Test
	def testAddOperator_Boolean() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)

		val e1 = true
		jsArray += e1

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isBoolean)
		assertEquals(e1, jsArray(list.length).value)

		val e2 = false
		jsArray += e2

		assertEquals(list.length + 2, jsArray.length)
		assertTrue(jsArray(list.length + 1).isNonNull)
		assertTrue(jsArray(list.length + 1).isBoolean)
		assertEquals(e2, jsArray(list.length + 1).value)
	}

	@Test
	def testAddOperator_Int() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Random.nextInt()

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isNumber)
		assertEquals(value, jsArray(list.length).value)
	}

	@Test
	def testAddOperator_Long() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Random.nextLong()

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isNumber)
		assertEquals(value, jsArray(list.length).value)
	}

	@Test
	def testAddOperator_Float() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Random.nextFloat()

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isNumber)
		assertEquals(value, jsArray(list.length).value)
	}

	@Test
	def testAddOperator_Double() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Random.nextDouble()

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isNumber)
		assertEquals(value, jsArray(list.length).value)
	}

	@Test
	def testAddOperator_String() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Random.nextString(10)

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isString)
		assertEquals(value, jsArray(list.length).value)
	}

	@Test
	def testAddOperator_Null() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)

		val value1 = null
		jsArray += value1

		assertEquals(list.length + 1, jsArray.length)
		assertFalse(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isNull)
		assertEquals(JsonValue.NULL, jsArray(list.length))
		assertEquals(None, jsArray(list.length).value)

		val value2 = None
		jsArray += value2

		assertEquals(list.length + 2, jsArray.length)
		assertFalse(jsArray(list.length + 1).isNonNull)
		assertTrue(jsArray(list.length + 1).isNull)
		assertEquals(JsonValue.NULL, jsArray(list.length + 1))
		assertEquals(None, jsArray(list.length + 1).value)
	}


	@Test
	def testAddOperator_ArrayofInts() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Array(100,150,200,250,300)

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isArray)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].length)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].array.length)

		for (pair <- value.zip(jsArray(list.length).asInstanceOf[JsonArray].array)) {
			if (pair._1 != null) {
				assertEquals(pair._1, pair._2)
			}
			else {
				assertEquals(None, pair._2)
			}
		}
	}

	@Test
	def testAddOperator_ArrayofLongs() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Array(100L,150L,200L,250L,300L)

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isArray)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].length)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].array.length)

		for (pair <- value.zip(jsArray(list.length).asInstanceOf[JsonArray].array)) {
			if (pair._1 != null) {
				assertEquals(pair._1, pair._2)
			}
			else {
				assertEquals(None, pair._2)
			}
		}
	}

	@Test
	def testAddOperator_ArrayOfStrings() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Array("one", "two", "three", "four", "five")

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isArray)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].length)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].array.length)

		for (pair <- value.zip(jsArray(list.length).asInstanceOf[JsonArray].array)) {
			if (pair._1 != null) {
				assertEquals(pair._1, pair._2)
			}
			else {
				assertEquals(None, pair._2)
			}
		}
	}

	@Test
	def testAddOperator_Array_Mixed() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = Array(1, 2L, 3.0, "four", true, false, null)

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isArray)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].length)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].array.length)

		for (pair <- value.zip(jsArray(list.length).asInstanceOf[JsonArray].array)) {
			if (pair._1 != null) {
				assertEquals(pair._1, pair._2)
			}
			else {
				assertEquals(None, pair._2)
			}
		}
	}

	@Test
	def testAddOperator_ListOfInts() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = List(100,150,200,250,300)

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isArray)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].length)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].array.length)

		for (pair <- value.zip(jsArray(list.length).asInstanceOf[JsonArray].list)) {
			assertEquals(pair._1, pair._2)
		}
	}

	@Test
	def testAddOperator_ListOfLongs() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = List(100L,150L,200L,250L,300L)

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isArray)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].length)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].array.length)

		for (pair <- value.zip(jsArray(list.length).asInstanceOf[JsonArray].list)) {
			assertEquals(pair._1, pair._2)
		}
	}

	@Test
	def testAddOperator_ListOfStrings() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = List("one", "two", "three", "four", "five")

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isArray)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].length)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].array.length)

		for (pair <- value.zip(jsArray(list.length).asInstanceOf[JsonArray].list)) {
			assertEquals(pair._1, pair._2)
		}
	}

	@Test
	def testAddOperator_List_Mixed() = {
		val list = List(1,2,3,4,5)
		val jsArray = JsonArray(list)
		val value = List(1, 2L, 3.0, "four", true, false, null)

		jsArray += value

		assertEquals(list.length + 1, jsArray.length)
		assertTrue(jsArray(list.length).isNonNull)
		assertTrue(jsArray(list.length).isArray)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].length)
		assertEquals(value.length, jsArray(list.length).asInstanceOf[JsonArray].array.length)

		for (pair <- value.zip(jsArray(list.length).asInstanceOf[JsonArray].array)) {
			if (pair._1 != null) {
				assertEquals(pair._1, pair._2)
			}
			else {
				assertEquals(None, pair._2)
			}
		}
	}
}
