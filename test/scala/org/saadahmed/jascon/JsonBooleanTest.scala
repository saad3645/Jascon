package org.saadahmed.jascon

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test


/**
 * @author Saad Ahmed
 */
class JsonBooleanTest extends AssertionsForJUnit {

	@Test
	def testConstructor_True() = {
		val value = true
		val jsBoolean = new JsonBoolean(value)

		assertNotNull(jsBoolean)
		assertNotNull(jsBoolean.value)
		assertTrue(jsBoolean.isInstanceOf[JsonValue])
		assertTrue(jsBoolean.isInstanceOf[JsonBoolean])
		assertTrue(jsBoolean.value.isInstanceOf[Boolean])
		assertTrue(jsBoolean.isNonNull)
		assertTrue(jsBoolean.isValue)
		assertTrue(jsBoolean.isBoolean)
		assertEquals(value, jsBoolean.value)
	}

	@Test
	def testConstructor_False() = {
		val value = false
		val jsBoolean = new JsonBoolean(value)

		assertNotNull(jsBoolean)
		assertNotNull(jsBoolean.value)
		assertTrue(jsBoolean.isInstanceOf[JsonValue])
		assertTrue(jsBoolean.isInstanceOf[JsonBoolean])
		assertTrue(jsBoolean.value.isInstanceOf[Boolean])
		assertTrue(jsBoolean.isNonNull)
		assertTrue(jsBoolean.isValue)
		assertTrue(jsBoolean.isBoolean)
		assertEquals(value, jsBoolean.value)
	}

	@Test
	def testValue_True() = {
		val value = true
		val jsBoolean = new JsonBoolean(value)

		assertEquals(value, jsBoolean.value)
		assertTrue(jsBoolean.value)
	}

	@Test
	def testValue_False() = {
		val value = false
		val jsBoolean = new JsonBoolean(value)

		assertEquals(value, jsBoolean.value)
		assertFalse(jsBoolean.value)
	}

	@Test
	def testToString_True() = {
		val value = true
		val jsBoolean = new JsonBoolean(value)

		assertEquals(value.toString, jsBoolean.value.toString)
		assertEquals(value.toString, jsBoolean.toString)
		assertEquals("true", jsBoolean.toString)
	}

	@Test
	def testToString_False() = {
		val value = false
		val jsBoolean = new JsonBoolean(value)

		assertEquals(value.toString, jsBoolean.value.toString)
		assertEquals(value.toString, jsBoolean.toString)
		assertEquals("false", jsBoolean.toString)
	}

	@Test
	def testJsonValue_TRUE() = {
		val value = JsonValue.TRUE

		assertNotNull(value)
		assertTrue(value.value)
		assertEquals(true, value.value)
		assertEquals("true", value.toString)
	}

	@Test
	def testJsonValue_False() = {
		val value = JsonValue.FALSE

		assertNotNull(value)
		assertFalse(value.value)
		assertEquals(false, value.value)
		assertEquals("false", value.toString)
	}
}
