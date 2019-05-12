package com.eddielegg.chargekata.domain.exception

/**
 * Exception for Slack Response Errors
 */
class SlackResponseException(error: String?) : Exception(error)