package io.github.arainko.ducktape.function

import io.github.arainko.ducktape.internal.macros.*

sealed trait FunctionMirror[F] {
  type Args <: Tuple
  type Return
}

object FunctionMirror {
  type Aux[F, A <: Tuple, R] = FunctionMirror[F] {
    type Args = A
    type Return = R
  }

  transparent inline given [F]: FunctionMirror[F] = FunctionMacros.createMirror[F]
}