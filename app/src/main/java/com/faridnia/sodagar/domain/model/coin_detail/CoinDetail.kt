package com.faridnia.sodagar.domain.model.coin_detail

import com.faridnia.sodagar.data.remote.dto.coin_detail.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
