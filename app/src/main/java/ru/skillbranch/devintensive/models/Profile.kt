package ru.skillbranch.devintensive.models


data class Profile(

    val firstName :String,
    val lastName :String,
    val about :String,
    val repository :String,
    val raiting : Int = 0,
    val respect : Int = 0
) {
    val nickName:String = "John Doe"
    val rank :String= "Junior Android Developer"

    fun toMap():Map<String,Any> = mapOf(
        "nickname" to nickName,
        "rank" to rank,
        "firstName" to firstName,
        "lastName" to lastName,
        "about" to about,
        "repository" to repository,
        "raiting" to raiting,
        "respect" to respect
    )
}