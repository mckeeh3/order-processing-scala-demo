package io.mystore

import com.google.protobuf.timestamp.Timestamp

object TimeTo {
  def now() =
    Some(Timestamp.of(seconds = System.currentTimeMillis() / 1000, nanos = 0))

  def zero() =
    Some(Timestamp.of(seconds = 0, nanos = 0))
}
