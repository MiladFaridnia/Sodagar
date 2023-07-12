package com.faridnia.sodagar.data.remote.dto.coin_detail


import com.google.gson.annotations.SerializedName

data class TeamMember(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)