package com.eddielegg.chargekata.domain.user.slack

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Slack Profile Object Model
 */
data class SlackProfile(
        @JsonProperty("avatar_hash")
        val avatarHash: String?,
        @JsonProperty("status_text")
        val statusText: String?,
        @JsonProperty("status_emoji")
        val statusEmojiString: String?,
        @JsonProperty("real_name")
        val realName: String?,
        @JsonProperty("display_name")
        val displayName: String?,
        @JsonProperty("real_name_normalized")
        val realNameNormalized: String?,
        @JsonProperty("display_name_normalized")
        val displayNameNormalized: String?,
        @JsonProperty
        val email: String?,
        @JsonProperty("image_original")
        val imageOriginalUri: String?,
        @JsonProperty("image_24")
        val image24Uri: String,
        @JsonProperty("image_32")
        val image32Uri: String,
        @JsonProperty("image_48")
        val image48UriString: String,
        @JsonProperty("image_72")
        val image72UriString: String,
        @JsonProperty("image_192")
        val image192UriString: String,
        @JsonProperty("image_512")
        val image512UriString: String,
        @JsonProperty
        val team: String?
        )