package com.eddielegg.chargekata.service.user

import com.eddielegg.chargekata.domain.user.User

/**
 * User Service Interface
 */
interface UserService {

    /**
     * Find a user by given ID
     * @param id Given User ID
     * @return User
     */
    fun findUserById(id: String): User?
}