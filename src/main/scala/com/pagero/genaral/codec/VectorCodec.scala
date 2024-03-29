/*
 * Copyright 2017 DataStax
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

package com.pagero.genaral.codec

import com.datastax.driver.core._

class VectorCodec[E](eltCodec: TypeCodec[E])
  extends AbstractSeqCodec[E, Vector[E]](
    DataType.list(eltCodec.getCqlType),
    TypeTokens.vectorOf(eltCodec.getJavaType),
    eltCodec) {
}

object VectorCodec {

    def apply[E](eltCodec: TypeCodec[E]): VectorCodec[E] = new VectorCodec[E](eltCodec)

    import scala.reflect.runtime.universe._

    def apply[E](implicit eltTag: TypeTag[E]): VectorCodec[E] = {
        val eltCodec = TypeConversions.toCodec[E](eltTag.tpe)
      apply(eltCodec)
    }

}



