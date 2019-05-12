package com.eddielegg.chargekata.domain.user.slack

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Error response from Slack API
 */
class SlackErrorResponse (
        @JsonProperty
        val ok: Boolean,
        @JsonProperty
        val error: String): SlackResponse(ok)