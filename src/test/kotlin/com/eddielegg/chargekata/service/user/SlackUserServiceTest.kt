package com.eddielegg.chargekata.service.user

import com.eddielegg.chargekata.domain.user.slack.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.fail
import org.mockito.ArgumentMatchers.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.test.util.ReflectionTestUtils
import org.springframework.web.client.RestTemplate
import java.lang.Exception
import java.net.URI

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SlackUserServiceTest {

    @Mock
    lateinit var restTemplate: RestTemplate

    @InjectMocks
    lateinit var service: SlackUserService

    @BeforeAll
    fun setup() {
        MockitoAnnotations.initMocks(this)
        ReflectionTestUtils.setField(service,"uri","https://slack.com/api")
        ReflectionTestUtils.setField(service,"slackToken", "test")
    }

    @Test
    fun `should return user when SlackUserResponse is returned`() {
        val user = getTestSlackUser()
        `when`(restTemplate.getForObject<SlackResponse>(any(URI::class.java), eq(SlackResponse::class.java))).thenReturn(SlackUserResponse(ok = true, user = user))
        val returned = service.findUserById("test")
        assertEquals(user, returned, "User")
    }

    @Test
    fun `should throw error when SlackUserResponse is returned`() {
        val error = SlackErrorResponse(ok = false, error = "error")
        `when`(restTemplate.getForObject<SlackResponse>(any(URI::class.java), eq(SlackResponse::class.java))).thenReturn(error)

        try {
            service.findUserById("test")
            fail("Exception not thrown")
        }
        catch(e: Exception) {
            assertEquals(error.error, e.message, "Error")
        }
    }

    @Test
    fun `should throw error when unsupported response is returned`() {
        `when`(restTemplate.getForObject<SlackResponse>(any(URI::class.java), eq(SlackResponse::class.java))).thenReturn(null)
        try {
            service.findUserById("test")
            fail("Exception not thrown")
        }
        catch(e: Exception) {
            assertEquals("Response type not supported", e.message, "Error")
        }
    }

    private fun getTestSlackUser() = SlackUser(
            admin = false,
            appUser = false,
            bot = false,
            color = "blue",
            deleted = false,
            name = "Test",
            owner = false,
            primaryOwner = false,
            profile = SlackProfile(
                    realName = "test",
                    avatarHash = "test",
                    displayName = "test",
                    displayNameNormalized = "test",
                    email = "test",
                    imageOriginalUri = "test",
                    realNameNormalized = "test",
                    statusEmojiString = "test",
                    statusText = "test",
                    team = "test",
                    image24Uri = "test",
                    image32Uri = "test",
                    image48UriString = "test",
                    image72UriString = "test",
                    image192UriString = "test",
                    image512UriString = "test"
            ),
            realName = "Test",
            restricted = false,
            id = "test",
            teamId = "test",
            timeZone = "tz",
            timeZoneLabel = "tz",
            timeZoneOffset = 1,
            twoFactorAuth = false,
            ultraRestricted = false,
            updatedEpoch = 1
    )
}