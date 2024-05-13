//As our Article data class consists one object also, so this will convert it into primitive data type

package com.hello.samachar.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.hello.samachar.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: Source): String{
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): Source{
        return source.split(',').let { sourceArray ->
            Source(id = sourceArray[0], name = sourceArray[1])
        }
    }
}