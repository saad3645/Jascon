/*
 * Copyright 2014 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.saadahmed.jascon

import org.saadahmed.jascon.annotation.JsonIgnore
import org.saadahmed.jascon.annotation.JsonIgnoreType._


/**
 * @author Saad Ahmed
 * @version 0.1 2014/02/24
 */
trait JsonModel {

	def toJson = {
		val obj = JsonObject()
		val fields = this.getClass.getDeclaredFields
		for (field <- fields) {
			field.setAccessible(true)
			var ignore = false
			if (field.isAnnotationPresent(classOf[JsonIgnore])) {
				val ignoreType = field.getAnnotation(classOf[JsonIgnore]).ignoreType()
				val value = field.get(this)

				(ignoreType, value) match {
					case (ANY, _) => ignore = true
					case (NULL, null) => ignore = true
					case (NULL, None) => ignore = true
					case (EMPTY, null) => ignore = true
					case (EMPTY, None) => ignore = true
					case (EMPTY, s:String) => if (s.isEmpty) ignore = true
					case (EMPTY, Some(s:String)) => if (s.isEmpty) ignore = true
					case (EMPTY, i:Iterable[_]) => if (i.isEmpty) ignore = true
					case (EMPTY, Some(i:Iterable[_])) => if (i.isEmpty) ignore = true
					case (ZERO, i:Integer) => if (i == 0) ignore = true
					case (ZERO, l:java.lang.Long) => if (l == 0L) ignore = true
					case (ZERO, f:java.lang.Float) => if (f == 0F) ignore = true
					case (ZERO, d:java.lang.Double) => if (d == 0D) ignore = true
					case _ => ignore = false
				}
			}

			if (!ignore) {
				obj += (field.getName, JsonType(field.get(this)))
			}
		}

		obj
	}


	def stringify = this.toJson.toString

}
