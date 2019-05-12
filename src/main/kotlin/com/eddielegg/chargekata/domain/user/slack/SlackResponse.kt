package com.eddielegg.chargekata.domain.user.slack

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "ok"
)
@JsonSubTypes(
        Type(value = SlackUserResponse::class, name = "true"),
        Type(value = SlackErrorResponse::class, name = "false")
)
/**
 * Slack API Response Object model
 */
abstract class SlackResponse(val ok: Boolean)