package com.example.ex3_2_back.algorithm

import org.springframework.stereotype.Component

@Component
class TestAlgorithm {
    override fun toString(): String {
        return "TestAlgorithm" + hashCode()
    }
}