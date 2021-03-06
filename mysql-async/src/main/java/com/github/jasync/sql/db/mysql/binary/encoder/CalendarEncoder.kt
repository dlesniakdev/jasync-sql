package com.github.jasync.sql.db.mysql.binary.encoder

import com.github.jasync.sql.db.mysql.column.ColumnTypes
import io.netty.buffer.ByteBuf
import java.util.Calendar
import org.joda.time.LocalDateTime

object CalendarEncoder : BinaryEncoder {
    override fun encode(value: Any, buffer: ByteBuf) {
        val calendar = value as Calendar
        LocalDateTimeEncoder.encode(LocalDateTime(calendar.timeInMillis), buffer)
    }

    override fun encodesTo(): Int = ColumnTypes.FIELD_TYPE_TIMESTAMP
}
