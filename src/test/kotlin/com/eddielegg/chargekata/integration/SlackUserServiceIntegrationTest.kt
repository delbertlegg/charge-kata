package com.eddielegg.chargekata.integration

import com.eddielegg.chargekata.domain.exception.SlackResponseException
import com.eddielegg.chargekata.domain.user.slack.SlackUser
import com.eddielegg.chargekata.service.user.SlackUserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SlackUserServiceIntegrationTest {
    @Autowired
    lateinit var service: SlackUserService

    /**
     * User ID - must be known to return a valid user in order for integration test to pass
     */
    @Value("\${interface.slack.testUser}")
    lateinit var testUserId: String

    @Test
    fun `should return a Slack User`() {
        val user: SlackUser? = service.findUserById(testUserId) as SlackUser
        assertEquals(testUserId, user?.id, "User ID")
    }

    @Test
    fun `should return an error response`() {
        try {
            service.findUserById("invalidID") as SlackUser
            fail("No exception thrown for invalid user")
        }
        catch(e: SlackResponseException) {
            assertEquals("user_not_found", e.message, "User Not found exception")
        }
    }
}