package org.saadahmed.jascon

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import scala.util.Random
import org.saadahmed.jascon.annotation.JsonIgnore
import org.saadahmed.jascon.annotation.JsonIgnoreType._
import scala.annotation.meta.field

case class User(firstName: String, lastName: Option[String], @(JsonIgnore@field)(ignoreType = ZERO)age: Int, email: String) extends JsonModel

class JSONTest2 extends AssertionsForJUnit {

	val testUser = User("John", None, 0, "john@gmail.com")


	@Test
	def testOptionType() = {
		println(testUser.toJson.toString)
	}
}
