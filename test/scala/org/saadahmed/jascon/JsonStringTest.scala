package org.saadahmed.jascon

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import scala.util.Random

/**
 * Created by Saad on 3/7/14.
 */
class JsonStringTest extends AssertionsForJUnit {

	@Test
	def constructorTest() = {
		val value = Random.nextString(10)
		val jsString = JsonString(value)

		assertNotNull(jsString)
		assertNotNull(jsString.value)
		assertTrue(jsString.isInstanceOf[JsonValue])
		assertTrue(jsString.isInstanceOf[JsonString])
		assertTrue(jsString.value.isInstanceOf[String])
		assertTrue(jsString.isNonNull)
		assertTrue(jsString.isValue)
		assertTrue(jsString.isString)
		assertEquals(value, jsString.value)
	}

	@Test
	def constructorTest_EmptyString() = {
		val value = ""
		val jsString = JsonString(value)

		assertNotNull(jsString)
		assertNotNull(jsString.value)
		assertTrue(jsString.isInstanceOf[JsonValue])
		assertTrue(jsString.isInstanceOf[JsonString])
		assertTrue(jsString.value.isInstanceOf[String])
		assertTrue(jsString.isNonNull)
		assertTrue(jsString.isValue)
		assertTrue(jsString.isString)
		assertEquals(value, jsString.value)
	}

	@Test
	def constructorTest_LargeString() = {
		val value = Random.nextString(80)
		val jsString = JsonString(value)

		assertNotNull(jsString)
		assertNotNull(jsString.value)
		assertTrue(jsString.isInstanceOf[JsonValue])
		assertTrue(jsString.isInstanceOf[JsonString])
		assertTrue(jsString.value.isInstanceOf[String])
		assertTrue(jsString.isNonNull)
		assertTrue(jsString.isValue)
		assertTrue(jsString.isString)
		assertEquals(value, jsString.value)
	}
}
