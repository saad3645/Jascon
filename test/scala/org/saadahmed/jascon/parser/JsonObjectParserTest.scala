package org.saadahmed.jascon.parser

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import org.saadahmed.jascon._
import ParserTestData._

/**
 * @author Saad Ahmed
 */
class JsonObjectParserTest extends AssertionsForJUnit {

	@Test
	def testEmptyObject() = {
		val s = "{}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertTrue(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals("{}", json.asInstanceOf[JsonObject].toString)
	}

	@Test
	def testEmptyObject2() = {
		val s = "{ }"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertTrue(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals("{}", json.asInstanceOf[JsonObject].toString)
	}

	@Test
	def testEmptyObject3() = {
		val s = "{     }"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertTrue(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals("{}", json.asInstanceOf[JsonObject].toString)
	}

	@Test
	def testObject_True() = {
		val s = "{\"truth\":true}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("truth"))
		assertNotNull(json.asInstanceOf[JsonObject]("truth"))
		assertTrue(json.asInstanceOf[JsonObject]("truth").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("truth").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("truth"))
		assertEquals(true, json.asInstanceOf[JsonObject]("truth").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("truth").get)
	}

	@Test
	def testObject_False() = {
		val s = "{\"fallacy\":false}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("fallacy"))
		assertNotNull(json.asInstanceOf[JsonObject]("fallacy"))
		assertTrue(json.asInstanceOf[JsonObject]("fallacy").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("fallacy").isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonObject]("fallacy"))
		assertEquals(false, json.asInstanceOf[JsonObject]("fallacy").asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonObject].getBoolean("fallacy").get)
	}

