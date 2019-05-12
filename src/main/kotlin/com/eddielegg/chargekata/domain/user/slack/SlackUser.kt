package com.eddielegg.chargekata.domain.user.slack

import com.eddielegg.chargekata.domain.user.User
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Slack User Object Model
 */
data class SlackUser(
        @JsonProperty
        val id: String,
        @JsonProperty("team_id")
        val teamId: String,
        @JsonProperty
        val name: String,
        @JsonProperty
        val deleted: Boolean,
        @JsonProperty
        val color: String,
        @JsonProperty("real_name")
        val realName: String,
        @JsonProperty("tz")
        val timeZone: String,
        @JsonProperty("tz_label")
        val timeZoneLabel: String,
        @JsonProperty("tz_offset")
        val timeZoneOffset: Long,
        @JsonProperty("profile")
        val profile: SlackProfile,
        @JsonProperty("is_admin")
        val admin: Boolean,
        @JsonProperty("is_owner")
        val owner: Boolean,
        @JsonProperty("is_primary_owner")
        val primaryOwner: Boolean,
        @JsonProperty("is_restricted")
        val restricted: Boolean,
        @JsonProperty("is_ultra_restricted")
        val ultraRestricted: Boolean,
        @JsonProperty("is_bot")
        val bot: Boolean,
        @JsonProperty("updated")
        val updatedEpoch: Long,
        @JsonProperty("is_app_user")
        val appUser: Boolean,
        @JsonProperty("has_2fa")
        val twoFactorAuth: Boolean
        ) : User