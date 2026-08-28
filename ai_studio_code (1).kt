package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class MediaType {
    PHOTO, VIDEO, REEL
}

enum class FeedFilter {
    FOR_YOU, FOLLOWING, LATEST
}

enum class ActivityType {
    LIKE, COMMENT, FOLLOW, MENTION
}

enum class ExploreCategory {
    TRENDING, BALOCHISTAN, TOP_CREATORS, LANDSCAPES, SHORTS, ART_CULTURE, AMBIENT_SOUND
}

enum class BalooraAccent(val title: String, val primary: Long) {
    GOLD("Zarwan Gold", 0xFFD4AF37),
    AZURE("Makran Azure", 0xFF00B4D8),
    CRIMSON("Chagai Crimson", 0xFFD62828),
    EMERALD("Gwadar Emerald", 0xFF2A9D8F),
    OBSIDIAN("Obsidian Monochrome", 0xFFE5E5E5)
}

data class InstagramAccount(
    val username: String,
    val displayName: String,
    val bio: String,
    val location: String = "Gwadar & Quetta",
    val avatarRes: Int? = null,
    val followersCount: Int = 12400,
    val followingCount: Int = 380,
    val postsCount: Int = 24,
    val isVerified: Boolean = false,
    val culturalTitle: String = "Creator"
)

data class UserProfile(
    val username: String = "raskolnikov_h1",
    val displayName: String = "Hasnain Ayaz",
    val bio: String = "Architect of Baloora ✦ Exploring digital heritage, contemporary minimalism & Baloch landscapes ⛰️ Crafted with pride.",
    val location: String = "Gwadar & Quetta",
    val instagramHandle: String = "raskolnikov_h1",
    val avatarRes: Int? = null,
    val followersCount: Int = 28400,
    val followingCount: Int = 412,
    val postsCount: Int = 38,
    val isVerified: Boolean = true,
    val culturalTitle: String = "البلوشی Design Lab",
    val isLoggedIn: Boolean = true
)

data class Post(
    val id: String,
    val authorName: String,
    val authorHandle: String,
    val authorAvatarRes: Int? = null,
    val mediaType: MediaType = MediaType.PHOTO,
    val imageRes: Int? = null,
    val caption: String,
    val location: String,
    val timeAgo: String,
    val likesCount: Int,
    val commentsCount: Int,
    val repostCount: Int = 0,
    val isLiked: Boolean = false,
    val isBookmarked: Boolean = false,
    val audioTrack: String? = null,
    val tags: List<String> = emptyList()
)

data class Story(
    val id: String,
    val authorName: String,
    val authorHandle: String,
    val authorAvatarRes: Int? = null,
    val mediaRes: Int? = null,
    val isSeen: Boolean = false,
    val caption: String = ""
)

data class Comment(
    val id: String,
    val authorName: String,
    val authorHandle: String,
    val authorAvatarRes: Int? = null,
    val text: String,
    val timeAgo: String,
    val likesCount: Int = 0,
    val isLiked: Boolean = false
)

data class ActivityNotification(
    val id: String,
    val type: ActivityType,
    val actorName: String,
    val actorHandle: String,
    val actorAvatarRes: Int? = null,
    val targetPreviewRes: Int? = null,
    val message: String,
    val timeAgo: String,
    val isFollowedBack: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "drafts")
data class UserDraft(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val caption: String,
    val mediaType: String,
    val imageRes: Int?,
    val location: String,
    val timestamp: Long = System.currentTimeMillis()
)

data class UserSettings(
    val isDarkMode: Boolean = true,
    val isTrueOledBlack: Boolean = true,
    val isPrivateAccount: Boolean = false,
    val isGhostModeStories: Boolean = false,
    val allowCommentsFromAnyone: Boolean = true,
    val showActivityStatus: Boolean = true,
    val highBitrateMedia: Boolean = true,
    val cacheSizeMb: Float = 24.8f,
    val accentTheme: BalooraAccent = BalooraAccent.GOLD,
    val fontScaleRatio: Float = 1.0f,
    val compactFeedDensity: Boolean = false
)