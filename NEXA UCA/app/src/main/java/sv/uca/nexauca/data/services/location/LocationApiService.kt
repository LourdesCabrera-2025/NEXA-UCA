package sv.uca.nexauca.data.services.location

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class LocationApiService(

    private val client: HttpClient

) {

    suspend fun reverseGeocode(

        latitude: Double,
        longitude: Double

    ): String {

        return client.get(
            "https://nominatim.openstreetmap.org/reverse"
        ) {

            parameter("format", "jsonv2")
            parameter("lat", latitude)
            parameter("lon", longitude)

            headers.append(
                "User-Agent",
                "NEXA-UCA"
            )

        }.body<String>()

    }
}