	@Test
	def testObject_Boolean_2_1() = {
		val s = "{\"foo\":true,\"bar\":false}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// true
		assertTrue(json.asInstanceOf[JsonObject].has("foo"))
		assertNotNull(json.asInstanceOf[JsonObject]("foo"))
		assertTrue(json.asInstanceOf[JsonObject]("foo").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("foo").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("foo"))
		assertEquals(true, json.asInstanceOf[JsonObject]("foo").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("foo").get)

		// false
		assertTrue(json.asInstanceOf[JsonObject].has("bar"))
		assertNotNull(json.asInstanceOf[JsonObject]("bar"))
		assertTrue(json.asInstanceOf[JsonObject]("bar").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("bar").isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonObject]("bar"))
		assertEquals(false, json.asInstanceOf[JsonObject]("bar").asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonObject].getBoolean("bar").get)
	}

	@Test
	def testObject_Boolean_2_2() = {
		val s = "{\"foo\":false,\"bar\":true}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// false
		assertTrue(json.asInstanceOf[JsonObject].has("foo"))
		assertNotNull(json.asInstanceOf[JsonObject]("foo"))
		assertTrue(json.asInstanceOf[JsonObject]("foo").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("foo").isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonObject]("foo"))
		assertEquals(false, json.asInstanceOf[JsonObject]("foo").asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonObject].getBoolean("foo").get)

		// true
		assertTrue(json.asInstanceOf[JsonObject].has("bar"))
		assertNotNull(json.asInstanceOf[JsonObject]("bar"))
		assertTrue(json.asInstanceOf[JsonObject]("bar").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("bar").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("bar"))
		assertEquals(true, json.asInstanceOf[JsonObject]("bar").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("bar").get)
	}

	@Test
	def testObject_Boolean_3_1() = {
		val s = "{\"one\":true,\"two\":false,\"three\":true}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one -> true
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("one"))
		assertEquals(true, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("one").get)

		// two -> false
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonObject]("two"))
		assertEquals(false, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonObject].getBoolean("two").get)

		// three -> true
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("three"))
		assertEquals(true, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("three").get)
	}

	@Test
	def testObject_Boolean_3_2() = {
		val s = "{\"one\":true,\"two\":false,\"three\":false}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one -> true
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("one"))
		assertEquals(true, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("one").get)

		// two -> false
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonObject]("two"))
		assertEquals(false, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonObject].getBoolean("two").get)

		// three -> false
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonObject]("three"))
		assertEquals(false, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonObject].getBoolean("three").get)
	}

	@Test
	def testObject_Boolean_5() = {
		val s = "{\"one\":true,\"two\":false,\"three\":true,\"four\":false,\"five\":true}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one -> true
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("one"))
		assertEquals(true, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("one").get)

		// two -> false
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonObject]("two"))
		assertEquals(false, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonObject].getBoolean("two").get)

		// three -> true
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("three"))
		assertEquals(true, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("three").get)

		// four -> false
		assertTrue(json.asInstanceOf[JsonObject].has("four"))
		assertNotNull(json.asInstanceOf[JsonObject]("four"))
		assertTrue(json.asInstanceOf[JsonObject]("four").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("four").isBoolean)
		assertEquals(JsonValue.FALSE, json.asInstanceOf[JsonObject]("four"))
		assertEquals(false, json.asInstanceOf[JsonObject]("four").asInstanceOf[JsonBoolean].value)
		assertEquals(false, json.asInstanceOf[JsonObject].getBoolean("four").get)

		// five -> true
		assertTrue(json.asInstanceOf[JsonObject].has("five"))
		assertNotNull(json.asInstanceOf[JsonObject]("five"))
		assertTrue(json.asInstanceOf[JsonObject]("five").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("five").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("five"))
		assertEquals(true, json.asInstanceOf[JsonObject]("five").asInstanceOf[JsonBoolean].value)
		assertEquals(true, json.asInstanceOf[JsonObject].getBoolean("five").get)
	}

	@Test
	def testObject_Int_Zero() = {
		val s = "{\"key\":0}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(0, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].value)
		assertEquals(0, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_MaxPositive() = {
		val value = Int.MaxValue
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_MaxNegative() = {
		val value = Int.MinValue
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_Positive1() = {
		val value = positiveInt1
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_Positive2() = {
		val value = positiveInt2
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_Positive3() = {
		val value = positiveInt3
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_Negative1() = {
		val value = negativeInt1
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_Negative2() = {
		val value = negativeInt2
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_Negative3() = {
		val value = negativeInt3
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].intValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getInt("key").get)
	}

	@Test
	def testObject_Int_Random_1() = {
		val s = "{\"foo\":" + randomInt1 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("foo"))
		assertNotNull(json.asInstanceOf[JsonObject]("foo"))
		assertTrue(json.asInstanceOf[JsonObject]("foo").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("foo").isNumber)
		assertEquals(randomInt1, json.asInstanceOf[JsonObject]("foo").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt1, json.asInstanceOf[JsonObject].getInt("foo").get)
	}

	@Test
	def testObject_Int_Random_2() = {
		val s = "{\"one\":" + randomInt1 + ",\"two\":" + randomInt2 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomInt1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt1, json.asInstanceOf[JsonObject].getInt("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomInt2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt2, json.asInstanceOf[JsonObject].getInt("two").get)
	}

	@Test
	def testObject_Int_Random_3() = {
		val s = "{\"one\":" + randomInt1 + ",\"two\":" + randomInt2 + ",\"three\":" + randomInt3 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomInt1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt1, json.asInstanceOf[JsonObject].getInt("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomInt2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt2, json.asInstanceOf[JsonObject].getInt("two").get)

		// three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isNumber)
		assertEquals(randomInt3, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt3, json.asInstanceOf[JsonObject].getInt("three").get)
	}

	@Test
	def testObject_Int_Random_5() = {
		val s = "{\"one\":" + randomInt1 + ",\"two\":" + randomInt2 + ",\"three\":" + randomInt3 + ",\"four\":" + randomInt4 + ",\"five\":" + randomInt5 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomInt1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt1, json.asInstanceOf[JsonObject].getInt("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomInt2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt2, json.asInstanceOf[JsonObject].getInt("two").get)

		// three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isNumber)
		assertEquals(randomInt3, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt3, json.asInstanceOf[JsonObject].getInt("three").get)

		// four
		assertTrue(json.asInstanceOf[JsonObject].has("four"))
		assertNotNull(json.asInstanceOf[JsonObject]("four"))
		assertTrue(json.asInstanceOf[JsonObject]("four").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("four").isNumber)
		assertEquals(randomInt4, json.asInstanceOf[JsonObject]("four").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt4, json.asInstanceOf[JsonObject].getInt("four").get)

		// five
		assertTrue(json.asInstanceOf[JsonObject].has("five"))
		assertNotNull(json.asInstanceOf[JsonObject]("five"))
		assertTrue(json.asInstanceOf[JsonObject]("five").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("five").isNumber)
		assertEquals(randomInt5, json.asInstanceOf[JsonObject]("five").asInstanceOf[JsonNumber].intValue)
		assertEquals(randomInt5, json.asInstanceOf[JsonObject].getInt("five").get)
	}

	@Test
	def testObject_Long_MaxPositive() = {
		val value = Long.MaxValue
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].longValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getLong("key").get)
	}

	@Test
	def testObject_Long_MaxNegative() = {
		val value = Long.MinValue
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].longValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getLong("key").get)
	}

	@Test
	def testObject_Long_SimplePositive() = {
		val value = simplePositiveLong
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].longValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getLong("key").get)
	}

	@Test
	def testObject_Long_SimpleNegative() = {
		val value = simpleNegativeLong
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].longValue)
		assertEquals(value, json.asInstanceOf[JsonObject].getLong("key").get)
	}

	@Test
	def testObject_Long_Random_1() = {
		val s = "{\"key\":" + randomLong1 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(randomLong1, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong1, json.asInstanceOf[JsonObject].getLong("key").get)
	}

	@Test
	def testObject_Long_Random_2() = {
		val s = "{\"one\":" + randomLong1 + ",\"two\":" + randomLong2 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomLong1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong1, json.asInstanceOf[JsonObject].getLong("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomLong2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong2, json.asInstanceOf[JsonObject].getLong("two").get)
	}

	@Test
	def testObject_Long_Random_3() = {
		val s = "{\"one\":" + randomLong1 + ",\"two\":" + randomLong2 + ",\"three\":" + randomLong3 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomLong1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong1, json.asInstanceOf[JsonObject].getLong("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomLong2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong2, json.asInstanceOf[JsonObject].getLong("two").get)

		// three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isNumber)
		assertEquals(randomLong3, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong3, json.asInstanceOf[JsonObject].getLong("three").get)
	}

	@Test
	def testObject_Long_Random_5() = {
		val s = "{\"one\":" + randomLong1 + ",\"two\":" + randomLong2 + ",\"three\":" + randomLong3 + ",\"four\":" + randomLong4 + ",\"five\":" + randomLong5 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomLong1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong1, json.asInstanceOf[JsonObject].getLong("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomLong2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong2, json.asInstanceOf[JsonObject].getLong("two").get)

		// three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isNumber)
		assertEquals(randomLong3, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong3, json.asInstanceOf[JsonObject].getLong("three").get)

		// four
		assertTrue(json.asInstanceOf[JsonObject].has("four"))
		assertNotNull(json.asInstanceOf[JsonObject]("four"))
		assertTrue(json.asInstanceOf[JsonObject]("four").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("four").isNumber)
		assertEquals(randomLong4, json.asInstanceOf[JsonObject]("four").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong4, json.asInstanceOf[JsonObject].getLong("four").get)

		// five
		assertTrue(json.asInstanceOf[JsonObject].has("five"))
		assertNotNull(json.asInstanceOf[JsonObject]("five"))
		assertTrue(json.asInstanceOf[JsonObject]("five").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("five").isNumber)
		assertEquals(randomLong5, json.asInstanceOf[JsonObject]("five").asInstanceOf[JsonNumber].longValue)
		assertEquals(randomLong5, json.asInstanceOf[JsonObject].getLong("five").get)
	}

	@Test
	def testObject_Float_Zero_1() = {
		val s = "{\"key\":0.0}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(0.0F, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(0.0, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(0.0F, json.asInstanceOf[JsonObject].getFloat("key").get, 0)
		assertEquals(0.0, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Float_Zero_2() = {
		val s = "{\"key\":0.00000}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals("{\"key\":0.0}", json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(0.0F, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(0.0, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(0.0F, json.asInstanceOf[JsonObject].getFloat("key").get, 0)
		assertEquals(0.0, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Float_Zero_3() = {
		val s = "{\"key\":000.00000}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals("{\"key\":0.0}", json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(0.0F, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(0.0, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(0.0F, json.asInstanceOf[JsonObject].getFloat("key").get, 0)
		assertEquals(0.0, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Float_MaxPositive() = {
		val value = Float.MaxValue
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(value, json.asInstanceOf[JsonObject].getFloat("key").get, 0)
	}

	@Test
	def testObject_Float_MaxNegative() = {
		val value = Float.MinValue
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].floatValue, 0)
		assertEquals(value, json.asInstanceOf[JsonObject].getFloat("key").get, 0)
	}

	@Test
	def testObject_Double_MaxPositive() = {
		val value = Double.MaxValue
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Double_MaxNegative() = {
		val value = Double.MinValue
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Double_SimplePositive1() = {
		val value = positiveDouble4
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Double_SimplePositive2() = {
		val value = positiveDouble5
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Double_SimpleNegative1() = {
		val value = negativeDouble1
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Double_SimpleNegative2() = {
		val value = negativeDouble2
		val s = "{\"key\":" + value + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(value, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(value, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Double_Random_1() = {
		val s = "{\"key\":" + randomDouble1 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isNumber)
		assertEquals(randomDouble1, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble1, json.asInstanceOf[JsonObject].getDouble("key").get, 0)
	}

	@Test
	def testObject_Double_Random_2() = {
		val s = "{\"one\":" + randomDouble1 + ",\"two\":" + randomDouble2 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		//one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomDouble1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble1, json.asInstanceOf[JsonObject].getDouble("one").get, 0)

		//two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomDouble2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble2, json.asInstanceOf[JsonObject].getDouble("two").get, 0)
	}

	@Test
	def testObject_Double_Random_3() = {
		val s = "{\"one\":" + randomDouble1 + ",\"two\":" + randomDouble2 + ",\"three\":" + randomDouble3 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		//one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomDouble1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble1, json.asInstanceOf[JsonObject].getDouble("one").get, 0)

		//two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomDouble2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble2, json.asInstanceOf[JsonObject].getDouble("two").get, 0)

		//three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isNumber)
		assertEquals(randomDouble3, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble3, json.asInstanceOf[JsonObject].getDouble("three").get, 0)
	}

	@Test
	def testObject_Double_Random_5() = {
		val s = "{\"one\":" + randomDouble1 + ",\"two\":" + randomDouble2 + ",\"three\":" + randomDouble3 + ",\"four\":" + randomDouble4 + ",\"five\":" + randomDouble5 + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		//one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isNumber)
		assertEquals(randomDouble1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble1, json.asInstanceOf[JsonObject].getDouble("one").get, 0)

		//two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isNumber)
		assertEquals(randomDouble2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble2, json.asInstanceOf[JsonObject].getDouble("two").get, 0)

		//three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isNumber)
		assertEquals(randomDouble3, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble3, json.asInstanceOf[JsonObject].getDouble("three").get, 0)

		//four
		assertTrue(json.asInstanceOf[JsonObject].has("four"))
		assertNotNull(json.asInstanceOf[JsonObject]("four"))
		assertTrue(json.asInstanceOf[JsonObject]("four").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("four").isNumber)
		assertEquals(randomDouble4, json.asInstanceOf[JsonObject]("four").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble4, json.asInstanceOf[JsonObject].getDouble("four").get, 0)

		//five
		assertTrue(json.asInstanceOf[JsonObject].has("five"))
		assertNotNull(json.asInstanceOf[JsonObject]("five"))
		assertTrue(json.asInstanceOf[JsonObject]("five").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("five").isNumber)
		assertEquals(randomDouble5, json.asInstanceOf[JsonObject]("five").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(randomDouble5, json.asInstanceOf[JsonObject].getDouble("five").get, 0)
	}

	@Test
	def testObject_String_Empty() = {
		val s = "{\"key\":\"\"}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isString)
		assertTrue(json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value.isEmpty)
		assertEquals("", json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value)
		assertEquals("", json.asInstanceOf[JsonObject].getString("key").get)
	}

	@Test
	def testObject_String_Simple_1() = {
		val s = "{\"key\":" + "\"" + simpleString + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isString)
		assertEquals(simpleString, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value)
		assertEquals(simpleString, json.asInstanceOf[JsonObject].getString("key").get)
	}

	@Test
	def testObject_String_Simple_2() = {
		val s = "{\"first_name\":" + "\"" + simpleStringFirstName + "\"" + ",\"last_name\":" + "\"" + simpleStringLastName + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// first_name
		assertTrue(json.asInstanceOf[JsonObject].has("first_name"))
		assertNotNull(json.asInstanceOf[JsonObject]("first_name"))
		assertTrue(json.asInstanceOf[JsonObject]("first_name").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("first_name").isString)
		assertEquals(simpleStringFirstName, json.asInstanceOf[JsonObject]("first_name").asInstanceOf[JsonString].value)
		assertEquals(simpleStringFirstName, json.asInstanceOf[JsonObject].getString("first_name").get)

		// last_name
		assertTrue(json.asInstanceOf[JsonObject].has("last_name"))
		assertNotNull(json.asInstanceOf[JsonObject]("last_name"))
		assertTrue(json.asInstanceOf[JsonObject]("last_name").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("last_name").isString)
		assertEquals(simpleStringLastName, json.asInstanceOf[JsonObject]("last_name").asInstanceOf[JsonString].value)
		assertEquals(simpleStringLastName, json.asInstanceOf[JsonObject].getString("last_name").get)
	}

	@Test
	def testObject_String_Simple_10() = {
		val s = "{\"H\":\"Hydrogen\"" + ",\"He\":\"Helium\"" +
					",\"Li\":\"Lithium\",\"Be\":\"Beryllium\",\"B\":\"Boron\",\"C\":\"Carbon\",\"N\":\"Nitrogen\",\"O\":\"Oxygen\",\"F\":\"Fluorine\",\"Ne\":\"Neon\"}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(10, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// H -> Hydrogen
		assertTrue(json.asInstanceOf[JsonObject].has("H"))
		assertNotNull(json.asInstanceOf[JsonObject]("H"))
		assertTrue(json.asInstanceOf[JsonObject]("H").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("H").isString)
		assertEquals("Hydrogen", json.asInstanceOf[JsonObject]("H").asInstanceOf[JsonString].value)
		assertEquals("Hydrogen", json.asInstanceOf[JsonObject].getString("H").get)

		// He -> Helium
		assertTrue(json.asInstanceOf[JsonObject].has("He"))
		assertNotNull(json.asInstanceOf[JsonObject]("He"))
		assertTrue(json.asInstanceOf[JsonObject]("He").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("He").isString)
		assertEquals("Helium", json.asInstanceOf[JsonObject]("He").asInstanceOf[JsonString].value)
		assertEquals("Helium", json.asInstanceOf[JsonObject].getString("He").get)

		// Li -> Lithium
		assertTrue(json.asInstanceOf[JsonObject].has("Li"))
		assertNotNull(json.asInstanceOf[JsonObject]("Li"))
		assertTrue(json.asInstanceOf[JsonObject]("Li").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("Li").isString)
		assertEquals("Lithium", json.asInstanceOf[JsonObject]("Li").asInstanceOf[JsonString].value)
		assertEquals("Lithium", json.asInstanceOf[JsonObject].getString("Li").get)

		// Be -> Beryllium
		assertTrue(json.asInstanceOf[JsonObject].has("Be"))
		assertNotNull(json.asInstanceOf[JsonObject]("Be"))
		assertTrue(json.asInstanceOf[JsonObject]("Be").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("Be").isString)
		assertEquals("Beryllium", json.asInstanceOf[JsonObject]("Be").asInstanceOf[JsonString].value)
		assertEquals("Beryllium", json.asInstanceOf[JsonObject].getString("Be").get)

		// B -> Boron
		assertTrue(json.asInstanceOf[JsonObject].has("B"))
		assertNotNull(json.asInstanceOf[JsonObject]("B"))
		assertTrue(json.asInstanceOf[JsonObject]("B").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("B").isString)
		assertEquals("Boron", json.asInstanceOf[JsonObject]("B").asInstanceOf[JsonString].value)
		assertEquals("Boron", json.asInstanceOf[JsonObject].getString("B").get)

		// C -> Carbon
		assertTrue(json.asInstanceOf[JsonObject].has("C"))
		assertNotNull(json.asInstanceOf[JsonObject]("C"))
		assertTrue(json.asInstanceOf[JsonObject]("C").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("C").isString)
		assertEquals("Carbon", json.asInstanceOf[JsonObject]("C").asInstanceOf[JsonString].value)
		assertEquals("Carbon", json.asInstanceOf[JsonObject].getString("C").get)

		// N -> Nitrogen
		assertTrue(json.asInstanceOf[JsonObject].has("N"))
		assertNotNull(json.asInstanceOf[JsonObject]("N"))
		assertTrue(json.asInstanceOf[JsonObject]("N").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("N").isString)
		assertEquals("Nitrogen", json.asInstanceOf[JsonObject]("N").asInstanceOf[JsonString].value)
		assertEquals("Nitrogen", json.asInstanceOf[JsonObject].getString("N").get)

		// O -> Oxygen
		assertTrue(json.asInstanceOf[JsonObject].has("O"))
		assertNotNull(json.asInstanceOf[JsonObject]("O"))
		assertTrue(json.asInstanceOf[JsonObject]("O").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("O").isString)
		assertEquals("Oxygen", json.asInstanceOf[JsonObject]("O").asInstanceOf[JsonString].value)
		assertEquals("Oxygen", json.asInstanceOf[JsonObject].getString("O").get)

		// F -> Fluorine
		assertTrue(json.asInstanceOf[JsonObject].has("F"))
		assertNotNull(json.asInstanceOf[JsonObject]("F"))
		assertTrue(json.asInstanceOf[JsonObject]("F").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("F").isString)
		assertEquals("Fluorine", json.asInstanceOf[JsonObject]("F").asInstanceOf[JsonString].value)
		assertEquals("Fluorine", json.asInstanceOf[JsonObject].getString("F").get)

		// Ne -> Neon
		assertTrue(json.asInstanceOf[JsonObject].has("Ne"))
		assertNotNull(json.asInstanceOf[JsonObject]("Ne"))
		assertTrue(json.asInstanceOf[JsonObject]("Ne").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("Ne").isString)
		assertEquals("Neon", json.asInstanceOf[JsonObject]("Ne").asInstanceOf[JsonString].value)
		assertEquals("Neon", json.asInstanceOf[JsonObject].getString("Ne").get)
	}

	@Test
	def testObject_String_Random_2() = {
		val s = "{\"one\":" + "\"" + randomString1 + "\"" + ",\"two\":" + "\"" + randomString2 + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isString)
		assertEquals(randomString1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonString].value)
		assertEquals(randomString1, json.asInstanceOf[JsonObject].getString("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isString)
		assertEquals(randomString2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonString].value)
		assertEquals(randomString2, json.asInstanceOf[JsonObject].getString("two").get)
	}

	@Test
	def testObject_String_Random_3() = {
		val s = "{\"one\":" + "\"" + randomString1 + "\"" + ",\"two\":" + "\"" + randomString2 + "\"" + ",\"three\":" + "\"" + randomString3 + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isString)
		assertEquals(randomString1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonString].value)
		assertEquals(randomString1, json.asInstanceOf[JsonObject].getString("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isString)
		assertEquals(randomString2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonString].value)
		assertEquals(randomString2, json.asInstanceOf[JsonObject].getString("two").get)

		// three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isString)
		assertEquals(randomString3, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonString].value)
		assertEquals(randomString3, json.asInstanceOf[JsonObject].getString("three").get)
	}

	@Test
	def testObject_String_Random_5() = {
		val s = "{\"one\":" + "\"" + randomString1 + "\"" + ",\"two\":" + "\"" + randomString2 + "\"" + ",\"three\":" + "\"" + randomString3 + "\"" + ",\"four\":" + "\"" + randomString4 + "\"" + ",\"five\":" + "\"" + randomString5 + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("one").isString)
		assertEquals(randomString1, json.asInstanceOf[JsonObject]("one").asInstanceOf[JsonString].value)
		assertEquals(randomString1, json.asInstanceOf[JsonObject].getString("one").get)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("two").isString)
		assertEquals(randomString2, json.asInstanceOf[JsonObject]("two").asInstanceOf[JsonString].value)
		assertEquals(randomString2, json.asInstanceOf[JsonObject].getString("two").get)

		// three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("three").isString)
		assertEquals(randomString3, json.asInstanceOf[JsonObject]("three").asInstanceOf[JsonString].value)
		assertEquals(randomString3, json.asInstanceOf[JsonObject].getString("three").get)

		// four
		assertTrue(json.asInstanceOf[JsonObject].has("four"))
		assertNotNull(json.asInstanceOf[JsonObject]("four"))
		assertTrue(json.asInstanceOf[JsonObject]("four").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("four").isString)
		assertEquals(randomString4, json.asInstanceOf[JsonObject]("four").asInstanceOf[JsonString].value)
		assertEquals(randomString4, json.asInstanceOf[JsonObject].getString("four").get)

		// five
		assertTrue(json.asInstanceOf[JsonObject].has("five"))
		assertNotNull(json.asInstanceOf[JsonObject]("five"))
		assertTrue(json.asInstanceOf[JsonObject]("five").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("five").isString)
		assertEquals(randomString5, json.asInstanceOf[JsonObject]("five").asInstanceOf[JsonString].value)
		assertEquals(randomString5, json.asInstanceOf[JsonObject].getString("five").get)
	}

	@Test
	def testObject_String_SingleQuote() = {
		val s = "{\"key\":" + "\"" + stringWithSingleQuotes_Escaped + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals("{\"key\":" + "\"" + stringWithSingleQuotes + "\"" + "}", json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isString)
		assertEquals(stringWithSingleQuotes, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value)
		assertEquals(stringWithSingleQuotes, json.asInstanceOf[JsonObject].getString("key").get)
	}

	@Test
	def testObject_String_DoubleQuote() = {
		val s = "{\"key\":" + "\"" + stringWithDoubleQuotes_Escaped + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isString)
		assertEquals(stringWithDoubleQuotes, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value)
		assertEquals(stringWithDoubleQuotes, json.asInstanceOf[JsonObject].getString("key").get)
	}

	@Test
	def testObject_String_Tab() = {
		val s = "{\"key\":" + "\"" + stringWithTab_Escaped + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isString)
		assertEquals(stringWithTab, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value)
		assertEquals(stringWithTab, json.asInstanceOf[JsonObject].getString("key").get)
	}

	@Test
	def testObject_String_NewLine() = {
		val s = "{\"key\":" + "\"" + stringWithNewLine_Escaped + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isString)
		assertEquals(stringWithNewLine, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value)
		assertEquals(stringWithNewLine, json.asInstanceOf[JsonObject].getString("key").get)
	}

	@Test
	def testObject_String_Backslash() = {
		val s = "{\"key\":" + "\"" + stringWithBackslash_Escaped + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isString)
		assertEquals(stringWithBackslash, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value)
		assertEquals(stringWithBackslash, json.asInstanceOf[JsonObject].getString("key").get)
	}

	@Test
	def testObject_String_ForwardSlash() = {
		val s = "{\"key\":" + "\"" + stringWithForwardSlash_Escaped + "\"" + "}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals("{\"key\":" + "\"" + stringWithForwardSlash + "\"" + "}", json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("key").isString)
		assertEquals(stringWithForwardSlash, json.asInstanceOf[JsonObject]("key").asInstanceOf[JsonString].value)
		assertEquals(stringWithForwardSlash, json.asInstanceOf[JsonObject].getString("key").get)
	}

	@Test
	def testObject_Null_1() = {
		val s = "{\"key\":null}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("key"))
		assertNotNull(json.asInstanceOf[JsonObject]("key"))
		assertTrue(json.asInstanceOf[JsonObject]("key").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("key"))
		assertEquals(None, json.asInstanceOf[JsonObject]("key").value)
	}

	@Test
	def testObject_Null_2() = {
		val s = "{\"one\":null,\"two\":null}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(2, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("one"))
		assertEquals(None, json.asInstanceOf[JsonObject]("one").value)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("two"))
		assertEquals(None, json.asInstanceOf[JsonObject]("two").value)
	}

	@Test
	def testObject_Null_3() = {
		val s = "{\"one\":null,\"two\":null,\"three\":null}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(3, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("one"))
		assertEquals(None, json.asInstanceOf[JsonObject]("one").value)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("two"))
		assertEquals(None, json.asInstanceOf[JsonObject]("two").value)

		// three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("three"))
		assertEquals(None, json.asInstanceOf[JsonObject]("three").value)
	}

	@Test
	def testObject_Null_5() = {
		val s = "{\"one\":null,\"two\":null,\"three\":null,\"four\":null,\"five\":null}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// one
		assertTrue(json.asInstanceOf[JsonObject].has("one"))
		assertNotNull(json.asInstanceOf[JsonObject]("one"))
		assertTrue(json.asInstanceOf[JsonObject]("one").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("one"))
		assertEquals(None, json.asInstanceOf[JsonObject]("one").value)

		// two
		assertTrue(json.asInstanceOf[JsonObject].has("two"))
		assertNotNull(json.asInstanceOf[JsonObject]("two"))
		assertTrue(json.asInstanceOf[JsonObject]("two").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("two"))
		assertEquals(None, json.asInstanceOf[JsonObject]("two").value)

		// three
		assertTrue(json.asInstanceOf[JsonObject].has("three"))
		assertNotNull(json.asInstanceOf[JsonObject]("three"))
		assertTrue(json.asInstanceOf[JsonObject]("three").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("three"))
		assertEquals(None, json.asInstanceOf[JsonObject]("three").value)

		// four
		assertTrue(json.asInstanceOf[JsonObject].has("four"))
		assertNotNull(json.asInstanceOf[JsonObject]("four"))
		assertTrue(json.asInstanceOf[JsonObject]("four").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("four"))
		assertEquals(None, json.asInstanceOf[JsonObject]("four").value)

		// five
		assertTrue(json.asInstanceOf[JsonObject].has("five"))
		assertNotNull(json.asInstanceOf[JsonObject]("five"))
		assertTrue(json.asInstanceOf[JsonObject]("five").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("five"))
		assertEquals(None, json.asInstanceOf[JsonObject]("five").value)
	}

	@Test
	def testObject_Mixed1() = {
		val isAlive = true
		val age = 25
		val height = 167.64
		val s = "{\"firstName\":" + "\"" + simpleStringFirstName + "\"" + ",\"lastName\":" + "\"" + simpleStringLastName + "\"" + ",\"isAlive\":" + isAlive + ",\"age\":" + age + ",\"height_cm\":" + height + ",\"optionalAttributes\":null}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(6, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		// firstName
		assertTrue(json.asInstanceOf[JsonObject].has("firstName"))
		assertNotNull(json.asInstanceOf[JsonObject]("firstName"))
		assertTrue(json.asInstanceOf[JsonObject]("firstName").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("firstName").isString)
		assertEquals(simpleStringFirstName, json.asInstanceOf[JsonObject]("firstName").asInstanceOf[JsonString].value)
		assertEquals(simpleStringFirstName, json.asInstanceOf[JsonObject].getString("firstName").get)

		// lastName
		assertTrue(json.asInstanceOf[JsonObject].has("lastName"))
		assertNotNull(json.asInstanceOf[JsonObject]("lastName"))
		assertTrue(json.asInstanceOf[JsonObject]("lastName").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("lastName").isString)
		assertEquals(simpleStringLastName, json.asInstanceOf[JsonObject]("lastName").asInstanceOf[JsonString].value)
		assertEquals(simpleStringLastName, json.asInstanceOf[JsonObject].getString("lastName").get)

		// isAlive
		assertTrue(json.asInstanceOf[JsonObject].has("isAlive"))
		assertNotNull(json.asInstanceOf[JsonObject]("isAlive"))
		assertTrue(json.asInstanceOf[JsonObject]("isAlive").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("isAlive").isBoolean)
		assertEquals(JsonValue.TRUE, json.asInstanceOf[JsonObject]("isAlive"))
		assertEquals(isAlive, json.asInstanceOf[JsonObject]("isAlive").asInstanceOf[JsonBoolean].value)
		assertEquals(isAlive, json.asInstanceOf[JsonObject].getBoolean("isAlive").get)

		// age
		assertTrue(json.asInstanceOf[JsonObject].has("age"))
		assertNotNull(json.asInstanceOf[JsonObject]("age"))
		assertTrue(json.asInstanceOf[JsonObject]("age").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("age").isNumber)
		assertEquals(age, json.asInstanceOf[JsonObject]("age").asInstanceOf[JsonNumber].intValue)
		assertEquals(age, json.asInstanceOf[JsonObject].getInt("age").get)

		// height_cm
		assertTrue(json.asInstanceOf[JsonObject].has("height_cm"))
		assertNotNull(json.asInstanceOf[JsonObject]("height_cm"))
		assertTrue(json.asInstanceOf[JsonObject]("height_cm").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("height_cm").isNumber)
		assertEquals(height, json.asInstanceOf[JsonObject]("height_cm").asInstanceOf[JsonNumber].doubleValue, 0)
		assertEquals(height, json.asInstanceOf[JsonObject].getDouble("height_cm").get, 0)

		// optionalAttributes
		assertTrue(json.asInstanceOf[JsonObject].has("optionalAttributes"))
		assertNotNull(json.asInstanceOf[JsonObject]("optionalAttributes"))
		assertTrue(json.asInstanceOf[JsonObject]("optionalAttributes").isNull)
		assertEquals(JsonValue.NULL, json.asInstanceOf[JsonObject]("optionalAttributes"))
		assertEquals(None, json.asInstanceOf[JsonObject]("optionalAttributes").value)
	}

	@Test
	def testObject() = {
		val s = "{\"menu\":{\"id\":1,\"text\":\"File\",\"tooltip\":\"Click me\",\"focus\":false,\"shortcut\":\"Alt+F1\"}}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		//assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("menu"))
		assertNotNull(json.asInstanceOf[JsonObject]("menu"))
		assertTrue(json.asInstanceOf[JsonObject]("menu").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("menu").isObject)
		assertFalse(json.asInstanceOf[JsonObject]("menu").asInstanceOf[JsonObject].isEmpty)
		assertEquals(5, json.asInstanceOf[JsonObject]("menu").asInstanceOf[JsonObject].size)
	}

	@Test
	def testArray() = {
		val s = "{\"menu\":[\"File\",\"Edit\",\"View\",\"Navigate\",\"Code\",\"Analyze\",\"Refactor\",\"Build\",\"Run\",\"Tools\",\"Window\",\"Help\"]}"
		val json = JsonParser.parse(s)

		assertNotNull(json)
		assertTrue(json.isInstanceOf[JsonType])
		assertTrue(json.isInstanceOf[JsonObject])
		assertFalse(json.asInstanceOf[JsonObject].isEmpty)
		assertEquals(1, json.asInstanceOf[JsonObject].size)
		assertEquals(s, json.asInstanceOf[JsonObject].toString)

		assertTrue(json.asInstanceOf[JsonObject].has("menu"))
		assertNotNull(json.asInstanceOf[JsonObject]("menu"))
		assertTrue(json.asInstanceOf[JsonObject]("menu").isNonNull)
		assertTrue(json.asInstanceOf[JsonObject]("menu").isArray)
		assertFalse(json.asInstanceOf[JsonObject]("menu").asInstanceOf[JsonArray].isEmpty)
		assertEquals(12, json.asInstanceOf[JsonObject]("menu").asInstanceOf[JsonArray].length)
	}
}
