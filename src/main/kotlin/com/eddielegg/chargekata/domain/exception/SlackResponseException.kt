package com.eddielegg.chargekata.domain.exception

import java.lang.RuntimeException

/**
 * Exception for Slack Response Errors
 */
class SlackResponseException(error: String?) : RuntimeException(error)