package org.saadahmed.jascon.parser

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import org.saadahmed.jascon._
import ParserTestData._

/**
 * @author Saad Ahmed
 */
class JsonArrayParserTest extends AssertionsForJUnit {

	@Test
	def testEmptyArray() = {
		val s = "[]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertTrue(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals("[]", json.asInstanceOf[JsonArray].toString)
	}

	@Test
	def testEmptyArray2() = {
		val s = "[ ]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertTrue(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals("[]", json.asInstanceOf[JsonArray].toString)
	}

	@Test
	def testEmptyArray3() = {
		val s = "[     ]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertTrue(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals("[]", json.asInstanceOf[JsonArray].toString)
	}

	@Test
	def testArray_True() = {
		val s = "[true]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](0))
		assertEquals(true, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(0))
	}

	@Test
	def testArray_False() = {
		val s = "[false]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonArray](0))
		assertEquals(false, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonArray].getBoolean(0))
	}

	@Test
	def testArray_Boolean_2_1() = {
		val s = "[true,false]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// (0) -> true
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](0))
		assertEquals(true, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(0))

		// (1) -> false
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonArray](1))
		assertEquals(false, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonArray].getBoolean(1))
	}

	@Test
	def testArray_Boolean_2_2() = {
		val s = "[false,true]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// (0) -> false
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonArray](0))
		assertEquals(false, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonArray].getBoolean(0))

		// (1) -> true
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](1))
		assertEquals(true, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(1))
	}

	@Test
	def testArray_Boolean_3_1() = {
		val s = "[true,false,true]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// (0) -> true
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](0))
		assertEquals(true, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(0))

		// (1) -> false
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonArray](1))
		assertEquals(false, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonArray].getBoolean(1))

		// (2) -> true
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](2))
		assertEquals(true, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(2))
	}

	@Test
	def testArray_Boolean_3_2() = {
		val s = "[true,false,false]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// (0) -> true
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](0))
		assertEquals(true, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(0))

		// (1) -> false
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonArray](1))
		assertEquals(false, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonArray].getBoolean(1))

		// (2) -> false
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonArray](2))
		assertEquals(false, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonArray].getBoolean(2))
	}

	@Test
	def testArray_Boolean_5() = {
		val s = "[true,false,true,false,true]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// (0) -> true
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](0))
		assertEquals(true, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(0))

		// (1) -> false
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonArray](1))
		assertEquals(false, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonArray].getBoolean(1))

		// (2) -> true
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](2))
		assertEquals(true, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(2))

		// (3) -> false
		assertNotNull(json.asInstanceOf[JsonArray](3))
		assertTrue(json.asInstanceOf[JsonArray](3).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](3).isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonArray](3))
		assertEquals(false, json.asInstanceOf[JsonArray](3).asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonArray].getBoolean(3))

		// (4) -> true
		assertNotNull(json.asInstanceOf[JsonArray](4))
		assertTrue(json.asInstanceOf[JsonArray](4).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](4).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](4))
		assertEquals(true, json.asInstanceOf[JsonArray](4).asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonArray].getBoolean(4))
	}

	@Test
	def testArray_Int_Zero() = {
		val s = "[0]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(0, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(0, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_MaxPositive() = {
		val value = Int.MaxValue
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_MaxNegative() = {
		val value = Int.MinValue
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_Positive1() = {
		val value = positiveInt1
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_Positive2() = {
		val value = positiveInt2
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_Positive3() = {
		val value = positiveInt3
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_Negative1() = {
		val value = negativeInt1
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_Negative2() = {
		val value = negativeInt2
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_Negative3() = {
		val value = negativeInt3
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_Random_1() = {
		val s = "[" + randomInt1 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomInt1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt1, json.asInstanceOf[JsonArray].getInt(0))
	}

	@Test
	def testArray_Int_Random_2() = {
		val s = "[" + randomInt1 + "," + randomInt2 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomInt1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt1, json.asInstanceOf[JsonArray].getInt(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomInt2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt2, json.asInstanceOf[JsonArray].getInt(1))
	}

	@Test
	def testArray_Int_Random_3() = {
		val s = "[" + randomInt1 + "," + randomInt2 + "," + randomInt3 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomInt1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt1, json.asInstanceOf[JsonArray].getInt(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomInt2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt2, json.asInstanceOf[JsonArray].getInt(1))

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isNumber)
		assertEquals(randomInt3, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt3, json.asInstanceOf[JsonArray].getInt(2))
	}

	@Test
	def testArray_Int_Random_5() = {
		val s = "[" + randomInt1 + "," + randomInt2 + "," + randomInt3 + "," + randomInt4 + "," + randomInt5 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomInt1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt1, json.asInstanceOf[JsonArray].getInt(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomInt2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt2, json.asInstanceOf[JsonArray].getInt(1))

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isNumber)
		assertEquals(randomInt3, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt3, json.asInstanceOf[JsonArray].getInt(2))

		// index 3
		assertNotNull(json.asInstanceOf[JsonArray](3))
		assertTrue(json.asInstanceOf[JsonArray](3).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](3).isNumber)
		assertEquals(randomInt4, json.asInstanceOf[JsonArray](3).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt4, json.asInstanceOf[JsonArray].getInt(3))

		// index 4
		assertNotNull(json.asInstanceOf[JsonArray](4))
		assertTrue(json.asInstanceOf[JsonArray](4).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](4).isNumber)
		assertEquals(randomInt5, json.asInstanceOf[JsonArray](4).asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt5, json.asInstanceOf[JsonArray].getInt(4))
	}

	@Test
	def testArray_Long_MaxPositive() = {
		val value = Long.MaxValue
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].longValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getLong(0))
	}

	@Test
	def testArray_Long_MaxNegative() = {
		val value = Long.MinValue
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].longValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getLong(0))
	}

	@Test
	def testArray_Long_SimplePositive() = {
		val value = simplePositiveLong
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].longValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getLong(0))
	}

	@Test
	def testArray_Long_SimpleNegative() = {
		val value = simpleNegativeLong
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].longValue)
		assertEquals(value, json.asInstanceOf[JsonArray].getLong(0))
	}

	@Test
	def testArray_Long_Random_1() = {
		val s = "[" + randomLong1 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomLong1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong1, json.asInstanceOf[JsonArray].getLong(0))
	}

	@Test
	def testArray_Long_Random_2() = {
		val s = "[" + randomLong1 + "," + randomLong2 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomLong1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong1, json.asInstanceOf[JsonArray].getLong(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomLong2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong2, json.asInstanceOf[JsonArray].getLong(1))
	}

	@Test
	def testArray_Long_Random_3() = {
		val s = "[" + randomLong1 + "," + randomLong2 + "," + randomLong3 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomLong1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong1, json.asInstanceOf[JsonArray].getLong(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomLong2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong2, json.asInstanceOf[JsonArray].getLong(1))

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isNumber)
		assertEquals(randomLong3, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong3, json.asInstanceOf[JsonArray].getLong(2))
	}

	@Test
	def testArray_Long_Random_5() = {
		val s = "[" + randomLong1 + "," + randomLong2 + "," + randomLong3 + "," + randomLong4 + "," + randomLong5 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomLong1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong1, json.asInstanceOf[JsonArray].getLong(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomLong2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong2, json.asInstanceOf[JsonArray].getLong(1))

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isNumber)
		assertEquals(randomLong3, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong3, json.asInstanceOf[JsonArray].getLong(2))

		// index 3
		assertNotNull(json.asInstanceOf[JsonArray](3))
		assertTrue(json.asInstanceOf[JsonArray](3).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](3).isNumber)
		assertEquals(randomLong4, json.asInstanceOf[JsonArray](3).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong4, json.asInstanceOf[JsonArray].getLong(3))

		// index 4
		assertNotNull(json.asInstanceOf[JsonArray](4))
		assertTrue(json.asInstanceOf[JsonArray](4).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](4).isNumber)
		assertEquals(randomLong5, json.asInstanceOf[JsonArray](4).asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong5, json.asInstanceOf[JsonArray].getLong(4))
	}

	@Test
	def testArray_Float_Zero_1() = {
		val s = "[0.0]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(0.0F, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(0.0, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(0.0F, json.asInstanceOf[JsonArray].getFloat(0), 0)
		assertEquals(0.0, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Float_Zero_2() = {
		val s = "[0.00000]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals("[0.0]", json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(0.0F, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(0.0, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(0.0F, json.asInstanceOf[JsonArray].getFloat(0), 0)
		assertEquals(0.0, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Float_Zero_3() = {
		val s = "[000.00000]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals("[0.0]", json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(0.0F, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(0.0, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(0.0F, json.asInstanceOf[JsonArray].getFloat(0), 0)
		assertEquals(0.0, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Float_MaxPositive() = {
		val value = Float.MaxValue
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(value, json.asInstanceOf[JsonArray].getFloat(0), 0)
	}

	@Test
	def testArray_Float_MaxNegative() = {
		val value = Float.MinValue
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(value, json.asInstanceOf[JsonArray].getFloat(0), 0)
	}

	@Test
	def testArray_Double_MaxPositive() = {
		val value = Double.MaxValue
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Double_MaxNegative() = {
		val value = Double.MinValue
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Double_SimplePositive_1() = {
		val value = positiveDouble4
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Double_SimplePositive_2() = {
		val value = positiveDouble5
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Double_SimpleNegative_1() = {
		val value = negativeDouble1
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Double_SimpleNegative_2() = {
		val value = negativeDouble2
		val s = "[" + value + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(value, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Double_Random_1() = {
		val s = "[" + randomDouble1 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomDouble1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble1, json.asInstanceOf[JsonArray].getDouble(0), 0)
	}

	@Test
	def testArray_Double_Random_2() = {
		val s = "[" + randomDouble1 + "," + randomDouble2 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomDouble1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble1, json.asInstanceOf[JsonArray].getDouble(0), 0)

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomDouble2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble2, json.asInstanceOf[JsonArray].getDouble(1), 0)
	}

	@Test
	def testArray_Double_Random_3() = {
		val s = "[" + randomDouble1 + "," + randomDouble2 + "," + randomDouble3 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomDouble1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble1, json.asInstanceOf[JsonArray].getDouble(0), 0)

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomDouble2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble2, json.asInstanceOf[JsonArray].getDouble(1), 0)

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isNumber)
		assertEquals(randomDouble3, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble3, json.asInstanceOf[JsonArray].getDouble(2), 0)
	}

	@Test
	def testArray_Double_Random_5() = {
		val s = "[" + randomDouble1 + "," + randomDouble2 + "," + randomDouble3 + "," + randomDouble4 + "," + randomDouble5 + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isNumber)
		assertEquals(randomDouble1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble1, json.asInstanceOf[JsonArray].getDouble(0), 0)

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isNumber)
		assertEquals(randomDouble2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble2, json.asInstanceOf[JsonArray].getDouble(1), 0)

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isNumber)
		assertEquals(randomDouble3, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble3, json.asInstanceOf[JsonArray].getDouble(2), 0)

		// index 3
		assertNotNull(json.asInstanceOf[JsonArray](3))
		assertTrue(json.asInstanceOf[JsonArray](3).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](3).isNumber)
		assertEquals(randomDouble4, json.asInstanceOf[JsonArray](3).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble4, json.asInstanceOf[JsonArray].getDouble(3), 0)

		// index 4
		assertNotNull(json.asInstanceOf[JsonArray](4))
		assertTrue(json.asInstanceOf[JsonArray](4).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](4).isNumber)
		assertEquals(randomDouble5, json.asInstanceOf[JsonArray](4).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble5, json.asInstanceOf[JsonArray].getDouble(4), 0)
	}

	@Test
	def testArray_String_Empty() = {
		val s = "[\"\"]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertTrue(json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value.isEmpty)
		assertEquals("", json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals("", json.asInstanceOf[JsonArray].getString(0))
	}

	@Test
	def testArray_String_Simple_1() = {
		val s = "[" + "\"" +  simpleString + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(simpleString, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(simpleString, json.asInstanceOf[JsonArray].getString(0))
	}

	@Test
	def testArray_String_Simple_2() = {
		val s = "[" + "\"" + simpleStringFirstName + "\"" + "," + "\"" + simpleStringLastName + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// firstName
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(simpleStringFirstName, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(simpleStringFirstName, json.asInstanceOf[JsonArray].getString(0))

		// lastName
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isString)
		assertEquals(simpleStringLastName, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonString].value)
		assertEquals(simpleStringLastName, json.asInstanceOf[JsonArray].getString(1))
	}

	@Test
	def testArray_String_Simple_10() = {
		val s = "[\"Hydrogen\",\"Helium\",\"Lithium\",\"Beryllium\",\"Boron\",\"Carbon\",\"Nitrogen\",\"Oxygen\",\"Fluorine\",\"Neon\"]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(10, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// Hydrogen
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals("Hydrogen", json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals("Hydrogen", json.asInstanceOf[JsonArray].getString(0))

		// Helium
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isString)
		assertEquals("Helium", json.asInstanceOf[JsonArray](1).asInstanceOf[JsonString].value)
		assertEquals("Helium", json.asInstanceOf[JsonArray].getString(1))

		// Lithium
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isString)
		assertEquals("Lithium", json.asInstanceOf[JsonArray](2).asInstanceOf[JsonString].value)
		assertEquals("Lithium", json.asInstanceOf[JsonArray].getString(2))

		// Beryllium
		assertNotNull(json.asInstanceOf[JsonArray](3))
		assertTrue(json.asInstanceOf[JsonArray](3).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](3).isString)
		assertEquals("Beryllium", json.asInstanceOf[JsonArray](3).asInstanceOf[JsonString].value)
		assertEquals("Beryllium", json.asInstanceOf[JsonArray].getString(3))

		// Boron
		assertNotNull(json.asInstanceOf[JsonArray](4))
		assertTrue(json.asInstanceOf[JsonArray](4).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](4).isString)
		assertEquals("Boron", json.asInstanceOf[JsonArray](4).asInstanceOf[JsonString].value)
		assertEquals("Boron", json.asInstanceOf[JsonArray].getString(4))

		// Carbon
		assertNotNull(json.asInstanceOf[JsonArray](5))
		assertTrue(json.asInstanceOf[JsonArray](5).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](5).isString)
		assertEquals("Carbon", json.asInstanceOf[JsonArray](5).asInstanceOf[JsonString].value)
		assertEquals("Carbon", json.asInstanceOf[JsonArray].getString(5))

		// Nitrogen
		assertNotNull(json.asInstanceOf[JsonArray](6))
		assertTrue(json.asInstanceOf[JsonArray](6).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](6).isString)
		assertEquals("Nitrogen", json.asInstanceOf[JsonArray](6).asInstanceOf[JsonString].value)
		assertEquals("Nitrogen", json.asInstanceOf[JsonArray].getString(6))

		// Oxygen
		assertNotNull(json.asInstanceOf[JsonArray](7))
		assertTrue(json.asInstanceOf[JsonArray](7).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](7).isString)
		assertEquals("Oxygen", json.asInstanceOf[JsonArray](7).asInstanceOf[JsonString].value)
		assertEquals("Oxygen", json.asInstanceOf[JsonArray].getString(7))

		// Fluorine
		assertNotNull(json.asInstanceOf[JsonArray](8))
		assertTrue(json.asInstanceOf[JsonArray](8).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](8).isString)
		assertEquals("Fluorine", json.asInstanceOf[JsonArray](8).asInstanceOf[JsonString].value)
		assertEquals("Fluorine", json.asInstanceOf[JsonArray].getString(8))

		// Neon
		assertNotNull(json.asInstanceOf[JsonArray](9))
		assertTrue(json.asInstanceOf[JsonArray](9).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](9).isString)
		assertEquals("Neon", json.asInstanceOf[JsonArray](9).asInstanceOf[JsonString].value)
		assertEquals("Neon", json.asInstanceOf[JsonArray].getString(9))
	}

	@Test
	def testArray_String_Random_2() = {
		val s = "[" + "\"" + randomString1 + "\"" + "," + "\"" + randomString2 + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonArray].length)
		//assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(randomString1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(randomString1, json.asInstanceOf[JsonArray].getString(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isString)
		assertEquals(randomString2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonString].value)
		assertEquals(randomString2, json.asInstanceOf[JsonArray].getString(1))
	}

	@Test
	def testArray_String_Random_3() = {
		val s = "[" + "\"" + randomString1 + "\"" + "," + "\"" + randomString2 + "\"" + "," + "\"" + randomString3 + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonArray].length)
		//assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(randomString1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(randomString1, json.asInstanceOf[JsonArray].getString(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isString)
		assertEquals(randomString2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonString].value)
		assertEquals(randomString2, json.asInstanceOf[JsonArray].getString(1))

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isString)
		assertEquals(randomString3, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonString].value)
		assertEquals(randomString3, json.asInstanceOf[JsonArray].getString(2))
	}

	@Test
	def testArray_String_Random_5() = {
		val s = "[" + "\"" + randomString1 + "\"" + "," + "\"" + randomString2 + "\"" + "," + "\"" + randomString3 + "\"" + "," + "\"" + randomString4 + "\"" + "," + "\"" + randomString5 + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonArray].length)
		//assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(randomString1, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(randomString1, json.asInstanceOf[JsonArray].getString(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isString)
		assertEquals(randomString2, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonString].value)
		assertEquals(randomString2, json.asInstanceOf[JsonArray].getString(1))

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isString)
		assertEquals(randomString3, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonString].value)
		assertEquals(randomString3, json.asInstanceOf[JsonArray].getString(2))

		// index 3
		assertNotNull(json.asInstanceOf[JsonArray](3))
		assertTrue(json.asInstanceOf[JsonArray](3).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](3).isString)
		assertEquals(randomString4, json.asInstanceOf[JsonArray](3).asInstanceOf[JsonString].value)
		assertEquals(randomString4, json.asInstanceOf[JsonArray].getString(3))

		// index 4
		assertNotNull(json.asInstanceOf[JsonArray](4))
		assertTrue(json.asInstanceOf[JsonArray](4).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](4).isString)
		assertEquals(randomString5, json.asInstanceOf[JsonArray](4).asInstanceOf[JsonString].value)
		assertEquals(randomString5, json.asInstanceOf[JsonArray].getString(4))
	}

	@Test
	def testArray_String_SingleQuote() = {
		val s = "[" + "\"" +  stringWithSingleQuotes_Escaped + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals("[" + "\"" + stringWithSingleQuotes + "\"" + "]", json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(stringWithSingleQuotes, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(stringWithSingleQuotes, json.asInstanceOf[JsonArray].getString(0))
	}

	@Test
	def testArray_String_DoubleQuote() = {
		val s = "[" + "\"" +  stringWithDoubleQuotes_Escaped + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(stringWithDoubleQuotes, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(stringWithDoubleQuotes, json.asInstanceOf[JsonArray].getString(0))
	}

	@Test
	def testArray_String_Tab() = {
		val s = "[" + "\"" +  stringWithTab_Escaped + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(stringWithTab, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(stringWithTab, json.asInstanceOf[JsonArray].getString(0))
	}

	@Test
	def testArray_String_NewLine() = {
		val s = "[" + "\"" +  stringWithNewLine_Escaped + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(stringWithNewLine, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(stringWithNewLine, json.asInstanceOf[JsonArray].getString(0))
	}

	@Test
	def testArray_String_Backslash() = {
		val s = "[" + "\"" +  stringWithBackslash_Escaped + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(stringWithBackslash, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(stringWithBackslash, json.asInstanceOf[JsonArray].getString(0))
	}

	@Test
	def testArray_String_ForwardSlash() = {
		val s = "[" + "\"" +  stringWithForwardSlash_Escaped + "\"" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals("[" + "\"" + stringWithForwardSlash + "\"" + "]", json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(stringWithForwardSlash, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(stringWithForwardSlash, json.asInstanceOf[JsonArray].getString(0))
	}

	@Test
	def testArray_Null_1() = {
		val s = "[null]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](0))
		assertEquals(None, json.asInstanceOf[JsonArray](0).value)
	}

	@Test
	def testArray_Null_2() = {
		val s = "[null,null]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](0))
		assertEquals(None, json.asInstanceOf[JsonArray](0).value)

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](1))
		assertEquals(None, json.asInstanceOf[JsonArray](1).value)
	}

	@Test
	def testArray_Null_3() = {
		val s = "[null,null,null]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](0))
		assertEquals(None, json.asInstanceOf[JsonArray](0).value)

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](1))
		assertEquals(None, json.asInstanceOf[JsonArray](1).value)

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](2))
		assertEquals(None, json.asInstanceOf[JsonArray](2).value)
	}

	@Test
	def testArray_Null_5() = {
		val s = "[null,null,null,null,null]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](0))
		assertEquals(None, json.asInstanceOf[JsonArray](0).value)

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](1))
		assertEquals(None, json.asInstanceOf[JsonArray](1).value)

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](2))
		assertEquals(None, json.asInstanceOf[JsonArray](2).value)

		// index 3
		assertNotNull(json.asInstanceOf[JsonArray](3))
		assertTrue(json.asInstanceOf[JsonArray](3).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](3))
		assertEquals(None, json.asInstanceOf[JsonArray](3).value)

		// index 4
		assertNotNull(json.asInstanceOf[JsonArray](4))
		assertTrue(json.asInstanceOf[JsonArray](4).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](4))
		assertEquals(None, json.asInstanceOf[JsonArray](4).value)
	}

	@Test
	def testArray_Mixed1() = {
		val isAlive = true
		val age = 25
		val height = 167.64
		val s = "[" + "\"" + simpleStringFirstName + "\"" + "," + "\"" + simpleStringLastName + "\"" + "," + isAlive + "," + age + "," + height + "," + "null" + "]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(6, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		// index 0
		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isString)
		assertEquals(simpleStringFirstName, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonString].value)
		assertEquals(simpleStringFirstName, json.asInstanceOf[JsonArray].getString(0))

		// index 1
		assertNotNull(json.asInstanceOf[JsonArray](1))
		assertTrue(json.asInstanceOf[JsonArray](1).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](1).isString)
		assertEquals(simpleStringLastName, json.asInstanceOf[JsonArray](1).asInstanceOf[JsonString].value)
		assertEquals(simpleStringLastName, json.asInstanceOf[JsonArray].getString(1))

		// index 2
		assertNotNull(json.asInstanceOf[JsonArray](2))
		assertTrue(json.asInstanceOf[JsonArray](2).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](2).isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonArray](2))
		assertEquals(isAlive, json.asInstanceOf[JsonArray](2).asInstanceOf[JsonBoolean].value)
		assertEquals(isAlive, json.asInstanceOf[JsonArray].getBoolean(2))

		// index 3
		assertNotNull(json.asInstanceOf[JsonArray](3))
		assertTrue(json.asInstanceOf[JsonArray](3).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](3).isNumber)
		assertEquals(age, json.asInstanceOf[JsonArray](3).asInstanceOf[JsonNumber].intValue)
		assertEquals(age, json.asInstanceOf[JsonArray].getInt(3))

		// index 4
		assertNotNull(json.asInstanceOf[JsonArray](4))
		assertTrue(json.asInstanceOf[JsonArray](4).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](4).isNumber)
		assertEquals(height, json.asInstanceOf[JsonArray](4).asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(height, json.asInstanceOf[JsonArray].getDouble(4), 0)

		// index 5
		assertNotNull(json.asInstanceOf[JsonArray](5))
		assertTrue(json.asInstanceOf[JsonArray](5).isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonArray](5))
		assertEquals(None, json.asInstanceOf[JsonArray](5).value)
	}

	@Test
	def testObject() = {
		val s = "[{\"id\":1,\"text\":\"File\",\"tooltip\":\"Click me\",\"focus\":false,\"shortcut\":\"Alt+F1\"}]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		//assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isObject)
		assertFalse(json.asInstanceOf[JsonArray](0).asInstanceOf[JsonObject].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonObject].size)
	}

	@Test
	def testArray() = {
		val s = "[[\"File\",\"Edit\",\"View\",\"Navigate\",\"Code\",\"Analyze\",\"Refactor\",\"Build\",\"Run\",\"Tools\",\"Window\",\"Help\"]]"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonArray])
		assertFalse(json.asInstanceOf[JsonArray].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonArray].length)
		assertEquals(s, json.asInstanceOf[JsonArray].toString)

		assertNotNull(json.asInstanceOf[JsonArray](0))
		assertTrue(json.asInstanceOf[JsonArray](0).isNonNull)
		assertTrue(json.asInstanceOf[JsonArray](0).isArray)
		assertFalse(json.asInstanceOf[JsonArray](0).asInstanceOf[JsonArray].isEmpty)
		assertEquals(12, json.asInstanceOf[JsonArray](0).asInstanceOf[JsonArray].length)
	}
}
