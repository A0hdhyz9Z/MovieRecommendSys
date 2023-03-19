package com.example.ex3_2_back.entity

import com.fasterxml.jackson.annotation.JsonValue
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Unknown

enum class Gender(var code: Int) {
    Unknown(0),
    Male(1),
    Female(2);

    @JsonValue
    fun toJsonValue(): String {
        return when (this) {
            Male -> "男"
            Female -> "女"
            else -> "未知"
        }
    }
}

@Converter
class GenderConverter : AttributeConverter<Gender, Int> {
    override fun convertToDatabaseColumn(g: Gender?): Int {
        return g?.code ?: 0
    }

    override fun convertToEntityAttribute(g: Int?): Gender {
        return when (g) {
            1 -> Gender.Male
            2 -> Gender.Female
            else -> Gender.Unknown
        }
    }
}