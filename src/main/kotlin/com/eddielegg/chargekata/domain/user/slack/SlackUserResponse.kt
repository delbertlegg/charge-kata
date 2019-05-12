package com.eddielegg.chargekata.domain.user.slack

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Slack API User Response Model
 */
class SlackUserResponse(
        @JsonProperty
        val ok: Boolean,
        @JsonProperty
        val user: SlackUser
        ): SlackResponse(ok)