package com.yj.service.response

/**
 * desc:
 * time: 2019/3/21
 * @author yinYin
 */
data class TakeRecodeEntity(
    val code: Int?,
    val list: List<X?>?,
    val msg: String?,
    val time: String?
)

data class X(
    val Time: String?,
    val boxNumber: String?,
    val cabinetName: String?,
    val operateTime: String?,
    val pieceNumber: String?,
    val recordId: String?
)