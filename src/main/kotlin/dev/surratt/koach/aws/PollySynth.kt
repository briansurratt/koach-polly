package dev.surratt.koach.aws

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.polly.PollyClient
import software.amazon.awssdk.services.polly.model.*
import java.io.File
import java.io.InputStream

class PollySynth(private val voiceId: VoiceId) {

    lateinit var voice: Voice
    lateinit var pollyClient: PollyClient

    fun generate(ssml: String, targetFile: File) {

        pollyClient = PollyClient.builder()
            .region(Region.US_WEST_2)
            .build()

        lookupVoice()

        synthesize(ssml, targetFile)

        pollyClient.close()

    }

    private fun lookupVoice() {

        val describeVoiceRequest: DescribeVoicesRequest = DescribeVoicesRequest.builder()
            .engine(Engine.STANDARD)
            .build()

        val describeVoicesResult: DescribeVoicesResponse = pollyClient.describeVoices(describeVoiceRequest)

        // this will fail if voice id can not be found.  will handle better in the future
        voice = describeVoicesResult.voices().find { v -> v.id() == voiceId }!!

    }

    private fun synthesize(text: String, targetFile: File) {

        if (targetFile.exists()) {
            targetFile.delete()
        }

        val synthReq = SynthesizeSpeechRequest.builder()
            .text(text)
            .textType(TextType.SSML)
            .voiceId(voice.id())
            .outputFormat(OutputFormat.MP3)
            .build()

        val synthRes: SynthesizeSpeechResponse = pollyClient.synthesizeSpeech(synthReq, targetFile.toPath());
        println(synthRes)

    }

}