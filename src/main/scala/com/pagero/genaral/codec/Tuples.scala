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

import com.datastax.driver.core.{CodecRegistry, DataType, ProtocolVersion, TupleType}

object Tuples {

  def of(types: DataType*)(implicit protocolVersion: ProtocolVersion, codecRegistry: CodecRegistry): TupleType = {
    TupleType.of(protocolVersion, codecRegistry, types: _*)
  }

}

