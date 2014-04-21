package org.saadahmed.jascon

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import scala.util.Random


/**
 * Created by Saad on 3/7/14.
 */
class JsonNumberTest extends AssertionsForJUnit {

	@Test
	def constructIntTest_Positive() = {
		val value = Random.nextInt()
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def constructIntTest_Negative() = {
		val random = Random.nextInt()
		val value = if (random < 0) random else 0 - random
		assertTrue(value < 0)

		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def constructIntTest_Zero() = {
		val value = 0
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def constructIntTest_MaxPositive() = {
		val value = Int.MaxValue
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def constructIntTest_MaxNegative() = {
		val value = Int.MinValue
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testLongConstructor_Positive() = {
		val value = Random.nextLong()
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testLongConstructor_Negative() = {
		val random = Random.nextLong()
		val value = if (random < 0) random else 0 - random
		assertTrue(value < 0)

		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testLongConstructor_Zero() = {
		val value = 0L
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testLongConstructor_MaxPositive() = {
		val value = Long.MaxValue
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testLongConstructor_MaxNegative() = {
		val value = Long.MinValue
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testFloatConstructor_Positive() = {
		val value = Random.nextFloat()
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testFloatConstructor_Negative() = {
		val random = Random.nextFloat()
		val value = if (random < 0) random else 0 - random
		assertTrue(value < 0)

		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testFloatConstructor_Zero() = {
		val value = 0.0F
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testFloatConstructor_MaxPositive() = {
		val value = Float.MaxValue
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testFloatConstructor_MaxNegative() = {
		val value = Float.MinValue
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testDoubleConstructor_Positive() = {
		val value = Random.nextDouble()
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testDoubleConstructor_Negative() = {
		val random = Random.nextDouble()
		val value = if (random < 0) random else 0 - random
		assertTrue(value < 0)

		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testDoubleConstructor_Zero() = {
		val value = 0.0D
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testDoubleConstructor_MaxPositive() = {
		val value = Double.MaxValue
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}

	@Test
	def testDoubleConstructor_MaxNegative() = {
		val value = Double.MinValue
		val jsNumber = JsonNumber(value)

		assertNotNull(jsNumber)
		assertNotNull(jsNumber.value)
		assertTrue(jsNumber.isInstanceOf[JsonValue])
		assertTrue(jsNumber.isInstanceOf[JsonNumber])
		assertTrue(jsNumber.value.isInstanceOf[Number])
		assertTrue(jsNumber.isNonNull)
		assertTrue(jsNumber.isValue)
		assertTrue(jsNumber.isNumber)
		assertEquals(value, jsNumber.value)
	}
}
