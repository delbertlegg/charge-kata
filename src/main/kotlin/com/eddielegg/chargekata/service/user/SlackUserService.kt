package com.eddielegg.chargekata.service.user

import com.eddielegg.chargekata.domain.exception.SlackResponseException
import com.eddielegg.chargekata.domain.user.User
import com.eddielegg.chargekata.domain.user.slack.SlackErrorResponse
import com.eddielegg.chargekata.domain.user.slack.SlackResponse
import com.eddielegg.chargekata.domain.user.slack.SlackUserResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

/**
 * Service for interfacing with Slack Users
 */
@Service
class SlackUserService : UserService {
    companion object {
        private const val USER_INFO = "/users.info"
    }

    /**
     * Required token for Slack API
     */
    @Value("\${interface.slack.token.user}")
    lateinit var slackToken: String

    /**
     * Slack API URI
     */
    @Value("\${interface.slack.uri}")
    lateinit var uri: String

    /**
     * Rest Template
     */
    @Autowired
    lateinit var restTemplate: RestTemplate

    /**
     * Find Slack User by ID
     * @param id user ID
     * @return Slack user for given ID
     * @throws SlackResponseException if exception in request or error in return
     */
    override fun findUserById(id: String): User? {
        val builder: UriComponentsBuilder = buildUserRequest(id)
        val response: SlackResponse? = restTemplate.getForObject(builder.build().toUri(), SlackResponse::class.java)
        if (response is SlackUserResponse) {
            return response.user
        }
        else if (response is SlackErrorResponse) {
            throw SlackResponseException(response.error)
        }
        throw SlackResponseException("Response type not supported")
    }

    private fun buildUserRequest(id: String): UriComponentsBuilder {
        return UriComponentsBuilder.fromHttpUrl(uri + USER_INFO)
                .queryParam("token", slackToken)
                .queryParam("user", id)
                .queryParam("include_locale", true)
    }
}