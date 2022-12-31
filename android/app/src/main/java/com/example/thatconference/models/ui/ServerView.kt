package com.example.thatconference.models.ui

import androidx.compose.runtime.mutableStateOf
import com.example.thatconference.models.ui.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

@Serializable(UiSerializer::class)
open class ServerView() {
    var parent: ServerView? = null
    val selected = mutableStateOf(false)
}

@Serializable
data class GenericServerView(
    val type: String = "GenericServerView",
): ServerView()

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = ServerView::class)
object UiSerializer: KSerializer<ServerView> {
    override fun deserialize(decoder: Decoder): ServerView {
        val jsonDecoder = decoder as JsonDecoder
        return try {
            val jsonObject = jsonDecoder.decodeJsonElement() as? JsonObject ?: return GenericServerView()
            val objectType = jsonObject.getValue("type").jsonPrimitive.content
            when (objectType) {
                "TextView" -> jsonDecoder.json.decodeFromJsonElement(TextView.serializer(),jsonObject )
                "CardView" -> jsonDecoder.json.decodeFromJsonElement(CardView.serializer(),jsonObject )
                "ColumnView" -> jsonDecoder.json.decodeFromJsonElement(ColumnView.serializer(),jsonObject )
                "FavoriteIconView" -> jsonDecoder.json.decodeFromJsonElement(FavoriteIconView.serializer(),jsonObject )
                "FullWidthImageView" -> jsonDecoder.json.decodeFromJsonElement(FullWidthImageView.serializer(),jsonObject )
                "SpacerView" -> jsonDecoder.json.decodeFromJsonElement(SpacerView.serializer(),jsonObject )
                "TitleWithScrimView" -> jsonDecoder.json.decodeFromJsonElement(TitleWithScrimView.serializer(),jsonObject )
                "BoxView" -> jsonDecoder.json.decodeFromJsonElement(BoxView.serializer(), jsonObject)
                "AnimatedVisibility" -> jsonDecoder.json.decodeFromJsonElement(AnimatedVisibility.serializer(), jsonObject)
                "ListView" -> jsonDecoder.json.decodeFromJsonElement(ListView.serializer(), jsonObject)
                else -> GenericServerView()
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            ServerView()
        }
    }

    override fun serialize(encoder: Encoder, value: ServerView) {
        val jsonEncoder = encoder as? JsonEncoder
        when(value) {
            is TextView -> jsonEncoder?.encodeSerializableValue(TextView.serializer(), value)
            is CardView -> jsonEncoder?.encodeSerializableValue(CardView.serializer(), value)
            is ColumnView -> jsonEncoder?.encodeSerializableValue(ColumnView.serializer(), value)
            is FavoriteIconView -> jsonEncoder?.encodeSerializableValue(FavoriteIconView.serializer(), value)
            is FullWidthImageView -> jsonEncoder?.encodeSerializableValue(FullWidthImageView.serializer(), value)
            is SpacerView -> jsonEncoder?.encodeSerializableValue(SpacerView.serializer(), value)
            is TitleWithScrimView -> jsonEncoder?.encodeSerializableValue(TitleWithScrimView.serializer(), value)
            else -> {}
        }
    }
}