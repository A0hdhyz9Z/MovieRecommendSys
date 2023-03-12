package com.example.ex3_2_back.data

class DataResult<DataType>(success: Boolean = false, message: String = "", var data: DataType) :
    Result(success, message)