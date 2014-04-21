package org.saadahmed.jascon.parser

import scala.util.Random


/**
 * @author Saad Ahmed
 */
object ParserTestData {

	// Int
	val positiveInt1 = 1
	val positiveInt2 = 12
	val positiveInt3 = 12345
	val negativeInt1 = -1
	val negativeInt2 = -12
	val negativeInt3 = -12345
	val randomInt1 = Random.nextInt()
	val randomInt2 = Random.nextInt()
	val randomInt3 = Random.nextInt()
	val randomInt4 = Random.nextInt()
	val randomInt5 = Random.nextInt()

	// Long
	val simplePositiveLong = 1395703287000L
	val simpleNegativeLong = -1395703287000L
	val randomLong1 = Random.nextLong()
	val randomLong2 = Random.nextLong()
	val randomLong3 = Random.nextLong()
	val randomLong4 = Random.nextLong()
	val randomLong5 = Random.nextLong()

	// Float
	val simplePositiveFloat1 = 10.12F
	val simplePositiveFloat2 = 10.12345F
	val simpleNegativeFloat1 = -10.12F
	val simpleNegativeFloat2 = -10.12345F
	val randomFloat1 = Random.nextFloat()
	val randomFloat2 = Random.nextFloat()
	val randomFloat3 = Random.nextFloat()
	val randomFloat4 = Random.nextFloat()
	val randomFloat5 = Random.nextFloat()

	// Double
	val positiveDouble1 = 0.1D
	val positiveDouble2 = 0.12D
	val positiveDouble3 = 0.12345D
	val positiveDouble4 = 1.12D
	val positiveDouble5 = 1.12345D
	val positiveDouble6 = 100.12D
	val positiveDouble7 = 100.12345D
	val negativeDouble1 = -0.1D
	val negativeDouble2 = -0.12D
	val negativeDouble3 = -0.12345D
	val negativeDouble4 = -1.12D
	val negativeDouble5 = -1.12345D
	val negativeDouble6 = -100.12D
	val negativeDouble7 = -100.12345D
	val positiveDouble_PositiveExponent1 = "0e22"
	val positiveDouble_PositiveExponent2 = "1e22"
	val positiveDouble_PositiveExponent3 = "100e22"
	val positiveDouble_NegativeExponent1 = "0e-22"
	val positiveDouble_NegativeExponent2 = "1e-22"
	val positiveDouble_NegativeExponent3 = "100e-22"
	val negativeDouble_PositiveExponent1 = "-0e22"
	val negativeDouble_PositiveExponent2 = "-1e22"
	val negativeDouble_PositiveExponent3 = "-100e22"
	val negativeDouble_NegativeExponent1 = "-0e-22"
	val negativeDouble_NegativeExponent2 = "-1e-22"
	val negativeDouble_NegativeExponent3 = "-100e-22"
	val randomDouble1 = Random.nextDouble()
	val randomDouble2 = Random.nextDouble()
	val randomDouble3 = Random.nextDouble()
	val randomDouble4 = Random.nextDouble()
	val randomDouble5 = Random.nextDouble()

	// String
	val simpleString = "Hello World!"
	val simpleStringFirstName = "John"
	val simpleStringLastName = "Smith"
	val stringWithSingleQuotes = "I'm a string with 'single quotes'."
	val stringWithSingleQuotes_Escaped = "I'm a string with \\'single quotes\\'."
	val stringWithDoubleQuotes = "I'm a string with \"double quotes\"."
	val stringWithDoubleQuotes_Escaped = "I'm a string with \\\"double quotes\\\"."
	val stringWithTab = "I'm a string with \ttab."
	val stringWithTab_Escaped = "I'm a string with \\ttab."
	val stringWithNewLine = "This is line 1.\nThis is line 2."
	val stringWithNewLine_Escaped = "This is line 1.\\nThis is line 2."
	val stringWithBackslash = "I'm a string with \\backslash\\."
	val stringWithBackslash_Escaped = "I'm a string with \\\\backslash\\\\."
	val stringWithForwardSlash = "I'm a string with /forward slash/."
	val stringWithForwardSlash_Escaped = "I'm a string with \\/forward slash\\/."
	val randomString1 = Random.nextString(10)
	val randomString2 = Random.nextString(10)
	val randomString3 = Random.nextString(10)
	val randomString4 = Random.nextString(10)
	val randomString5 = Random.nextString(10)
}
