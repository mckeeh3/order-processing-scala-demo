package io.mystore

import com.google.protobuf.timestamp.Timestamp

object TimeTo {
  def now() =
    Timestamp.of(seconds = System.currentTimeMillis() / 1000, nanos = 0)

  def zero() =
    Timestamp.of(seconds = 0, nanos = 0)
}
