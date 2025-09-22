package com.sardor.multirecyclerview.models

data class ParentData(
    val id: Int,
    val name: String,
    val childData: MutableList<ChildData>
)
